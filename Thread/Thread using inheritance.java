import static java.lang.Thread.sleep;

public class Application1 {
    public static void main(String[] args) {
        B objB = new B();
        A objA = new A();


        objA.start();
        objB.start();

    }
}
class B extends Thread{
    public void run(){
        for(int i=0;i<=5;i++)
        {
            System.out.println("BB");
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
class A extends Thread{

    public void run(){
        for(int i=0;i<=5;i++)
        {
            System.out.println("AA");
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

