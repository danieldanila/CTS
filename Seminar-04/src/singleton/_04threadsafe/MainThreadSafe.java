import singleton._03lazy.BazaDeDateLazy;
import singleton._04threadsafe.BazaDeDateThreadSafe;

static BazaDeDateLazy bazaDeDateLazy1;
static BazaDeDateLazy bazaDeDateLazy2;

static BazaDeDateThreadSafe bazaDeDateThreadSafe1;
static BazaDeDateThreadSafe bazaDeDateThreadSafe2;

void main() throws InterruptedException {
    Thread thread1 = new Thread(() -> bazaDeDateLazy1 = BazaDeDateLazy.getInstanta("Baza-Lazy-01", 2));
    Thread thread2 = new Thread(() -> bazaDeDateLazy2 = BazaDeDateLazy.getInstanta("Baza-Lazy-02", 5));

    thread1.start();
    thread2.start();

    thread1.join();
    thread2.join();

    System.out.println(bazaDeDateLazy1);
    System.out.println(bazaDeDateLazy2);

    // O să fie true SAU false (race condition)
    System.out.println(bazaDeDateLazy1 == bazaDeDateLazy2);

    Thread thread3 = new Thread(() -> bazaDeDateThreadSafe1 = BazaDeDateThreadSafe.getInstanta("Baza-ThreadSafe-01", 7));
    Thread thread4 = new Thread(() -> bazaDeDateThreadSafe2 = BazaDeDateThreadSafe.getInstanta("Baza-ThreadSafe-02", 10));

    thread3.start();
    thread4.start();

    thread3.join();
    thread4.join();

    System.out.println(bazaDeDateThreadSafe1);
    System.out.println(bazaDeDateThreadSafe2);

    // Mereu o să fie true
    System.out.println(bazaDeDateThreadSafe1 == bazaDeDateThreadSafe2);
}