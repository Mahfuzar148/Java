
---

# 🟦 Polymorphism in Java: বিস্তারিত ব্যাখ্যা

## 🔹 1. Polymorphism কী?

**Polymorphism** শব্দটি এসেছে গ্রিক ভাষা থেকে:

* **Poly** = অনেক
* **Morph** = আকার/রূপ

👉 প্রোগ্রামিং-এ এর মানে হলো:
**একটি জিনিস (method বা object) একাধিক রূপে কাজ করতে পারে।**

Java-তে polymorphism মূলত দুইভাবে কাজ করে:

1. **Compile-time Polymorphism (Static Binding / Method Overloading)**
2. **Runtime Polymorphism (Dynamic Binding / Method Overriding)**

---

## 🔹 2. Compile-time Polymorphism (Method Overloading)

* একই ক্লাসে একই নামের method থাকতে পারে, কিন্তু **parameters (type/number/order)** ভিন্ন হতে হবে।
* Compiler নির্ধারণ করে কোন method কল হবে।

### উদাহরণ:

```java
class Calculator {
    // Overloaded methods
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class TestOverloading {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(5, 10));        // int version
        System.out.println(calc.add(2.5, 3.5));    // double version
        System.out.println(calc.add(1, 2, 3));     // 3-parameter version
    }
}
```

👉 Output:

```
15
6.0
6
```

⚡ এক নাম, কিন্তু আলাদা রূপ = **Polymorphism at compile-time**

---

## 🔹 3. Runtime Polymorphism (Method Overriding)

* Subclass **superclass-এর method** override করে তার নিজের behavior define করতে পারে।
* কোন method কল হবে সেটা **runtime-এ JVM নির্ধারণ করে** (object-এর টাইপ দেখে)।

### উদাহরণ:

```java
class Animal {
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Cat meows");
    }
}

public class TestOverriding {
    public static void main(String[] args) {
        Animal a1 = new Dog();   // Upcasting
        Animal a2 = new Cat();

        a1.sound();   // Dog’s sound
        a2.sound();   // Cat’s sound
    }
}
```

👉 Output:

```
Dog barks
Cat meows
```

⚡ এখানে reference টাইপ Animal হলেও, আসল object-এর টাইপ (Dog বা Cat) runtime-এ নির্ধারণ করে কোন method execute হবে। এটাকে **dynamic dispatch** বলা হয়।

---

## 🔹 4. Polymorphism এর ব্যবহারিক সুবিধা

1. **Code reusability** → একই নামের method বিভিন্ন রূপে ব্যবহার করা যায়।
2. **Flexibility** → Implementation পরিবর্তন হলেও client code পরিবর্তন করতে হয় না।
3. **Extensibility** → নতুন ক্লাস যোগ করলে system ভেঙে পড়ে না, শুধু contract মেনে চলে।
4. **Polymorphic references** → একটি superclass reference দিয়ে একাধিক subclass object কে handle করা যায়।

---

## 🔹 5. UML Representation

* UML-এ polymorphism বোঝাতে **inheritance (generalization arrow)** ব্যবহার করা হয়।
* একই superclass method → subclass গুলো override করে বিভিন্ন রূপ দেয়।

---

## 🔹 6. Real-life Example (PDF Inspired)

### Example: UrbanService (Superclass)

```java
class UrbanService {
    public void provideService() {
        System.out.println("General city service");
    }
}

class WasteManagement extends UrbanService {
    @Override
    public void provideService() {
        System.out.println("Waste is being collected in Dhaka");
    }
}

class TrafficManagement extends UrbanService {
    @Override
    public void provideService() {
        System.out.println("Traffic signals controlled in Dhaka");
    }
}
```

### Main Class

```java
public class CityService {
    public static void main(String[] args) {
        UrbanService u1 = new WasteManagement();
        UrbanService u2 = new TrafficManagement();

        u1.provideService();  // Waste service
        u2.provideService();  // Traffic service
    }
}
```

👉 Output:

```
Waste is being collected in Dhaka
Traffic signals controlled in Dhaka
```

⚡ এখানে **UrbanService reference** polymorphic হয়ে দুই রকম আচরণ করছে → **Polymorphism**।

---

## 🔹 7. Polymorphism Summary

* **Compile-time Polymorphism (Overloading):** Same method name, different parameters → সিদ্ধান্ত compiler নেয়।
* **Runtime Polymorphism (Overriding):** Subclass method redefine করে, JVM runtime-এ সিদ্ধান্ত নেয়।
* **Interface & Abstract Class:** Polymorphism এর সবচেয়ে বড় হাতিয়ার → একাধিক implementation একই reference-এ কাজ করতে পারে।

---

✅ সারসংক্ষেপ:
**Polymorphism** হলো Object-Oriented Programming এর backbone। এটি কোডকে flexible, reusable ও maintainable করে। **একই interface/superclass reference বিভিন্ন subclass object কে handle করতে পারে**, ফলে system সহজে scalable হয়।

---

