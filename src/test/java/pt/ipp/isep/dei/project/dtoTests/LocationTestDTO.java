package pt.ipp.isep.dei.project.dtoTests;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.project.DTO.LocationDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocationTestDTO {
    /**
     * Test 01 - Creates object successfully. Tests it by checking the DTO's city against the parameter city
     */
    @Test
    void constructorCorrectlyAttributesParamater(){
        //Arrange
        String doorReference = "4A";
        String buildingNumber = "1234";
        String streetName = "Rua da Alegria";
        String city = "Porto";
        String country = "Portugal";
        String zipCode = "4570-222";
        double latitude = 42;
        double longitude = 42;
        LocationDTO dto = new LocationDTO(doorReference, buildingNumber, streetName, city, country, zipCode, latitude, longitude);
        String expected = dto.getCity();
        //Act
        String result = "Porto";
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test 02 - Ensures constructor does not exclude empty values
     */
    @Test
    void constructorDoesNotExcludeEmptyValues(){
        //Arrange
        String doorReference = "    ";
        String buildingNumber = "1234";
        String streetName = "Rua da Alegria";
        String city = "Porto";
        String country = "Portugal";
        String zipCode = "4570-222";
        double latitude = 42;
        double longitude = 42;
        LocationDTO dto = new LocationDTO(doorReference,buildingNumber,streetName,city,country,zipCode,latitude,longitude);
        String expected = "    ";
        //Act
        String result = dto.getDoorReference();
        //Assert
        assertEquals(expected,result);
    }
    /**
     * Test 03 - Ensures constructor does not exclude null values
     */
    @Test
    void constructorDoesNotExcludeNullValues(){
        //Arrange
        String doorReference = null;
        String buildingNumber = "1234";
        String streetName = "Rua da Alegria";
        String city = "Porto";
        String country = "Portugal";
        String zipCode = "4570-222";
        double latitude = 42;
        double longitude = 42;
        LocationDTO dto = new LocationDTO(doorReference,buildingNumber,streetName,city,country,zipCode,latitude,longitude);
        String expected = null;
        //Act
        String result = dto.getDoorReference();
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test 04 - Ensures specific value is covered (0.0d)
     */
    @Test
    void constructor_testSpecificValue(){
        //Arrange
        String doorReference = "4A";
        String buildingNumber = "1234";
        String streetName = "Rua da Alegria";
        String city = "Porto";
        String country = "Portugal";
        String zipCode = "4570-222";
        double latitude = 42;
        double longitude = 0.0d;
        LocationDTO dto = new LocationDTO(doorReference,buildingNumber,streetName,city,country,zipCode,latitude,longitude);
        double expected = 0.0d;
        //Act
        double result = dto.getLongitude();
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test 05 - Ensures specific value is covered (5.4d)
     */
    @Test
    void constructor_testToDifferentSpecificValue(){
        //Arrange
        String doorReference = "4A";
        String buildingNumber = "1234";
        String streetName = "Rua da Alegria";
        String city = "Porto";
        String country = "Portugal";
        String zipCode = "4570-222";
        double latitude = 42;
        double longitude = 5.4d;
        LocationDTO dto = new LocationDTO(doorReference,buildingNumber,streetName,city,country,zipCode,latitude,longitude);
        double expected = 5.4d;
        //Act
        double result = dto.getLongitude();
        //Assert
        assertEquals(expected,result);
    }
}
