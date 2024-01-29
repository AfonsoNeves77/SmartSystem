package pt.ipp.isep.dei.project.dtoTests;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.project.DTO.RoomDTO;
import pt.ipp.isep.dei.project.DTO.RoomDTOMapper;
import pt.ipp.isep.dei.project.domain.House;
import pt.ipp.isep.dei.project.domain.Room;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RoomDTOMapperTest {
    /**
     * Test 01. Verifies that roomDTO is created successfully from Room
     * (1.) Creates room object and assigns it a Dimensions object
     * (2.) Creates Room DTO mapper and converts Room object into a roomDTO
     * (3.) Calls getName on roomDTO and verifies it matches with the room's name
     */
    @Test
    void convertRoomToDTO() throws InstantiationException {
        //Arrange
        //(1.)
        //(2.)
        String name = "Blue Room";
        int floor = 7;
        double width = 3;
        double length = 3;
        double height = 2;
        Room domainRoom = new Room(name,floor);
        domainRoom.createRoomDimensions(width,length,height);
        //(2.)
        RoomDTOMapper mapper = new RoomDTOMapper();
        RoomDTO dto = mapper.domainToDTO(domainRoom);
        //Act
        //(3.)
        String result = dto.getRoomName();
        //Assert
        assertEquals(name,result);
    }

    /**
     * Test 02. Verifies dtoToDomain only returns a room that exists in the domain.
     * (1.) Creates House and Room objects. Adds Room to House.
     * (2.) Creates new RoomDTO object (with a different name) and a mapper object.
     * (3.) Calls dtoToDomain on the mapper object, checking if the roomDTO name matches any of the rooms in House by name.
     * It returns null
     */
    @Test
    void dtoToDomain_RoomNotInList() throws InstantiationException {
        //Arrange
        // (1.)
        String houseName = "casa";
        House myhouse = new House(houseName);
        String roomName = "Blue Room";
        String roomDTOName = "Blue Kitchen";
        int floor = 7;
        double width = 3;
        double length = 3;
        double height = 2;
        myhouse.getListOfRooms().addRoomToList(roomName, floor, width, length, height);
        // (2.)
        RoomDTO newRoomDto = new RoomDTO("bedroom", floor, width, length, height);
        RoomDTOMapper mapper = new RoomDTOMapper();

        //Act
        Room result = mapper.dtoToDomain(newRoomDto,myhouse);
        //Assert
        assertNull(result);
    }
    /**
     * Test 03. Ensures the first roomDTO name in the DTOlist is the first room in the House's RoomList
     * (1.) Creates two rooms and adds them to the House
     * (2.) Gets the list of rooms from house and uses mapper to convert to roomDTOList
     * (3.) Accesses first Room on the roomDTOList and validates the name matches the actual room in House
     */
    @Test
    void getRoomDTOList() throws InstantiationException {
        //Arrange
        // (1.)
        String houseName = "casa";
        House myhouse = new House(houseName);
        String roomName = "Blue Room";
        String roomName1 = "Red Room";
        int floor = 7;
        double width = 3;
        double length = 3;
        double height = 2;
        myhouse.getListOfRooms().addRoomToList(roomName, floor, width, length, height);
        myhouse.getListOfRooms().addRoomToList(roomName1, floor, width, length, height);
        // (2.)
        ArrayList<Room> roomList = myhouse.getListOfRooms().getRoomList();
        RoomDTOMapper mapper = new RoomDTOMapper();
        ArrayList<RoomDTO> roomDTOList = mapper.getRoomDTOList(roomList);
        //Act
        // (3.)
        String result = roomDTOList.get(0).getRoomName();
        //Assert
        assertEquals(roomName,result);
    }
}