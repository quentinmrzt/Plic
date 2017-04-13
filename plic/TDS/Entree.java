package plic.TDS;

public class Entree {
	protected String idf;
	
	public Entree(String s){
		idf = s;
	}
	
	public String getIdf(){
		return idf;
	}

	@Override
	public int hashCode() {
		return idf.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		if(obj.getClass() != Entree.class){
			return false;
		}
		Entree e = (Entree)obj;
		return idf.equals(e.getIdf());
	}

}
