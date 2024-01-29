package pt.ipp.isep.dei.project.dtoTests;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.project.DTO.RoomDTO;

import static org.junit.jupiter.api.Assertions.*;

class RoomDTOTest {
    //It is always possible to create a DTO since, there is no restriction in their parameters,
    //they are validated in the domain level
    @Test
    void createRoomDTO(){
        //Arrange
        String name = null;
        int floor = 2;
        double width = -3;
        double length = -2;
        double height = -1;
        double lengthExpected = -2;
        //Act
        RoomDTO newDTO = new RoomDTO(name,floor,width,length,height);
        double result = newDTO.getRoomLength();
        //Assert
        assertEquals(lengthExpected,result);
    }

    /**
     * Validates DTO succesfully saves parameter
     */
    @Test
    void createRoomDTO_getName(){
        //Arrange
        String name = "Room";
        int floor = 2;
        double width = 3;
        double length = 2;
        double height = 1;
        String expected = "Room";
        //Act
        RoomDTO newDTO = new RoomDTO(name,floor,width,length,height);
        String result = newDTO.getRoomName();
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Validates DTO succesfully saves parameter
     */
    @Test
    void createRoomDTO_getFloor(){
        //Arrange
        String name = "Room";
        int floor = 2;
        double width = 3;
        double length = 2;
        double height = 1;
        int expected = 2;
        //Act
        RoomDTO newDTO = new RoomDTO(name,floor,width,length,height);
        int result = newDTO.getHouseFloor();
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Validates DTO succesfully saves parameter
     */
    @Test
    void createRoomDTO_getWidth(){
        //Arrange
        String name = "Room";
        int floor = 2;
        double width = 3;
        double length = 2;
        double height = 1;
        double expected = 3;
        //Act
        RoomDTO newDTO = new RoomDTO(name,floor,width,length,height);
        double result = newDTO.getRoomWidth();
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Validates DTO succesfully saves parameter
     */
    @Test
    void createRoomDTO_getLength(){
        //Arrange
        String name = "Room";
        int floor = 2;
        double width = 3;
        double length = 2;
        double height = 1;
        double expected = 2;
        //Act
        RoomDTO newDTO = new RoomDTO(name,floor,width,length,height);
        double result = newDTO.getRoomLength();
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Validates DTO succesfully saves parameter
     */
    @Test
    void createRoomDTO_getHeight() {
        //Arrange
        String name = "Room";
        int floor = 2;
        double width = 3;
        double length = 2;
        double height = 1;
        double expected = 1;
        //Act
        RoomDTO newDTO = new RoomDTO(name, floor, width, length, height);
        double result = newDTO.getRoomHeight();
        //Assert
        assertEquals(expected, result);
    }
}