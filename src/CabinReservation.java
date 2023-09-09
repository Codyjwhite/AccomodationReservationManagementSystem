public class CabinReservation extends Reservation {

    private Boolean hasFullKitchen;
    private Boolean hasLoft;

    public CabinReservation(){
        super();
    }
    public CabinReservation(Boolean hasFullKitchen, Boolean hasLoft) {
//        this.hasFullKitchen = hasFullKitchen;
//        this.hasLoft = hasLoft;
    }
    //returns a double representing a Cabin Reservation's cost per night
    @Override
    public double pricePerNight(){
        /*
         double basePrice = super.pricePerNight()

         if hasFullKitchen
            basePrice = basePrice + 20.0

         if numberOfBathrooms > 1
            for each bathroom after the first
                basePrice = basePrice + 5.0
          return basePrice
         */

        return 0.0;}

    @Override
    public CabinReservation clone(){
        //return super.clone();
        return null;
    }
    //provide UI with ability to output data to the screen
    public String toString(){return null;}
}
