package Miscellaneous.Custom_Exceptions;

/**
 * Indicates the Total Probability Axiom has been violated for a space of events.
 */
public class TotalProbabilityException extends ProbabilityException{

    public TotalProbabilityException(){
        super(MESSAGE);
    }

    private static final String MESSAGE = "The total Probability of the events in the space does not equal 100%.";
}
