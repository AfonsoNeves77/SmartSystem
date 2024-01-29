package pt.ipp.isep.dei.project.domainTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.project.domain.ListOfRooms;
import pt.ipp.isep.dei.project.domain.Room;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ListOfRoomsTest {
    /**
     * Test01 case to ensure that the constructor creates a non-null ListOfRooms object.
     */
    @Test
    void constructorCreatesNonNullObject() {
        //Arrange and Act
        ListOfRooms roomsList = new ListOfRooms();

        //Assert
        assertNotNull(roomsList);
    }

    /**
     * Test02 case to ensure that the addRoomToList method successfully adds a room to the list.
     *
     * @throws InstantiationException if there is an issue with instantiating a room object(invalid parameters).
     */
    @Test
    void addRoomToList_Success() throws InstantiationException {
        //Arrange
        String roomName = "Living Room";
        int houseFloor = 1;
        double roomWidth = 3;
        double roomLength = 1;
        double roomHeight = 2;
        ListOfRooms roomsList = new ListOfRooms();
        int expected = 0;

        //Act
        int result = roomsList.addRoomToList(roomName,houseFloor,roomWidth,roomLength,roomHeight);

        //Assert
        assertEquals(expected, result);
    }
}