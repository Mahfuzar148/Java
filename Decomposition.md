
---

# 🟦 Decomposition in Object-Oriented Design

## 🔹 সংজ্ঞা

* **Decomposition** মানে হলো **একটা বড় সিস্টেমকে ছোট ছোট manageable অংশে ভাগ করা**, অথবা ছোট অংশগুলোকে একত্রিত করে একটা সম্পূর্ণ সিস্টেম তৈরি করা।
* মূল উদ্দেশ্য → **divide & conquer** → বড় সমস্যা কে ভেঙে manageable sub-problem বানানো।

---

## 🔹 উদ্দেশ্য

* বড় সমস্যাকে **manageable pieces** এ ভাগ করা।
* প্রতিটি অংশের আলাদা দায়িত্ব থাকে।
* **Class-based design**-এ প্রতিটি অংশকে আলাদা ক্লাস হিসাবে মডেল করা যায়।
* Similar to **abstraction** → প্রতিটি অংশের essential characteristic ধরা হয়।

---

## 🔹 Dhaka Urban Management System Example (PDF থেকে)

### Step 1: Subsystems এ ভাঙা

```java
class TrafficManagement {
    public void controlTraffic() {
        System.out.println("Traffic signals are being monitored and controlled.");
    }
}

class WasteManagement {
    public void collectGarbage() {
        System.out.println("Garbage is being collected from different zones of Dhaka.");
    }
}

class WaterSupply {
    public void distributeWater() {
        System.out.println("Safe drinking water is being supplied to citizens.");
    }
}
```

### Step 2: একত্রিত করে মূল সিস্টেম

```java
class DhakaUrbanManagementSystem {
    private TrafficManagement traffic;
    private WasteManagement waste;
    private WaterSupply water;

    public DhakaUrbanManagementSystem() {
        traffic = new TrafficManagement();
        waste = new WasteManagement();
        water = new WaterSupply();
    }

    public void manageCity() {
        traffic.controlTraffic();
        waste.collectGarbage();
        water.distributeWater();
    }
}
```

### Main Class

```java
public class DecompositionExample {
    public static void main(String[] args) {
        DhakaUrbanManagementSystem dhaka = new DhakaUrbanManagementSystem();
        dhaka.manageCity();
    }
}
```

👉 **Output:**

```
Traffic signals are being monitored and controlled.
Garbage is being collected from different zones of Dhaka.
Safe drinking water is being supplied to citizens.
```

⚡ এখানে দেখা যাচ্ছে, বড় সিস্টেম → ছোট মডিউল (Traffic, Waste, Water) এ ভাগ করা হয়েছে → পরে একত্রিত করা হয়েছে।

---

## 🔹 Nature of Parts (Slide 41)

Decomposition-এ parts এর প্রকৃতি:

1. **Fixed parts** → সংখ্যা সবসময় একই (যেমন: চুলার ৪টা বার্নার)।
2. **Dynamic parts** → সময়ের সাথে পরিবর্তন হয় (যেমন: ফ্রিজের ভেতরে খাবারের সংখ্যা)।
3. **Parts as wholes** → একটা part নিজেই আবার sub-part থাকতে পারে (যেমন: বাড়ির ভেতরে রান্নাঘর)।
4. **Lifetime dependency** →

   * কিছু part মূল অবজেক্টের lifetime share করে।
   * কিছু independent থাকে।
5. **Shared parts** → একাধিক whole এ অংশ শেয়ার করা যেতে পারে।

---

## 🔹 UML Relationship Types in Decomposition (Slide 42–48)

### 1. **Association** → (loose relationship, শুধু uses)

* দুইটা ক্লাস loosely connected, lifetime dependency নেই।

**Example: Student – Sport**

```java
public class Student {
    public void play(Sport sport) {
        sport.play();
    }
}
```

**PDF Example: TrafficPolice – TrafficManagement**

```java
class TrafficPolice {
    public void monitorTraffic(TrafficManagement tm) {
        tm.controlTraffic();
        System.out.println("Traffic police is monitoring the traffic system.");
    }
}
```

👉 TrafficPolice uses TrafficManagement → কিন্তু lifetime dependency নেই।

---

### 2. **Aggregation (“Has-a”, Weak Ownership)**

* Whole ক্লাস parts ধারণ করে, কিন্তু parts স্বাধীনভাবে থাকতে পারে।
* UML symbol → **empty diamond (◊)**।

**Example: Airliner – CrewMember**

```java
public class Airliner {
    private ArrayList<CrewMember> crew = new ArrayList<>();

    public void add(CrewMember crewMember) {
        crew.add(crewMember);
    }
}
```

**PDF Example: DhakaUrbanManagementSystem – WasteManagement**

```java
class DhakaUrbanManagementSystem {
    private WasteManagement waste;  // Aggregation

    public DhakaUrbanManagementSystem(WasteManagement waste) {
        this.waste = waste;
    }

    public void manageWaste() {
        waste.collectGarbage();
    }
}
```

👉 System ধ্বংস হলেও WasteManagement আলাদা থাকতে পারে।

---

### 3. **Composition (“Owns-a”, Strong Ownership)**

* Whole ক্লাস parts **create ও own করে**।
* Whole ধ্বংস হলে part-ও ধ্বংস হয়।
* UML symbol → **filled diamond (◆)**।

**Example: House – Room**

```java
public class House {
    private Room room;
    public House() {
        room = new Room(); // tightly bound
    }
}
```

**PDF Example: DhakaUrbanManagementSystem2 – WaterSupply**

```java
class DhakaUrbanManagementSystem2 {
    private WaterSupply water;  // Composition

    public DhakaUrbanManagementSystem2() {
        this.water = new WaterSupply(); // created inside
    }

    public void manageWater() {
        water.distributeWater();
    }
}
```

👉 এখানে WaterSupply class system এর বাইরে থাকতে পারে না। System ধ্বংস হলে WaterSupply ও চলে যাবে।

---

# 🟩 সারসংক্ষেপ (PDF অনুযায়ী)

**Decomposition = Breaking down big system → smaller parts**

* **Association:** uses, loose relation
* **Aggregation:** has-a, weak ownership
* **Composition:** owns-a, strong ownership

📌 **Dhaka Urban Example:**

* Association → TrafficPolice ↔ TrafficManagement
* Aggregation → System ↔ WasteManagement
* Composition → System ↔ WaterSupply

---

