package clase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Curs implements Cloneable {
    private String numeCurs;
    private int credite;
    private Profesor profesor;
    private List<Student> studenti;

    // Constructor fără parametrii
    public Curs() {
        this.numeCurs = "Curs fara nume";
        this.credite = 0;
        this.profesor = new Profesor();
        this.studenti = new ArrayList<>();
    }

    // Constructor cu parametrii
    public Curs(String numeCurs, int credite, Profesor profesor, List<Student> studenti) {
        this.numeCurs = numeCurs;
        this.credite = credite;
        // this.profesor = profesor; // shallow copy (copiem referința obiectului, ambele obiecte referă aceeași locație de memorie)
        // this.profesor = new Profesor(profesor.getNume(), profesor.getVarsta(), profesor.getIdAngajat()); // deep copy (nerecomandat). Această modalitate funcționează ca deep copy deoarece avem DOAR String (care este imuabil / immutable) și int (care este de tip primitiv)
        // this.profesor = profesor.clone(); // deep copy folosind metoda clone(), implementată din interfața Cloneable
        this.profesor = new Profesor(profesor); // deep copy folosind constructorul de copiere
        // this.studenti = studenti; // shallow copy (copiem referința obiectului, ambele obiecte referă aceeași locație de memorie)
        // this.studenti = new ArrayList<>(studenti); // deep copy „incomplet”. Noua listă este un deep copy, insă studenții sunt shallow copy
        // 1. deep copy complet prin crearea unei liste noi, iar fiecărui student îi este creat un deep copy folosind constructorul de copiere
        // this.studenti = new ArrayList<>();
        // for (Student student : studenti) {
        //     this.studenti.add(new Student(student));
        // }
        // 2.
        // this.studenti = studenti.stream().map(student -> new Student(student)).collect(Collectors.toList());
        // 3.
        this.studenti = studenti.stream().map(Student::new).collect(Collectors.toList());
        // 1, 2 și 3 sunt echivalente, toate realizând deep copy atât pentru listă, cât și pentru fiecare student
    }

    // Constructor de copiere
    public Curs(Curs other) {
        this.numeCurs = other.numeCurs;
        this.credite = other.credite;
        this.profesor = new Profesor(other.profesor); // deep copy folosind constructorul de copiere
        this.studenti = other.studenti.stream().map(Student::new).collect(Collectors.toList()); // deep copy prin crearea unei liste noi, iar fiecărui student îi este creat un deep copy folosind constructorul de copiere
    }

    public String getNumeCurs() {
        return this.numeCurs;
    }

    public int getCredite() {
        return this.credite;
    }

    public Profesor getProfesor() {
        // return this.profesor; // shallow copy
        return new Profesor(this.profesor); // deep copy folosind constructorul de copiere
    }

    public List<Student> getStudenti() {
        // return this.studenti; // shallow copy

        // 1. deep copy complet prin crearea unei liste noi, iar fiecărui student îi este creat un deep copy folosind constructorul de copiere
        // List<Student> copy = new ArrayList<>();
        // for (Student student : this.studenti) {
        //     copy.add(new Student(student));
        // }
        // return copy;
        // 2.
        // return this.studenti.stream().map(student -> new Student(student)).collect(Collectors.toList());
        // 3.
        return this.studenti.stream().map(Student::new).collect(Collectors.toList());
        // 1, 2 și 3 sunt echivalente, toate realizând deep copy atât pentru listă, cât și pentru fiecare student
    }

    public void setStudenti(List<Student> studenti) {
        // this.studenti = studenti; // shallow copy (copiem referința obiectului, ambele obiecte referă aceeași locație de memorie)
        this.studenti = studenti.stream().map(Student::new).collect(Collectors.toList()); // deep copy complet prin crearea unei liste noi, iar fiecărui student îi este creat un deep copy folosind constructorul de copiere
    }

    @Override
    public Curs clone() {
        try {
            Curs cloned = (Curs) super.clone();
            cloned.profesor = this.profesor.clone(); // deep copy folosind metoda clone(), implementată din interfața Cloneable
            cloned.studenti = this.studenti.stream().map(Student::clone).collect(Collectors.toList()); // deep copy complet prin crearea unei liste noi, iar fiecărui student îi este creat un deep copy folosind metoda clone(), implementată din interfața Cloneable
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
