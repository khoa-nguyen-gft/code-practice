package command_pattern.solution03;

public interface FileSystemReceiver {
	public void openFile();
	public void writeFile();
	public void closeFile();
}


class LinuxFileSystemReceiver implements FileSystemReceiver{

	@Override
	public void openFile() {
		System.out.println("Open file in Linux");		
	}

	@Override
	public void writeFile() {
		System.out.println("Write file in Linux");	
		
	}

	@Override
	public void closeFile() {
		System.out.println("Close file in Linux");		
		
	}
	
}


class WindowFileSystemReceiver implements FileSystemReceiver{

	@Override
	public void openFile() {
		System.out.println("Open file in Windows OS");		
	}

	@Override
	public void writeFile() {
		System.out.println("Write file in Windows OS");		
		
	}

	@Override
	public void closeFile() {
		System.out.println("Close file in Windows OS");		
		
	}
	
}
