public class CabinReservation extends Reservation {

    public Boolean hasFullKitchen;
    public Boolean hasLoft;

    //returns a double representing a Cabin Reservation's cost per night
    public double pricePerNight(Reservation reservation){return 0.0;}

    //provide UI with ability to output data to the screen
    public String toString(){return null;}
}
