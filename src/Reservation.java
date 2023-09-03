import java.time.LocalDate;

public class Reservation {

    public String accountNumber;
    public String reservationNumber;
    public Address physicalAddress;
    public Address mailingAddress;
    public LocalDate startDate;
    public int stayDuration;
    public int numberOfBeds;
    public int numberOfBedrooms;
    public float numberOfBathrooms;
    public int lodgingSize;
    public enum status { Draft, Completed, Canceled}

   //returns a double representing a Reservation's cost per night
    public double pricePerNight(Reservation reservation) {return 0.0;}

    //returns a double representing a Reservation's total cost
    public double TotalPrice(Reservation reservation) {return 0.0;}

    //Sets status of the reservation to canceled
    public void cancelReservation(Reservation reservation) {}

    //Sets status of the reservation to complete
    public void completeReservation(String accountNumber, String reservationNumber){}

    //provide UI with ability to output data to the screen
    public String toString(){return null;}
}
