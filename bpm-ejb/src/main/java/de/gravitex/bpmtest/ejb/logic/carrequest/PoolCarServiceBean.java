package de.gravitex.bpmtest.ejb.logic.carrequest;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import de.gravitex.bpmtest.ejb.entity.carrequest.StaffCar;

@Stateless(name = "PoolCarService")
@Local(PoolCarService.class)
public class PoolCarServiceBean implements PoolCarService {

	public List<StaffCar> findSuitablePoolCar(int numSeatsRequested, Date requestCarFrom, Date requestCarUntil) {
		System.out.println(" @------------------------------------------------> [numSeatsRequested:"+numSeatsRequested+"|requestCarFrom:"+requestCarFrom+"|requestCarUntil:"+requestCarUntil+"]");
		return null;
	}
}
