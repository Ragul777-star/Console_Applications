# Console Applications

A collection of console-based applications implemented in Java, demonstrating core programming concepts and real-world problem-solving through interactive command-line interfaces.

## 📚 Projects Overview

This repository contains multiple console applications, each focused on specific problem-solving approaches and design patterns.

### 1. 🚖 **Taxi Booking System**
**Location**: `Taxi_Booking_System/`

A console-based taxi booking system that efficiently manages taxi allocation to customers based on availability and proximity.

#### Key Features:
- ✅ **Dynamic Taxi Allocation**: Intelligently selects taxis based on multiple criteria
- ✅ **Distance-Based Matching**: Finds closest available taxi to pickup location
- ✅ **Load Balancing**: Distributes work fairly among taxis
- ✅ **Earnings Tracking**: Monitors each taxi's total earnings
- ✅ **Real-time Availability**: Checks taxi free time and location

#### Quick Overview:
- **Language**: Java
- **Allocation Algorithm**: O(n) complexity
- **Core Concepts**: Encapsulation, Object Composition, Algorithmic Optimization

#### Getting Started:
```java
Customer c1 = new Customer(1, 'A', 'B', 9);
Booking_System bookingSystem = new Booking_System(4);
bookingSystem.bookTaxi(c1);
bookingSystem.displayTaxi();
```

📖 **Full Documentation**: See [Taxi_Booking_System/README.md](Taxi_Booking_System/README.md) for detailed information.

---

### 2. 🔄 **[Future Projects - Coming Soon]**

More console applications will be added to this collection covering various domains and programming patterns.

---

## 🏗️ Repository Structure

```
Console_Applications/
├── README.md                          # Main repository documentation
├── Taxi_Booking_System/
│   ├── README.md                      # Project-specific documentation
│   ├── Main.java                      # Entry point
│   ├── Customer.java                  # Customer model
│   ├── Taxi.java                      # Taxi model
│   ├── Booking.java                   # Booking model
│   └── Booking_System.java            # Core booking system
└── [Future_Project_Folder]/
    ├── README.md
    ├── [Source files...]
    └── [Test files...]
```

## 🎯 Learning Outcomes

By exploring these console applications, you'll learn:

- **Object-Oriented Programming (OOP)**: Classes, Encapsulation, Composition
- **Data Structures**: ArrayList, List, Collections
- **Algorithm Design**: Optimization, Multi-criteria selection
- **System Design**: Managing complex interactions between multiple entities
- **Problem Solving**: Breaking down real-world problems into code

## 🚀 Getting Started

### Prerequisites
- Java 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or command-line tools

### Running a Project

1. Navigate to the project folder:
   ```bash
   cd Taxi_Booking_System
   ```

2. Compile the Java files:
   ```bash
   javac *.java
   ```

3. Run the Main class:
   ```bash
   java Main
   ```

## 📊 Projects Comparison

| Project | Focus Area | Difficulty | Lines of Code |
|---------|-----------|------------|---------------|
| Taxi Booking System | System Design, Algorithms | Intermediate | ~300-400 |
| [Future] | TBA | TBA | TBA |

## 💡 Design Patterns Used

- **Object-Oriented Design**: Encapsulation of data and behavior
- **Strategy Pattern**: Dynamic taxi selection based on multiple criteria
- **Model-View Pattern**: Separation of business logic and display

## 🔧 Technologies & Tools

- **Language**: Java
- **Build**: Manual compilation (no external build tools required)
- **Version Control**: Git & GitHub

## 📝 Coding Standards

All projects follow:
- ✅ Clear naming conventions (PascalCase for classes, camelCase for methods)
- ✅ Proper encapsulation (private fields, public getters)
- ✅ Comprehensive comments and documentation
- ✅ DRY (Don't Repeat Yourself) principle

## 🤝 Contributing

To add new console applications to this collection:

1. Create a new folder with a descriptive project name
2. Include a comprehensive `README.md` with project details
3. Write clean, well-documented Java code
4. Add usage examples and expected output
5. Update this main README with the new project

## 📞 Support & Questions

For questions about specific projects, refer to their individual README files.

---

## 👤 Author

**Ragul777-star**

## 📄 License

This project collection is open for educational purposes.

---

**Last Updated**: 2026-03-25  
**Total Projects**: 1 (More coming soon!)
