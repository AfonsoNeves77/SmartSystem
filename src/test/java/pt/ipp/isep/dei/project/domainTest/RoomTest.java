package pt.ipp.isep.dei.project.domainTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.project.domain.Room;
import pt.ipp.isep.dei.project.domain.RoomDimensions;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    /**
     * Test01 case to verify that attempting to create a room with null name results in an InstantiationException.
     */
    @Test
    void invalidRoomData_NullName() {
        //Arrange
        String name = null;
        int floor = 2;
        String expected = "Please insert valid room data.";
        //Act
        Exception exception = assertThrows(InstantiationException.class,() -> {
            new Room(name,floor);
        });
        String result = exception.getMessage();
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test02 case to verify that attempting to create a room with an empty name results in an InstantiationException.
     */
    @Test
    void invalidRoomData_EmptyName() {
        //Arrange
        String name = "   ";
        int floor = 2;
        String expected = "Please insert valid room data.";
        //Act
        Exception exception = assertThrows(InstantiationException.class,() -> {
            new Room(name,floor);
        });
        String result = exception.getMessage();
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test03 case to verify that creating a room with valid data is successful.
     * Compares the name of the created room with the one extracted.
     */
    @Test
    void validRoomData_Success() throws InstantiationException {
        //Arrange
        String name = "Room Test";
        int floor = 2;
        String expected = name;
        //Act
        Room newRoom = new Room(name,floor);
        String result = newRoom.getRoomName();
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test04 case to verify that creating a room with a house floor of zero is successful.
     * Compares the name of the created room with the one extracted.
     */
    @Test
    void validRoomData_SuccessHouseFloorZero() throws InstantiationException {
        //Arrange
        String name = "Room 0";
        int floor = 0;
        int expected = 0;
        //Act
        Room newRoom = new Room(name,floor);
        int result = newRoom.getHouseFloor();
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test05 case to verify that creating a room with a negative house floor is successful.
     * Compares the name of the created room with the one extracted.
     */
    @Test
    void validRoomData_SuccessNegativeHouseFloor() throws InstantiationException {
        //Arrange
        String name = "Room -1";
        int floor = -1;
        String expected = name;
        //Act
        Room newRoom = new Room(name,floor);
        String result = newRoom.getRoomName();
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test06 case to verify that setting room dimensions is successful.
     * Compares the name of the created room with the one extracted.
     */
    @Test
    void setRoomDimensions_Success() throws InstantiationException {
        //Arrange
        String name = "Room Test";
        int floor = 2;
        Room newRoom = new Room(name,floor);
        double width = 3; double length = 2; double height = 1.5;
        double expected = 3;
        //Act
        newRoom.createRoomDimensions(width,length,height);
        double result = newRoom.getDimensions().getRoomWidth();
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test07 case to verify that setting room dimensions with an invalid width results in an InstantiationException.
     */
    @Test
    void setRoomDimensions_InvalidWidth() throws InstantiationException {
        //Arrange
        String name = "Room Test";
        int floor = 2;
        Room newRoom = new Room(name,floor);
        double width = -3; double length = 2; double height = 1.5;
        String expected = "Invalid parameters.";
        //Act
        Exception exception = assertThrows(InstantiationException.class,() -> {
            newRoom.createRoomDimensions(width,length,height);
        });
        String result = exception.getMessage();
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test08 case to verify that setting room dimensions with an invalid length results in an InstantiationException.
     */
    @Test
    void setRoomDimensions_InvalidLength() throws InstantiationException {
        //Arrange
        String name = "Room Test";
        int floor = 2;
        Room newRoom = new Room(name,floor);
        double width = 3; double length = -2; double height = 1.5;
        String expected = "Invalid parameters.";
        //Act
        Exception exception = assertThrows(InstantiationException.class,() -> {
            newRoom.createRoomDimensions(width,length,height);
        });
        String result = exception.getMessage();
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test09 case to verify that setting room dimensions with an invalid height results in an InstantiationException.
     */
    @Test
    void setRoomDimensions_InvalidHeight() throws InstantiationException {
        //Arrange
        String name = "Room Test";
        int floor = 2;
        Room newRoom = new Room(name,floor);
        double width = 3; double length = 2; double height = -1.5;
        String expected = "Invalid parameters.";
        //Act
        Exception exception = assertThrows(InstantiationException.class,() -> {
            newRoom.createRoomDimensions(width,length,height);
        });
        String result = exception.getMessage();
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test10 case to verify that extracting room dimensions is successful.
     * Compares the height of the created room with the one extracted.
     */
    @Test
    void extractRoomDimensions() throws InstantiationException {
        //Arrange
        String name = "Room Test";
        int floor = 2;
        Room newRoom = new Room(name,floor);
        double width = 3; double length = 2; double height = 1.5;
        newRoom.createRoomDimensions(width,length,height);
        RoomDimensions dimensions = new RoomDimensions(width,length,height);
        double expected = 1.5;
        //Act
        double[] roomDimensions = newRoom.extractEachDimension(dimensions);
        double result = roomDimensions[2];
        //Assert
        assertEquals(expected,result);
    }

}