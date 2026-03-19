import singleton._05innerstatichelperclass.BazaDeDateInnerStaticHelperClass;

void main() {
    BazaDeDateInnerStaticHelperClass bazaDeDateInnerStaticHelperClass1 = BazaDeDateInnerStaticHelperClass.getInstanta();
    BazaDeDateInnerStaticHelperClass bazaDeDateInnerStaticHelperClass2 = BazaDeDateInnerStaticHelperClass.getInstanta();

    System.out.println(bazaDeDateInnerStaticHelperClass1);
    System.out.println(bazaDeDateInnerStaticHelperClass2);

    System.out.println(bazaDeDateInnerStaticHelperClass1 == bazaDeDateInnerStaticHelperClass2);
}