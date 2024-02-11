# Automated Parking Lot Ticketing System

This project implements an automated ticketing system for a parking lot, allowing customers to use the parking lot without human intervention. The system issues tickets to drivers upon entry, allocates parking slots, and handles the process of exiting the parking lot.

## Features

- Creation of a parking lot with a specified number of slots.
- Parking a car, issuing a ticket, and allocating a nearest available parking slot.
- Exiting the parking lot and marking the slot as available.
- Querying the status of the parking lot to view parked cars and available slots.
- Finding registration numbers of cars of a particular color.
- Finding the slot number of a car with a given registration number.
- Finding slot numbers of slots where cars of a particular color are parked.

## Commands

The system can be interacted with via a set of commands:

- `create_parking_lot <capacity>`: Creates a parking lot with the specified capacity.
- `park <registration_number> <color>`: Parks a car with the given registration number and color.
- `leave <slot_number>`: Marks the specified slot as available.
- `status`: Displays the current status of the parking lot.
- `registration_numbers_for_cars_with_colour <color>`: Finds registration numbers of cars with the specified color.
- `slot_number_for_registration_number <registration_number>`: Finds the slot number of the car with the specified registration number.
- `slot_numbers_for_cars_with_colour <color>`: Finds slot numbers of slots where cars with the specified color are parked.
- `exit`: Terminates the process and returns control to the shell.

## Exception Handling

The system includes exception handling to deal with errors gracefully:

- If a vehicle is not found at the specified slot number when leaving, an exception is thrown.
- If the capacity for creating a parking slot is not defined (e.g., negative or zero), an exception is thrown.


## Usage


To use the parking lot system:

1. Compile the Java code.
2. Run the compiled program.
3. Enter commands at the interactive command prompt.

Example usage:

