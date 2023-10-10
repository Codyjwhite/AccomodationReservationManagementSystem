import java.time.LocalDate;

public class HotelReservation extends Reservation{

    private boolean hasKitchenette;

    public HotelReservation(){
    }

    //TODO Fix constructor to create object with full Reservation parameters
    public HotelReservation(String accountNumber, String reservationNumber, Address physicalAddress, Address mailingAddress,
                            LocalDate startDate, int stayDuration, int numberOfBeds, int numberOfBedrooms,
                            float numberOfBathrooms, int lodgingSize, Boolean hasKitchenette){

        super(accountNumber, reservationNumber, physicalAddress, mailingAddress,
                startDate,stayDuration, numberOfBeds,numberOfBedrooms, numberOfBathrooms,lodgingSize);
//      this.hasKitchenette = hasKitchenette;
    }

    //returns a double representing a Hotel Reservation's cost per night
    @Override
    public double pricePerNight(){
        /*
        double basePrice = super.pricePerNight() + 50.0

        if hasKitchenette
            basePrice = basePrice + 15.0
        return basePrice

        */
        return 0.0;}

    @Override
    public HotelReservation clone(){
        //return super.clone();
        return null;
    }

    public void setHasKitchenette(Boolean hasKitchenette) {
        this.hasKitchenette = hasKitchenette;
    }

    public Boolean getHasKitchenette() {
        return hasKitchenette;
    }

    //provide UI with ability to output data to the screen
    public String toString(){return null;}
}
