package pt.ipp.isep.dei.project.domainTest;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.project.domain.Address;
import pt.ipp.isep.dei.project.domain.GPS;

import static org.junit.jupiter.api.Assertions.*;

class GPSTest {
    /**
     * Test 01. Verifies constructor throws exception if parameters invalid
     */
    @Test
    void constructor_throwsExceptionIfLatitudeInvalid() {
        //Arrange
        double latitude = 91;
        double longitude = 180;
        String expectedMessage = "Invalid Parameters";
        //Act
        Exception exception = assertThrows(InstantiationException.class, () ->
            new GPS(latitude,longitude));
        String result = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, result);
    }
    /**
     * Test 02. Verifies constructor throws exception if parameters invalid
     */
    @Test
    void constructor_throwsExceptionIfLatitudeInvalidBorderCase() {
        //Arrange
        double latitude = -91;
        double longitude = 180;
        String expectedMessage = "Invalid Parameters";
        //Act
        Exception exception = assertThrows(InstantiationException.class, () ->
            new GPS(latitude,longitude));
        String result = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, result);
    }
    /**
     * Test 03. Verifies constructor throws exception if parameters invalid
     */
    @Test
    void constructor_throwsExceptionIfLongitudeInvalid() {
        //Arrange
        double latitude = 90;
        double longitude = 181;
        String expectedMessage = "Invalid Parameters";
        //Act
        Exception exception = assertThrows(InstantiationException.class, () ->
            new GPS(latitude,longitude));
        String result = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, result);
    }
    /**
     * Test 04. Verifies constructor throws exception if parameters invalid
     */
    @Test
    void constructor_throwsExceptionIfLongitudeInvalidBorderCase() {
        //Arrange
        double latitude = 90;
        double longitude = -181;
        String expectedMessage = "Invalid Parameters";
        //Act
        Exception exception = assertThrows(InstantiationException.class, () ->
            new GPS(latitude,longitude));
        String result = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, result);
    }
    /**
     * Test 05 - Edits gps succesfully
     * 1. Creates gps object, whose attributes will change after method call
     * 2. Creates a new gps object to serve as base for editing
     * 3. Edits gps, and returns code 0 as successful
     */
    @Test
    void editGPS_success() throws InstantiationException {
        //Arrange
        // 1.
        GPS startingGPS = new GPS(0,0);
        // 2.
        double latitude = 42;
        double longitude = 42;
        GPS newGPS = new GPS(latitude,longitude);
        int expected = 0;
        //Act
        // 3.
        int result = startingGPS.editGPS(newGPS);
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test 06 - Successfully gets latitude
     */
    @Test
    void getLatitude_Success() throws InstantiationException {
        //Arrange
        GPS gps = new GPS(20,30);
        double expected = 20;
        //Act
        double result = gps.getLatitude();
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test 07 - Successfully gets longitude
     */
    @Test
    void getLongitude_Success() throws InstantiationException {
        //Arrange
        GPS gps = new GPS(20,30);
        double expected = 30;
        //Act
        double result = gps.getLongitude();
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test 08 - Successfully gets latitude, bordercase (90)
     */
    @Test
    void getLatitude_BorderCase() throws InstantiationException {
        //Arrange
        GPS gps = new GPS(90,30);
        double expected = 90;
        //Act
        double result = gps.getLatitude();
        //Assert
        assertEquals(expected,result);
    }
    /**
     * Test 08 - Successfully gets longitude, bordercase (180)
     */
    @Test
    void getLongitude_BorderCase2() throws InstantiationException {
        //Arrange
        GPS gps = new GPS(90,180);
        double expected = 180;
        //Act
        double result = gps.getLongitude();
        //Assert
        assertEquals(expected,result);
    }
    /**
     * Test 09 - Successfully gets longitude, bordercase (-90)
     */
    @Test
    void getLatitude_BorderCase3() throws InstantiationException {
        //Arrange
        GPS gps = new GPS(-90,30);
        double expected = -90;
        //Act
        double result = gps.getLatitude();
        //Assert
        assertEquals(expected,result);
    }
    /**
     * Test 10 - Successfully gets longitude, bordercase (-180)
     */
    @Test
    void getLongitude_BorderCase4() throws InstantiationException {
        //Arrange
        GPS gps = new GPS(90,-180);
        double expected = -180;
        //Act
        double result = gps.getLongitude();
        //Assert
        assertEquals(expected,result);
    }
}
