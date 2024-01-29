package pt.ipp.isep.dei.project.domainTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.project.domain.Device;
import pt.ipp.isep.dei.project.domain.ListOfDevices;

import static org.junit.jupiter.api.Assertions.*;

public class ListOfDevicesTest {

    /**
     * Test 01 - Tests if the constructor successfully creates a ListOfDevices object.
     */
    @Test
    void constructorCreatesNonNullObject() {
        //Arrange and Act
        ListOfDevices list = new ListOfDevices();
        //Assert
        assertNotNull(list);
    }

    /**
     * Test 02 - Tests if addDeviceToList method returns 0 when adding a device successfully.
     */
    @Test
    void addDeviceToList_ReturnZeroWhenSuccessful() throws InstantiationException {
        //Arrange
        String name = "Device 1";
        String deviceModel = "Heater";
        String location = "WC";
        ListOfDevices list = new ListOfDevices();
        int expected = 0;
        //Act
        int result = list.addDeviceToList(name, deviceModel, location);
        //Assert
        assertEquals(expected, result);
    }

    /**
     * Test 03 - Tests if addDeviceToList method returns 2 when adding a device that already exists.
    */
    @Test
    void addDeviceToList_ReturnTwoWhenDuplicated() throws InstantiationException {
        //Arrange
        String name = "Device 1";
        String deviceModel = "Heater";
        String location = "Room";
        ListOfDevices list = new ListOfDevices();
        list.addDeviceToList(name, deviceModel, location);
        int expected = 2;
        //Act
        int result = list.addDeviceToList(name, deviceModel, location);
        //Assert
        assertEquals(expected, result);
    }

    /**
     * Test 04 - Tests if addDeviceToList method returns 1 when adding a device with invalid parameters.
    */
    @Test
    void addDeviceToList_ReturnsOneIfParametersInvalid() throws InstantiationException {
        //Arrange
        String name = "";
        String deviceModel = "Heater";
        String location = "Room";
        ListOfDevices list = new ListOfDevices();
        list.addDeviceToList(name, deviceModel, location);
        int expected = 1;
        //Act
        int result = list.addDeviceToList(name, deviceModel, location);
        //Assert
        assertEquals(expected, result);
    }

    /**
     * Tests if getDeviceList method returns the size of the device list.
    */
    @Test
    void getDeviceList(){
        //Arrange
        String name = "Gas Heater";
        String deviceModel = "Heater";
        String location = "Room";
        ListOfDevices list = new ListOfDevices();
        list.addDeviceToList(name, deviceModel, location);
        int expected = 1;
        //Act
        int result = list.getDeviceList().size();
        //Assert
        assertEquals(expected, result);
    }
}
