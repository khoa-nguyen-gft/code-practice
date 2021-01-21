package command_pattern.solution03;

public interface Command {
	public void execute();
}

class WriteFileCommand implements Command {
	private FileSystemReceiver fs;
	
	
	public WriteFileCommand(FileSystemReceiver fs) {
		this.fs = fs;
	}

	@Override
	public void execute() {
		fs.writeFile();
	}	
}


class CloseFileCommand implements Command {
	private FileSystemReceiver fs;
	
	
	public CloseFileCommand(FileSystemReceiver fs) {
		this.fs = fs;
	}

	@Override
	public void execute() {
		fs.closeFile();
	}	
}

class OpenFileCommand implements Command {
	private FileSystemReceiver fs;
	
	
	public OpenFileCommand(FileSystemReceiver fs) {
		this.fs = fs;
	}

	@Override
	public void execute() {
		fs.openFile();
	}	
}