package Project_1_Midterm.Mini_Coding_Projects.Hand_Evaluator;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class CardComparator implements Comparator<Card> {
    /**
     * compares two card objects.
     */
    @Override
    public int compare(Card o1, Card o2) {
        return Integer.compare(o1.getValue(), o2.getValue());
    }

    /**
     * compares the suits of two card objects.
     * @param o1 the first card
     * @param o2 the second card
     * @return true if both suits match, false otherwise.
     */
    public boolean compareSuits(Card o1, Card o2){
        return o1.getSuit().equals(o2.getSuit());
    }

    /**
     * compares the values of two card objects.
     * @param o1 the first card
     * @param o2 the second card
     * @return true if equal, false otherwise
     */
    public boolean compareValues(Card o1, Card o2){ return o1.getValue() == (o2.getValue());}

    /**
     * checks if the value of a card is one less than another.
     * @param o1 the lesser card
     * @param o2 the greater card
     * @return true if o2.value - o1.value = 1, false otherwise
     */
    public boolean oneLess(Card o1, Card o2){
        return o2.getValue() - o1.getValue() == 1;
    }

    @Override
    public Comparator<Card> reversed() {
        return Comparator.super.reversed();
    }

    @Override
    public Comparator<Card> thenComparing(Comparator<? super Card> other) {
        return Comparator.super.thenComparing(other);
    }

    @Override
    public <U> Comparator<Card> thenComparing(Function<? super Card, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return Comparator.super.thenComparing(keyExtractor, keyComparator);
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<Card> thenComparing(Function<? super Card, ? extends U> keyExtractor) {
        return Comparator.super.thenComparing(keyExtractor);
    }

    @Override
    public Comparator<Card> thenComparingInt(ToIntFunction<? super Card> keyExtractor) {
        return Comparator.super.thenComparingInt(keyExtractor);
    }

    @Override
    public Comparator<Card> thenComparingLong(ToLongFunction<? super Card> keyExtractor) {
        return Comparator.super.thenComparingLong(keyExtractor);
    }

    @Override
    public Comparator<Card> thenComparingDouble(ToDoubleFunction<? super Card> keyExtractor) {
        return Comparator.super.thenComparingDouble(keyExtractor);
    }
}
