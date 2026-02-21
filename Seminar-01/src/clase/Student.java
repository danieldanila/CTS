package clase;

public class Student extends Persoana implements Cloneable {
    private String idStudent;

    // Constructor fără parametrii
    public Student() {
        // super() va apela constructorul fără parametrii din clasa părinte / superclasă,
        // în cazul nostru constructorul fără parametrii al Persoana
        super();
        this.idStudent = "S00";
    }

    // Constructor cu parametrii
    public Student(String nume, int varsta, String idStudent) {
        // super(nume, varsta) va apela constructorul cu parametrii din clasa părinte / superclasă,
        // în cazul nostru constructorul cu parametrii al Persoana
        super(nume, varsta);
        this.idStudent = idStudent;
    }

    // Constructor de copiere
    public Student(Student altStudent) {
        // super(altStudent) va apela constructorul de copiere din clasa părinte / superclasă,
        // în cazul nostru constructorul de copiere al Persoana
        // Chiar dacă constructorul de copiere al Persoana acceptă un obiect de tipul Persoana,
        // iar noi trimitem un obiect de tipul Student, observăm că un obiect de tip Student
        // poate fi folosit oriunde se așteaptă un obiect de tip Persoana, deoarece Student
        // extinde Persoana și îi moștenește toate proprietățile și comportamentele
        // (upcasting - Student este tratat automat ca Persoana, un exemplu de polimorfism)
        // Acesta este un exemplu care ilustreaza principiul substituției Liskov,
        // „L-ul” din SOLID
        super(altStudent);
        this.idStudent = altStudent.idStudent;
    }

    public String getIdStudent() {
        return this.idStudent;
    }

    @Override
    public Student clone() {
        Student clone = (Student) super.clone();
        return clone;
    }
}
