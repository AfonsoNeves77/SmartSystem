package pt.ipp.isep.dei.project.controllerTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.project.DTO.DeviceDTO;

import pt.ipp.isep.dei.project.DTO.RoomDTO;
import pt.ipp.isep.dei.project.controller.GetListOfDevicesFromRoomCTRL;
import pt.ipp.isep.dei.project.domain.House;
import pt.ipp.isep.dei.project.domain.Room;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class GetListOfDevicesFromRoomCTRLTest {

    /**
     * Tests the listOfDevicesInARoom method in the GetListOfDevicesFromRoomCTRL class when a room contains a device.
     * 1. Adds the room to the House
     * 2. Adds device to room
     * 3. Starts the controller
     * 4. Asserts if the name of the device is the same as the one from the ArrayList
     * @throws InstantiationException If an error occurs during the instantiation of objects.
     */
    @Test
    void GetListOfDevicesFromRoomCTRL() throws InstantiationException {

        //Arrange
        String houseName = "my House";
        House myHouse = new House(houseName);

        String name = "Bathroom";
        int floor = 2;
        double roomWidth = 3.5;
        double roomLength = 3;
        double roomHeight = 2;
        //1.
        myHouse.getListOfRooms().addRoomToList(name, floor, roomWidth, roomLength, roomHeight);

        String deviceName = "Device 1";
        String deviceModel = "Dishwasher";
        String location = "Kitchen";
        Room room = myHouse.getListOfRooms().getRoomList().get(0);
        //2.
        room.getListOfDevices().addDeviceToList(deviceName, deviceModel, location);

        //Act
        //3.
        GetListOfDevicesFromRoomCTRL controller = new GetListOfDevicesFromRoomCTRL(myHouse);
        RoomDTO DTO = new RoomDTO(name, floor, roomWidth, roomLength, roomHeight);
        ArrayList<DeviceDTO> devicesInRoom = controller.listOfDevicesInARoom(DTO);
        String result = devicesInRoom.get(0).getName();

        //Assert
        //4.
        assertEquals(deviceName, result);

    }

    /**
     * Tests the listOfDevicesInARoom method in the GetListOfDevicesFromRoomCTRL class when a room contains a device.
     * 1. Starts the controller
     * 2. Asserts if the result is null given that no rooms were added to the house
     * @throws InstantiationException If an error occurs during the instantiation of objects.
     */
    @Test
    void GetListOfDevicesFromRoomCTRL_RoomWithNoDevices() throws InstantiationException {

        //Arrange
        String houseName = "my House";
        House myHouse = new House(houseName);

        String name = "Bathroom";
        int floor = 2;
        double roomWidth = 3.5;
        double roomLength = 3;
        double roomHeight = 2;

        //Act
        //1.
        GetListOfDevicesFromRoomCTRL controller = new GetListOfDevicesFromRoomCTRL(myHouse);
        RoomDTO DTO = new RoomDTO(name, floor, roomWidth, roomLength, roomHeight);
        ArrayList<DeviceDTO> devicesInRoom = controller.listOfDevicesInARoom(DTO);

        //Assert
        //2.
        assertNull(devicesInRoom);
    }

    /**
     * Tests the listOfDevicesInARoom method in the GetListOfDevicesFromRoomCTRL class when a room contains a device.
     * 1. Adds the room to the House
     * 2. Adds device to room
     * 3. Adds another device to room
     * 4. Starts the controller
     * 5. Asserts if the name of the device is the same as the one from the ArrayList
     * @throws InstantiationException If an error occurs during the instantiation of objects.
     */
    @Test
    void GetListOfDevicesFromRoomCTRL_RoomWithMultipleDevices() throws InstantiationException {

        //Arrange
        String houseName = "my House";
        House myHouse = new House(houseName);

        String name = "Bathroom";
        int floor = 2;
        double roomWidth = 3.5;
        double roomLength = 3;
        double roomHeight = 2;
        //1.
        myHouse.getListOfRooms().addRoomToList(name, floor, roomWidth, roomLength, roomHeight);

        String deviceName = "Device 1";
        String deviceModel = "Dishwasher";
        String location = "Kitchen";
        Room room = myHouse.getListOfRooms().getRoomList().get(0);
        //2.
        room.getListOfDevices().addDeviceToList(deviceName, deviceModel, location);

        String otherDeviceName = "Device 2";
        String otherDeviceModel = "Refrigerator";
        String otherLocation = "Kitchen";
        //3.
        room.getListOfDevices().addDeviceToList(otherDeviceName, otherDeviceModel, otherLocation);

        //Act
        GetListOfDevicesFromRoomCTRL controller = new GetListOfDevicesFromRoomCTRL(myHouse);
        RoomDTO DTO = new RoomDTO(name, floor, roomWidth, roomLength, roomHeight);
        ArrayList<DeviceDTO> devicesInRoom = controller.listOfDevicesInARoom(DTO);
        String result = devicesInRoom.get(1).getName();

        //Assert
        //4.
        assertEquals(otherDeviceName, result);

    }

    /**
     * Tests the listOfDevicesInARoom method in the GetListOfDevicesFromRoomCTRL class when a room contains a device.
     * 1. Adds the room to the House
     * 2. Starts the controller
     * 3. Asserts if the name of the room is the same as the one from the ArrayList
     * @throws InstantiationException If an error occurs during the instantiation of objects.
     */
    @Test
    void getListOfRooms() throws InstantiationException {

        //Arrange
        String houseName = "my House";
        House myHouse = new House(houseName);

        String name = "Bathroom";
        int floor = 2;
        double roomWidth = 3.5;
        double roomLength = 3;
        double roomHeight = 2;
        GetListOfDevicesFromRoomCTRL controller = new GetListOfDevicesFromRoomCTRL(myHouse);
        //1.
        myHouse.getListOfRooms().addRoomToList(name, floor, roomWidth, roomLength, roomHeight);

        //Act
        //2.
        ArrayList<RoomDTO> list = controller.getListOfRooms();
        String result = list.get(0).getRoomName();

        //Assert
        assertEquals(name, result);

    }

}