package fr.paris10.miage.file;

public class WindowsFactory extends AbstarctFileFactory {
	private static WindowsFactory f = new WindowsFactory();

	private WindowsFactory() {
		super();

	}

	public static WindowsFactory getInstance() {
		return WindowsFactory.f;
	}

	@Override
	public OrdinaryFileW creatFile(String name, String username) {

		return new OrdinaryFileW(name, username);
	}

	@Override
	public DirectoryW creatDirectory(String name, String username) {

		return new DirectoryW(name, username);
	}

}
