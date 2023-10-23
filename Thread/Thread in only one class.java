import static java.lang.Thread.sleep;

public class Application1 {
    public static void main(String[] args) {
       Thread t = new Thread(new Runnable() {
           @Override
           public void run() {
               for(int i=1;i<=10;i++)
               {

                   System.out.println("java");
                   try {
                       sleep(500);
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }

               }

           }
       });
       t.start();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=10;i++)
                {

                    System.out.println("CPP");
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }

            }
        });
        t1.start();
    }
}

