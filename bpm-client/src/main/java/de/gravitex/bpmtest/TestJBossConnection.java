package de.gravitex.bpmtest;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import de.gravitex.bpmtest.ejb.BpmTestRemote;

public class TestJBossConnection {

	public static void main(String[] args) {

		Properties props = new Properties();

		props.put("jboss.naming.client.ejb.context", true);
		props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		props.put(Context.PROVIDER_URL, "remote://localhost:4447");
		props.put(Context.SECURITY_PRINCIPAL, "pruser");
		props.put(Context.SECURITY_CREDENTIALS, "pruser123@");
		props.put("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");

		InitialContext ctxt = null;

		try {		
			ctxt = new InitialContext(props);
			
			BpmTestRemote processingTest = lookupRemoteInterface(BpmTestRemote.class, ctxt);
			processingTest.saySomething("hello");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private static <T> T lookupRemoteInterface(Class<T> clazz, InitialContext ctxt) throws NamingException {
		String lookup = "ejb:bpm-ear-1.0-SNAPSHOT/bpm-ejb-1.0-SNAPSHOT/"+clazz.getSimpleName().replace("Remote", "")+"!"+clazz.getCanonicalName();
		System.out.println("using lookup : " + lookup);
		T t = (T) ctxt.lookup(lookup);
		return (T) t;
	}
}
