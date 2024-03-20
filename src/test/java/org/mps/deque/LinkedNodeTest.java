
/*
 * @author1 José Antonio Casado Molina
 * @author2 Clemente Cano Mengíbar
 * @author3 Manuel Fuentes Vida
*/

package org.mps.deque;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

import javax.management.DescriptorKey;

@DisplayName("Un nodo enlazado")
public class LinkedNodeTest {

    @Nested
    @DisplayName("Pruebas para construir un nuevo nodo enlazado")
    class TestConstructorLinkedNode {
        LinkedNode<Object> node;

        @BeforeEach
        void setUp_LinkedNode(){
            node = new LinkedNode<Object>(null, null, null);
        }

        @Test
        @DisplayName("Test para comprobar que el constructor funciona correctamente")
        void TestConstructor_LinkedNode(){
            assertNull(node.getItem());
            assertNull(node.getPrevious());
            assertNull(node.getNext());

        }

    }

    @Nested
    @DisplayName("Pruebas para obtener los atributos de un Nodo enlazado")
    class TestGettersLinkedNode {

        @Test
        @DisplayName("Test para comprobar que se obtiene el item correctamente")
        void getItemLinkedNode_WorksProperly(){
            // Arrange
        LinkedNode<Integer> node1 = new LinkedNode<>(3, null, null);
        LinkedNode<Integer> node2 = new LinkedNode<>(5, null, null);
        LinkedNode<Integer> node3 = new LinkedNode<>(10, null, null);

            // Act
        int item1 = node1.getItem();
        int item2 = node2.getItem();
        int item3 = node3.getItem();

            // Assert
        assertEquals(3, item1);
        assertEquals(5, item2);
        assertEquals(10, item3);

        }

        @Test
        @DisplayName("Test para comprobar que se obtiene el nodo previo correctamente")
        void getPreviousLinkedNode_WorksProperly(){
            // Arrange
        LinkedNode<Integer> node1 = new LinkedNode<>(3, null, null);
        LinkedNode<Integer> node2 = new LinkedNode<>(5, node1, null);
        LinkedNode<Integer> node3 = new LinkedNode<>(10, node2, null);

        node1.setNext(node2);
        node2.setNext(node3);

            // Act & Assert
        assertEquals(null, node1.getPrevious());
        assertEquals(node1, node2.getPrevious());
        assertEquals(node2, node3.getPrevious());

        }

        @Test
        @DisplayName("Test para comprobar que se obtiene el nodo siguiente correctamente")
        void getNextLinkedNode_WorksProperly(){
            // Arrange
        LinkedNode<Integer> node1 = new LinkedNode<>(3, null, null);
        LinkedNode<Integer> node2 = new LinkedNode<>(5, node1, null);
        LinkedNode<Integer> node3 = new LinkedNode<>(10, node2, null);

        node1.setNext(node2);
        node2.setNext(node3);

            // Act & Assert
        assertEquals(node2, node1.getNext());
        assertEquals(node3, node2.getNext());
        assertEquals(null, node3.getNext());

        }
    }

    @Nested
    @DisplayName("Pruebas para establecer los atributos de un Nodo enlazado")
    class TestSettersLinkedNode {

        @Test
        @DisplayName("Test para comprobar que se establece el nuevo item correctamente")
        void setItemLinkedNode_WorksProperly(){
            // Arrange
        LinkedNode<Integer> node1 = new LinkedNode<>(3, null, null);
        LinkedNode<Integer> node2 = new LinkedNode<>(5, null, null);
        LinkedNode<Integer> node3 = new LinkedNode<>(10, null, null);

            // Act
        node1.setItem(6);
        node2.setItem(10);
        node3.setItem(20);


            // Assert
        assertEquals(6, node1.getItem());
        assertEquals(10, node2.getItem());
        assertEquals(20, node3.getItem());

        }

        @Test
        @DisplayName("Test para comprobar que se establece el nuevo nodo previo correctamente")
        void setPreviousLinkedNode_WorksProperly(){
            // Arrange
        LinkedNode<Integer> node1 = new LinkedNode<>(3, null, null);
        LinkedNode<Integer> node2 = new LinkedNode<>(5, node1, null);
        LinkedNode<Integer> node3 = new LinkedNode<>(10, node2, null);

            // Act
        node1.setPrevious(node2);
        node2.setPrevious(node3);
        node3.setPrevious(node1);

            // Assert
        assertEquals(node2, node1.getPrevious());
        assertEquals(node3, node2.getPrevious());
        assertEquals(node1, node3.getPrevious());

        }

