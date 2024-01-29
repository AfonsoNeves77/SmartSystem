package pt.ipp.isep.dei.project.domainTest;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.project.domain.Address;
import pt.ipp.isep.dei.project.domain.House;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {
    /**
     * Test 01 - Tests constructor throws exception if parameters invalid
     * 1. Lists all the parameters required to instantiate a House
     * 2. Attemps to create House with blank doorReference, resulting in an exception
     */
    @Test
    void constructor_throwsExceptionIfDoorRefEmpty() {
        //Arrange
        // 1.
        String doorReference = " ";
        String buildingNumber = "1234";
        String streetName = "Rua da Alegria";
        String city = "Porto";
        String country = "Portugal";
        String zipCode = "4570-222";
        String expectedMessage = "Invalid Parameters";
        //Act

        Exception exception = assertThrows(InstantiationException.class, () -> {
            new Address(doorReference,buildingNumber,streetName,city,country,zipCode);
        });
        String result = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, result);
    }
    /**
     * Test 02 - Tests constructor throws exception if parameters invalid
     * 1. Lists all the parameters required to instantiate a House
     * 2. Attemps to create House with null doorReference, resulting in an exception
     */
    @Test
    void constructor_throwsExceptionIfDoorRefNull() {
        //Arrange
        // 1.
        String buildingNumber = "1234";
        String streetName = "Rua da Alegria";
        String city = "Porto";
        String country = "Portugal";
        String zipCode = "4570-222";
        String expectedMessage = "Invalid Parameters";
        //Act
        // 2.
        Exception exception = assertThrows(InstantiationException.class, () -> {
            new Address(null,buildingNumber,streetName,city,country,zipCode);
        });
        String result = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, result);
    }
    /**
     * Test 03 - Tests constructor throws exception if parameters invalid
     * 1. Lists all the parameters required to instantiate a House
     * 2. Attemps to create House with empty buildingNumber, resulting in an exception
     */
    @Test
    void constructor_throwsExceptionIfBuildNumEmpty() {
        //Arrange
        // 1.
        String doorReference = "1234";
        String buildingNumber = " ";
        String streetName = "Rua da Alegria";
        String city = "Porto";
        String country = "Portugal";
        String zipCode = "4570-222";
        String expectedMessage = "Invalid Parameters";
        //Act
        // 2.
        Exception exception = assertThrows(InstantiationException.class, () -> {
            new Address(doorReference,buildingNumber,streetName,city,country,zipCode);
        });
        String result = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, result);
    }
    /**
     * Test 04 - Tests constructor throws exception if parameters invalid
     * 1. Lists all the parameters required to instantiate a House
     * 2. Attemps to create House with null buildingNumber, resulting in an exception
     */
    @Test
    void constructor_throwsExceptionIfBuildNumNull() {
        //Arrange
        // 1.
        String doorReference = "1234";
        String buildingNumber = null;
        String streetName = "Rua da Alegria";
        String city = "Porto";
        String country = "Portugal";
        String zipCode = "4570-222";
        String expectedMessage = "Invalid Parameters";
        //Act
        // 2.
        Exception exception = assertThrows(InstantiationException.class, () -> {
            new Address(doorReference,buildingNumber,streetName,city,country,zipCode);
        });
        String result = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, result);
    }
    /**
     * Test 05 - Tests constructor throws exception if parameters invalid
     * 1. Lists all the parameters required to instantiate a House
     * 2. Attemps to create House with empty streetName, resulting in an exception
     */
    @Test
    void constructor_throwsExceptionIfStreetNameEmpty() {
        //Arrange
        // 1.
        String doorReference = "1234";
        String buildingNumber = "4A";
        String streetName = " ";
        String city = "Porto";
        String country = "Portugal";
        String zipCode = "4570-222";
        String expectedMessage = "Invalid Parameters";
        //Act
        // 2.
        Exception exception = assertThrows(InstantiationException.class, () -> {
            new Address(doorReference,buildingNumber,streetName,city,country,zipCode);
        });
        String result = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, result);
    }
    /**
     * Test 06 - Tests constructor throws exception if parameters invalid
     * 1. Lists all the parameters required to instantiate a House
     * 2. Attemps to create House with null streetName, resulting in an exception
     */
    @Test
    void constructor_throwsExceptionIfStreetNameNull() {
        //Arrange
        // 1.
        String doorReference = "1234";
        String buildingNumber = "4A";
        String streetName = null;
        String city = "Porto";
        String country = "Portugal";
        String zipCode = "4570-222";
        String expectedMessage = "Invalid Parameters";
        //Act
        // 2.
        Exception exception = assertThrows(InstantiationException.class, () -> {
            new Address(doorReference,buildingNumber,streetName,city,country,zipCode);
        });
        String result = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, result);
    }
    /**
     * Test 07 - Tests constructor throws exception if parameters invalid
     * 1. Lists all the parameters required to instantiate a House
     * 2. Attemps to create House with empty city, resulting in an exception
     */
    @Test
    void constructor_throwsExceptionIfCityEmpty() {
        //Arrange
        // 1.
        String doorReference = "1234";
        String buildingNumber = "4A";
        String streetName = "Rua da Alegria";
        String city = " ";
        String country = "Portugal";
        String zipCode = "4570-222";
        String expectedMessage = "Invalid Parameters";
        //Act
        // 2.
        Exception exception = assertThrows(InstantiationException.class, () -> {
            new Address(doorReference,buildingNumber,streetName,city,country,zipCode);
        });
        String result = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, result);
    }
    /**
     * Test 08 - Tests constructor throws exception if parameters invalid
     * 1. Lists all the parameters required to instantiate a House
     * 2. Attemps to create House with null city, resulting in an exception
     */
    @Test
    void constructor_throwsExceptionIfCityNull() {
        //Arrange
        // 1.
        String doorReference = "1234";
        String buildingNumber = "4A";
        String streetName = "Rua da Alegria";
        String city = null;
        String country = "Portugal";
        String zipCode = "4570-222";
        String expectedMessage = "Invalid Parameters";
        //Act
        // 2.
        Exception exception = assertThrows(InstantiationException.class, () -> {
            new Address(doorReference,buildingNumber,streetName,city,country,zipCode);
        });
        String result = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, result);
    }
    /**
     * Test 09 - Tests constructor throws exception if parameters invalid
     * 1. Lists all the parameters required to instantiate a House
     * 2. Attemps to create House with empty country, resulting in an exception
     */
    @Test
    void constructor_throwsExceptionIfCountryEmpty() {
        //Arrange
        // 1.
        String doorReference = "1234";
        String buildingNumber = "4A";
        String streetName = "Rua da Alegria";
        String city = "Porto";
        String country = " ";
        String zipCode = "4570-222";
        String expectedMessage = "Invalid Parameters";
        //Act
        // 2.
        Exception exception = assertThrows(InstantiationException.class, () -> {
            new Address(doorReference,buildingNumber,streetName,city,country,zipCode);
        });
        String result = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, result);
    }
    /**
     * Test 09 - Tests constructor throws exception if parameters invalid
     * 1. Lists all the parameters required to instantiate a House
     * 2. Attemps to create House with null country, resulting in an exception
     */
    @Test
    void constructor_throwsExceptionCountryEmpty() {
        //Arrange
        // 1.
        String doorReference = "1234";
        String buildingNumber = "4A";
        String streetName = "Rua da Alegria";
        String city = "Porto";
        String country = null;
        String zipCode = "4570-222";
        String expectedMessage = "Invalid Parameters";
        //Act
        // 2.
        Exception exception = assertThrows(InstantiationException.class, () -> {
            new Address(doorReference,buildingNumber,streetName,city,country,zipCode);
        });
        String result = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, result);
    }
    /**
     * Test 10 - Tests constructor throws exception if parameters invalid
     * 1. Lists all the parameters required to instantiate a House
     * 2. Attemps to create House with empty zipcode, resulting in an exception
     */
    @Test
    void constructor_throwsExceptionIfZipCodeEmpty() {
        //Arrange
        // 1.
        String doorReference = "1234";
        String buildingNumber = "4A";
        String streetName = "Rua da Alegria";
        String city = "Porto";
        String country = "Portugal";
        String zipCode = " ";
        String expectedMessage = "Invalid Parameters";
        //Act
        // 2.
        Exception exception = assertThrows(InstantiationException.class, () -> {
            new Address(doorReference,buildingNumber,streetName,city,country,zipCode);
        });
        String result = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, result);
    }
    /**
     * Test 11 - Tests constructor throws exception if parameters invalid
     * 1. Lists all the parameters required to instantiate a House
     * 2. Attemps to create House with null zipcode, resulting in an exception
     */
    @Test
    void constructor_throwsExceptionZipCodeEmpty() {
        //Arrange
        // 1.
        String doorReference = "1234";
        String buildingNumber = "4A";
        String streetName = "Rua da Alegria";
        String city = "Porto";
        String country = "Portugal";
        String zipCode = null;
        String expectedMessage = "Invalid Parameters";
        //Act
        // 2.
        Exception exception = assertThrows(InstantiationException.class, () -> {
            new Address(doorReference,buildingNumber,streetName,city,country,zipCode);
        });
        String result = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, result);
    }
    /**
     * Test 12 - Edits address succesfully
     * 1. Creates address object, whose attributes will change after method call
     * 2. Creates a new address object to serve as base for editing
     * 3. Edits address, and returns code 0 as successful
     */
    @Test
    void editAddress_success() throws InstantiationException {
        //Arrange
        // 1.
        Address startingAddress = new Address("Test","Test","Test","Test","Test","Test");
        // 2.
        String doorReference = "4A";
        String buildingNumber = "1234";
        String streetName = "Rua da Alegria";
        String city = "Porto";
        String country = "Portugal";
        String zipCode = "4570-222";
        Address newAddress = new Address(doorReference,buildingNumber,streetName,city,country,zipCode);
        int expected = 0;
        //Act
        // 3.
        int result = startingAddress.editAddress(newAddress);
        //Assert
        assertEquals(expected,result);
    }
    /**
     * Test 13 - Simple getter test
     */
    @Test
    void testingGetDoorReference() throws InstantiationException {
        //Arrange
        Address address = new Address("Test","Test","Test","Test","Test","Test");
        String expected = "Test";
        //Act
        String result = address.getDoorReference();
        //Assert
        assertEquals(expected,result);
    }
    /**
     * Test 14 - Simple getter test
     */
    @Test
    void testingGetBuildingNumber() throws InstantiationException {
        //Arrange
        Address address = new Address("Test","Test","Test","Test","Test","Test");
        String expected = "Test";
        //Act
        String result = address.getBuildingNumber();
        //Assert
        assertEquals(expected,result);
    }
    /**
     * Test 15 - Simple getter test
     */
    @Test
    void testingGetStreetname() throws InstantiationException {
        //Arrange
        Address address = new Address("Test","Test","Test","Test","Test","Test");
        String expected = "Test";
        //Act
        String result = address.getStreetName();
        //Assert
        assertEquals(expected,result);
    }
    /**
     * Test 16 - Simple getter test
     */
    @Test
    void testingGetCity() throws InstantiationException {
        //Arrange
        Address address = new Address("Test","Test","Test","Test","Test","Test");
        String expected = "Test";
        //Act
        String result = address.getCity();
        //Assert
        assertEquals(expected,result);
    }
    /**
     * Test 17 - Simple getter test
     */
    @Test
    void testingGetCountry() throws InstantiationException {
        //Arrange
        Address address = new Address("Test","Test","Test","Test","Test","Test");
        String expected = "Test";
        //Act
        String result = address.getCountry();
        //Assert
        assertEquals(expected,result);
    }
    /**
     * Test 18 - Simple getter test
     */
    @Test
    void testingGetZipcode() throws InstantiationException {
        //Arrange
        Address address = new Address("Test","Test","Test","Test","Test","Test");
        String expected = "Test";
        //Act
        String result = address.getZipCode();
        //Assert
        assertEquals(expected,result);
    }
}
