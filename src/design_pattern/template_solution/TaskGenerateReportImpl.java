package design_pattern.template_solution;

public class TaskGenerateReportImpl extends TaskAbs {

	public TaskGenerateReportImpl() {
		super();
	}

	
	public TaskGenerateReportImpl(AuditTrail auditTrail) {
		super(auditTrail);
	}

	@Override
	protected void doExecute() {
		System.out.println("Generate Report");
	}

	
	
//	private AuditTrail auditTrail;
//
//	public GenerateReportTask(AuditTrail auditTrail) {
//		this.auditTrail = auditTrail;
//	};
//	
//	
//	public void execute() {
//		auditTrail.record();
//		
//		System.out.println("Generate Report");
//	}
	
}
