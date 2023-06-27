package lt.techin.exception;


public class CarWorkshopServiceDisabledException extends RuntimeException {


    public CarWorkshopServiceDisabledException() {
    }

    public CarWorkshopServiceDisabledException(String message) {
        super(message);
    }

}
