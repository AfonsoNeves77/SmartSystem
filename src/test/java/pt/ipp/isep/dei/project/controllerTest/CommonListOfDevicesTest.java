package pt.ipp.isep.dei.project.controllerTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.project.controller.CommonListOfDevices;
import pt.ipp.isep.dei.project.domain.House;
import pt.ipp.isep.dei.project.domain.Room;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonListOfDevicesTest {

    /**
     * Tests the getListOfDevices method in the CommonDeviceListCTRL class when a device is added to a room.
     * 1. Adds the room to the House
     * 2. Adds device to room
     * 3. Starts the controller
     * Asserts if the name of the device is the same as the one from the ArrayList
     * @throws InstantiationException If an error occurs during the instantiation of objects.
     */
    @Test
    void getListOfDevices() throws InstantiationException {

        //Arrange
        String houseName = "myHouse";
        String roomName = "Room 1";
        int roomFloor = 2;
        double width = 1.9;
        double length = 2;
        double height = 4;
        House house = new House(houseName);
        //1.
        house.getListOfRooms().addRoomToList(roomName,roomFloor,width,length,height);
        Room room = house.getListOfRooms().getRoomList().get(0);
        String deviceName = "Device 1";
        String model = "XPTO";
        String location = "BedRoom";

        //Act
        //2.
        room.getListOfDevices().addDeviceToList(deviceName,model,location);
        String result =  room.getListOfDevices().getDeviceList().get(0).getDeviceName();
        //3.
        CommonListOfDevices commonListOfDevices = new CommonListOfDevices(house);
        String expected = commonListOfDevices.getListOfDevices(room).get(0).getDeviceName();

        //Assert
        //4.
        assertEquals(expected,result);

    }

}
