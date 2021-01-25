package design_pattern.command_pattern.solution03;

public class FileSystemReceiverUtils {
	public static FileSystemReceiver getUnderlyingFileSystem() {
		String osName = System.getProperty("os.name");
		if (osName.contains("Window")) {
			return new WindowFileSystemReceiver();
		} else {
			return new LinuxFileSystemReceiver();

		}
	}
}
