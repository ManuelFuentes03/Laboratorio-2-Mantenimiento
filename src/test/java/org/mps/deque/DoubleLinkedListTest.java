package org.mps.deque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class DoubleLinkedListTest {
    DoubleLinkedList list;

    @BeforeEach
    void setUp_list(){
        list = new DoubleLinkedList<>();
    }
    
    @Nested
    @DisplayName("Pruebas al método first")
    class testFirst {

        @Test
        @DisplayName("First con una lista con elementos devuelve el primero")
        void first_whenThereAreElements_worksCorrectly() {
            
        }

    }
}
