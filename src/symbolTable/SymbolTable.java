package symbolTable;

import java.util.ArrayList;
import java.util.HashMap;

import ast.decl.*;
import ast.expr.IdentExpr;

public class SymbolTable {
	private HashMap<String, Decl> dictionary;

	private SymbolTable parentTable;
	private ArrayList<SymbolTable> childrenTables;
	private ArrayList<FunctionDecl> libFunctions;

	public SymbolTable() {
		dictionary = new HashMap<>();
		parentTable = null;
		childrenTables = null;
		libFunctions = null;
	}

	public void add(IdentExpr id, Decl d) {
		dictionary.put(id.getIdentName(), d);
	}

	public void setParentTable(SymbolTable parentTable) {
		this.parentTable = parentTable;
		parentTable.addChildrenTable(this);
	}
	
	protected void addChildrenTable(SymbolTable childTable) {
		if (childrenTables == null) {
			childrenTables = new ArrayList<>();
		}
		childrenTables.add(childTable);
	}
	
	public void setLibFunctions(ArrayList<FunctionDecl> libFunctions) {
		this.libFunctions = libFunctions;
	}

	public Decl lookup(IdentExpr id) {
		Decl result;
		String name = id.getIdentName();
		result = dictionary.get(name);
		if (result != null) {
			return result;
		}
		if (parentTable == null) {
			return null;
		}
		return parentTable.lookup(id);
	}
	
	public Decl lookupFunction(IdentExpr id) {
		Decl result;
		String name = id.getIdentName();
		result = dictionary.get(name);
		if (result != null && result instanceof FunctionDecl) {
			return result;
		}
		if (parentTable == null) {
			if (libFunctions != null) {
				for (FunctionDecl f : libFunctions) {
					if (id.getIdentName().equals(f.getDeclName())) {
						return f;
					}
				}
			}
		    return null;
		}
		return parentTable.lookupFunction(id);
	}

	public Decl lookupThisScope(IdentExpr id) {
		String name = id.getIdentName();
		return dictionary.get(name);
	}
}
