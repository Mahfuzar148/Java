
---

## 🔹 1. Inheritance

**Definition:**

* A child class **inherits attributes and methods** from a parent class.
* Promotes **code reuse**.

**Dhaka Example:**

* *WasteManagement* and *TrafficManagement* both inherit from a common *UrbanService* class.

**Java Example:**

```java
class UrbanService {
    public void provideService() {
        System.out.println("General city service");
    }
}
class WasteManagement extends UrbanService { }
```

✔ Here, `WasteManagement` inherits `provideService()` from `UrbanService`.

---

## 🔹 2. Overriding

**Definition:**

* Child class **redefines (overrides)** a parent’s method with the **same signature**.

**Dhaka Example:**

* *TrafficManagement* overrides `provideService()` for traffic-specific tasks.

**Java Example:**

```java
class TrafficManagement extends UrbanService {
    @Override
    public void provideService() {
        System.out.println("Traffic signals controlled in Dhaka");
    }
}
```

✔ The parent’s method is replaced by a **new version** in the child.

---

## 🔹 3. Overloading

**Definition:**

* **Same method name**, but with **different parameter lists** in the same class.

**Dhaka Example:**

* `collectGarbage()` has multiple versions for different zones.

**Java Example:**

```java
class GarbageCollector {
    public void collectGarbage() {
        System.out.println("Collecting general garbage");
    }
    public void collectGarbage(String zone) {
        System.out.println("Collecting garbage from " + zone);
    }
}
```

✔ This is **compile-time polymorphism** (method overloading).

---

## 🔹 4. Interface

**Definition:**

* Defines a **contract** (method signatures only, no implementation).
* All implementing classes must **define the methods**.

**Dhaka Example:**

* *UrbanDepartment* interface → all departments must implement `manage()`.

**Java Example:**

```java
interface UrbanDepartment {
    void manage();
}

class WasteManagement implements UrbanDepartment {
    public void manage() {
        System.out.println("Waste managed in Dhaka");
    }
}
```

✔ Ensures standardization across multiple departments.

---

## 🔹 5. Constructor Inheritance

**Definition:**

* A child class calls the **parent constructor** using `super()`.
* Ensures **initialization** of parent class fields.

**Dhaka Example:**

* *WasteManagement* calls *UrbanService* constructor to set department name.

**Java Example:**

```java
class UrbanService {
    String dept;
    public UrbanService(String dept) {
        this.dept = dept;
    }
}

class WasteManagement extends UrbanService {
    public WasteManagement() {
        super("Waste Management");
    }
}
```

✔ The child constructor calls the parent constructor before executing its own code.

---

## ✅ Summary

* **Inheritance** → Reuse code from parent.
* **Overriding** → Replace parent’s method in child.
* **Overloading** → Same method name, different parameters.
* **Interface** → Define a contract, enforce common behavior.
* **Constructor Inheritance** → Use `super()` to initialize parent class.

---

