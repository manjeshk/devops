package com.manjeshk.app.mockito;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MockitoTest {


    //Mockito Mock method
    @SuppressWarnings("unchecked")
    @Test
    @Disabled
    public void testMockitoMock() {
        //Use Mockito.mock() method to mock the object
        List<String> mockList = mock(List.class);
        when(mockList.get(0)).thenReturn("Mockito");
        assertEquals("Mockito", mockList.get(0));
    }

    //@Mock - Mock the object at class level that can be used in multiple places
    //In this MockitoAnnotations.initMocks(this) needs to be called to initialize mocked object
    @Mock
    List<String> mockListObject;

    @BeforeEach
    public void setup() {
        //if we don't call below, we will get NullPointerException
        MockitoAnnotations.initMocks(this);
    }

    @SuppressWarnings("unchecked")
    @Test
    @Disabled
    public void testMockListObject() {
        when(mockListObject.get(0)).thenReturn("mockListObject");
        assertEquals("mockListObject", mockListObject.get(0));
    }

    /**
     * spy() - Used for partial mocking. If we want to mock only specific behaviors
     * and call the real methods for unstubbed behaviors,
     * then we can create a spy object using Mockito spy() method.
     */

    /**
     * it’s always a good idea to provide an instance to spy on.
     * Otherwise real methods might not get called and silently ignored.
     */
//    @Spy
//    List<String> spyOnList;

    @Spy
    List<String> spyOnList = new ArrayList<>();

    @Test
    @Disabled
    public void testSpyMethod() {
//        List<String> list = new ArrayList<>();
//        List<String> spyOnList = spy(list);

        when(spyOnList.size()).thenReturn(10);
        assertEquals(10, spyOnList.size());

        //calling real methods since below methods are not stubbed
        spyOnList.add("Pankaj");
        spyOnList.add("Meghna");
        assertEquals("Pankaj", spyOnList.get(0));
        assertEquals("Meghna", spyOnList.get(1));
    }

    /**
     * @Spy - to spy on an object
     * tries to call the no-args constructor to initialized the mocked object.
     * If your class doesn’t have it then you will get the following error.
     */

    @Spy
    Utils mockUtils;

    @Test
    @Disabled
    public void testSpyAnnotation() {
        when(mockUtils.process(1, 1)).thenReturn(5);
        //mocked method
        assertEquals(5, mockUtils.process(1, 1));
        //real method called since it's not stubbed
        assertEquals(20, mockUtils.process(19, 1));
    }

    //Mockito Argument Matchers – any()

    @Test
    public void testArgumentMatchers() {

        //any()
        Foo mockFoo = mock(Foo.class);
        when(mockFoo.bool(anyString(), anyInt(), any(Object.class))).thenReturn(true);

        assertTrue(mockFoo.bool("A", 1, "A"));
        assertTrue(mockFoo.bool("B", 10, new Object()));

        //eq()
        when(mockFoo.bool(eq("false"), anyInt(), any(Object.class))).thenReturn(false);
        assertFalse(mockFoo.bool("false", 10, new Object()));

    }







}

class Utils {

    public Utils() {
    }

    int name;
    public Utils(int name) {
        this.name = name;
    }

    public int process(int x, int y) {
        System.out.println("Input Params = " + x + "," + y);
        return x + y;
    }

}


class Foo {
    boolean bool(String str, int i, Object obj) {
        return false;
    }

    int in(boolean b, List<String> strs) {
        return 0;
    }

    int bar(byte[] bytes, String[] s, int i) {
        return 0;
    }
}


/**
 * Note: Mockito cannot instantiate inner classes, local classes, abstract classes, and interfaces
 *
 */
