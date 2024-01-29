package pt.ipp.isep.dei.project.controllerTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.project.DTO.DeviceDTO;
import pt.ipp.isep.dei.project.DTO.RoomDTO;
import pt.ipp.isep.dei.project.controller.ToggleDeviceCTRL;
import pt.ipp.isep.dei.project.domain.House;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ToggleDeviceCTRLTest {
    /**
     * Test01 - Returns true when device status false
     * 1. Adds room to the house
     * 2. Adds device to the previously added Room
     * 3. Starts controller
     * 4. Activates first controller method to get list of rooms
     * 5. Gets the first room in the list to simulate user choice
     * 6. Activates second controller method to get list of devices
     * 7. Gets the first device to simulate user choice
     * 8. Activates third controller method to toggle the selected device
     * 9. The result is True after toggling a device status from False to True
     * @throws InstantiationException May throw exception on House instantiation
     */
    @Test
    void getListOfRoomsCTRLTest_returnsTrueIfDeviceStatusFalse() throws InstantiationException {
        //Arrange
        String house = "house";
        House myHouse = new House(house);
        // 1.
        myHouse.getListOfRooms().addRoomToList("Bathroom",2,2,2,2);
        // 2.
        myHouse.getListOfRooms().getRoomList().get(0).getListOfDevices().addDeviceToList("Heater","XPOT","1");
        // 3.
        ToggleDeviceCTRL ctrl = new ToggleDeviceCTRL(myHouse);
        // 4.
        ArrayList<RoomDTO> listRoomDTO = ctrl.getListOfRooms();
        // 5.
        RoomDTO roomDTO = listRoomDTO.get(0);
        // 6.
        ArrayList<DeviceDTO> listDeviceDTO = ctrl.getListOfDevices(roomDTO);
        // 7.
        DeviceDTO deviceDTO = listDeviceDTO.get(0);
        //Act
        // 8.
        boolean result = ctrl.toggleDevice(roomDTO,deviceDTO);
        //Assert
        // 9.
        assertTrue(result);
    }

    /**
     * Test02 - Returns false when device status true
     * 1.Adds room to the house
     * 2.Adds device to the previously added Room
     * 3.Starts controller
     * 4.Activates first controller method to get list of rooms
     * 5.Gets the first room in the list to simulate user choice
     * 6.Activates second controller method to get list of devices
     * 7.Gets the first device to simulate user choice
     * 8.Toggles added device to status = true
     * 9.Activates third controller method to toggle the selected device
     * 10. The result is True after toggling a device status from False to True
     * @throws InstantiationException May throw exception on House instantiation
     */
    @Test
    void getListOfRoomsCTRLTest_returnsFalseIfDeviceStatusTrue() throws InstantiationException {
    //Arrange
        String house = "house";
        House myHouse = new House(house);
        // 1.
        myHouse.getListOfRooms().addRoomToList("Bathroom",2,2,2,2);
        // 2.
        myHouse.getListOfRooms().getRoomList().get(0).getListOfDevices().addDeviceToList("Heater","XPOT","1");
        // 3.
        ToggleDeviceCTRL ctrl = new ToggleDeviceCTRL(myHouse);
        // 4.
        ArrayList<RoomDTO> listRoomDTO = ctrl.getListOfRooms();
        // 5.
        RoomDTO roomDTO = listRoomDTO.get(0);
        // 6.
        ArrayList<DeviceDTO> listDeviceDTO = ctrl.getListOfDevices(roomDTO);
        // 7.
        DeviceDTO deviceDTO = listDeviceDTO.get(0);
        // 8.
        ctrl.toggleDevice(roomDTO,deviceDTO);
        //Act
        // 9.
        boolean result = ctrl.toggleDevice(roomDTO,deviceDTO);
        //Assert
        // 10.
        assertFalse(result);
    }

}
