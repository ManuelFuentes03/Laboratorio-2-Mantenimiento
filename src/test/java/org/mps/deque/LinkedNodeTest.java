
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

@DisplayName("Un nodo enlazado")
public class LinkedNodeTest {

    @Nested
    @DisplayName("Pruebas para construir un nuevo nodo enlazado")
    class TestConstructor {
        LinkedNode<Object> node;

        @BeforeEach
        void setUp_LinkedNode(){
            node = new LinkedNode<Object>(node, null, null);
        }

        @Test
        @DisplayName("Test para comprobar que el constructor funciona correctamente")
        void TestConstructorLinkedNode(){

        }

    }

    
}
