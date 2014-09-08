package de.gravitex.bpmtest;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import de.gravitex.bpmtest.ejb.common.BpmnVariables;
import de.gravitex.bpmtest.ejb.common.ProcessDefinitionKeys;
import de.gravitex.bpmtest.ejb.logic.wstest.WSTestRemote;
import de.gravitex.bpmtest.ejb.remoting.EngineProviderRemote;

public class TestJBossConnection {

	public static void main(String[] args) {		
//		testCarRequestProcess();
		testWebservice();
//		testWebserviceSimple();
//		testParallelWait();
	}

	private static void testParallelWait() {
		try {
			InitialContext context = getServerContext();
			EngineProviderRemote engineProvider = lookupRemoteInterface(EngineProviderRemote.class, context);
//			engineProvider.startProcessInstance("testParallelWait", null);
			engineProvider.completeTask("17d60901-3758-11e4-9ed7-1a1320524153");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static void testWebserviceSimple() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(WSTestRemote.class);
		factory.setAddress("http://192.168.0.5:8484/bpm-ejb-1.0-SNAPSHOT/HelloWorldWS?wsdl");
		WSTestRemote ws = (WSTestRemote) factory.create();
		ws.triggerWebserviceSimple(null, null);
	}

	private static void testWebservice() {
		
		//BY JNDI
//		try {
//			InitialContext context = getServerContext();
//			lookupRemoteInterface(WSTestRemote.class, context).triggerWebservice("moo", 0, 0);
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
			
		//BY WS CALL
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(WSTestRemote.class);
		factory.setAddress("http://localhost:8484/bpm-ejb-1.0-SNAPSHOT/HelloWorldWS?wsdl");
		WSTestRemote ws = (WSTestRemote) factory.create();
		int result = ws.triggerWebservice("hello from web service !", 6, 616);
		System.out.println("result in client is "+result+".");
	}

	private static void testCarRequestProcess() {
		try {
			InitialContext context = getServerContext();
			Map<String, Object> variables = new HashMap<String, Object>();
			variables.put(BpmnVariables.CarRequestVariables.NUM_SEATS_REQUESTED, 4);
			variables.put(BpmnVariables.CarRequestVariables.REQUEST_CAR_FROM, Calendar.getInstance().getTime());
			variables.put(BpmnVariables.CarRequestVariables.REQUEST_CAR_UNTIL, Calendar.getInstance().getTime());
			lookupRemoteInterface(EngineProviderRemote.class, context).startProcessInstance(ProcessDefinitionKeys.CAR_REQUEST, variables);			
		} catch (NamingException e) {
			e.printStackTrace();
		}		
	}

	private static InitialContext getServerContext() throws NamingException {
		
		Properties props = new Properties();

		props.put("jboss.naming.client.ejb.context", true);
		props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		props.put(Context.PROVIDER_URL, "remote://localhost:8282");
		props.put(Context.SECURITY_PRINCIPAL, "pruser");
		props.put(Context.SECURITY_CREDENTIALS, "pruser123@");
		props.put("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");

		return new InitialContext(props);		
	}

	@SuppressWarnings("unchecked")
	private static <T> T lookupRemoteInterface(Class<T> clazz, InitialContext ctxt) throws NamingException {
		String lookup = "ejb:bpm-ear-1.0-SNAPSHOT/bpm-ejb-1.0-SNAPSHOT/"+clazz.getSimpleName().replace("Remote", "")+"!"+clazz.getCanonicalName();
		System.out.println("using lookup : " + lookup);
		T t = (T) ctxt.lookup(lookup);
		return (T) t;
	}
}
