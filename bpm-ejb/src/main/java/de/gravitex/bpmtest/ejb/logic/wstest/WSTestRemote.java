package de.gravitex.bpmtest.ejb.logic.wstest;

import javax.ejb.Remote;
import javax.jws.WebService;

@Remote
@WebService
public interface WSTestRemote {

	public int triggerWebservice(String message, int x, int y);
}
