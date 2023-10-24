import com.google.gson.Gson;
import jdk.jshell.Snippet;

import java.util.Date;

public abstract class Reservation implements Cloneable {

    private String accountNumber;
    private String reservationNumber;
    private Address physicalAddress;
    private Address mailingAddress;
    private Date startDate;
    private int stayDuration;
    private int numberOfBeds;
    private int numberOfBedrooms;
    private Float numberOfBathrooms;
    private int lodgingSize;
    private enum status { Draft, Completed, Canceled}
    private status currentStatus;

    public Reservation(){}

    public Reservation(String accountNumber, String reservationNumber, Address physicalAddress, Address mailingAddress,
                       Date startDate, int stayDuration, int numberOfBeds, int numberOfBedrooms,
                       float numberOfBathrooms, int lodgingSize){
        this.accountNumber = accountNumber;
        this.reservationNumber = reservationNumber;
        this.physicalAddress = physicalAddress;
        this.mailingAddress = mailingAddress;
        this.startDate = startDate;
        this.stayDuration = stayDuration;
        this.numberOfBeds = numberOfBeds;
        this.numberOfBedrooms = numberOfBedrooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.lodgingSize = lodgingSize;
        this.currentStatus = status.Draft;

    }
    public void setPhysicalAddress(Address newAddress){
        this.physicalAddress = newAddress;
    }

    public void setMailingAddress(Address newAddress){
        this.mailingAddress= newAddress;
    }

    public void setStartDate(Date newStartDate){
        this.startDate = newStartDate;
    }

    public void setStayDuration(int newStayDuration) {
        this.stayDuration = newStayDuration;
    }

    public void setNumberOfBeds(int newNumberOfBeds) {
        this.numberOfBeds = newNumberOfBeds;
    }

    public void setNumberOfBedrooms(int newNumberOfBedrooms) {
        this.numberOfBedrooms = newNumberOfBedrooms;
    }

    public void setNumberOfBathrooms(float newNumberOfBathrooms) {
        this.numberOfBathrooms = newNumberOfBathrooms;
    }

    public void setLodgingSize(int newLodgingSize) {
        this.lodgingSize = newLodgingSize;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public Address getPhysicalAddress() {
        return physicalAddress;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public Date getStartDate() {
        return startDate;
    }

    public int getStayDuration() {
        return stayDuration;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public float getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public int getLodgingSize() {
        return lodgingSize;
    }

    public status getCurrentStatus() {
        return currentStatus;
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
    public void completeReservation(){
        //this.currentStatus = status.Completed;
    }
    @Override
    public Reservation clone(){
        //return super.clone();
        return null;
    }
    //provide UI with ability to output data to the screen
    public String toString(){
        Gson newJsonFile = new Gson();
        return newJsonFile.toJson(this);
    }
}
