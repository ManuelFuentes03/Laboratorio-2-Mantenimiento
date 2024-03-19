/*
 * @author1 José Antonio Casado Molina
 * @author2 Clemente Cano Mengíbar
 * @author3 Manuel Fuentes Vida
*/

package org.mps.deque;

public class DoubleLinkedList<T> implements DoubleLinkedQueue<T> {

    private LinkedNode<T> first;
    private LinkedNode<T> last;
    private int size;

    public DoubleLinkedList() {
        // TODO
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public void prepend(T value) {
        // TODO
        LinkedNode<T> newNode = new LinkedNode<T>(value, null, null);
        if (size==0) {
            first = newNode;
            last = newNode;
        } else {
            newNode.setNext(first);
            first.setPrevious(newNode);
            first = newNode;
        }

        size++;
    }

    @Override
    public void append(T value) {
        // TODO
        LinkedNode<T> newNode = new LinkedNode<T>(value, null, null);
        if(size == 0){
            last = newNode;
            first = newNode;
        }else{
            newNode.setPrevious(last);
            last.setNext(newNode);
            last = newNode;
        }
        size++;
    }

    @Override
    public void deleteFirst() {
        // TODO
        LinkedNode<T> newNode = new LinkedNode<T>(null, null, null);
        if(size == 0){
            throw new DoubleLinkedQueueException("Lista Vacia: no se puede borrar");
        }else{
            newNode = first.getNext();
            first = newNode;

        }
        size--;
    }

    @Override
    public void deleteLast() {
        // 
        LinkedNode<T> newNode = new LinkedNode<T>(null, null, null);
        if(size == 0){
            throw new DoubleLinkedQueueException("Lista Vacia: no se puede borrar");
        }else{
            newNode = last.getPrevious();
            last = newNode;

        }
        size--;
    }

    @Override
    public T first() {
        // TODO
        if(size == 0){
            throw new DoubleLinkedQueueException("Lista Vacia: no se puede devolver el primero");
        }else{
            return first.getItem();
        }
    }

    @Override
    public T last() {
        // TODO
        if(size == 0){
            throw new DoubleLinkedQueueException("Lista Vacia: no se puede devolver el ultimo");
        }else{
            return last.getItem();
        }
        
    }

    @Override
    public int size() {
        // TODO
        return size;
    }
}
