package ast.expr.rhsexpr;

/*
 * A helper class for indicating a pair
 * !!!: Never used during code generation
 */
public class Pair<S, T> {
	S fst;
	T snd;

	public Pair(S fst, T snd) {
		this.fst = fst;
		this.snd = snd;
	}

	public S getFst() {
		return fst;
	}

	public T getSnd() {
		return snd;
	}
}
