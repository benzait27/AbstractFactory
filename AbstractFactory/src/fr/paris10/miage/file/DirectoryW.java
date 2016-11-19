package fr.paris10.miage.file;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

final class DirectoryW extends WindowsFile {

	private Map<Integer, WindowsFile> contents;

	public DirectoryW(String name, String username) {
		super(name, username);
		this.contents = new HashMap<>();
	}

	private WindowsFile add(WindowsFile f) {
		return contents.put(f.getId(), f);
	}

	private WindowsFile remove(WindowsFile f) {
		return contents.remove(f.getId());
	}

	public WindowsFile getById(Integer fileId) {
		return contents.get(fileId);
	}

	public WindowsFile getByName(String fileName) {
		return contents.values().stream().filter(f -> f.getName().equals(fileName)).findAny().orElse(null);
	}

	@Override
	public String toString() {
		return String.format("(d)%s [%s]", super.toString(),
				contents.values().stream().map(f -> f.toString()).collect(Collectors.joining("\n")));
	}

	@Override
	public String read() {
		if (getMode() == OpenMode.READ) {
			return contents.values().stream().map(f -> f.toString()).collect(Collectors.joining("\n"));
		} else {
			return null;
		}
	}

	@Override
	public boolean write(String content) {
		if (getMode() == OpenMode.WRITE) {
			contents.clear();
			WindowsFile file = new OrdinaryFileW(content, getUser().getUid());
			add(file);
			return true;
		} else if (getMode() == OpenMode.APPEND) {
			WindowsFile file = new OrdinaryFileW(content, getUser().getUid());
			add(file);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		return contents.size();
	}

}
