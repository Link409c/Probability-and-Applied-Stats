package Miscellaneous.Custom_Exceptions;

import javax.xml.datatype.DatatypeConfigurationException;

/**
 * Indicates an error in passed probability variables has occurred, following
 * the axioms of probability.
 */
public class ProbabilityException extends DatatypeConfigurationException {

    public ProbabilityException(String message){
        super(message);
    }

}
