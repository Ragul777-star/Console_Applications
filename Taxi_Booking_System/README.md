# Taxi Booking System

A console-based taxi booking system implemented in Java that efficiently manages taxi allocation to customers based on availability and proximity.

## 📋 Overview

This application simulates a real-world taxi booking system where customers can request rides and taxis are intelligently allocated based on:
- **Taxi Availability**: Checks if a taxi is free at the requested time
- **Proximity**: Selects the closest available taxi to the pickup location
- **Balanced Earnings**: Among closest taxis, allocates to the one with lower earnings for fair distribution

## 🏗️ Project Structure

### Classes

#### `Main.java`
Entry point of the application that demonstrates the booking system with sample customers and taxi fleet.

#### `Customer.java`
Represents a customer requesting a taxi ride.
- **Properties**:
  - `customer_id`: Unique customer identifier
  - `pick_up`: Pickup location (character A-Z)
  - `drop`: Drop-off location (character A-Z)
  - `picktime`: Requested pickup time

#### `Taxi.java`
Represents a taxi in the system.
- **Properties**:
  - `taxi_id`: Unique taxi identifier
  - `current_spot`: Current location of the taxi
  - `free_time`: Time when taxi becomes available
  - `earnings`: Total earnings from all bookings
  - `bookings`: List of all bookings assigned to this taxi
- **Key Methods**:
  - `isFree()`: Checks if taxi is available for pickup at requested time and location

#### `Booking.java`
Represents a confirmed booking.
- **Properties**:
  - `booking_id`: Unique booking identifier
  - `drop_time`: Time when passenger reaches destination
  - `charges`: Total fare for the booking
  - `customer`: Associated customer object
- Uses **Encapsulation**: All properties are read-only

#### `Booking_System.java`
Core system that manages all bookings and taxi allocation.
- **Key Methods**:
  - `bookTaxi()`: Main method to book a taxi for a customer
  - `findTaxi()`: Intelligently selects the best available taxi using multi-criteria selection
  - `calculateCharges()`: Computes fare based on distance
  - `displayTaxi()`: Shows earnings of all taxis

## 🚀 How It Works

1. **Taxi Allocation Algorithm**:
   - Filters all taxis to find those available at the requested time and location
   - Among available taxis, calculates distance to pickup location
   - Finds taxis at minimum distance
   - Selects the taxi with lowest earnings for fair load balancing

2. **Fare Calculation**:
   - Base fare: ₹100
   - Distance calculation: `(pickup_location - drop_location) × 15` km
   - Per km rate: ₹10
   - Formula: `100 + (distance - 5) × 10`

3. **Booking Process**:
   - System finds the best taxi match
   - Creates a booking record
   - Updates taxi's free time, earnings, and current location
   - Returns confirmation with allocated taxi ID

## 💻 Usage

### Sample Execution
```java
Customer c1 = new Customer(1, 'A', 'B', 9);
Customer c2 = new Customer(2, 'B', 'D', 9);
Customer c3 = new Customer(3, 'B', 'C', 12);

Booking_System bookingSystem = new Booking_System(4);  // 4 taxis
bookingSystem.bookTaxi(c1);
bookingSystem.bookTaxi(c2);
bookingSystem.bookTaxi(c3);
bookingSystem.displayTaxi();  // Shows earnings for each taxi
```

### Output
```
Taxi-1 is allocated
Taxi-2 is allocated
Taxi-3 is allocated
Taxi-1 Earnings: [amount]
Taxi-2 Earnings: [amount]
Taxi-3 Earnings: [amount]
Taxi-4 Earnings: 0
```

## 🎯 Key Features

✅ **Dynamic Taxi Allocation**: Intelligently selects taxis based on multiple criteria  
✅ **Distance-Based Matching**: Finds closest available taxi to pickup location  
✅ **Load Balancing**: Distributes work fairly among taxis  
✅ **Encapsulation**: Protected data with read-only access  
✅ **Real-time Availability**: Checks taxi free time and location  
✅ **Earnings Tracking**: Monitors each taxi's total earnings  

## 📊 Algorithm Complexity

- **Time Complexity**: O(n) where n is the number of taxis
- **Space Complexity**: O(n) for storing taxi fleet and bookings

## 🔧 Technologies

- **Language**: Java
- **Data Structures**: ArrayList, List
- **OOP Concepts**: Encapsulation, Object Composition

## 📝 Notes

- Locations are represented as characters (A, B, C, D, etc.)
- Distances are calculated as absolute differences between character values
- Times are represented as integers (in minutes or hours)
- All taxis start at location 'A' with zero earnings

## 👤 Author

Ragul777-star

## 📄 License

This project is part of Console Applications collection.
