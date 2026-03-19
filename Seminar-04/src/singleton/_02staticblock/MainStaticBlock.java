import singleton._02staticblock.BazaDeDateStaticBlock;

void main() {
    BazaDeDateStaticBlock bazaDeDateStaticBlock1 = BazaDeDateStaticBlock.getInstanta();
    BazaDeDateStaticBlock bazaDeDateStaticBlock2 = BazaDeDateStaticBlock.getInstanta();

    System.out.println(bazaDeDateStaticBlock1);
    System.out.println(bazaDeDateStaticBlock2);

    System.out.println(bazaDeDateStaticBlock1 == bazaDeDateStaticBlock2);
}