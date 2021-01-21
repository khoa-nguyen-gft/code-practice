package template_solution;

public class TaskTranserMoneyImpl extends TaskAbs {

	public TaskTranserMoneyImpl() {
		super();
	}
	
	public TaskTranserMoneyImpl(AuditTrail auditTrail) {
		super(auditTrail);
	}

	@Override
	protected void doExecute() {
		System.out.println("Transfer Money");		
	}


	
	
	//	private AuditTrail auditTrail;
//
//	public TranserMoneyTask(AuditTrail auditTrail) {
//		this.auditTrail = auditTrail;
//	}
//	
//	public void execute() {
//		auditTrail.record();
//		
//		System.out.println("Transfer Money");
//	}
	
	
}
