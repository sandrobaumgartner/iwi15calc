package at.edu.c02.calculator;

public class StoreException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public StoreException() {
    }

    public StoreException(String arg0) {
        super(arg0);
    }


    public StoreException(Throwable arg0) {
        super(arg0);
    }

    public StoreException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

}
