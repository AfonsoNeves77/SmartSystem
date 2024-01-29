package pt.ipp.isep.dei.project.controllerTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.project.DTO.RoomDTO;
import pt.ipp.isep.dei.project.controller.AddDeviceToRoomCTRL;
import pt.ipp.isep.dei.project.domain.Device;
import pt.ipp.isep.dei.project.domain.House;
import pt.ipp.isep.dei.project.domain.Room;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AddDeviceToRoomCTRLTest {

    /**
     * Test 01 - Tests if controller object is not null.
     * @throws InstantiationException
     */
    @Test
    void AddDeviceToRoomCTRL_NotNull() throws InstantiationException {
        //Arrange and Act
        House myHouse = new House("Test");
        AddDeviceToRoomCTRL ctrl = new AddDeviceToRoomCTRL(myHouse);
        //Assert
        assertNotNull(ctrl);
    }

    /**
     * Test 02 - Tests if the  getListOfRooms method returns the list of rooms from the house
     * by comparing room name.
     * @throws InstantiationException
     */
    @Test
    void getListOfRooms_Success () throws InstantiationException {
        //Arrange
        String houseName = "casa";
        House myhouse = new House(houseName);
        //1. Adds device to
        AddDeviceToRoomCTRL controller = new AddDeviceToRoomCTRL(myhouse);

        String name = "Blue Room";
        int floor = 7;
        double width = 3;
        double length = 3;
        double height = 2;
        myhouse.getListOfRooms().addRoomToList(name, floor, width, length, height);

        String expected = "Blue Room";

        //Act
        ArrayList<RoomDTO> result = controller.getListOfRooms();
        String resultName = result.get(0).getRoomName();

        //Assert
        assertEquals(expected, resultName);
    }

    /**
     * Test 03 - Tests if addDeviceToRoom method adds the device to the room and returns 0 in case the operation is successful.
     * @throws InstantiationException
     */
    @Test
    void AddDeviceToRoomCTRL_Success () throws InstantiationException {
        //Arrange
        String houseName = "casa";
        House myhouse = new House(houseName);
        String name = "Blue Room";
        int floor = 7;
        double width = 3;
        double length = 3;
        double height = 2;
        myhouse.getListOfRooms().addRoomToList(name, floor, width, length, height);
        RoomDTO roomDTO = new RoomDTO(name, floor, width, length, height);
        String deviceName = "aquecedor";
        String deviceModel = "XPTO3000";
        AddDeviceToRoomCTRL controller = new AddDeviceToRoomCTRL(myhouse);
        int expected = 0;
        //Act
        int result = controller.addDeviceToRoom(roomDTO,deviceName,deviceModel);
        //Assert
        assertEquals(expected, result);
    }

    /**
     * Test 04 - Tests if addDeviceToRoom method returns 1 if device name is invalid.
     * * @throws InstantiationException**
     */
    @Test
    void AddDeviceToRoomCTRL_ReturnsOneIfParameterInvalid() throws InstantiationException {
        //Arrange
        String houseName = "casa";
        House myhouse = new House(houseName);
        String name = "Blue Room";
        int floor = 7;
        double width = 3;
        double length = 3;
        double height = 2;
        myhouse.getListOfRooms().addRoomToList(name, floor, width, length, height);
        RoomDTO roomDTO = new RoomDTO(name, floor, width, length, height);
        String deviceName = "";
        String deviceModel = "XPTO3000";
        AddDeviceToRoomCTRL controller = new AddDeviceToRoomCTRL(myhouse);
        int expected = 1;
        //Act
        int result = controller.addDeviceToRoom(roomDTO,deviceName,deviceModel);
        //Assert
        assertEquals(expected, result);
    }

    /**
     * Test 05 - Tests if addDeviceToRoom method returns 2 if device is already in the room.
     * @throws InstantiationException
    */
    @Test
    void AddDeviceToRoomCTRL_ReturnsTwoIfDuplicated() throws InstantiationException {
        //Arrange
        String houseName = "casa";
        House myhouse = new House(houseName);
        String name = "Blue Room";
        int floor = 7;
        double width = 3;
        double length = 3;
        double height = 2;
        myhouse.getListOfRooms().addRoomToList(name, floor, width, length, height);
        RoomDTO roomDTO = new RoomDTO(name, floor, width, length, height);
        String deviceName = "Heater";
        String deviceModel = "XPTO3000";
        AddDeviceToRoomCTRL controller = new AddDeviceToRoomCTRL(myhouse);
        controller.addDeviceToRoom(roomDTO,deviceName,deviceModel);
        int expected = 2;
        //Act
        int result = controller.addDeviceToRoom(roomDTO,deviceName,deviceModel);
        //Assert
        assertEquals(expected, result);
    }

    /**
     * Test 06 - Tests if addDeviceToRoom method returns 3 if room is null.
     * @throws InstantiationException
     */
    @Test
    void AddDeviceToRoomCTRL_ReturnsThreeIfRoomNull() throws InstantiationException {
        //Arrange
        String houseName = "casa";
        House myhouse = new House(houseName);
        String name = "Blue Room";
        int floor = 7;
        double width = 3;
        double length = 3;
        double height = 2;
        RoomDTO roomDTO = new RoomDTO(name, floor, width, length, height);
        String deviceName = "Heater";
        String deviceModel = "XPTO3000";
        AddDeviceToRoomCTRL controller = new AddDeviceToRoomCTRL(myhouse);
        controller.addDeviceToRoom(roomDTO,deviceName,deviceModel);
        int expected = 3;
        //Act
        int result = controller.addDeviceToRoom(roomDTO,deviceName,deviceModel);
        //Assert
        assertEquals(expected, result);
    }
}
