class Remorca {
	private int cantitateCutii;
	private String numarInmatriculare;
	public static Remorca remorcaCreataAnterior;

	public Remorca(int cantitateCutii, String numarInmatriculare) {
		this.cantitateCutii = cantitateCutii;
		this.numarInmatriculare = numarInmatriculare;
		Remorca.remorcaCreataAnterior = this;

	}

	public Remorca(String numarInmatriculare) {
		this.numarInmatriculare = numarInmatriculare;
		if (Remorca.remorcaCreataAnterior == null) {
			this.cantitateCutii = 10;
			Remorca.remorcaCreataAnterior = this;
		} else {
			this.cantitateCutii = 1 + remorcaCreataAnterior.getCantitateCutii();
			Remorca.remorcaCreataAnterior = this;

		}
	}

	public int getCantitateCutii() {
		return this.cantitateCutii;
	}

	public String getNrInmatriculare() {
		return this.numarInmatriculare;
	}

	public void afisare() {
		System.out.println(this.numarInmatriculare + this.cantitateCutii + "###");

	}

}

class Tir {
	private Remorca[] remorci = new Remorca[5];
	private int nrRemorci;
	public boolean adaugaRemorca(int capacitate, String nr_inmatriculare) {
		if(nrRemorci < 5)
		{
			remorci[nrRemorci] = new Remorca(capacitate, nr_inmatriculare);
			nrRemorci++;
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public boolean adaugaRemorca(Remorca remorca1) {
		if(nrRemorci < 5)
		{
			remorci[nrRemorci] = remorca1;
			nrRemorci++;
			return true;
		}
		else
		{
			return false;
		}
	}
	public Remorca stergeRemorca(String nrInmatriculare) {
		for(int i = 0; i < nrRemorci; i++)
		{
			if( remorci[i].getNrInmatriculare().equals(nrInmatriculare))
			{
				Remorca remorcaReturnata = remorci[i];
				for(int j = i; j < nrRemorci - 1; j++)
				{
					remorci[j] = remorci[j+1];
					
				}
				remorci[nrRemorci-1] = null;
				nrRemorci--;
				return remorcaReturnata;
			}
		}
		return null;
	}
	public int cantitateTransport()
	{
		int cantitate = 0;
		for(int i = 0; i < nrRemorci; i++)
		{
			cantitate += remorci[i].getCantitateCutii();
		}
		return cantitate;
	}
	public boolean equals( Object o) {
		Tir r = null;
		if(o instanceof Tir)
			 r = (Tir) o;
			if(this.cantitateTransport() == r.cantitateTransport())
				return true;
			else 
				return false;
			
	}
	public String toString() {
		String aux = "T->";
		for(int i = 0; i < nrRemorci; i++)
		{
			
			if(i == nrRemorci -1 )
				aux += "R(" + this.remorci[i].getNrInmatriculare() + "," + this.remorci[i].getCantitateCutii() + ")";
			else
				
				aux += "R(" + this.remorci[i].getNrInmatriculare() + "," + this.remorci[i].getCantitateCutii() + ")->";
				
		}
		return aux;
	}
}

