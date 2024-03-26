package org.mps.deque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Comparator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


public class DoubleLinkedListTest {

    @Nested
    @DisplayName("Tests para probar el constructor")
    class testConstructor{
        @Test
        @DisplayName("Con los parámetros adecuados")
        void constructor_WithGoodParameter__WorksCorrectly(){
            DoubleLinkedList <Integer> list = new DoubleLinkedList<>();
            
            assertThrows(DoubleLinkedQueueException.class, () -> list.first());
            assertThrows(DoubleLinkedQueueException.class, () -> list.last());
            assertEquals(0, list.size());

        }
    }

    @Nested
    @DisplayName("Tests para probar el método prepend")
    class testPrepend{
        @Test
        @DisplayName("Comprobamos que añada el elemento correctamente al principio")
        void prepend_OneElementAtTheBegin_WorksCorrectly() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

            list.prepend(1);
            
            assertEquals(1, list.size());
            assertEquals(1, list.first());
            assertEquals(1, list.last());
        }

        @Test
        @DisplayName("Comprobamos que añada correctamente 3 nodos al principio")
        void prepend_ThreeElementAtTheBegin_WorksCorrectly() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

            list.prepend(1);
            list.prepend(2);
            list.prepend(3);
            
            assertEquals(3, list.size());
            assertEquals(3, list.first());
            assertEquals(1, list.last());
        }

        @Test
        @DisplayName("Al intentar añadir un elemento null al principio nos debe lanzar una excepción")
        void prepend_withValueNull_throwsException() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

            assertThrows(DoubleLinkedQueueException.class, () -> list.prepend(null));
        }
    }

    @Nested
    @DisplayName("Tests para probar el método append")
    class testAppend{
        @Test
        @DisplayName("Comprobamos que añada correctamente 1 elemento al final")
        void append_OneElementAtTheEnd_WorksCorrectly() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

            list.append(1);
            
            assertEquals(1, list.size());
            assertEquals(1, list.first());
            assertEquals(1, list.last());
        }

        @Test
        @DisplayName("Comprobamos que añada correctamente 3 nodos al final")
        void append_ThreeElementAtTheEnd_WorksCorrectly() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

            list.append(1);
            list.append(2);
            list.append(3);
            
            assertEquals(3, list.size());
            assertEquals(1, list.first());
            assertEquals(3, list.last());
        }

        @Test
        @DisplayName("Al intentar añadir un elemento null al final nos debe lanzar una excepción")
        void append_withValueNull_throwsException() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

            assertThrows(DoubleLinkedQueueException.class, () -> list.append(null));
        }
    }

    @Nested
    @DisplayName("Tests al método deleteFirst")
    class testDeleteFirst{
        @Test
        @DisplayName("Cuando hay elementos, se borra el primer elemento correctamente")
        void deleteFirst_WithElements_WorksCorrectly(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            list.append(1);
            list.append(7);
            list.append(4);

            list.deleteFirst();

            assertEquals(3-1, list.size());
            assertEquals(7, list.first());
        }

        @Test
        @DisplayName("Cuando no hay elementos, se lanza una excepción")
        void deleteFirst_WithoutElements_ThrowsException(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

            assertThrows(DoubleLinkedQueueException.class, () -> list.deleteFirst());
        }
    }

    @Nested
    @DisplayName("Tests al método deleteLast")
    class testDeleteLast{
        @Test
        @DisplayName("Cuando hay elementos, se borra el último elemento correctamente")
        void deleteLast_WithElements_WorksCorrectly(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            list.append(1);
            list.append(7);
            list.append(6);

            list.deleteLast();

            assertEquals(2, list.size());
            assertEquals(7, list.last());
        }

        @Test
        @DisplayName("Cuando no hay elementos, se lanza una excepción")
        void deleteLast_WithoutElements_ThrowsException(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

            assertThrows(DoubleLinkedQueueException.class, () -> list.deleteLast());
        }
    }

    @Nested
    @DisplayName("Tests al método first")
    class testFirst{
        @Test
        @DisplayName("Cuando la cola tiene elementos, first nos devuelve el valor del primero correctamente")
        void first_WithElements_ReturnsValueOfFirst(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            list.append(1);
            list.append(2);
            list.append(3);

            int result = list.first();

            assertEquals(1, result);
        }

        @Test
        @DisplayName("Cuando la cola no tiene elementos, se lanza una excepción")
        void first_WithoutElements_ThrowsException(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

            assertThrows(DoubleLinkedQueueException.class, () -> list.first());
        }

    }

    @Nested
    @DisplayName("Tests al método last")
    class testLast{
        @Test
        @DisplayName("Cuando la cola tiene elementos, last nos devuelve el valor del último correctamente")
        void last_WithElements_ReturnsValueOfLast(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            list.append(1);
            list.append(2);
            list.append(3);

            int result = list.last();

            assertEquals(3, result);
        }

        @Test
        @DisplayName("Cuando la cola no tiene elementos, se lanza una excepción")
        void last_WithoutElements_ThrowsException(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

            assertThrows(DoubleLinkedQueueException.class, () -> list.last());
        }
    }

    @Nested
    @DisplayName("Tests al método size")
    class testSize{
        @Test
        @DisplayName("Cuando la cola tiene elementos, size devuelve el tamaño de la cola")
        void size_WithElements_ReturnNumberOfElements(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            list.append(0);
            list.append(1);
            list.append(4);
            list.append(8);
            list.append(2);

            int result = list.size();

            assertEquals(5, result);
        }

        @Test
        @DisplayName("Cuando la cola no tiene elementos, size develve cero")
        void size_WithoutElements_ReturnZero(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

            int result = list.size();

            assertEquals(0, result);
        }
    }

    @Nested
    @DisplayName("Tests al método get")
    class testGet {

        @Test
        @DisplayName("Cuando recibe un index que está dentro del rango, devuelve el valor del nodo correctamente")
        void get_WithIndexInRange_ReturnsValue(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            list.append(0);
            list.append(1);
            list.append(4);
            list.append(8);
            list.append(2);

            int result = list.get(3);

            assertEquals(8, result);
        }

        @Test
        @DisplayName("Cuando recibe un index que está fuera del rango, lanza una excepción")
        void get_WithIndexOutOfRange_throwsExcepction(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            list.append(0);
            list.append(1);
            list.append(4);

            assertThrows(IndexOutOfBoundsException.class, () -> list.get(4));
        }

        @Test
        @DisplayName("Cuando recibe un index con valor negativo, lanza una excepción")
        void get_WithNtegativeIndex_throwsExcepction(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            list.append(0);
            list.append(1);
            list.append(4);

            assertThrows(IndexOutOfBoundsException.class, () -> list.get(-2));
        }
    }

    @Nested
    @DisplayName("Tests al método contains")
    class testContains {

        @Test
        @DisplayName("Cuando el valor a buscar sea null, se debe lanzar la excepcion correcta")
        void contains_NullInList_ThrowsException(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            list.append(0);
            list.append(1);

            assertThrows(DoubleLinkedQueueException.class, () -> list.contains(null));
        }

        @Test
        @DisplayName("Cuando el valor a buscar está en la lista, contains devuelve true")
        void contains_WithValueInList_ReturnsTrue(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            list.append(0);
            list.append(1);
            list.append(4);
            list.append(8);
            list.append(2);

            boolean contains = list.contains(4);

            assertEquals(true, contains);

        }

        @Test
        @DisplayName("Cuando el valor a buscar no está en la lista, contains devuelve false")
        void contains_WithoutValueInList_ReturnsFalse(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            list.append(0);
            list.append(1);
            list.append(4);
            list.append(8);
            list.append(2);

            boolean contains = list.contains(10);

            assertEquals(false, contains);
        }
    }

    @Nested
    @DisplayName("Tests al método remove")
    class testRemove {

        @Test
        @DisplayName("Cuando pasamos un valor contenido en la cola, el elemento debe ser borrado")
        public void remove_withTheValueInQueue_DeleteTheValue(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            list.append(0);
            list.append(1);
            list.append(4);
            list.append(8);
            list.append(2);

            list.remove(4);

            assertEquals(4, list.size());
            assertFalse(list.contains(4));
        }

        @Test
        @DisplayName("Cuando pasamos un valor que es el primero en la cola, el elemento debe ser borrado")
        public void remove_whenValueIsTheFirst_DeleteTheValue(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            list.append(0);
            list.append(1);
            list.append(4);
            list.append(8);
            list.append(2);

            list.remove(0);

            assertEquals(4, list.size());
            assertFalse(list.contains(0));
        }

        @Test
        @DisplayName("Cuando pasamos un valor que es el último en la cola, el elemento debe ser borrado")
        public void remove_whenValueIsTheLast_DeleteTheValue(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            list.append(0);
            list.append(1);
            list.append(8);
            list.append(2);

            list.remove(2);

            assertEquals(3, list.size());
            assertFalse(list.contains(2));
        }

        @Test
        @DisplayName("Cuando pasamos un valor que no está en la cola, se devuelve una excepción")
        public void remove_whenValueIsNotInQueue_throwsException(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            list.append(0);
            list.append(1);
            list.append(8);
            list.append(2);

            assertEquals(4, list.size());
            assertThrows(DoubleLinkedQueueException.class, () -> list.remove(5));
        }

        @Test
        @DisplayName("Cuando pasamos como parámetro un null, se devuelve una excepción")
        public void remove_whenValueIsNull_throwsException(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            list.append(0);
            list.append(1);
            list.append(8);
            list.append(2);

            assertThrows(DoubleLinkedQueueException.class, () -> list.remove(null));
        }
    }

    @Nested
    @DisplayName("Tests al método sort")
    class testSort {

        @Test
        @DisplayName("Si el tamaño de la lista en uno, devuelve el único nodo")
        void sort_WithOneElement_WorksProperly(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            list.append(1);

            list.sort(Comparator.naturalOrder()); // Comparador para ordenar números enteros de forma ascendente

            assertEquals(1, list.get(0));

        }

        @Test
        @DisplayName("Ordena la lista correctamente")
        void sort_WithElements_WorksProperly(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            list.append(0);
            list.append(1);
            list.append(4);
            list.append(8);
            list.append(2);

            list.sort(Comparator.naturalOrder()); // Comparador para ordenar números enteros de forma ascendente

            assertEquals(0, list.get(0));
            assertEquals(1, list.get(1));
            assertEquals(2, list.get(2));
            assertEquals(4, list.get(3));
            assertEquals(8, list.get(4));
        }

        @Test
        @DisplayName("Lanza exception si el comparador es null")
        void sort_WithComparatorNull_ThrowsException(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            list.append(0);
            list.append(1);
            list.append(4);
            list.append(8);
            list.append(2);

            assertThrows(DoubleLinkedQueueException.class, () -> list.sort(null));
        }

        @Test
        @DisplayName("Lanza excepcion si la lista está vacía")
        void sort_WithoutElements_ThrowsException(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

            assertThrows(DoubleLinkedQueueException.class, () -> list.sort(Comparator.naturalOrder()));
        }
            
    }

}
