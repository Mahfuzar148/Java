public class Box<T> {
    T container;
    public Box(T container)
    {
        this.container = container;
    }
    public void performSomeTask(){
        if(container instanceof String )
        {
            System.out.println(" Length of " + container +" : " +((String) container).length());
        }
        else if(container instanceof Integer)
        {
            System.out.println(container);
        }
    }
    public T getContainer()
    {
        return container;
    }

}
 class Example1 {
    public static void main(String[] args) {

        Box<String> box = new Box<String>("Wow! This is amazing");
        System.out.println(box.getContainer());
        System.out.println(box.container.getClass().getName());


        Box<Integer> box1 = new Box<>(123);
        System.out.println(box1.getContainer());
        System.out.println(box1.container.getClass().getName());


        Box<Boolean>box2 = new Box<>(true);
        System.out.println(box2.getContainer());
        System.out.println(box2.container.getClass().getName());


        box.performSomeTask();
        box1.performSomeTask();
    }
}

