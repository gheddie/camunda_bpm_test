package de.gravitex.bpmtest.ejb;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name = "BLAdapter")
@Local(BLAdapter.class)
public class BLAdapterBean implements BLAdapter {

	public void invokeSomeBusinessLogic(String command) {
		System.out.println("bl command received : " + command + ".");
	}
}
