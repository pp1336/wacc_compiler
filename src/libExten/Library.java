package libExten;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Library {
	
	private String libName;
	
	private ArrayList<Library> subLibrarys = new ArrayList<Library>();
	
	private String libraryCode = "";
	
	public void setLibraryCode(String libraryCode) {
		this.libraryCode = libraryCode;
	}
	
	public String getLibraryCode() {
		return libraryCode;
	}
	
	private static Library instance;
	
	public static Library getMasterLibrary(){
		if (instance == null) {
			instance = new Library("master");
		}
		// add all libraries and libFuncs here
                
                // navie libs added for testing
		Library t3 = new Library("testLib3");
		t3.setLibraryCode("\nint inc(int x) is\n  return x + 1\nend\n");
		Library t2 = new Library("testLib2");
		t2.setLibraryCode("\nint incc(int x) is\n  return x + 2\nend\n\nint "
                                  + "inc(int x) is\n  return x + 1\nend\n");
		t2.addToSubLibrarys(t3);
		Library t1 = new Library("testLib1");
		t1.setLibraryCode("\nint inc(int x) is\n  return x + 1\nend\n");
		t1.addToSubLibrarys(t2);
                instance.addToSubLibrarys(t1);

                // adding wacc libraries
                Library math = new Library("math");
                Library array = new Library("array");
                Library string = new Library("string");
                try {
                    math = Library.createLibraryFromPath("library/math.txt");
                } catch(FileNotFoundException e) {
                    System.out.println("library " + math.getLibName()
                                       + " not found !!!");
                }
                try {
                    array = Library.createLibraryFromPath("library/array.txt");
                } catch(FileNotFoundException e) {
                    System.out.println("library " + array.getLibName()
                                       + " not found !!!");
                }
                try {
                    string = Library.createLibraryFromPath("library/string.txt");
                } catch(FileNotFoundException e) {
                    System.out.println("library " + string.getLibName()
                                       + " not found !!!");
                }
                instance.addToSubLibrarys(math);
                instance.addToSubLibrarys(array);
                instance.addToSubLibrarys(string);

		return instance;
	}
	
	public static Library createLibraryFromPath(String path)
                      throws FileNotFoundException {
		Scanner in = new Scanner(new FileInputStream(path));
		String name = in.nextLine();
		String code = "";
		while(in.hasNextLine()) {
			code += in.nextLine() + '\n';
		}
		in.close();
		return new Library(name, code);
	}
	
	public Library(String libName) {
		this.libName = libName;
	}
	
	public Library(String libName, String libraryCode) {
		this.libName = libName;
		this.libraryCode = libraryCode;
	}
	
	public String getLibName() {
		return libName;
	}
	
	public void addToSubLibrarys(Library l) {
		if (l != null && !subLibrarys.contains(l)) {
			subLibrarys.add(l);
		}
	}
	
	public Library searchForLibraryWithGivenPath(ArrayList<String> names) {
		if (names != null) {
			if (names.size() == 0) {
				return this;
			}
			for (Library l : subLibrarys) {
				if (l.getLibName().equals(names.get(0))) {
				    names.remove(0);
				    return l.searchForLibraryWithGivenPath(names);
				}
			}
		}
		return null;
	}
	
	// deprecated
	public Library searchForLibrary(String name) {
		if (libName.equals(name)) {
			return this;
		}
		if (subLibrarys != null) {
			for (Library l : subLibrarys) {
				Library r = l.searchForLibrary(name);
				if (r != null) {
					return r;
				}
			}
		}
		return null;
	}
	
	// deprecated
	public Library searchForSubLibrary(String name) {
		if (subLibrarys != null) {
			for (Library l : subLibrarys) {
				if (l.getLibName().equals(name)) {
					return l;
				}
			}
		}
		return null;
	}
	
	@Override
	public int hashCode() {
		return libName.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Library)) {
			return false;
		}
		Library l = (Library) o;
		return libName.equals(l.getLibName());
	}
	
	// for debugging
	public void printLib(String indent) {
		System.out.println(indent + "lib name : " + libName);
		System.out.println(indent + "lib code : ");
		System.out.println(indent + libraryCode);
		indent = indent + "  ";
		for (Library l : subLibrarys) {
			l.printLib(indent);
		}
	}
	
}
