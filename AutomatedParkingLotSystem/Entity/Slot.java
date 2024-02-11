package AutomatedParkingLotSystem.Entity;

import AutomatedParkingLotSystem.Exception.CapacityForSlotNotDefined;
import AutomatedParkingLotSystem.Exception.VehicleNotFoundException;

import java.util.*;

public class Slot {


    private Integer slotNumber;   //instance variable
    private Boolean isAvailable = true;   //instance variable
    private Vehicle vehicle;  //instance Variable
    private static int capacity;  //static variable
    public static Vector<Slot> slots ; //static vector
    public Slot(Integer slotNumber){
        this.slotNumber=slotNumber;
    } // connstructor

    public static void setcapacity(String  cap){
        capacity=Integer.parseInt(cap);
        slots = new Vector<>(capacity);
        for (int i = 0; i < capacity; i++) {
            slots.add(new Slot(i+1));
        }
        System.out.println(" > created parking lot of capacity "+capacity);
    } //finished |

    public static void parkVehicle( String vehicleNumber,String vehicleColor) throws CapacityForSlotNotDefined {
           Vehicle vehicle = new Vehicle(vehicleNumber,vehicleColor);
           if(slots!=null)
            for (Slot s : slots) {
                    if (s.isAvailable) {
                        s.vehicle=vehicle;
                        s.isAvailable=false;
                        System.out.println(" > Alotted slot no : "+s.getSlotNumber());
                        return;
                    }
            }
           throw new CapacityForSlotNotDefined("Capcity Need to be Defined fiest");

    } //finished |


    public static void vehicleLeaved(String slotNumber_) throws VehicleNotFoundException {
        Integer slotNumber = Integer.parseInt(slotNumber_);
        for (Slot s : getOccupiedSlots()){
            if(s.getSlotNumber().equals(slotNumber)) {
                if(s.vehicle != null) {
                    s.vehicle = null;
                    s.isAvailable = true;
                    System.out.println(" > slot no : " + s.slotNumber + " is Available");
                    return;
                }
                
            }
        }
        throw new VehicleNotFoundException(" > No Vehicle Parked Here");
    } //finished |

    public static List<Slot> getOccupiedSlots(){
        return slots.stream().filter(p-> !p.isAvailable).toList();


    } //finished

    public static void getSlotsByVehicleColor(String color) throws VehicleNotFoundException {
        System.out.println(" > SLOT NO :");
        boolean notFound = true;
        for (Slot s : getOccupiedSlots()) {
            if (s.getVehicleColor().equals(color)) {
                System.out.println(s.slotNumber);
                notFound = true;
            }
        }
        if(notFound)throw new VehicleNotFoundException(" > No Vehicle with  "+ color +" is parked");
    } //finished |

    public static void getVehicleNumberByVehicleColor(String color) throws VehicleNotFoundException {
        System.out.println(" > VEHICLE NO:");
        for (Slot s : getOccupiedSlots()) {
            if (s.getVehicleColor().equals(color)) {
                System.out.println(" > Vehicle found at Slot No :" + s.slotNumber);
                return;
            }
        }
        throw new VehicleNotFoundException(" > No Vehicle with  "+ color +" is parked");

    } //finished |

    public static void getSlotNumberByVehicleNumber(String vehicleNumber) throws VehicleNotFoundException {
        System.out.println(" > SLOT NO");
        for (Slot s : getOccupiedSlots()) {
            if (s.getVehicleNumber().equals(vehicleNumber)) {
                System.out.println(" > Vehicle found at Slot No :" + s.slotNumber);
                return;
            }
        }
            throw new VehicleNotFoundException(" > No Vehicle with  Number "+vehicleNumber+" is parked");
    }

    public static void getSlotDetails(){
        for (Slot s : slots){
            System.out.println( " >  { " + s.getSlotNumber() + s.getParkedVehicleDetails() +" }");
        }
    } //finished |

    public String getVehicleColor(){
        return this.vehicle != null? this.vehicle.getVehicleColor(): " > no vehicle parked here";
    } //finished

    public String getParkedVehicleDetails(){

        return  this.vehicle!=null ? " <> [ "+ this.vehicle.getVehicleNumber() +" | " + this.vehicle.getVehicleColor() + "]": " > no vehicle is parked here";
    } //finished


    public String getVehicleNumber(){
        return this.vehicle != null? this.vehicle.getVehicleNumber(): " > no vehicle parked here";
    } //finished


    public Integer getSlotNumber() {
        return slotNumber;
    } //finished



}
