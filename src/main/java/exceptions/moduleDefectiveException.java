package exceptions;

public class moduleDefectiveException extends RuntimeException{
    public moduleDefectiveException(String name) {
        super("Модуль " + name + " неисправен и не может быть включен.");
    }
}
