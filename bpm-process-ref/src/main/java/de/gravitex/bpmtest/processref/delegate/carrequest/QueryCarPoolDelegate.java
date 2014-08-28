package de.gravitex.bpmtest.processref.delegate.carrequest;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;

import de.gravitex.bpmtest.ejb.common.BpmnVariables;
import de.gravitex.bpmtest.ejb.logic.carrequest.PoolCarService;
import de.gravitex.bpmtest.processref.delegate.AbstractProcessDelegate;

@Named
public class QueryCarPoolDelegate extends AbstractProcessDelegate {
	
	@Inject
	PoolCarService poolCarService;

	public void execute(DelegateExecution execution) throws Exception {
		ensureVariablesSet(execution, BpmnVariables.CarRequestVariables.NUM_SEATS_REQUESTED, BpmnVariables.CarRequestVariables.REQUEST_CAR_FROM, BpmnVariables.CarRequestVariables.REQUEST_CAR_UNTIL);		
		int numSeatsRequested = (int) execution.getVariable(BpmnVariables.CarRequestVariables.NUM_SEATS_REQUESTED);
		Date from = (Date) execution.getVariable(BpmnVariables.CarRequestVariables.REQUEST_CAR_FROM);
		Date until = (Date) execution.getVariable(BpmnVariables.CarRequestVariables.REQUEST_CAR_UNTIL);
		poolCarService.findSuitablePoolCar(numSeatsRequested, from, until);
	}
}
