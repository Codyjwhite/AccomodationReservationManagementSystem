import com.google.gson.Gson;
import jdk.jshell.Snippet;

import java.util.Date;

public abstract class Reservation {

    private String accountNumber;
    private final String reservationNumber;
    private Address physicalAddress;
    private Address mailingAddress;
    private Date startDate;
    private int stayDuration;
    private int numberOfBeds;
    private int numberOfBedrooms;
    private Float numberOfBathrooms;
    private int lodgingSize;
    enum resType {Hotel, Cabin, House}
    private resType reservationType;
    private enum status { Draft, Completed, Canceled}
    private status currentStatus;

    private String filePath;

    public Reservation(String accountNumber, String reservationNumber, Address physicalAddress, Address mailingAddress,
                       Date startDate, int stayDuration, int numberOfBeds, int numberOfBedrooms,
                       float numberOfBathrooms, int lodgingSize, resType reservationType, String filePath){
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
        this.reservationType = reservationType;
        this.currentStatus = status.Draft;
        this.filePath = filePath;

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

    public void setFilePath(String filePath) {this.filePath = filePath;}

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

    public resType getReservationType() {return reservationType;}

    public status getCurrentStatus() {
        return currentStatus;
    }

    public String getFilePath() {
        return filePath;
    }


   //returns a double representing a Reservation's cost per night
    public double pricePerNight() {

        double totalPricePerNight = 0.0;
        double basicPrice = 120.0;
        double sizeFee = 15.0;

        if (lodgingSize > 900) {
            totalPricePerNight = basicPrice + sizeFee;
        }
        else {
                totalPricePerNight = basicPrice;
            }

        return totalPricePerNight;
    }

    //returns a double representing a Reservation's total cost
    public double TotalPrice() {

        double totalPrice;
        totalPrice = pricePerNight() * stayDuration;
        return totalPrice;


    }



    public void updateReservation (String accountNumber, String reservationNumber, Date startDate,
                                   int stayDuration, int numberOfBeds, int numberOfBedrooms,
                                   float numberOfBathrooms, int lodgingSize, resType reservationType, String phyStreet,
                                   String phyCity, String phyState, String phyZipCode, String phyCountry,
                                   String mailStreet,
                                   String mailCity, String mailState, String mailZipCode, String mailCountry) {

        //Method used to update reservations, will get called by each subclass before updating unique attributes.

        try {
            if (phyStreet != null || phyCity != null || phyState != null || phyZipCode != null || phyCountry != null) {
                this.getPhysicalAddress().updateAddress(phyStreet, phyCity, phyState, phyZipCode, phyCountry);
            }
            if (mailStreet != null || mailCity != null || mailState != null || mailZipCode != null || mailCountry != null) {
                this.getMailingAddress().updateAddress(mailStreet, mailCity, mailState, mailZipCode, mailCountry);
            }
            if (startDate != null) {
                this.setStartDate(startDate);
            }
            if (stayDuration != -1) {
                this.setStayDuration(stayDuration);
            }
            if (numberOfBeds != -1) {
                this.setNumberOfBeds(numberOfBeds);
            }
            if (numberOfBathrooms != -1) {
                this.setNumberOfBathrooms(numberOfBathrooms);
            }
            if (numberOfBedrooms != -1) {
                this.setNumberOfBedrooms(numberOfBedrooms);
            }
            if (lodgingSize != -1) {
                this.setLodgingSize(lodgingSize);
            }
            this.reservationType = reservationType;
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException(reservationNumber, "Reservation number does not exist or is incorrect");
        }
    }


    //Sets status of the reservation to complete
    public Reservation completeReservation(){

        this.currentStatus = status.Completed;

        return this;
    }

    //Sets status of the reservation to canceled
    public Reservation cancelReservation() throws InvalidStatusException {

        Date currentDate = new Date();

        if(this.startDate.after(currentDate)) {
            this.currentStatus = status.Canceled;
        }
        else {
            throw new InvalidStatusException(this. reservationNumber, " Reservation can't be canceled. Start date has passed");
        }
        return this;
    }

    //provide UI with ability to output data to the screen
    public String toString(){
        Gson newJsonFile = new Gson();
        return newJsonFile.toJson(this);
    }
}
