public class JenericFunction {
    static <T> void display(T element)
    {
        System.out.println(element.getClass().getName()+" = " + element);
    }

    public static void main(String[] args) {
        JenericFunction j = new JenericFunction();
        j.display(123);
        j.display("Bangladesh");
        j.display(12.12);
        j.display(true);

    }
}
