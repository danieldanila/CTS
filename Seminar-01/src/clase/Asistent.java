package clase;

import interfete.IPredabil;

public class Asistent extends Persoana implements IPredabil {
    private String idAsistent;

    // Constructor fără parametrii
    public Asistent() {
        // super() va apela constructorul fără parametrii din clasa părinte / superclasă,
        // în cazul nostru constructorul fără parametrii al Persoana
        super();
        this.idAsistent = "A00";
    }

    // Constructor cu parametrii
    public Asistent(String nume, int varsta, String idAsistent) {
        // super(nume, varsta) va apela constructorul cu parametrii din clasa părinte / superclasă,
        // în cazul nostru constructorul cu parametrii al Persoana
        super(nume, varsta);
        this.idAsistent = idAsistent;
    }

    public String getIdAsistent() {
        return this.idAsistent;
    }

    @Override
    public void preda() {
        System.out.println(this.getNume() + " preda ca asistent.");
    }
}
