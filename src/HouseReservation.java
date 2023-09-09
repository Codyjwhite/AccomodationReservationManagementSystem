public class HouseReservation extends Reservation {

    private int numOfFloors;

    public HouseReservation(){

        super();
    }
    public HouseReservation(int numOfFloors) {

//        this.numOfFloors = numOfFloors;
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
    //provide UI with ability to output data to the screen
    public String toString(){return null;}
}
