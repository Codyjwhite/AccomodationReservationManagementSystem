import com.google.gson.Gson;

import java.util.Date;

public class HotelReservation extends Reservation {

    private boolean hasKitchenette;


    public HotelReservation() {
    }


    public HotelReservation(String accountNumber, String reservationNumber, Address physicalAddress, Address mailingAddress,
                            Date startDate, int stayDuration, int numberOfBeds, int numberOfBedrooms,
                            float numberOfBathrooms, int lodgingSize, Boolean hasKitchenette) {
        super(accountNumber, reservationNumber, physicalAddress, mailingAddress, startDate,
                stayDuration, numberOfBeds, numberOfBedrooms, numberOfBathrooms, lodgingSize);

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

    @Override
    public HotelReservation clone() {
        //return super.clone();
        return null;
    }

    public void setHasKitchenette(Boolean hasKitchenette) {
        this.hasKitchenette = hasKitchenette;
    }

    public Boolean getHasKitchenette() {
        return hasKitchenette;
    }

}
