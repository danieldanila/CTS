package clase;

public class Elev extends Aplicant {
	private int clasa;
	private String tutore;

	public Elev() {
		super();
		Elev.sumaFinantare = 80;
	}

	public Elev(String nume, String prenume, int varsta, int punctaj,
				int numarProiecte, String[] denumiriProiecte, int clasa, String tutore, int sumaFinantare) {
		super(nume, prenume, varsta, punctaj, numarProiecte, denumiriProiecte, sumaFinantare);
		this.clasa = clasa;
		this.tutore = tutore;
	}

	public int getClasa() {
		return this.clasa;
	}

	public void setClasa(int clasa) {
		this.clasa = clasa;
	}

	public String getTutore() {
		return this.tutore;
	}

	public void setTutore(String tutore) {
		this.tutore = tutore;
	}

	@Override
	public String toString() {
		return "Elev: " + super.toString() + ", clasa=" + this.clasa + ", tutore=" + this.tutore;
	}

	@Override
	public void afisareFinantare() {
		super.afisareFinantare(Elev.sumaFinantare, "Elev");
	}
}