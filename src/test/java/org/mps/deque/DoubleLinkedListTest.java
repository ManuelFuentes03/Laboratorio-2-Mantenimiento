package org.mps.deque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
        void constructorWithGoodParameter(){
            DoubleLinkedList <Integer> list = new DoubleLinkedList<>();

            assertNull(list.first());
            assertNull(list.last());
            assertEquals(0, list.size());

        }
    }

    @Nested
    @DisplayName("Tests para probar el método prepend")
    class testPrepend{
        @Test
        @DisplayName("Comprobamos que añada correctamente 1 al principio")
        void prependOneElementAtTheBegin() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

            list.prepend(1);
            
            assertEquals(1, list.size());
            assertEquals(1, list.first());
            assertEquals(1, list.last());
        }

        @Test
        @DisplayName("Comprobamos que añada correctamente 3 nodos al principio")
        void prependThreeElementAtTheBegin() {
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
        void appendOneElementAtTheEnd() {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

            list.append(1);
            
            assertEquals(1, list.size());
            assertEquals(1, list.first());
            assertEquals(1, list.last());
        }

        @Test
        @DisplayName("Comprobamos que añada correctamente 3 nodos al final")
        void appendThreeElementAtTheEnd() {
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
    @DisplayName("Tests al método first")
    class testFirst{
        @Test
        @DisplayName("Cuando la cola tiene elementos, first nos devuelve el primero correctamente")
        void first_WithElements_ReturnsValueOfFirst(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            list.append(1);
            list.append(2);
            list.append(3);

            int result = list.first();

            assertEquals(1, result);
        }

        @Test
        @DisplayName("Cuando la cola no tiene elementos, se lanza un error")
        void first_WithoutElements_ReturnsException(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

            assertThrows(DoubleLinkedQueueException.class, () -> list.first());
        }

    }
    
}
