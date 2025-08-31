
---

# 🟦 Java Interface: বিস্তারিত আলোচনা

## 🔹 1. Interface কী?

* **Interface** হলো এক ধরনের **contract (চুক্তি)**, যেখানে শুধু **method-এর signature** ঘোষণা করা হয় (method body থাকে না)।
* ক্লাস যখন কোনো interface **implement** করে, তখন সে বাধ্য থাকে interface-এর সব method **implement** করতে।
* এর মাধ্যমে **multiple inheritance of type** সম্ভব হয়, অর্থাৎ এক ক্লাস একাধিক interface implement করতে পারে।

---

## 🔹 2. Interface vs Abstract Class

| বিষয়        | Interface                                                                   | Abstract Class                                     |
| ----------- | --------------------------------------------------------------------------- | -------------------------------------------------- |
| Method body | থাকে না (Java 7 পর্যন্ত), Java 8 থেকে default এবং static methods থাকতে পারে | Abstract method + concrete method দুটোই থাকতে পারে |
| Variables   | সবসময় `public static final` (constant)                                      | instance variables থাকতে পারে                      |
| Inheritance | Multiple inheritance (এক ক্লাস একাধিক interface implement করতে পারে)        | কেবলমাত্র single inheritance                       |
| Usage       | আচরণ (behaviour contract) define করে                                        | আংশিক implementation দেয়                           |

---

## 🔹 3. Java Syntax

### Interface Declaration

```java
public interface Animal {
    void eat();    // abstract by default
    void sleep();
}
```

### Implementing Interface

```java
public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("Dog eats bones.");
    }

    @Override
    public void sleep() {
        System.out.println("Dog sleeps in a kennel.");
    }
}
```

### Usage

```java
public class TestInterface {
    public static void main(String[] args) {
        Animal dog = new Dog();   // Reference type = Interface
        dog.eat();
        dog.sleep();
    }
}
```

---

## 🔹 4. Interface Features

### (a) Multiple Inheritance

Java ক্লাস একাধিক interface implement করতে পারে:

```java
interface A { void methodA(); }
interface B { void methodB(); }

class C implements A, B {
    public void methodA() { System.out.println("A method"); }
    public void methodB() { System.out.println("B method"); }
}
```

---

### (b) Default Methods (Java 8+)

Interface এ **default method** থাকতে পারে → implement না করলেও চলবে।

```java
interface Vehicle {
    void start();
    default void stop() {
        System.out.println("Vehicle stopped.");
    }
}

class Car implements Vehicle {
    public void start() {
        System.out.println("Car started.");
    }
}
```

---

### (c) Static Methods (Java 8+)

Interface এ static method থাকতে পারে (class এর মতো কল করতে হয়)।

```java
interface MathUtils {
    static int add(int a, int b) {
        return a + b;
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(MathUtils.add(5, 10)); // static call
    }
}
```

---

### (d) Private Methods (Java 9+)

Interface এ **private helper method** রাখা যায় → শুধুমাত্র default method এর মধ্যে ব্যবহার করা যায়।

```java
interface Logger {
    default void log(String msg) {
        prepare();
        System.out.println("LOG: " + msg);
    }

    private void prepare() {
        System.out.println("Preparing log...");
    }
}
```

---

## 🔹 5. UML Representation

* UML diagram-এ interface বোঝাতে `«interface»` লেখা হয়।
* Arrow: **dotted line + hollow arrowhead** superclass/interface এর দিকে যায়।

---

## 🔹 6. Real-life Example: Urban Management System (PDF Example)

```java
interface UrbanDepartment {
    void manage();
}

class WasteManagement implements UrbanDepartment {
    public void manage() {
        System.out.println("Waste managed in Dhaka");
    }
}

class TrafficManagement implements UrbanDepartment {
    public void manage() {
        System.out.println("Traffic signals controlled in Dhaka");
    }
}
```

👉 এখানে `UrbanDepartment` হলো interface (contract) এবং WasteManagement ও TrafficManagement হলো এর বাস্তব implementation।

---

## 🔹 7. Interface-এর ব্যবহারিক সুবিধা

* **Polymorphism** → একই interface reference দিয়ে বিভিন্ন ক্লাস চালানো যায়।
* **Loose coupling** → implementation change হলেও interface contract একই থাকে।
* **Scalability** → নতুন ক্লাস যোগ করলে পুরোনো কোডে পরিবর্তন দরকার হয় না।
* **Multiple inheritance support** → একাধিক আচরণ এক ক্লাসে আনা যায়।

---

✅ **সারসংক্ষেপ:**
Java-তে interface হলো এমন একটি structure যেটা **behaviour contract** দেয়। এটি multiple inheritance-এর বিকল্প, polymorphism নিশ্চিত করে, এবং flexible system design-এ সহায়তা করে। Java 8 থেকে default ও static methods এবং Java 9 থেকে private methods যুক্ত হওয়ায় interface আরও শক্তিশালী হয়েছে।

---

