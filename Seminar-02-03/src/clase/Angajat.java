package clase;

public class Angajat extends Aplicant {
	private String ocupatie;
	private int salariu;

	public Angajat() {
		super();
		Angajat.sumaFinantare = 10;
	}

	public Angajat(String nume, String prenume, int varsta, int punctaj, int numarProiecte,
				   String[] denumiriProiecte, int salariu, String ocupatie, int sumaFinantare) {
		super(nume, prenume, varsta, punctaj, numarProiecte, denumiriProiecte, sumaFinantare);
		this.salariu = salariu;
		this.ocupatie = ocupatie;
	}

	public String getOcupatie() {
		return this.ocupatie;
	}

	public void setOcupatie(String ocupatie) {
		this.ocupatie = ocupatie;
	}

	public int getSalariu() {
		return this.salariu;
	}

	public void setSalariu(int salariu) {
		this.salariu = salariu;
	}

	@Override
	public String toString() {
		return "Angajat: " + super.toString() + ", ocupatie=" + this.ocupatie + ", salariu=" + this.salariu;
	}

	@Override
	public void afisareFinantare() {
		super.afisareFinantare(Angajat.sumaFinantare, "Angajat");
	}
}