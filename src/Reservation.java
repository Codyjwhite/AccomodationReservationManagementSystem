import java.time.LocalDate;

public abstract class Reservation implements Cloneable {

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
    public status currentStatus;

    public Reservation(){}

    public Reservation(String accountNumber, String reservationNumber, Address physicalAddress, Address mailingAddress,
                       LocalDate startDate, int stayDuration, int numberOfBeds, int numberOfBedrooms,
                       float numberOfBathrooms, int lodgingSize){
//        this.accountNumber = accountNumber;
//        this.reservationNumber = reservationNumber;
//        this.physicalAddress = physicalAddress;
//        this.mailingAddress = mailingAddress;
//        this.startDate = startDate;
//        this.stayDuration = stayDuration;
//        this.numberOfBeds = numberOfBeds;
//        this.numberOfBedrooms = numberOfBedrooms;
//        this.numberOfBathrooms = numberOfBathrooms;
//        this.lodgingSize = lodgingSize;
//        this.currentStatus = status.Draft;

    }

   //returns a double representing a Reservation's cost per night
    public double pricePerNight() {
        /*
        double totalPricePerNight = 0.0
        double basicPrice = 120.0
        double sizeFee = 15.0

        if lodgingSize is greater than 900
            totalPricePerNight = basicPrice + sizeFee
        else
            totalPricePerNight = basicPrice

        return totalPricePerNight

         */
        return 0.0;
    }

    //returns a double representing a Reservation's total cost
    public double TotalPrice() {
        /*
        double totalPrice
        totalPrice = pricePerNight() * stayDuration
        return totalPrice
         */
        return 0.0;
    }

    //Sets status of the reservation to canceled
    public void cancelReservation() {
        //this.currentStatus = status.Canceled;
    }

    //Sets status of the reservation to complete
    public void completeReservation(String accountNumber, String reservationNumber){
        //this.currentStatus = status.Completed;
    }
    @Override
    public Reservation clone(){
        //return super.clone();
    return null;
    }
    //provide UI with ability to output data to the screen
    public String toString(){return null;}
}
