import com.google.gson.Gson;

import java.util.Date;

public class CabinReservation extends Reservation {

    private boolean hasFullKitchen;
    private boolean hasLoft;



    public CabinReservation(){
    }

    //TODO Fix constructor to create object with full Reservation parameters
    public CabinReservation(String accountNumber, String reservationNumber, Address physicalAddress, Address mailingAddress,
                            Date startDate, int stayDuration, int numberOfBeds, int numberOfBedrooms,
                            float numberOfBathrooms, int lodgingSize, Boolean hasFullKitchen, Boolean hasLoft) {

        super(accountNumber, reservationNumber, physicalAddress, mailingAddress, startDate,
                stayDuration, numberOfBeds, numberOfBedrooms, numberOfBathrooms, lodgingSize);
        this.hasFullKitchen = hasFullKitchen;
        this.hasLoft = hasLoft;

    }
    //returns a double representing a Cabin Reservation's cost per night
    @Override
    public double pricePerNight(){
        /*
         double basePrice = super.pricePerNight()

         if hasFullKitchen
            basePrice = basePrice + 20.0

         if numberOfBathrooms > 1
            for each bathroom after the first
                basePrice = basePrice + 5.0
          return basePrice
         */

        return 0.0;}

    @Override
    public CabinReservation clone(){
        //return super.clone();
        return null;
    }

    public void setHasFullKitchen(Boolean hasFullKitchen) {
        this.hasFullKitchen = hasFullKitchen;
    }

    public void setHasLoft(Boolean hasLoft) {
        this.hasLoft = hasLoft;
    }

    public Boolean getHasFullKitchen() {
        return hasFullKitchen;
    }

    public Boolean getHasLoft() {
        return hasLoft;
    }

    //provide UI with ability to output data to the screen
//    public String toString(){
//        Gson newJsonFile = new Gson();
//        return newJsonFile.toJson(this);
//    }
}
