package de.gravitex.bpmtest.processref.delegate.simplecollaboration;

import org.camunda.bpm.BpmPlatform;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class TriggerFirmDelegate implements JavaDelegate {

	public void execute(DelegateExecution execution) throws Exception {
		System.out.println(" ### TriggerFirmDelegate ### ");
		BpmPlatform.getDefaultProcessEngine().getRuntimeService().correlateMessage("triggerFirm");
	}
}