        @Test
        @DisplayName("Test para comprobar que se establece el nuevo nodo siguiente correctamente")
        void setNextLinkedNode_WorksProperly(){
            // Arrange
        LinkedNode<Integer> node1 = new LinkedNode<>(3, null, null);
        LinkedNode<Integer> node2 = new LinkedNode<>(5, node1, null);
        LinkedNode<Integer> node3 = new LinkedNode<>(10, node2, null);

            // Act
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node1);

            // Assert
        assertEquals(node2, node1.getNext());
        assertEquals(node3, node2.getNext());
        assertEquals(node1, node3.getNext());

        }
    }

    @Nested
    @DisplayName("Pruebas para verificar si el nodo es el primero, el último o ninguno de los anteriores")
    class TestIsNodeLinkedNode {

        @Test 
        @DisplayName("Test para comprobar si el nodo de entrada es el primero de la Linked List devuelve true")
        void isFirstNode_withFirstNode_ReturnTrue(){
                // Arrange
            LinkedNode<Integer> node = new LinkedNode<>(3, null, null);

                // Act & Assert
            assertEquals(true, node.isFirstNode());

        }

        @Test 
        @DisplayName("Test para comprobar si el nodo de entrada no es el primero de la Linked List devuelve falso")
        void isFirstNode_notFirstNode_ReturnFalse(){
                // Arrange
            LinkedNode<Integer> node1 = new LinkedNode<>(3, null, null);
            LinkedNode<Integer> node2 = new LinkedNode<>(5, node1, null);
            LinkedNode<Integer> node3 = new LinkedNode<>(10, node2, null);
            node1.setNext(node2);
            node2.setNext(node3);


                // Act & Assert
            assertEquals(false, node2.isFirstNode());

        }

        @Test 
        @DisplayName("Test para comprobar si el nodo de entrada es el último de la Linked List devuelve true")
        void isLastNode_withLastNode_ReturnTrue(){
                // Arrange
            LinkedNode<Integer> node = new LinkedNode<>(3, null, null);

                // Act & Assert
            assertEquals(true, node.isLastNode());

        }

        @Test 
        @DisplayName("Test para comprobar si el nodo de entrada no es el último de la Linked List devuelve falso")
        void isLastNode_notLastNode_ReturnFalse(){
                // Arrange
            LinkedNode<Integer> node1 = new LinkedNode<>(3, null, null);
            LinkedNode<Integer> node2 = new LinkedNode<>(5, node1, null);
            LinkedNode<Integer> node3 = new LinkedNode<>(10, node2, null);
            node1.setNext(node2);
            node2.setNext(node3);


                // Act & Assert
            assertEquals(false, node2.isLastNode());

        }

        @Test 
        @DisplayName("Cuando no le pasamos un nodo terminal a isNotATerminalNode, nos devuelve true")
        void isNotATerminalNode_NotFirstOrLastNode_ReturnTrue(){
                // Arrange
            LinkedNode<Integer> node1 = new LinkedNode<>(3, null, null);
            LinkedNode<Integer> node2 = new LinkedNode<>(5, node1, null);
            LinkedNode<Integer> node3 = new LinkedNode<>(10, node2, null);
            node1.setNext(node2);
            node2.setNext(node3);
                // Act
            boolean result = node2.isNotATerminalNode();

                // Assert
            assertEquals(true, result);
    
        }

        @Test 
        @DisplayName("Cuando le pasamos un nodo terminal a isNotATerminalNode, nos devuelve false")
        void isNotATerminalNode_FirstOrLastNode_ReturnFalse(){
                // Arrange
            LinkedNode<Integer> node1 = new LinkedNode<>(3, null, null);
            LinkedNode<Integer> node2 = new LinkedNode<>(5, node1, null);
            LinkedNode<Integer> node3 = new LinkedNode<>(10, node2, null);
            node1.setNext(node2);
            node2.setNext(node3);
                // Act
            boolean result1 = node1.isNotATerminalNode();
            boolean result2 = node3.isNotATerminalNode();

                // Assert
            assertEquals(false, result1);
            assertEquals(false, result2);
    
        }
    }

    
}
