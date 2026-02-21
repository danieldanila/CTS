package clase;

import interfete.IPredabil;

// O clasă poate extinde o singură altă clasă, dar poate implementa multiple interfețe
public class Profesor extends Persoana implements IPredabil, Cloneable {
    private String idAngajat;

    // Constructor fără parametrii
    public Profesor() {
        // super() va apela constructorul fără parametrii din clasa părinte / superclasă,
        // în cazul nostru constructorul fără parametrii al Persoana
        super();
        this.idAngajat = "P00";
    }

    // Constructor cu parametrii
    public Profesor(String nume, int varsta, String idAngajat) {
        // super(nume, varsta) va apela constructorul cu parametrii din clasa părinte / superclasă,
        // în cazul nostru constructorul cu parametrii al Persoana
        super(nume, varsta);
        this.idAngajat = idAngajat;
    }

    // Constructor de copiere
    public Profesor(Profesor altProfesor) {
        // super(altProfesor) va apela constructorul de copiere din clasa părinte / superclasă,
        // în cazul nostru constructorul de copiere al Persoana
        // Chiar dacă constructorul de copiere al Persoana acceptă un obiect de tipul Persoana,
        // iar noi trimitem un obiect de tipul Profesor, observăm că un obiect de tip Profesor
        // poate fi folosit oriunde se așteaptă un obiect de tip Persoana, deoarece Profesor
        // extinde Persoana și îi moștenește toate proprietățile și comportamentele
        // (upcasting - Profesor este tratat automat ca Persoana, un exemplu de polimorfism)
        // Acesta este un exemplu care ilustreaza principiul substituției Liskov,
        // „L-ul” din SOLID
        super(altProfesor);
        this.idAngajat = altProfesor.idAngajat;
    }

    public String getIdAngajat() {
        return this.idAngajat;
    }

    @Override
    public void preda() {
        System.out.println(this.getNume() + " preda ca profesor.");
    }

    @Override
    public Profesor clone() {
        Profesor clone = (Profesor) super.clone();
        return clone;
    }
}
