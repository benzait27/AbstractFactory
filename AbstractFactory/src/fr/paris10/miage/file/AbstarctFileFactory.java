package fr.paris10.miage.file;

public abstract class AbstarctFileFactory {
	public final static String OS_NAME = System.getProperty("os.name");
	

	public AbstarctFileFactory() {
		super();
		
	} 
    public abstract File creatFile(String name, String username);
    public abstract File creatDirectory(String name, String username);
	public AbstarctFileFactory GenererFactoryFile(){
		if (OS_NAME.equals("Linux"))
		{
			return LinuxFactory.getInstance();
		}
		if (OS_NAME.equals("Windows"))
		{
			return WindowsFactory.getInstance();
		}
		return null;
	
	}
	
	

}
