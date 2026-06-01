package clase;

import exceptii.CnpInvalidException;

public class CnpValidator {
    private static final int CNP_LUNGIME = 13;
    private static final int CNP_MODULO = 11;
    private static final int CNP_CIFRA_CONTROL_SPECIAL = 10;
    private static final int CNP_CIFRA_CONTROL_INLOCUITOR = 1;
    private static final int CNP_INDEX_CIFRA_CONTROL = 12;
    private static final String COMPONENTA_C = "279146358279";

    public void valideazaCnp(String cnp) {
        if (cnp == null || cnp.isEmpty()) {
            throw new CnpInvalidException("CNP-ul nu poate fi null sau necompletat");
        }

        if (cnp.length() != CNP_LUNGIME) {
            throw new CnpInvalidException("CNP-ul trebuie să conțină exact " + CNP_LUNGIME + " cifre: " + cnp);
        }

        if (!cnp.matches("\\d+")) {
            throw new CnpInvalidException("CNP-ul trebuie să conțină doar cifre: " + cnp);
        }

        if ("09".indexOf(cnp.charAt(0)) != -1) {
            throw new CnpInvalidException("Prima cifră din CNP este invalidă: " + cnp);
        }

        if (!this.esteCnpValid(cnp)) {
            throw new CnpInvalidException("CNP-ul nu trece validarea matematică: " + cnp);
        }
    }

    private boolean esteCnpValid(String cnp) {
        int suma = 0;

        for (int i = 0; i < COMPONENTA_C.length(); i++) {
            suma += Character.getNumericValue(cnp.charAt(i))
                    * Character.getNumericValue(COMPONENTA_C.charAt(i));
        }

        int cifraControl = suma % CNP_MODULO;

        if (cifraControl == CNP_CIFRA_CONTROL_SPECIAL) {
            cifraControl = CNP_CIFRA_CONTROL_INLOCUITOR;
        }

        return cifraControl == Character.getNumericValue(cnp.charAt(CNP_INDEX_CIFRA_CONTROL));
    }
}
