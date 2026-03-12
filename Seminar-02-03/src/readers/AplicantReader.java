package readers;

import clase.Aplicant;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public abstract class AplicantReader {
    public abstract List<Aplicant> citireAplicanti(String numeFisier) throws FileNotFoundException;

    public void citireAplicant(Scanner input, Aplicant aplicant) {
        String nume = input.next();
        String prenume = input.next();
        int varsta = input.nextInt();
        int punctaj = input.nextInt();
        int numarProiecte = input.nextInt();
        String[] denumiriProiecte = new String[numarProiecte];
        for (int i = 0; i < numarProiecte; i++)
            denumiriProiecte[i] = input.next();

        aplicant.setNume(nume);
        aplicant.setPrenume(prenume);
        aplicant.setVarsta(varsta);
        aplicant.setPunctaj(punctaj);
        aplicant.setNumarProiecte(numarProiecte, denumiriProiecte);
    }
}