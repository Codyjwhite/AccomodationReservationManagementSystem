public class HotelReservation extends Reservation{

    private Boolean hasKitchenette;

    public HotelReservation(){
        super();
    }
    public HotelReservation(Boolean hasKitchenette){
//        this.hasKitchenette = hasKitchenette;
    }

    //returns a double representing a Hotel Reservation's cost per night
    @Override
    public double pricePerNight(){
        /*
        double basePrice = super.pricePerNight() + 50.0

        if hasKitchenette
            basePrice = basePrice + 15.0
        return basePrice

        */
        return 0.0;}

    @Override
    public HotelReservation clone(){
        //return super.clone();
        return null;
    }

    //provide UI with ability to output data to the screen
    public String toString(){return null;}
}
