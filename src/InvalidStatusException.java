public class InvalidStatusException extends IllegalArgumentException {
    private String reservationNumber;
    private enum status { Draft, Completed, Canceled}
    private status currentStatus;
    private String message;

    InvalidStatusException(String reservationNumber, status currentStatus) {
        this.reservationNumber = reservationNumber;
        this.currentStatus = currentStatus;
    }
    InvalidStatusException(status currentStatus, String message) {
        this.currentStatus = currentStatus;
        this.message = message;
    }

    @Override
    public String toString() {
        if(message == null){
            return reservationNumber + " has an invalid status of " + currentStatus;
        }
        else {
            return reservationNumber + " has an invalid status of " + currentStatus + ": " + message;
        }
    }
}
