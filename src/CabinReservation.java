import com.google.gson.Gson;

import java.util.Date;

public class CabinReservation extends Reservation {

    private boolean hasFullKitchen;
    private boolean hasLoft;

    public CabinReservation(String accountNumber, String reservationNumber, Address physicalAddress, Address mailingAddress,
                            Date startDate, int stayDuration, int numberOfBeds, int numberOfBedrooms,
                            float numberOfBathrooms, int lodgingSize, resType reservationType, String filePath, Boolean hasFullKitchen, Boolean hasLoft) {

        super(accountNumber, reservationNumber, physicalAddress, mailingAddress, startDate,
                stayDuration, numberOfBeds, numberOfBedrooms, numberOfBathrooms, lodgingSize, reservationType, filePath);
        this.hasFullKitchen = hasFullKitchen;
        this.hasLoft = hasLoft;

    }
    //returns a double representing a Cabin Reservation's cost per night
    @Override
    public double pricePerNight() {

        double basePrice = super.pricePerNight();

        if (hasFullKitchen) {
            basePrice = basePrice + 20.0;

            if (this.getNumberOfBathrooms() > 1) {
                for (int i = 1; i < this.getNumberOfBathrooms(); ++i)
                    basePrice = basePrice + 5.0;
                return basePrice;

            }

        }
        return basePrice;
    }


    public void updateReservation (String accountNumber, String reservationNumber, Date startDate,
                                   int stayDuration, int numberOfBeds, int numberOfBedrooms,
                                   float numberOfBathrooms, int lodgingSize, resType reservationType, String phyStreet,
                                   String phyCity, String phyState, String phyZipCode, String phyCountry,
                                   String mailStreet,
                                   String mailCity, String mailState, String mailZipCode, String mailCountry,
                                   boolean updateHasFullKitchen, boolean updateHasLoft) {
        //Calls parent method for shared attributes
        super.updateReservation(accountNumber,reservationNumber,startDate, stayDuration, numberOfBeds, numberOfBedrooms,
                numberOfBathrooms,lodgingSize,reservationType, phyStreet,phyCity,phyState,phyZipCode,phyCountry,mailStreet,
                mailCity, mailState, mailZipCode, mailCountry);

        //Unique attributes
        if(updateHasFullKitchen) {
            this.hasFullKitchen = !hasFullKitchen;
        }
        if(updateHasLoft) {
            this.hasLoft = !hasLoft;
        }


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

}
