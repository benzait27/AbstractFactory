package fr.paris10.miage.file;

public abstract class WindowsFile implements File {

	private static UserRegistry registry = new UserRegistry();
	private static int nextId = 0;

	private int id;
	private String name;
	private UserRegistry.User user;
	private OpenMode mode;
	private boolean open;

	public WindowsFile(String name, String username) {
		this.id = nextId++;
		this.name = name;
		this.mode = null;
		this.open = false;
		this.user = registry.getAndCreateIfNeeded(username);
	}

	@Override
	public String toString() {

		return String.format("%s:%s %s", id, user, name);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		WindowsFile that = (WindowsFile) o;

		return id == that.id;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public UserRegistry.User getUser() {
		return user;
	}

	@Override
	public OpenMode getMode() {
		return mode;
	}

	@Override
	public boolean open(OpenMode mode) {
		if (!open) {
			this.open = true;
			this.mode = mode;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean close() {
		if (open) {
			this.open = false;
			this.mode = null;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void rename(String name) {
		this.name = name;
	}

}
