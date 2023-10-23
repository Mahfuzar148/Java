public class OuterClass {
    void showOuter(){
        System.out.println("This is outer class");
        class MethodClass{
            void showMethodClass(){
                System.out.println("This is method class");
            }
        }
        MethodClass methodClass = new MethodClass();
        methodClass.showMethodClass();
    }
    public class InnerClass{
        void showInner(){
            System.out.println("This is inner class");

        }
        public class InnerInnerClass{
            void showInnerInnerClass(){
                System.out.println("This is innerInner class");
            }
        }
    }
}
class OuterClassTester1 {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.showOuter();
        OuterClass.InnerClass innerClass=  outerClass.new InnerClass();
        innerClass.showInner();
        OuterClass.InnerClass.InnerInnerClass innerInnerClass = innerClass.new InnerInnerClass();
        innerInnerClass.showInnerInnerClass();
    }

}
