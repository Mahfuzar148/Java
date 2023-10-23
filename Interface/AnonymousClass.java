public class Person {
    void display()
    {
        System.out.println("Person class");
    }
}
class PersonTest{
    public static void main(String[] args) {
        Person p = new Person(){
              void display(){
                  System.out.println("Test class");
                  method();
              }
              public void method(){
                  System.out.println("Annonymous class");
              }
        };
        p.display();
        Person p1 = new Person();
        p1.display();
    }

}
