package Mini_Coding_Projects.Hand_Evaluator;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class Deck implements Queue<Card> {
    //TODO: implement this class for future use in the HandEvaluator program.
    @Override
    public int size() {
        int elements = 0;
        for(Card c : this){
            if (c != null){
                elements++;
            }
        }
        return elements;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Card> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Card card) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Card> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean offer(Card card) {
        return false;
    }

    @Override
    public Card remove() {
        return null;
    }

    @Override
    public Card poll() {
        return null;
    }

    @Override
    public Card element() {
        return null;
    }

    @Override
    public Card peek() {
        return null;
    }
}
