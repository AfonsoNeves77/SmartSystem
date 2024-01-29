package pt.ipp.isep.dei.project.domainTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.project.domain.Address;
import pt.ipp.isep.dei.project.domain.GPS;
import pt.ipp.isep.dei.project.domain.House;

import static org.junit.jupiter.api.Assertions.*;

class HouseTest {
    /**
     * Test 01 - Verifies constructor throws exception if invalid parameter
     */
    @Test
    void createHouse_InvalidHouseName() {
        //Arrange
        String name = " ";
        String expectedMessage = "Please insert a valid house name.";
        //Act
        Exception exception = assertThrows(InstantiationException.class, () -> {
            new House(name);
        });
        String result = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, result);
    }
    /**
     * Test 02 - Verifies constructor throws exception if invalid parameter
     */
    @Test
    void createHouse_NullHouseName() {
        //Arrange
        String name = null;
        String expectedMessage = "Please insert a valid house name.";
        //Act
        Exception exception = assertThrows(InstantiationException.class, () -> {
            new House(name);
        });
        String result = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, result);
    }

    /**
     * Test 03 - Confirms configure location methods returns 0 signaling a successful operation
     * @throws InstantiationException If invalid House parameters
     */
    @Test
    void configureLocation_successScenario() throws InstantiationException {
        //Arrange
        House myHouse = new House("test");
        String doorReference = "4";
        String buildingNumber = "1234";
        String streetName = "Rua da Alegria";
        String city = "Porto";
        String country = "Portugal";
        String zipCode = "4570-222";
        double latitude = 90;
        double longitude = 180;
        int expected = 0;
        //Act
        int result = myHouse.configureLocation(doorReference,buildingNumber,streetName,city,country,zipCode,latitude,longitude);
        //Assert
        assertEquals(expected, result);
    }
    /**
     * Test 04 - Confirms configure location methods returns 1 signaling an unssuccessful operation due to invalid parameter
     * @throws InstantiationException If invalid House parameters
     */
    @Test
    void configureLocation_invalidGPSparameters() throws InstantiationException {
        //Arrange
        House myHouse = new House("test");
        String doorReference = "4";
        String buildingNumber = "1234";
        String streetName = "Rua da Alegria";
        String city = "Porto";
        String country = "Portugal";
        String zipCode = "4570-222";
        double latitude = 91;
        double longitude = 180;
        int expected = 1;
        //Act
        int result = myHouse.configureLocation(doorReference,buildingNumber,streetName,city,country,zipCode,latitude,longitude);
        //Assert
        assertEquals(expected, result);
    }
    /**
     * Test 05 - Confirms configure location methods returns 1 signaling an unssuccessful operation due to invalid parameter
     * @throws InstantiationException If invalid House parameters
     */
    @Test
    void configureLocation_invalidAddress() throws InstantiationException {
        //Arrange
        House myHouse = new House("test");
        String doorReference = "4";
        String buildingNumber = " ";
        String streetName = "Rua da Alegria";
        String city = "Porto";
        String country = "Portugal";
        String zipCode = "4570-222";
        double latitude = 91;
        double longitude = 180;
        int expected = 1;
        //Act
        int result = myHouse.configureLocation(doorReference,buildingNumber,streetName,city,country,zipCode,latitude,longitude);
        //Assert
        assertEquals(expected, result);
    }


    @Test
    void configureLocation_getClonedAdress() throws InstantiationException {
        //Arrange
        House myHouse = new House("test");
        String doorReference = "4";
        String buildingNumber = "45";
        String streetName = "Rua da Alegria";
        String city = "Porto";
        String country = "Portugal";
        String zipCode = "4570-222";
        double latitude = 20;
        double longitude = 30;

        //Act
         myHouse.configureLocation(doorReference,buildingNumber,streetName,city,country,zipCode,latitude,longitude);
         Address myAdress = myHouse.getClonedAddress();
        //Assert
        assertNotNull(myAdress);
    }

    @Test
    void configureLocation_getClonedGPS() throws InstantiationException {
        //Arrange
        House myHouse = new House("test");
        String doorReference = "4";
        String buildingNumber = "45";
        String streetName = "Rua da Alegria";
        String city = "Porto";
        String country = "Portugal";
        String zipCode = "4570-222";
        double latitude = 20;
        double longitude = 30;

        //Act
        myHouse.configureLocation(doorReference,buildingNumber,streetName,city,country,zipCode,latitude,longitude);
        GPS myAdress = myHouse.getClonedGPS();
        //Assert
        assertNotNull(myAdress);
    }



}
