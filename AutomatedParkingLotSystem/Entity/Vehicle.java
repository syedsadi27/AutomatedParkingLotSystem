package AutomatedParkingLotSystem.Entity;

public class Vehicle {

    private String vehicleNumber;
    private String vehicleColor;
    public  Vehicle(String vehicleNumber,String vehicleColor){
        this.vehicleNumber=vehicleNumber;
        this.vehicleColor=vehicleColor;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }


    public String getVehicleNumber() {
        return vehicleNumber;
    }

}
