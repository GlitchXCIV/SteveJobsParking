import java.util.ArrayList;

public class ParkingLot {
    
    private String name;
    private int numTotal;
    private ArrayList<Parking> parkings;
    private int takenSpace=0;
    private double priceForMinute = 0.01; 
    private double multiplerForScooter = 0.5; 
    private double multiplerForCar = 1; 
    private double multiplerForTruck = 2; 
    private double cash = 0;
    private int treshold1Low = 200;
    private int treshold1High = 4 * 60;
    private int treshold2Low = 10 * 60;
    private int treshold2High = 24 * 60;

    public ParkingLot(String name, int numTotal) {
        this.name = name;
        this.numTotal = numTotal;
        this.parkings=new ArrayList<>();
    }

    public double getCash() {
        return cash;
    }
    
    public boolean addVehicle(Vehicle v){        
        int freeSpace = this.numTotal - this.takenSpace;
        if(freeSpace >= v.getSpaceForVehicle()){
            /*Parking parking = new Parking (v);
            this.parking.add(parking);*/
            this.parkings.add(new Parking (v));
            this.takenSpace+=v.getSpaceForVehicle();
            return true;
        }
        return false;
    }
    
    public boolean exitVehicle (String plate) {
        for (Parking parking : this.parkings) {
            if (parking.getVehicle().getPlate().equals(plate)) {
                int minutes = parking.exitVehicle();
                this.getCash(parking.getVehicle(), minutes);
                this.takenSpace-=parking.getVehicle().getSpaceForVehicle();
                return true;
            }
        }
        return false;
    }
    
    public void getCash (Vehicle vehicle, int minutes) {
        if (minutes > this.treshold1High && minutes <= this.treshold2High) {
            minutes = Math.min(minutes, this.treshold2Low);
        }
        else if (minutes <= this.treshold1High) {
            minutes = Math.min(minutes, this.treshold1Low);
        }
        
        if (vehicle.getKind() == Vehicle.Kind.SCOOTER) {
            this.cash += minutes * this.multiplerForScooter / 100; 
        }
        else if (vehicle.getKind() == Vehicle.Kind.CAR) {
            this.cash += minutes * this.multiplerForCar / 100;
        }
        else this.cash += minutes * this.multiplerForTruck / 100;
    }
    








}
