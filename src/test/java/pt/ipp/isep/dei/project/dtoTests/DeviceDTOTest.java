package pt.ipp.isep.dei.project.dtoTests;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.project.DTO.DeviceDTO;
import static org.junit.jupiter.api.Assertions.*;

class DeviceDTOTest {

    /**
     * Test01 case to verify that a DeviceDTO can be created successfully.
     */
    @Test
    void createDeviceDTO(){
        //Arrange
        String deviceName = "Device 1";
        String deviceModel = "Refrigerator";
        String location = "Kitchen";
        boolean status = true;
        //Act
        DeviceDTO newDeviceDTO = new DeviceDTO(deviceName, deviceModel, location, status);
        //Assert
        assertNotNull(newDeviceDTO);
    }

    /**
     * Test02 case to verify that the getDeviceModel method returns the correct device model.
     * Compares the deviceModel of the device with the one extracted.
     */
    @Test
    void createDeviceDTO_getDeviceModel(){
        //Arrange
        String deviceName = "Device 1";
        String deviceModel = "Dishwasher";
        String location = "Kitchen";
        boolean status = true;
        DeviceDTO newDeviceDTO = new DeviceDTO(deviceName, deviceModel, location, status);
        //Act
        String result = newDeviceDTO.getModel();
        //Assert
        assertEquals(deviceModel,result);
    }

    /**
     * Test03 case to verify that the getLocation method returns the correct location.
     * Compares the location of the device with the one extracted.
     */
    @Test
    void createDeviceDTO_getLocation(){
        //Arrange
        String deviceName = "Device 1";
        String deviceModel = "Refrigerator";
        String location = "Kitchen";
        boolean status = true;
        DeviceDTO newDeviceDTO = new DeviceDTO(deviceName, deviceModel, location, status);
        //Act
        String result = newDeviceDTO.getLocation();
        //Assert
        assertEquals(location,result);
    }

    /**
     * Test04 Asserts method returns status (True)
     */
    @Test
    void createDeviceDTO_getStatus(){
        //Arrange
        String deviceName = "Device 1";
        String deviceModel = "Refrigerator";
        String location = "Kitchen";
        boolean status = true;
        DeviceDTO newDeviceDTO = new DeviceDTO(deviceName, deviceModel, location, status);
        //Act
        boolean result = newDeviceDTO.getStatus();
        //Assert
        assertTrue(result);
    }
    /**
     * Test04 Asserts method returns status (False)
     */
    @Test
    void createDeviceDTO_getStatus1(){
        //Arrange
        String deviceName = "Device 1";
        String deviceModel = "Refrigerator";
        String location = "Kitchen";
        boolean status = false;
        DeviceDTO newDeviceDTO = new DeviceDTO(deviceName, deviceModel, location, status);
        //Act
        boolean result = newDeviceDTO.getStatus();
        //Assert
        assertFalse(result);
    }
}