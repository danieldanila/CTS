import singleton._03lazy.BazaDeDateLazy;

void main() {
    BazaDeDateLazy bazaDeDateLazy1 = BazaDeDateLazy.getInstanta("Baza-Lazy-01", 2);
    BazaDeDateLazy bazaDeDateLazy2 = BazaDeDateLazy.getInstanta("Baza-Lazy-02", 5);

    System.out.println(bazaDeDateLazy1);
    System.out.println(bazaDeDateLazy2);

    System.out.println(bazaDeDateLazy1 == bazaDeDateLazy2);
}