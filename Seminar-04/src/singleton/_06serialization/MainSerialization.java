import singleton._06serialization.BazaDeDateSerialization;
import singleton._06serialization.BazaDeDateSerializationFaraReadResolve;

void main() throws IOException, ClassNotFoundException {
    BazaDeDateSerializationFaraReadResolve bazaDeDateSerializationFaraReadResolve1 = BazaDeDateSerializationFaraReadResolve.getInstanta("Baza-Serialization-Fara-Read-Resolve-01", 2);

    ObjectOutput output = new ObjectOutputStream(new FileOutputStream(".\\src\\singleton\\_06serialization\\baza-de-date-serialization-fara-read-resolve.bin"));
    output.writeObject(bazaDeDateSerializationFaraReadResolve1);
    output.close();

    ObjectInput input = new ObjectInputStream(new FileInputStream(".\\src\\singleton\\_06serialization\\baza-de-date-serialization-fara-read-resolve.bin"));
    BazaDeDateSerializationFaraReadResolve bazaDeDateSerializationFaraReadResolve2 = (BazaDeDateSerializationFaraReadResolve) input.readObject();
    input.close();

    System.out.println(bazaDeDateSerializationFaraReadResolve1);
    System.out.println(bazaDeDateSerializationFaraReadResolve2);

    // Mereu false
    System.out.println(bazaDeDateSerializationFaraReadResolve1 == bazaDeDateSerializationFaraReadResolve2);

    BazaDeDateSerialization bazaDeDateSerialization1 = BazaDeDateSerialization.getInstanta("Baza-Serialization-01", 5);

    ObjectOutput output2 = new ObjectOutputStream(new FileOutputStream(".\\src\\singleton\\_06serialization\\baza-de-date-serialization.bin"));
    output2.writeObject(bazaDeDateSerialization1);
    output2.close();

    ObjectInput input2 = new ObjectInputStream(new FileInputStream(".\\src\\singleton\\_06serialization\\baza-de-date-serialization.bin"));
    BazaDeDateSerialization bazaDeDateSerialization2 = (BazaDeDateSerialization) input2.readObject();
    input2.close();

    System.out.println(bazaDeDateSerialization1);
    System.out.println(bazaDeDateSerialization2);

    // Mereu true
    System.out.println(bazaDeDateSerialization1 == bazaDeDateSerialization2);
}