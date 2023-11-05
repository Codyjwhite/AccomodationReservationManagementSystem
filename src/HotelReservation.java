import com.google.gson.Gson;

import java.util.Date;

public class HotelReservation extends Reservation {

    private boolean hasKitchenette;

    public HotelReservation(String accountNumber, String reservationNumber, Address physicalAddress, Address mailingAddress,
                            Date startDate, int stayDuration, int numberOfBeds, int numberOfBedrooms,
                            float numberOfBathrooms, int lodgingSize, resType reservationType, String filePath, Boolean hasKitchenette) {
        super(accountNumber, reservationNumber, physicalAddress, mailingAddress, startDate,
                stayDuration, numberOfBeds, numberOfBedrooms, numberOfBathrooms, lodgingSize, reservationType, filePath);

        this.hasKitchenette = hasKitchenette;
        this.setNumberOfBedrooms(1);
        this.setNumberOfBeds(2);
        this.setNumberOfBathrooms(1);

    }

    //returns a double representing a Hotel Reservation's cost per night
    @Override
    public double pricePerNight() {

        double basePrice = super.pricePerNight() + 50.0;

        if (hasKitchenette) {
            basePrice = basePrice + 15.0;
        }
        return basePrice;
    }

    public void updateReservation (String accountNumber, String reservationNumber, Date startDate,
                                   int stayDuration, int numberOfBeds, int numberOfBedrooms,
                                   float numberOfBathrooms, int lodgingSize, resType reservationType, String phyStreet,
                                   String phyCity, String phyState, String phyZipCode, String phyCountry,
                                   String mailStreet,
                                   String mailCity, String mailState, String mailZipCode, String mailCountry,
                                   boolean updateHasKitchenette){

        //Calls parent method for shared attributes
        super.updateReservation(accountNumber,reservationNumber,startDate, stayDuration, numberOfBeds, numberOfBedrooms,
                numberOfBathrooms,lodgingSize, reservationType, phyStreet,phyCity,phyState,phyZipCode,phyCountry,mailStreet,
                mailCity, mailState, mailZipCode, mailCountry);

        //Unique attributes
        if (updateHasKitchenette) {
            this.hasKitchenette = !hasKitchenette;
        }

    }

    public void setHasKitchenette(Boolean hasKitchenette) {
        this.hasKitchenette = hasKitchenette;
    }

    public Boolean getHasKitchenette() {
        return hasKitchenette;
    }

}
