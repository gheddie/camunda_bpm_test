package de.gravitex.bpmtest.ejb;

import javax.ejb.Remote;

@Remote
public interface BpmTestRemote {

	public void saySomething(String something);
}
