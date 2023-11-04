public class InvalidStatusException extends IllegalArgumentException {
    private String reservationNumber;
    private enum status { Draft, Completed, Canceled}
    private status currentStatus;
    private String message;

    InvalidStatusException(String reservationNumber, status currentStatus) {
        this.reservationNumber = reservationNumber;
        this.currentStatus = currentStatus;
    }
    InvalidStatusException(String reservationNumber, String message) {
        this.reservationNumber = reservationNumber;
        this.message = message;
    }

    @Override
    public String toString() {
        if(message == null){
            return reservationNumber + " has an invalid status of " + currentStatus;
        }
        else {
            return reservationNumber + message;
        }
    }
}
