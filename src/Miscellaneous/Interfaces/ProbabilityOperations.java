package Miscellaneous.Interfaces;

public interface ProbabilityOperations<E> {

    //a method to count the number of unique objects in a list.
    E countUniqueObjects(E aList);

    //a method to assign simple probabilities to the unique objects in a list.
    E assignObjectProbabilities(E aList);

    //methods to create unions and intersections of objects based on their supertypes.
    E unite(E theLists);
    E intersect(E theLists);

    //methods to check lists of objects against the axioms of probability.
    boolean checkAxioms(E aList);

    //methods to return strings informing the user of the probabilities of objects in a list.
    String listProbabilities(E aList);
}
