package de.gravitex.bpmtest.ejb;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless(name = "BpmTest")
@Remote(BpmTestRemote.class)
@Local(BpmTest.class)
@MyAdapter
public class BpmTestBean implements BpmTest {

	public void saySomething(String something) {
		System.out.println("saying something : " + something + ".");
	}
}
