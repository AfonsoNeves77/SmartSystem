package pt.ipp.isep.dei.project.controllerTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.project.DTO.RoomDTO;
import pt.ipp.isep.dei.project.controller.AddRoomCTRL;
import pt.ipp.isep.dei.project.domain.House;
import pt.ipp.isep.dei.project.domain.Room;

import static org.junit.jupiter.api.Assertions.*;

class AddRoomCTRLTest {

    /**
     * Test 01- Verifies controller is able to successfully add a room to the house. The expected result is 0 for confirmation.
     * (1.) Creates House, Room DTO and controller
     * (2.) Calls addRoom with roomDTO on controller, in order to obtain a result of 0 (successful operation)
     * @throws InstantiationException On house and room instantiation
     */
    @Test
    void addRoomCTRL_SuccessCase() throws InstantiationException {
        //Arrange
        // 1.
        String houseName = "Little House";
        String roomName = "Bathroom";
        int floor = -2;
        double roomWidth = 3.5;
        double roomLength = 3;
        double roomHeight = 2;
        House myHouse = new House(houseName);
        RoomDTO roomDTO = new RoomDTO(roomName,floor,roomWidth,roomLength,roomHeight);
        AddRoomCTRL controller = new AddRoomCTRL(myHouse);
        int expected = 0;
        //Act
        // 2.
        int result = controller.addRoom(roomDTO);
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test 02- Attempts to add a room with similar parameters to an already existing room
     * (1.) Creates House, Room DTO and controller
     * (2.) Adds on copy of room
     * (3.) Attempts to add the room again, resulting in a code 2 (duplicated parameters)
     * @throws InstantiationException On house and room instantiation
     */
    @Test
    void addRoomCTRL_DuplicatedRoom() throws InstantiationException {
        //Arrange
        // 1.
        String houseName = "Little House";
        String roomName = "Bathroom";
        int floor = -2;
        double roomWidth = 3.5;
        double roomLength = 3;
        double roomHeight = 2;
        House myHouse = new House(houseName);
        RoomDTO roomDTO = new RoomDTO(roomName,floor,roomWidth,roomLength,roomHeight);
        AddRoomCTRL controller = new AddRoomCTRL(myHouse);
        // 2.
        controller.addRoom(roomDTO);
        int expected = 2;
        //Act
        // 3.
        int result = controller.addRoom(roomDTO);
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test 03- Attempts to add a room with invalid parameters
     * (1.) Creates House, Room DTO (roomDTO can be created with invalid Room parameters) and controller
     * (2.) Attempts to add the room, resulting in a code 1 (invalid parameters)
     * @throws InstantiationException On house and room instantiation
     */
    @Test
    void addRoomCTRL_EmptyName() throws InstantiationException {
        //Arrange
        // 1.
        String houseName = "House";
        String roomName = " ";
        int floor = -2;
        double roomWidth = 1;
        double roomLength = 3;
        double roomHeight = 2;
        House myHouse = new House(houseName);
        RoomDTO roomDTO = new RoomDTO(roomName,floor,roomWidth,roomLength,roomHeight);
        AddRoomCTRL controller = new AddRoomCTRL(myHouse);
        int expected = 1;
        //Act
        // 2.
        int result = controller.addRoom(roomDTO);
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test 04- Attempts to add a room with invalid parameters
     * (1.) Creates House, Room DTO (roomDTO can be created with invalid Room parameters) and controller
     * (2.) Attempts to add the room, resulting in a code 1 (invalid parameters)
     * @throws InstantiationException On house and room instantiation
     */
    @Test
    void addRoomCTRL_NegativeWidth() throws InstantiationException {
        //Arrange
        // 1.
        String houseName = "Little House";
        String roomName = "Bathroom";
        int floor = -2;
        double roomWidth = -1;
        double roomLength = 3;
        double roomHeight = 2;
        House myHouse = new House(houseName);
        RoomDTO roomDTO = new RoomDTO(roomName,floor,roomWidth,roomLength,roomHeight);
        AddRoomCTRL controller = new AddRoomCTRL(myHouse);
        int expected = 1;
        //Act
        // 2.
        int result = controller.addRoom(roomDTO);
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test 05- Attempts to add a room with invalid parameters
     * (1.) Creates House, Room DTO (roomDTO can be created with invalid Room parameters) and controller
     * (2.) Attempts to add the room, resulting in a code 1 (invalid parameters)
     * @throws InstantiationException On house and room instantiation
     */
    @Test
    void addRoomCTRL_ZeroWidth() throws InstantiationException {
        //Arrange
        // 1.
        String houseName = "Little House";
        String roomName = "Bathroom";
        int floor = -2;
        double roomWidth = 0;
        double roomLength = 3;
        double roomHeight = 2;
        House myHouse = new House(houseName);
        RoomDTO roomDTO = new RoomDTO(roomName,floor,roomWidth,roomLength,roomHeight);
        AddRoomCTRL controller = new AddRoomCTRL(myHouse);
        int expected = 1;
        //Act
        // 2.
        int result = controller.addRoom(roomDTO);
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test 06- Attempts to add a room with invalid parameters
     * (1.) Creates House, Room DTO (roomDTO can be created with invalid Room parameters) and controller
     * (2.) Attempts to add the room, resulting in a code 1 (invalid parameters)
     * @throws InstantiationException On house and room instantiation
     */
    @Test
    void addRoomCTRL_NegativeLength() throws InstantiationException {
        //Arrange
        // 1.
        String houseName = "Little House";
        String roomName = "Bathroom";
        int floor = -2;
        double roomWidth = 1;
        double roomLength = -2;
        double roomHeight = 2;
        House myHouse = new House(houseName);
        RoomDTO roomDTO = new RoomDTO(roomName,floor,roomWidth,roomLength,roomHeight);
        AddRoomCTRL controller = new AddRoomCTRL(myHouse);
        int expected = 1;
        //Act
        // 2.
        int result = controller.addRoom(roomDTO);
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test 07- Attempts to add a room with invalid parameters
     * (1.) Creates House, Room DTO (roomDTO can be created with invalid Room parameters) and controller
     * (2.) Attempts to add the room, resulting in a code 1 (invalid parameters)
     * @throws InstantiationException On house and room instantiation
     */
    @Test
    void addRoomCTRL_ZeroLength() throws InstantiationException {
        //Arrange
        // 1.
        String houseName = "Little House";
        String roomName = "Bathroom";
        int floor = -2;
        double roomWidth = 1;
        double roomLength = 0;
        double roomHeight = 2;
        House myHouse = new House(houseName);
        RoomDTO roomDTO = new RoomDTO(roomName,floor,roomWidth,roomLength,roomHeight);
        AddRoomCTRL controller = new AddRoomCTRL(myHouse);
        int expected = 1;
        //Act
        // 2.
        int result = controller.addRoom(roomDTO);
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test 08- Attempts to add a room with invalid parameters
     * (1.) Creates House, Room DTO (roomDTO can be created with invalid Room parameters) and controller
     * (2.) Attempts to add the room, resulting in a code 1 (invalid parameters)
     * @throws InstantiationException On house and room instantiation
     */
    @Test
    void addRoomCTRL_NegativeHeight() throws InstantiationException {
        //Arrange
        // 1.
        String houseName = "Little House";
        String roomName = "Bathroom";
        int floor = -2;
        double roomWidth = 1;
        double roomLength = 1;
        double roomHeight = -3;
        House myHouse = new House(houseName);
        RoomDTO roomDTO = new RoomDTO(roomName,floor,roomWidth,roomLength,roomHeight);
        AddRoomCTRL controller = new AddRoomCTRL(myHouse);
        int expected = 1;
        //Act
        // 2.
        int result = controller.addRoom(roomDTO);
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test 09- Attempts to add a room with invalid parameters
     * (1.) Creates House, Room DTO (roomDTO can be created with invalid Room parameters) and controller
     * (2.) Attempts to add the room, resulting in a code 1 (invalid parameters)
     * @throws InstantiationException On house and room instantiation
     */
    @Test
    void addRoomCTRL_ZeroHeight() throws InstantiationException {
        //Arrange
        // 1.
        String houseName = "Little House";
        String roomName = "Bathroom";
        int floor = -2;
        double roomWidth = 1;
        double roomLength = 2;
        double roomHeight = 0;
        House myHouse = new House(houseName);
        RoomDTO roomDTO = new RoomDTO(roomName,floor,roomWidth,roomLength,roomHeight);
        AddRoomCTRL controller = new AddRoomCTRL(myHouse);
        int expected = 0;
        //Act
        // 2.
        int result = controller.addRoom(roomDTO);
        //Assert
        assertEquals(expected,result);
    }

}