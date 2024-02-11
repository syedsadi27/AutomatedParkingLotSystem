package AutomatedParkingLotSystem;
import AutomatedParkingLotSystem.Entity.Slot;
import AutomatedParkingLotSystem.Exception.CapacityForSlotNotDefined;
import AutomatedParkingLotSystem.Exception.VehicleNotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AutomatedTicketingSystem {


    public static void main(String[] args) {
//
//        Vehicle v1 = new Vehicle("KA 01","blue");
//        Vehicle v2 = new Vehicle("KA 02","green");
//        Vehicle v3 = new Vehicle("KA 03","blue");
//        Vehicle v4 = new Vehicle("KA 04","pink");
//        Vehicle v5 = new Vehicle("KA 05","magenta");
//
//
//
//        Slot.setcapacity(5);   // set Capacity
//
//        Slot.parkVehicle(v1);  // park vehicle
//        Slot.parkVehicle(v2);
//        Slot.parkVehicle(v3);
//        Slot.parkVehicle(v4);
//        Slot.parkVehicle(v5);
//
//        Slot.vehicleLeaved(1);  // empty slot
//
//        for (Slot s:getOccupiedSlots()){
//            System.out.println(s.getSlotNumber() + s.getParkedVehicleDetails());
//        }  // coustom occupied slots
//        for (Integer s:getSlotsByVehicleColor("blue")){
//            System.out.println(s);
//        }  // get slots by color
//
//        getSlotDetails(); //get all slot details
//        getSlotNumberByVehicleNumber("KA 02");



                try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                    while (true) {
                        System.out.print("$ ");
                        String input = reader.readLine(); // Read user input

                        if (input.equals("exit")) {
                            System.out.println("Exiting shell.");
                            break;
                        }

                        executeCommand(input);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            public static boolean checkCommandValidity(String[] cmdArr){
                   Map<String,Integer> cmdMap = new HashMap<>();
                    cmdMap.put("create_parking_lot", 2);
                    cmdMap.put("park",3 );
                    cmdMap.put("leave", 2);
                    cmdMap.put("status", 1);
                    cmdMap.put("registration_numbers_for_cars_with_colour", 2);
                    cmdMap.put("slot_number_of_cars_with_registration_number", 2);
                    cmdMap.put("slot_numbers_of_cars_with_colour", 2);
                    return cmdArr.length == cmdMap.get(cmdArr[0]);
            }
            private static void executeCommand(String command) {

                String[] cmdArr = command.toLowerCase().replaceAll("\\s+", " ").split(" ");
                if( checkCommandValidity(cmdArr)) {
                    switch (cmdArr[0]) {
                        case "create_parking_lot":
                            Slot.setcapacity(cmdArr[1]);
                            break;
                        case "park":
                            try {
                                Slot.parkVehicle(cmdArr[1], cmdArr[2]);
                            } catch (CapacityForSlotNotDefined e) {
                                System.out.println(e);
                            }

                            break;
                        case "leave":
                            try {
                                Slot.vehicleLeaved(cmdArr[1]);
                            } catch (VehicleNotFoundException e) {
                                System.out.println(e);
                            }
                            break;
                        case "status":
                            Slot.getSlotDetails();
                            break;
                        case "registration_numbers_for_cars_with_colour":
                            try {
                                Slot.getVehicleNumberByVehicleColor(cmdArr[1]);
                            } catch (VehicleNotFoundException e) {
                                System.out.println(e);
                            }

                            break;
                        case "slot_number_of_cars_with_registration_number":
                            try {
                                Slot.getSlotNumberByVehicleNumber(cmdArr[1]);
                            } catch (VehicleNotFoundException e) {
                                System.out.println(e);
                            }
                            break;
                        case "slot_numbers_of_cars_with_colour":
                            try {
                                Slot.getSlotsByVehicleColor(cmdArr[1]);

                            } catch (VehicleNotFoundException e) {
                                System.out.println(e);
                            }
                            break;


                    }
                }
                else System.out.println("Invalid Command");




            }
}
