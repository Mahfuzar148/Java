
# Abstraction কী?

**Abstraction** মানে হলো *জটিল ইমপ্লিমেন্টেশন লুকিয়ে* শুধু **প্রয়োজনীয় আচরণ/ফিচার** ইউজারের সামনে তুলে ধরা।
আপনি “কি করবে” (what) দেখবেন, “কিভাবে করবে” (how) সেটা আড়ালে থাকবে।

**রিমোট কন্ট্রোল** ভাবুন: আপনি শুধু বাটন চাপেন (what); ভেতরে সার্কিট কিভাবে কাজ করে (how)—তা জানার দরকার নেই।

জাভায় abstraction করার প্রধান ২টা উপায়:

1. **abstract class**
2. **interface**

---

## 1) Abstract Class

* `abstract` কীওয়ার্ড দিয়ে ক্লাস ডিফাইন করা হয়।
* **ইনস্ট্যান্স বানানো যায় না** (cannot instantiate)।
* **abstract method** রাখতে পারে (যার body নেই, সাবক্লাসে implement করতে হবে) এবং **concrete method** (body আছে)–দুটোই রাখতে পারে।
* **constructor** থাকতে পারে (সাবক্লাস থেকে call হবে), **fields** থাকতে পারে, **static method** থাকতে পারে।
* **abstract method** কখনো `private`, `final`, বা `static` হয় না (হলে override করা যাবে না/মানে হারাবে—কম্পাইলার এরর দেবে)।

### ছোট উদাহরণ

```java
abstract class Shape {
    // abstract method: body নেই, সাবক্লাসে দিতে হবে
    abstract double area();

    // concrete method: সাধারণ ইউটিলিটি
    void printArea() {
        System.out.println("Area = " + area());
    }
}

class Circle extends Shape {
    private final double r;
    Circle(double r) { this.r = r; }
    @Override double area() { return Math.PI * r * r; }
}

class Rectangle extends Shape {
    private final double w, h;
    Rectangle(double w, double h) { this.w = w; this.h = h; }
    @Override double area() { return w * h; }
}
```

এখানে `Shape` বলছে “**area() থাকবে**”—কিন্তু কিভাবে হবে সেটা সাবক্লাস ঠিক করছে। ব্যবহারকারী শুধু `printArea()` কল করলেই ফল পায়—ইমপ্লিমেন্টেশনের ডিটেইল লুকিয়ে গেল।

---

## 2) Interface

* ইন্টারফেস শুধু **কি করবে** (contract) বলে দেয়।
* কোনো state/instance field থাকে না (যা থাকে সেগুলো `public static final` কনস্ট্যান্ট)।
* মেথডগুলো ডিফল্টে `public abstract` (body ছাড়া)।
* **Java 8** থেকে **default** (body-সহ) ও **static** মেথড রাখা যায়;
  **Java 9** থেকে **private** হেল্পার মেথডও রাখা যায় (শুধু ইন্টারফেসের ভেতরে ব্যবহারের জন্য)।
* ক্লাস **multiple interfaces** implement করতে পারে (টাইপের multiple inheritance সম্ভব), কিন্তু **একটাই** ক্লাস extend করতে পারে।

### উদাহরণ

```java
interface Payable {
    void pay(double amount);           // abstract
    default void printReceipt(double a){ System.out.println("Paid: " + a); }
}

class BkashPayment implements Payable {
    @Override public void pay(double amount) {
        // ইমপ্লিমেন্টেশন লুকানো
        System.out.println("Bkash processing " + amount);
    }
}

class CardPayment implements Payable {
    @Override public void pay(double amount) {
        System.out.println("Card charged " + amount);
    }
}
```

কোথাও `Payable` টাইপে কাজ করলে আপনি জানেন “pay করতে পারবে”—কিন্তু ভিতরে bKash নাকি Card—সেটা জানার দরকার নেই। এটাই abstraction।

---

## Abstract Class বনাম Interface — কখন কোনটা?

* **সম্পর্ক/বংশ (is-a) + শেয়ারড state/কোড দরকার** → *abstract class*
  (common fields, protected helper, constructor—এসব দরকার হলে)
* **শুধু ক্ষমতা/আচরণ (can-do) ডিফাইন করা** → *interface*
  (প্লাগ-ইন স্টাইল; এক ক্লাস একাধিক interface implement করতে পারে)

