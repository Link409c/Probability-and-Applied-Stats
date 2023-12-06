package Miscellaneous.Custom_Exceptions;

/**
 * Indicates the calculation of the "Within Number" in Tchebysheffs Theorem has resulted in
 * non-equal values, which may indicate an error in the input or calculation of the value by
 * the user.
 */
public class WithinNumberException extends ProbabilityException{

    public WithinNumberException(){
        super(MESSAGE);
    }

    private static final String MESSAGE = "Within Numbers do not match. Check your standard deviation calculations" +
            "and the amount of standard deviations your problem asks for.";
}
