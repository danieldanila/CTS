package clase;

public class Student extends Aplicant {
	protected String facultate;
	protected int anStudii;

	public Student() {
		super();
		Student.sumaFinantare = 10;
	}

	public Student(String nume, String prenume, int varsta, int punctaj, int numarProiecte,
				   String[] denumireProiect, String facultate, int anStudii, int sumaFinantare) {
		super(nume, prenume, varsta, punctaj, numarProiecte, denumireProiect, sumaFinantare);
		this.facultate = facultate;
		this.anStudii = anStudii;
	}

	public String getFacultate() {
		return this.facultate;
	}

	public void setFacultate(String facultate) {
		this.facultate = facultate;
	}

	public int getAnStudii() {
		return this.anStudii;
	}

	public void setAnStudii(int anStudii) {
		this.anStudii = anStudii;
	}

	@Override
	public String toString() {
		return "Student: " + super.toString() + "Facultate=" + this.facultate + ", An studii=" + this.anStudii;
	}

	@Override
	public void afisareFinantare() {
		super.afisareFinantare(Student.sumaFinantare, "Student");
	}
}