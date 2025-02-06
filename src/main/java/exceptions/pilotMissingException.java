package exceptions;

public class pilotMissingException extends Exception{
    public pilotMissingException(String name) {
        super("На корабле " + name + " нет пилота, поэтому он не может взлететь.");
    }
}
