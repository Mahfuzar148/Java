
---

# 🟦 Generalization (Inheritance) ব্যাখ্যা

### 🔹 সংজ্ঞা

* **Generalization** হলো Object-Oriented Design (OOD)-এর একটি নীতি, যেখানে একাধিক ক্লাসের সাধারণ বৈশিষ্ট্য ও আচরণ (attributes এবং methods) একটি **superclass** এ রাখা হয়।
* এরপর **subclass** গুলো সেই superclass থেকে ঐ সাধারণ বৈশিষ্ট্যগুলো **inherit** করে এবং নিজেদের বিশেষ (specialized) বৈশিষ্ট্য যোগ করতে পারে।

👉 অর্থাৎ, common অংশগুলো একবার লিখে reuse করা যায়, বারবার লিখতে হয় না।

---

### 🔹 উদ্দেশ্য ও সুবিধা

* **Reduces redundancy** → একই কোড বারবার লেখার দরকার নেই।
* **Code reuse** → superclass-এ করা পরিবর্তন সব subclass-এ প্রয়োগ হয়।
* **Flexibility & maintainability** → নতুন subclass সহজেই যোগ করা যায়।
* **Hierarchy তৈরি হয়** → parent–child সম্পর্ক বোঝা যায় UML বা কোডে।

---

### 🔹 UML এ Visualization

* UML diagram-এ generalization বোঝাতে **solid line + hollow arrowhead** ব্যবহার করা হয়।
* Arrow সবসময় superclass-এর দিকে নির্দেশ করে।

---

### 🔹 জাভা উদাহরণ

**Superclass → Animal**

```java
class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " is eating...");
    }

    public void sleep() {
        System.out.println(name + " is sleeping...");
    }
}
```

**Subclass → Dog**

```java
class Dog extends Animal {
    public Dog(String name) {
        super(name); // superclass constructor call
    }

    public void bark() { // Dog-এর বিশেষ আচরণ
        System.out.println(name + " is barking!");
    }
}
```

**Main Class →**

```java
public class InheritanceExample {
    public static void main(String[] args) {
        Dog myDog = new Dog("Dog-1");
        myDog.eat();     // Inherited from Animal
        myDog.sleep();   // Inherited from Animal
        myDog.bark();    // Specialized in Dog
    }
}
```

---

### 🔹 Dhaka Urban Example

* **Superclass** → UrbanService

  * General service attributes & methods
* **Subclass** → WasteManagement, TrafficManagement

  * WasteManagement শহরের আবর্জনা ম্যানেজ করবে
  * TrafficManagement ট্রাফিক সিগন্যাল ম্যানেজ করবে

---

### 🔹 Agricultural Automation Example

* **Superclass** → FarmingMachine (সাধারণ মেশিন ফিচার)
* **Subclass** → IrrigationSystem, Harvester

  * IrrigationSystem → সেচের কাজ করবে
  * Harvester → ফসল কাটার কাজ করবে

---

### 🔹 Inheritance Features

1. **Constructors**

   * Subclass constructor → `super()` দিয়ে parent constructor কল করে।
2. **Method Overriding**

   * Subclass superclass-এর method redefine করতে পারে।
3. **Types of Inheritance** (Java-তে)

   * **Single Inheritance**: এক parent থেকে extend করা যায়।
   * **Multi-level Inheritance**: subclass নিজেও অন্য class-এর superclass হতে পারে।
4. **Interface Inheritance**

   * Multiple inheritance-এর বিকল্প → `interface` + `implements`
   * Allows polymorphism (same method, different implementation)

---

✅ সারসংক্ষেপ: **Generalization (Inheritance)** হলো parent-child structure তৈরি করার প্রক্রিয়া যেখানে common attributes superclass-এ রাখা হয় এবং subclass গুলো সেগুলো inherit করে নিজেদের বিশেষ বৈশিষ্ট্য যোগ করে। এটা কোডের পুনরাবৃত্তি কমায়, maintainability বাড়ায় এবং flexibility আনে।

---

