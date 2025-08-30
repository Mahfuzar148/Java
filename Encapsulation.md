
---

# What is Encapsulation?

**Encapsulation** bundles an object’s **data (state)** and **behavior (methods)** together and controls outside access to that data through a well-defined API.
Think: *“Data is protected inside; only controlled doors are exposed.”*

**Goals**

* **Information hiding** – keep internals private
* **Preserve invariants** – prevent illegal states
* **Loose coupling** – internal changes don’t break callers
* **Maintainability & testability** – simpler, safer code

---

# Core Tool: Access Modifiers

* `private` — visible only inside the class (**use for fields by default**)
* *(default)* package-private — visible in the same package
* `protected` — package + subclasses
* `public` — visible everywhere

**Rule of thumb:** Keep fields `private`. Expose controlled access via methods (or interfaces).

---

# Basic Example (with validation)

```java
public class BankAccount {
    private final String accountId;
    private double balance; // invariant: balance >= 0

    public BankAccount(String accountId, double openingBalance) {
        if (openingBalance < 0) throw new IllegalArgumentException("Negative opening balance");
        this.accountId = accountId;
        this.balance = openingBalance;
    }

    public double getBalance() {
        return balance; // read-only view
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0 || amount > balance)
            throw new IllegalArgumentException("Invalid withdraw");
        balance -= amount;
    }
}
```

Here `balance` is **private**, so no one can write `balance = -999`. Updates go through **validated** methods—this is encapsulation.

---

# Why “public fields” are dangerous

```java
class BadAccount {
    public double balance; // ❌ anyone can set any value, invariant breaks
}
```

Public mutable fields let callers put the object into illegal states. Avoid them.

---

# Encapsulating Collections/Arrays (defensive copies)

```java
import java.util.*;

public class Student {
    private final List<String> courses = new ArrayList<>();

    public void addCourse(String name) { courses.add(name); }

    // ✅ Expose an unmodifiable view (or return a copy)
    public List<String> getCourses() {
        return Collections.unmodifiableList(courses);
        // or: return new ArrayList<>(courses);
    }
}
```

Arrays:

```java
private byte[] secret;

public byte[] getSecret() { return secret.clone(); }         // defensive copy
public void setSecret(byte[] s) { this.secret = s == null ? null : s.clone(); }
```

---

# Immutability: encapsulation’s best friend

Immutable objects can’t change after construction, so invariants stay intact.

```java
public final class Person {
    private final String name;
    private final int age; // age >= 0

    public Person(String name, int age) {
        if (age < 0) throw new IllegalArgumentException("age must be non-negative");
        this.name = name;
        this.age = age;
    }

    public String name() { return name; }
    public int age() { return age; }
}
```

**Java 16+ `record`:**

```java
public record PersonRecord(String name, int age) {
    public PersonRecord {
        if (age < 0) throw new IllegalArgumentException("age must be non-negative");
    }
}
```

---

# Encapsulation vs Abstraction (different but related)

* **Encapsulation:** *control access to data* (enforce rules/invariants).
* **Abstraction:** *expose what to do, hide how it’s done* (contracts via interfaces/abstract classes).
  They work together: abstraction provides the API; encapsulation keeps state safe behind it.

---

# Package/Module-level encapsulation

* Prefer minimal `public` API; keep helpers package-private.
* **Java 9+ modules**: use `module-info.java` to `exports` only the packages you intend to expose.

---

# Concurrency tip (optional)

Encapsulation doesn’t automatically make code thread-safe. Guard shared state:

```java
public class SafeCounter {
    private int count;
    public synchronized void inc() { count++; }
    public synchronized int get() { return count; }
}
```

---

# Common pitfalls & fixes

* ❌ Public mutable fields
  ✅ Make fields `private`; expose behavior or validated accessors
* ❌ Returning internal collections/arrays directly
  ✅ Return unmodifiable views or defensive copies
* ❌ Setters without validation
  ✅ Validate invariants in constructors/setters/behavior methods
* ❌ “Setter storm” (anemic models)
  ✅ Prefer behavior-driven APIs (`deposit/withdraw` instead of `setBalance`)
* ✅ Prefer immutability where practical

---

## TL;DR

**Encapsulation = keep data private + expose controlled operations.**
In Java, that means **private fields, validated methods, defensive copies, minimal public API, and (ideally) immutable designs**—leading to safer, easier-to-maintain, and more testable code.
