/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import businessobjects.SceneFilmingDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author matthew
 */
public class DeleteFilmingDateEventTest {
    
    public DeleteFilmingDateEventTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSceneFilmingDate method, of class DeleteFilmingDateEvent.
     */
    @Test
    public void testGetSceneFilmingDate() {
        System.out.println("getSceneFilmingDate");
        DeleteFilmingDateEvent instance = null;
        SceneFilmingDate expResult = null;
        SceneFilmingDate result = instance.getSceneFilmingDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
