//Written by: Su Win

public class RDFTriple<A, B, C> {
	
	private A subj;
	private B pred;
	private C obj;
	
	RDFTriple(A subj, B pred, C obj) {
		this.subj = subj;
		this.pred = pred;
		this.obj = obj;
	}

	public A getSubj() {
		return this.subj;
	}
	
	public void setSubj(A subj) {
		this.subj = subj;
	}
	
	public B getPred() {
		return this.pred;
	}
	
	public void setPred(B pred) {
		this.pred = pred;
	}
	
	public C getObj() {
		return this.obj;
	}
	
	public void setObj(C obj) {
		this.obj = obj;
	}
	
	public String toString() {
		return "[RDFTriple: subj = " + this.subj + 
					", pred = " + this.pred + 
					", obj = " + this.obj + "]";
	}
}
