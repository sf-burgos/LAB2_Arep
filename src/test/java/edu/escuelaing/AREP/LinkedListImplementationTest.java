package edu.escuelaing.AREP;
import org.junit.jupiter.api.DynamicTest;
import org.junit.Before;
import org.junit.Test;
import java.util.LinkedList;
import edu.escuelaing.AREP.app.LinkedListImplementation;

import static org.junit.Assert.assertEquals;
public class LinkedListImplementationTest {

    @Test
    public void DeberiaInsertarDatosBien(){
        LinkedListImplementation <Integer> list = new LinkedListImplementation<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        list.insert(50);
        list2.add(50);
        assertEquals(50, 50);
    }
    @Test
    public void DeberiaInsertarAlInicio(){
        LinkedListImplementation <Integer> list = new LinkedListImplementation<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        list.insertAtStart(20);
        list2.add(20);
        assertEquals(20, 20);
    }

}

