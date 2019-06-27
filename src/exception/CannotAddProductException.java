package exception;

public class CannotAddProductException extends Throwable {
    public CannotAddProductException(String s) {
        System.out.println(s);
    }
}
