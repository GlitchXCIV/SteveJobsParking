import java.util.Date;

public class Parking {
    private Vehicle vehicle; 
    private Date entry; 
    private Date exit; 

    public Parking(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.entry = new Date ();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
    
    
    public int exitVehicle () {
        this.exit = new Date (); 
        
        long time = this.exit.getTime() - this.entry.getTime();
        //double minutes = time / 60000; 
        //double minutes = time / 1000; ogni secondo reale vale un minuto
        double minutes = time * 60 / 1000; //ogni secondo reale vale un'ora
        
        return (int) minutes; 
    }
}
