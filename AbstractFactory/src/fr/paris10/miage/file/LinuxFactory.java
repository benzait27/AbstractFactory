package fr.paris10.miage.file;

public class LinuxFactory extends AbstarctFileFactory {
	private static LinuxFactory f = new LinuxFactory();

	private LinuxFactory() {
		super();

	}

	public static LinuxFactory getInstance() {
		return LinuxFactory.f;
	}

	@Override
	public OrdinaryFileL creatFile(String name, String username) {

		return new OrdinaryFileL(name, username);
	}

	@Override
	public DirectoryL creatDirectory(String name, String username) {

		return new DirectoryL(name, username);
	}
}
