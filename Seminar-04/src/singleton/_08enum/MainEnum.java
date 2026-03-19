import singleton._08enum.BazaDeDateEnum;

void main() {
    BazaDeDateEnum bazaDeDateEnum1 = BazaDeDateEnum.instanta;
    BazaDeDateEnum bazaDeDateEnum2 = BazaDeDateEnum.instanta;

    System.out.println(bazaDeDateEnum1);
    System.out.println(bazaDeDateEnum2);

    System.out.println(bazaDeDateEnum1 == bazaDeDateEnum2);
}