public class PhysicalAddressRequiredException extends RuntimeException {
    public PhysicalAddressRequiredException() {
        super("Physical address is required and cannot be null.");
    }

    public PhysicalAddressRequiredException(String message) {
        super(message);
    }
}
