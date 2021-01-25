package design_pattern.template_solution;

public abstract class TaskAbs {
	
	private AuditTrail auditTrail;
	

	public TaskAbs() {
		this.auditTrail = new AuditTrail();
	}

	
	public TaskAbs(AuditTrail auditTrail) {
		this.auditTrail = auditTrail;
	}

	public void execute() {
		auditTrail.record();
		doExecute();
	}
	
	protected abstract void doExecute();
 
}
