package de.gravitex.bpmtest.ejb;

import javax.ejb.Stateless;

@Stateless(name = "BusinessLogicAdapter")
public class BusinessLogicAdapterBean implements BusinessLogicAdapter {

	public void triggerSomeBusinessLogic(String command) {
		System.out.println(command);
	}
}
