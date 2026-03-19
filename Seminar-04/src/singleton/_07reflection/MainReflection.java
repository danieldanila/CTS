import singleton._03lazy.BazaDeDateLazy;
import singleton._07reflection.BazaDeDateReflection;

void main() {
    BazaDeDateLazy bazaDeDateLazy1 = BazaDeDateLazy.getInstanta("Baza-Lazy-01", 2);
    BazaDeDateLazy bazaDeDateLazy2;

    try {
        Constructor<BazaDeDateLazy> constructor = BazaDeDateLazy.class.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        // Permite crearea unui nou obiect
        bazaDeDateLazy2 = constructor.newInstance("Baza-Lazy-02", 5);
    } catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
        throw new RuntimeException(e);
    }

    System.out.println(bazaDeDateLazy1);
    System.out.println(bazaDeDateLazy2);

    // Mereu false
    System.out.println(bazaDeDateLazy1 == bazaDeDateLazy2);

    BazaDeDateReflection bazaDeDateReflection1 = BazaDeDateReflection.getInstanta("Baza-Reflection-01", 7);
    BazaDeDateReflection bazaDeDateReflection2;

    try {
        Constructor<BazaDeDateReflection> constructor = BazaDeDateReflection.class.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        // NU permite crearea unui nou obiect datorită verificării din constructorul BazaDeDateReflection, ce va arunca RuntimeException
        bazaDeDateReflection2 = constructor.newInstance("Baza-Reflection-02", 9);
    } catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException exception) {
        throw new RuntimeException(exception);
    }

    System.out.println(bazaDeDateReflection1);
    System.out.println(bazaDeDateReflection2);

    System.out.println(bazaDeDateReflection1 == bazaDeDateReflection2);
}