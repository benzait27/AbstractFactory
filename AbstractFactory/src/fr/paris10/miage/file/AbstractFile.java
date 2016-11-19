package fr.paris10.miage.file;


public interface  AbstractFile {
	public enum OpenMode {
        READ(), WRITE(), APPEND();

        private OpenMode() {
        }
    }

 abstract int  getId();

 abstract  String getName();

 //abstract  UserRegistry.User getUser();

 abstract   OpenMode getMode();

 abstract   boolean open(OpenMode mode);

 abstract   boolean close();

 abstract   void rename(String name);

 abstract  String read();

 abstract  boolean write(String content);

 abstract  int size();

}