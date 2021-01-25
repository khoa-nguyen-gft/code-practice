package design_pattern.command_pattern.solution03;

public class Client {
	public static void main(String[] args) {
		FileSystemReceiver fs = FileSystemReceiverUtils.getUnderlyingFileSystem();
		
		Command openFileCommand = new OpenFileCommand(fs);
		Command closeFileCommand = new CloseFileCommand(fs);
		
		FileInvoker invoker = new FileInvoker(openFileCommand);
		invoker.execute();
		
		invoker = new FileInvoker(closeFileCommand);
		invoker.execute();
	}

}
