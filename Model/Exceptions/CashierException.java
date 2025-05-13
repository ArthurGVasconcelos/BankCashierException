package Model.Exceptions;

public class CashierException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public CashierException(String msg){
        super(msg);
    }
}
