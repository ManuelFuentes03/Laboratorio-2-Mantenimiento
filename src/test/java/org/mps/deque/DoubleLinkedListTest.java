package org.mps.deque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

    }

    @Nested
    @DisplayName("Tests al método contains")
    class testContains {

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

    }
    @Nested
    @DisplayName("Tests al método sort")
    class testSort {

    }
}
