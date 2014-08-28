package de.gravitex.bpmtest.ejb.logic.wstest;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

@Stateless(name = "WSTest")
@Local(WSTest.class)
@Remote(WSTestRemote.class)
@WebService(name = "HelloWorldWS")
//@WebService(name = "HelloWorldWS", targetNamespace="http://my-company/ws/")
//@WebService(name = "HelloWorldWS", targetNamespace="http://my-company/ws/")
//@WebContext(authMethod = "BASIC", contextRoot = "helloWS", urlPattern = "/*")
//@SecurityDomain("helloworld-webservice-login")
public class WSTestBean implements WSTest {

	@WebMethod
	public int triggerWebservice(String message, int x, int y) {
		System.out.println("ws :: " + message);
		return (x+y);
	}
}
