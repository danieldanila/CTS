package main;

import java.io.FileNotFoundException;
import java.util.List;

import clase.Aplicant;
import readers.AplicantReader;
import readers.ElevReader;

public class Program {

	public static void main(String[] args) {
		List<Aplicant> listaElevi;
		AplicantReader reader = new ElevReader();
		try {
			listaElevi = reader.citireAplicanti("elevi.txt");
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		for (Aplicant aplicant : listaElevi) {
			System.out.println(aplicant.toString());
			aplicant.afisareStatutAplicant();
		}
	}
}