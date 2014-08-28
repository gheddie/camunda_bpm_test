package de.gravitex.bpmtest.ejb.logic.carrequest;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import de.gravitex.bpmtest.ejb.entity.carrequest.StaffCar;

@Local
public interface PoolCarService {

	public List<StaffCar> findSuitablePoolCar(int numSeatsRequested, Date requestCarFrom, Date requestCarUntil);
}
