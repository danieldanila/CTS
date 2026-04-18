import composite.Departament;
import composite.Sectie;
import composite.StructuraSpital;

void main() {
    StructuraSpital dermatologie = new Sectie("Dermatologie");
    StructuraSpital cardiologie = new Sectie("Cardiologie");
    StructuraSpital pediatrie = new Sectie("Pediatrie");

    StructuraSpital departamentAdulti = new Departament("Departament Adulti");
    StructuraSpital departamentCopii = new Departament("Departament Copii");

    StructuraSpital spital = new Departament("Spital");

    departamentAdulti.adauga(dermatologie);
    departamentAdulti.adauga(cardiologie);

    departamentCopii.adauga(pediatrie);

    spital.adauga(departamentAdulti);
    spital.adauga(departamentCopii);

    spital.afiseazaIerarhie("");
}