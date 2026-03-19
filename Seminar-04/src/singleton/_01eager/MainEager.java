import singleton._01eager.BazaDeDateEager;

void main() {
    BazaDeDateEager bazaDeDateEager1 = BazaDeDateEager.getInstanta();
    BazaDeDateEager bazaDeDateEager2 = BazaDeDateEager.getInstanta();

    System.out.println(bazaDeDateEager1);
    System.out.println(bazaDeDateEager2);

    System.out.println(bazaDeDateEager1 == bazaDeDateEager2);
}