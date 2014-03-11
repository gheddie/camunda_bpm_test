package de.gravitex.bpmtest.ejb;

import javax.ejb.Local;

@Local
public interface BusinessLogicAdapter {

	public void triggerSomeBusinessLogic(String command);
}
