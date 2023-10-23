public class TestA {
    public static void main(String[] args) {
        A obj = new A() {
            @Override
            public void print1() {
                System.out.println("Mahfuz");
            }

            @Override
            public void print2() {
                System.out.println("Rahman");
            }

        };
        obj.print1();
        obj.print2();
    }


}
interface A{
    void print1();
    void print2();
}
