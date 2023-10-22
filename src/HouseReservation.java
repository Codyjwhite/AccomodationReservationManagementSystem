import com.google.gson.Gson;

import java.util.Date;

public class HouseReservation extends Reservation {

    private int numOfFloors;

    public HouseReservation(){

    }

    //TODO Fix constructor to create object with full Reservation parameters
    public HouseReservation(String accountNumber, String reservationNumber, Address physicalAddress, Address mailingAddress,
                            Date startDate, int stayDuration, int numberOfBeds, int numberOfBedrooms,
                            float numberOfBathrooms, int lodgingSize, int numOfFloors) {

        super(accountNumber, reservationNumber, physicalAddress, mailingAddress,
                startDate,stayDuration, numberOfBeds,numberOfBedrooms, numberOfBathrooms,lodgingSize);
//      this.numOfFloors = numOfFloors;
    }

    //returns a double representing a House Reservation's cost per night
    @Override
    public double pricePerNight(){
        /*
        return super.pricePerNight
         */
        return 0.0;}

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

    //provide UI with ability to output data to the screen
    public String toString(){
        Gson newJsonFile = new Gson();
        return newJsonFile.toJson(this);
    }
}
