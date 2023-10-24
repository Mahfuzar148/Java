public class LamdaExpression1 {
    public static void main(String[] args) {
        Printable obj =(message) -> System.out.println(message);
        obj.print("Lamda Example with single parameter");
    }
}
interface Printable{
    void print(String message);
}
