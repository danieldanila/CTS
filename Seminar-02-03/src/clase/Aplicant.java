package clase;

import java.util.Arrays;

public abstract class Aplicant {
	protected String nume;
	protected String prenume;
	protected int varsta;
	protected int punctaj;
	protected int numarProiecte;
	protected String[] denumiriProiecte;

	private static final int pragAcceptare = 80;
	protected static int sumaFinantare;

	public Aplicant() {
		super();
		Aplicant.sumaFinantare = 0;
	}

	public Aplicant(String nume, String prenume, int varsta, int punctaj, int numarProiecte,
					String[] denumiriProiecte, int sumaFinantare) {
		super();
		this.nume = nume;
		this.prenume = prenume;
		this.varsta = varsta;
		this.punctaj = punctaj;
		this.numarProiecte = numarProiecte;
		this.denumiriProiecte = denumiriProiecte;
		Aplicant.sumaFinantare = sumaFinantare;
	}

	public String getNume() {
		return this.nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return this.prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public int getVarsta() {
		return this.varsta;
	}

	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}

	public int getPunctaj() {
		return this.punctaj;
	}

	public void setPunctaj(int punctaj) {
		this.punctaj = punctaj;
	}

	public int getNumarProiecte() {
		return this.numarProiecte;
	}

	public void setNumarProiecte(int numarProiecte, String[] denumiriProiecte) {
		this.numarProiecte = numarProiecte;
		this.denumiriProiecte = new String[numarProiecte];
		for (int i = 0; i < numarProiecte; i++) {
			this.denumiriProiecte[i] = denumiriProiecte[i];
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("nume=");
		builder.append(this.nume);
		builder.append(", prenume=");
		builder.append(this.prenume);
		builder.append(", varsta=");
		builder.append(this.varsta);
		builder.append(", punctaj=");
		builder.append(this.punctaj);
		builder.append(", numarProiecte=");
		builder.append(this.numarProiecte);
		builder.append(", denumiriProiecte=");
		builder.append(Arrays.toString(this.denumiriProiecte));
		return builder.toString();
	}

	public void afisareStatutAplicant() {
		System.out.println("Aplicantul " + this.nume + " " + this.prenume +
				(this.punctaj > Aplicant.pragAcceptare ? " " : " nu ") + "a fost acceptat");
	}

	public abstract void afisareFinantare();

	protected void afisareFinantare(int sumaFinantare, String tipPersoana) {
		System.out.println(tipPersoana + " " + getNume() + " " + getPrenume() +
				" primeste" + sumaFinantare + " euro/zi in proiect.");
	}
}