public class TestA {
    public static void main(String[] args) {
           A obj = new A(){
               public void print1(){
                   System.out.println("Mahmudul Hassan Miraz");
               }
           };
           obj.print1();
           obj.print2();
    }


}
abstract class A{
    abstract public void print1();
    public void  print2(){
        System.out.println("Mahfuzar Rahman");
    }

}
