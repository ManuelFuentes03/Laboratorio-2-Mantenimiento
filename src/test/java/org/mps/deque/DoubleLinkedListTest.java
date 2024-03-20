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
        @DisplayName("Comprobamos que añada correctamente 1 al principio")
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
            list.append(2);
            list.append(3);

            list.deleteFirst();

            assertEquals(2, list.size());
        }

        @Test
        @DisplayName("Cuando hay elementos, se borra el ultimo elemento correctamente")
        void deleteLast_WithElements_CheckOk(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            list.append(1);
            list.append(2);
            list.append(3);

            list.deleteFirst();

            assertEquals(2, list.first());
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
        @DisplayName("Cuando hay elementos, se borra el ultimo elemento correctamente")
        void deleteLast_WithElements_WorksCorrectly(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            list.append(1);
            list.append(2);
            list.append(3);

            list.deleteLast();

            assertEquals(2, list.size());
        }

        @Test
        @DisplayName("Cuando hay elementos, se borra el ultimo elemento correctamente")
        void deleteLast_WithElements_CheckOk(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            list.append(1);
            list.append(2);
            list.append(3);

            list.deleteLast();

            assertEquals(2, list.last());
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

        @Nested
        @DisplayName("Tests a la clase size")
        class testSize{
            @Test
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
            void size_WithoutElements_ReturnZero(){
                DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

                int result = list.size();

                assertEquals(0, result);
            }
        }

    }
}
