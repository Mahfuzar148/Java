public class LamdaExpession2 {
    public static void main(String[] args) {
        Addable obj1 =(a,b)->{return (a+b);};
        substract obj2 =(x,y)->{
            int ans = x-y;
            return ans;
        };
        System.out.println(obj1.add(15,20));
        System.out.println(obj2.sub(45,30));
    }
}
interface Addable{
    int add(int a,int b);
}
interface substract{
    int sub(int x,int y);
}
