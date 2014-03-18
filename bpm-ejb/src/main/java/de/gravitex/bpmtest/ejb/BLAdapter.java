package de.gravitex.bpmtest.ejb;

import javax.ejb.Local;

@Local
public interface BLAdapter {

	public void invokeSomeBusinessLogic(String command);
}
