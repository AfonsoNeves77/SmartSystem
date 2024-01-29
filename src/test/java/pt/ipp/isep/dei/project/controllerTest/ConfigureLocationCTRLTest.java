package pt.ipp.isep.dei.project.controllerTest;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.project.controller.ConfigureLocationCTRL;
import pt.ipp.isep.dei.project.DTO.LocationDTO;
import pt.ipp.isep.dei.project.domain.House;

import static org.junit.jupiter.api.Assertions.*;

class ConfigureLocationCTRLTest {
    /**
     * Test 01. Verifies controller is able to call configure location on domain and return 0 signalling a successful edit.
     * 1. Instanciates controller with House parameter.
     * 2. Lists parameters for editing and creates locationDTO with said parameters
     * 3. Calls the controller method configure location utilizing the previously created locationDTO resulting in a code 0
     * @throws InstantiationException If house parameters invalid
     */
    @Test
    void testingCTRL_SuccessfulOperation() throws InstantiationException {
        // Arrange
        // 1.
        House myHouse = new House("test");
        ConfigureLocationCTRL ctrl = new ConfigureLocationCTRL(myHouse);
        // 2.
        String doorReference = "4A";
        String buildingNumber = "1234";
        String streetName = "Rua da Alegria";
        String city = "Porto";
        String country = "Portugal";
        String zipCode = "4570-222";
        double latitude = 42;
        double longitude = 42;
        LocationDTO dtoLoc= new LocationDTO(doorReference,buildingNumber,streetName,city,country,zipCode,latitude,longitude);

        int expected = 0;
        //Act
        // 3.
        int result = ctrl.configureLocation(dtoLoc);
        //Assert
        assertEquals(expected,result);
    }
    /**
     * Test 02. Repeats the test above, but uses a specific double value (0.0d)
     * 1. Instanciates controller with House parameter
     * 2. Lists parameters for editing and creates locationDTO with said parameters
     * 3. Calls the controller method configure location utilizing the previously created locationDTO resulting in a code 0
     * @throws InstantiationException If house parameters invalid
     */
    @Test
    void testingCTRL_SuccessfulOperationWithLatitudeZero() throws InstantiationException {
        // Arrange
        // 1.
        House myHouse = new House("test");
        ConfigureLocationCTRL ctrl = new ConfigureLocationCTRL(myHouse);
        // 2.
        String doorReference = "4A";
        String buildingNumber = "1234";
        String streetName = "Rua da Alegria";
        String city = "Porto";
        String country = "Portugal";
        String zipCode = "4570-222";
        double latitude = 0.0d;
        double longitude = 42;
        LocationDTO dtoLoc= new LocationDTO(doorReference,buildingNumber,streetName,city,country,zipCode,latitude,longitude);

        int expected = 0;
        //Act
        //3.
        int result = ctrl.configureLocation(dtoLoc);
        //Assert
        assertEquals(expected,result);
    }
    /**
     * Test 03. Repeats the test above, but uses a specific double value (0.0d)
     * 1. Instanciates controller with House parameter
     * 2. Lists parameters for editing and creates locationDTO with said parameters
     * 3. Calls the controller method configure location utilizing the previously created locationDTO resulting in a code 0
     * @throws InstantiationException If house parameters invalid
     */
    @Test
    void testingCTRL_SuccessfulOperationWithLongitudeZero() throws InstantiationException {
        // Arrange
        // 1.
        House myHouse = new House("test");
        ConfigureLocationCTRL ctrl = new ConfigureLocationCTRL(myHouse);
        // 2.
        String doorReference = "4A";
        String buildingNumber = "1234";
        String streetName = "Rua da Alegria";
        String city = "Porto";
        String country = "Portugal";
        String zipCode = "4570-222";
        double latitude = 42;
        double longitude = 0.0d;
        LocationDTO dtoLoc= new LocationDTO(doorReference,buildingNumber,streetName,city,country,zipCode,latitude,longitude);

        int expected = 0;
        //Act
        // 3.
        int result = ctrl.configureLocation(dtoLoc);
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test 04. Verifies controller is able to call configure location on domain and return 1 signalling invalid location parameters.
     * 1. Instanciates controller with House parameter
     * 2. Lists parameters for editing and creates locationDTO with said parameters
     * 3. Calls the controller method configure location utilizing the previously created locationDTO resulting in a code 1
     * @throws InstantiationException If invalid House parameters
     */
    @Test
    void testingCTRL_returnsOneDueToInvalidGPS() throws InstantiationException {
        // Arrange
        House myHouse = new House("test");
        ConfigureLocationCTRL ctrl = new ConfigureLocationCTRL(myHouse);

        String doorReference = "4";
        String buildingNumber = "1234";
        String streetName = "Rua da Alegria";
        String city = "Porto";
        String country = "Portugal";
        String zipCode = "4570-222";
        double latitude = 91;
        double longitude = 42;
        LocationDTO dtoLoc= new LocationDTO(doorReference,buildingNumber,streetName,city,country,zipCode,latitude,longitude);

        int expected = 1;
        //Act
        int result = ctrl.configureLocation(dtoLoc);
        //Assert
        assertEquals(expected,result);
    }
    /**
     * Test 05. Verifies controller is able to call configure location on domain and return 1 signalling invalid location parameters.
     * 1. Instanciates controller with House parameter
     * 2. Lists parameters for editing and creates locationDTO with said parameters
     * 3. Calls the controller method configure location utilizing the previously created locationDTO resulting in a code 1
     * @throws InstantiationException If invalid House parameters
     */
    @Test
    void testingCTRL_returnsOneDueToInvalidAddress() throws InstantiationException {
        // Arrange
        House myHouse = new House("test");
        ConfigureLocationCTRL ctrl = new ConfigureLocationCTRL(myHouse);

        String doorReference = " ";
        String buildingNumber = "1234";
        String streetName = "Rua da Alegria";
        String city = "Porto";
        String country = "Portugal";
        String zipCode = "4570-222";
        double latitude = 90;
        double longitude = 42;
        LocationDTO dtoLoc= new LocationDTO(doorReference,buildingNumber,streetName,city,country,zipCode,latitude,longitude);

        int expected = 1;
        //Act
        int result = ctrl.configureLocation(dtoLoc);
        //Assert
        assertEquals(expected,result);
    }
}
