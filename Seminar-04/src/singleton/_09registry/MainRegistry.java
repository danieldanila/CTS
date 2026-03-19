import singleton._09registry.BazeDeDateRegistry;

void main() {
    BazeDeDateRegistry.register("Baza-Registry-01", 2);
    BazeDeDateRegistry.register("Baza-Registry-02", 5);

    System.out.println(BazeDeDateRegistry.getBazaDeDate("Baza-Registry-01"));
    System.out.println(BazeDeDateRegistry.getBazaDeDate("Baza-Registry-02"));

    System.out.println(BazeDeDateRegistry.getBazaDeDate("Baza-Registry-01") == BazeDeDateRegistry.getBazaDeDate("Baza-Registry-02"));

    // Folosind o cheie deja existentă, va genera o excepție
    BazeDeDateRegistry.register("Baza-Registry-01", 7);
}