| Topic        | Abstract Class               | Interface                                                  |
| ------------ | ---------------------------- | ---------------------------------------------------------- |
| ইনস্ট্যান্স  | করা যায় না                   | করা যায় না                                                 |
| মেথড         | abstract + concrete দুটোই    | মূলত abstract; `default`/`static`/`private` (helper) সম্ভব |
| ফিল্ড        | যেকোনো টাইপ (state রাখা যায়) | কনস্ট্যান্ট (`public static final`)                        |
| কন্সট্রাক্টর | থাকে                         | নেই                                                        |
| ইনহেরিটেন্স  | একটাই ক্লাস extend করা যায়   | একাধিক interface implement করা যায়                         |

---

## কেন abstraction দরকার?

* **জটিলতা লুকায়** → ব্যবহার সহজ হয়।
* **লুজ কাপলিং** → ইমপ্লিমেন্টেশন বদলালেও কনট্র্যাক্ট একই থাকে; কোড ভাঙে না।
* **রিইউজ/টেস্টিং সহজ** → ইন্টারফেস মক করে ইউনিট টেস্ট করা যায়।
* **পলিমরফিজম** → এক নাম, ভিন্ন আচরণ (e.g., `Payable` দিয়ে `BkashPayment`/`CardPayment` কাজ করা)।

---

## Abstraction ≠ Encapsulation (দুটো আলাদা)

* **Encapsulation**: ডাটা + মেথড একসাথে বেঁধে রাখা, access control (`private`, `public`) দিয়ে **ডাটা সুরক্ষা**।
* **Abstraction**: **অনাবশ্যক ডিটেইল লুকানো**, শুধু প্রয়োজনীয় আচরণ দেখানো।
  দুটি সম্পর্কিত—কিন্তু এক জিনিস নয়।

---

## বাস্তব ব্যবহারক্ষেত্র

* **Template Method pattern**: abstract class কিছু ধাপ ফিক্স করে, কিছু ধাপ abstract রাখে—সাবক্লাসে কাস্টমাইজ হয়।
* **Strategy pattern**: interface দিয়ে আচরণ বদলানো যায় (e.g., বিভিন্ন sort strategy, payment strategy)।
* **Driver/Plugin API**: ইন্টারফেস দিয়ে কনট্র্যাক্ট; ভেতরে বিভিন্ন ভেন্ডর আলাদা ইমপ্লিমেন্টেশন দেয়।

---

## সাধারণ ভুল/টিপস

* `abstract method` কখনো `private/final/static` করবেন না (কম্পাইল হবে না/মানে হারাবে)।
* abstract class‐এ **constructor থাকতে পারে**—সাবক্লাসে `super()` কল হবে।
* interface‐এ state রাখবেন না; দরকার হলে abstract class ভাবুন।
* Java 17-এ **sealed classes** ব্যবহার করে হায়ারার্কি সীমাবদ্ধ করতে পারেন (নির্দিষ্ট সাবটাইপই অনুমোদিত)—এটাও abstraction-কে শক্ত করে।

---

## ছোট, বাস্তব উদাহরণ (ব্যাখ্যাসহ)

ধরা যাক order পেমেন্ট নিতে হবে—কিন্তু কে নেবে তা আগে জানি না:

```java
interface Payable {
    void pay(double amount);
}

class BkashPayment implements Payable {
    public void pay(double amount){ /* ... */ }
}

class CardPayment implements Payable {
    public void pay(double amount){ /* ... */ }
}

class CheckoutService {
    private final Payable gateway;
    CheckoutService(Payable gateway) { this.gateway = gateway; }

    void checkout(double total) {
        gateway.pay(total); // abstraction: শুধু pay জানা দরকার
    }
}
```

**ব্যাখ্যা:** `CheckoutService` কেবল `Payable` চেনে—ভিতরে bKash নাকি Card তা জানে না। পরে চাইলে `NagadPayment` যোগ করলেও `CheckoutService` বদলাতে হবে না—**এটাই abstraction এর শক্তি**।

---

## এক কথায়

**Abstraction** হলো—*“কি করবে” তা প্রকাশ, “কিভাবে করবে” তা আড়াল*—জাভায় সেটা করি **abstract class** আর **interface** দিয়ে; এতে কোড হয় **সহজ, নমনীয়, টেস্টেবল**।
