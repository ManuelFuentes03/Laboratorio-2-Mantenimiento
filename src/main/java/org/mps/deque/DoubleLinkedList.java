/*
 * @author1 José Antonio Casado Molina
 * @author2 Clemente Cano Mengíbar
 * @author3 Manuel Fuentes Vida
*/

package org.mps.deque;

import java.util.Comparator;

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
        if(value == null){
            throw new DoubleLinkedQueueException("ERROR: no se puede añadir un valor null");
        }

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
        if(value == null){
            throw new DoubleLinkedQueueException("ERROR: no se puede añadir un valor null");
        }

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
        LinkedNode<T> node = new LinkedNode<T>(null, null, null);
        if(size == 0){
            throw new DoubleLinkedQueueException("Lista Vacia: no se puede borrar");
        }else{
            node = first.getNext();
            first = node;
            first.setPrevious(null);
        }
        size--;
    }

    @Override
    public void deleteLast() {
        // 
        LinkedNode<T> node = new LinkedNode<T>(null, null, null);
        if(size == 0){
            throw new DoubleLinkedQueueException("Lista Vacia: no se puede borrar");
        }else{
            node = last.getPrevious();
            last = node;
            last.setNext(null);
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

    @Override
    public T get(int index){
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("ERROR: el índice está fuera de rango");
        }
        int i = 0;
        LinkedNode<T> node = first;
        while(i < index) {
            node = node.getNext();
            i++;
        }
            
        return node.getItem(); 
    }

    @Override
    public boolean contains(T value) {
        if(value == null){
            throw new DoubleLinkedQueueException("ERROR: no se puede comprobar que en la lista haya un valor null");
        }

        boolean contains = false;

        for(int i = 0; i < size; i++){
            if(!contains && first.getItem().equals(value)){
                contains = true;
            } else {
                first = first.getNext();
            }
        }
        return contains;
    }
    
    @Override
    public void remove(T value){
        if(value == null) {
            throw new DoubleLinkedQueueException("ERROR: no se puede borrar un valor null");

        }
        
        LinkedNode<T> node = first.getNext();
        LinkedNode<T> previous;
        LinkedNode<T> next;
        boolean borrado = false;
        
        if(first.getItem().equals(value)) {
            deleteFirst();
            borrado = true;

        } else {
            while(node != null && !borrado){
                if(node.getItem().equals(value)){
                    if(node.getNext() == null) { // si es el último
                        previous = node.getPrevious();
                        previous.setNext(null);
                    } else {
                        previous = node.getPrevious();
                        next = node.getNext();
                        previous.setNext(next);
                        next.setPrevious(previous);
                    }
                    node.setNext(null);
                    node.setPrevious(null);
                    borrado = true;
                    size--;
                } else {
                    node = node.getNext();
                }
            }
        }
            
        if(!borrado){ //no se ha borrado ninguno
            throw new DoubleLinkedQueueException ("ERROR: el elemento que quieres borrar no está en la lista");
        } 
    }

    
    @Override
    public void sort(Comparator<? super T> comparator) {
        if (size ==1) {
            return;
        }else if(comparator == null || size == 0){
            throw new DoubleLinkedQueueException ("ERROR: parámetro negativo o lista vacia");
        }
    
        LinkedNode<T> current = first;
    
        while (current != null) {
            LinkedNode<T> minNode = current;
            LinkedNode<T> innerCurrent = current.getNext();
    
            while (innerCurrent != null) {
                if (comparator.compare(innerCurrent.getItem(), minNode.getItem()) < 0) {
                    minNode = innerCurrent;
                }
                innerCurrent = innerCurrent.getNext();
            }
    
            T temp = current.getItem();
            current.setItem(minNode.getItem());
            minNode.setItem(temp);
    
            current = current.getNext();
        }
    }
}
