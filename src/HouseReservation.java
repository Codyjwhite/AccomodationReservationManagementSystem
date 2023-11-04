import com.google.gson.Gson;

import java.util.Date;

public class HouseReservation extends Reservation {

    private int numOfFloors;

    public HouseReservation(String accountNumber, String reservationNumber, Address physicalAddress, Address mailingAddress,
                            Date startDate, int stayDuration, int numberOfBeds, int numberOfBedrooms,
                            float numberOfBathrooms, int lodgingSize, String filePath, int numOfFloors) {
        super(accountNumber, reservationNumber, physicalAddress, mailingAddress, startDate,
                stayDuration, numberOfBeds, numberOfBedrooms, numberOfBathrooms, lodgingSize, filePath);

        this.numOfFloors = numOfFloors;

    }

    //returns a double representing a House Reservation's cost per night
    @Override
    public double pricePerNight(){

        return super.pricePerNight();
    }

    public void updateReservation (String accountNumber, String reservationNumber, Date startDate,
                                   int stayDuration, int numberOfBeds, int numberOfBedrooms,
                                   float numberOfBathrooms, int lodgingSize, String phyStreet,
                                   String phyCity, String phyState, String phyZipCode, String phyCountry,
                                   String mailStreet,
                                   String mailCity, String mailState, String mailZipCode, String mailCountry,
                                   int numOfFloors) {
        //Calls parent method for shared attributes
        super.updateReservation(accountNumber,reservationNumber,startDate, stayDuration, numberOfBeds, numberOfBedrooms,
                numberOfBathrooms,lodgingSize,phyStreet,phyCity,phyState,phyZipCode,phyCountry,mailStreet,
                mailCity, mailState, mailZipCode, mailCountry);

        //Unique attributes
        if (numOfFloors != -1) {
            this.numOfFloors = numOfFloors;
        }
    }

    @Override
    public Reservation clone(){
        //return super.clone();
        return null;
    }

    public void setNumOfFloors(int numOfFloors) {
        this.numOfFloors = numOfFloors;
    }

    public int getNumOfFloors() {
        return numOfFloors;
    }

}
