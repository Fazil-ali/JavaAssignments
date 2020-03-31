
import java.util.Scanner;

class DollarException extends Exception{
    public DollarException(String exceptionMsg){
        super(exceptionMsg);

    }

}
class AtTheRateException extends Exception{
    public AtTheRateException(String exceptionMsg){
        super(exceptionMsg);

    }
}
class ExclamationException extends Exception{
    public ExclamationException(String exceptionMsg){

        super(exceptionMsg);

    }
}
public class ErrorHandling {
    void throwExceptions(String input) {

        try {

            if (input.equals("$"))

                throw new DollarException("Dollar Exception");

            else if (input.equals("@"))

                throw new AtTheRateException(" @ Exception");

            else if (input.equals("!"))

                throw new ExclamationException("Exclamation Exception");

            else if (input.equals(""))

                throw new NullPointerException("Invalid String");

            else

                System.out.println(input);


        } catch (DollarException | AtTheRateException | ExclamationException e) {

            System.out.println(e.getMessage());
        } catch (NullPointerException e) {

            System.out.println(e.getMessage());

            e.printStackTrace();

        } finally {
            System.out.println("finally block excecuted");

        }
    }
}

