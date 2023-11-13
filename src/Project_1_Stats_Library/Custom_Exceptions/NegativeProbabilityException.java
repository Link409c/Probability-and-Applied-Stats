package Project_1_Stats_Library.Custom_Exceptions;

/**
 * Indicates that the Axiom of Negative Probability has been violated for one or more events.
 */
public class NegativeProbabilityException extends ProbabilityException{

    public NegativeProbabilityException(){
        super(MESSAGE);
    }

    private static final String MESSAGE = "The probability passed to the method is negative.";
}
