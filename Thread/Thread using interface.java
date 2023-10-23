public class Application1 {
    public static void main(String[] args) {
        B objB = new B();
        A objA = new A();
        Thread thread = new Thread(objA);
        thread.start();
        Thread thread1 = new Thread(objB);
        thread1.start();
    }
}

class A implements Runnable {
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("AA");
            try {
                Thread.sleep(500); // Use Thread.sleep() here
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class B implements Runnable {
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("BB");
            try {
                Thread.sleep(500); // Use Thread.sleep() here
            } catch (InterruptedException e) {
                throw new  RuntimeException(e);
            }
        }
    }
}
