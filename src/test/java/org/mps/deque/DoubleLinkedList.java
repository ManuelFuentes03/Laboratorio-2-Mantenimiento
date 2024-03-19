/*
 * @author1 José Antonio Casado Molina
 * @author2 Clemente Cano Mengíbar
 * @author3 Manuel Fuentes Vida
*/

package src.test.java.org.mps.deque;

public class DoubleLinkedList<T> implements DoubleLinkedQueue<T> {

    private LinkedNode<T> first;
    private LinkedNode<T> last;
    private int size;

    public DoubleLinkedList() {
        // TODO
        
    }

    @Override
    public void prepend(T value) {
        // TODO
    }

    @Override
    public void append(T value) {
        // TODO
    }

    @Override
    public void deleteFirst() {
        // TODO
    }

    @Override
    public void deleteLast() {
        // TODO
    }

    @Override
    public T first() {
        // TODO
        return first.getItem();
    }

    @Override
    public T last() {
        // TODO
        return last.getItem();
    }

    @Override
    public int size() {
        // TODO
        return size;
    }
}
