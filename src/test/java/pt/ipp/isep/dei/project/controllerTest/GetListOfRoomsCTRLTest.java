package pt.ipp.isep.dei.project.controllerTest;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.project.DTO.RoomDTO;
import pt.ipp.isep.dei.project.controller.GetListOfRoomsCTRL;
import pt.ipp.isep.dei.project.domain.House;
import pt.ipp.isep.dei.project.domain.ListOfRooms;
import pt.ipp.isep.dei.project.domain.Room;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class GetListOfRoomsCTRLTest {

    /**
     * Tests the getListOfRooms method in the GetListOfRoomsCTRL class when rooms are added to the house.
     * 1. Adds the room to the House
     * 2. Starts the controller
     * 3. Asserts if the name of the room is the same as the one from the ArrayList
     * @throws InstantiationException If an error occurs during the instantiation of objects.
     */
    @Test
    void getListOfRoomsCTRLTest() throws InstantiationException {

        //Arrange
        String houseName = "my House";
        House myHouse = new House(houseName);

        String name = "Bathroom";
        int floor = 2;
        double roomWidth = 3.5;
        double roomLength = 3;
        double roomHeight = 2;
        GetListOfRoomsCTRL controller = new GetListOfRoomsCTRL(myHouse);
        //1.
        myHouse.getListOfRooms().addRoomToList(name,floor,roomWidth,roomLength,roomHeight);

        //Act
        //2.
        ArrayList<RoomDTO> result = controller.getListOfRooms();
        String nameOfRoom = result.get(0).getRoomName();

        //Assert
        //3.
        assertEquals(name,nameOfRoom);

    }

    /**
     * Tests the getListOfRooms method in the GetListOfRoomsCTRL class when no rooms are added to the house
     * 1. Starts the controller
     * 2. Asserts if the ArrayList size is 0 given that no rooms were added.
     * @throws InstantiationException If an error occurs during the instantiation of objects
     */
    @Test
    void getListOfRoomsCTRLTest_NoRoomsAdded() throws InstantiationException {

        //Arrange
        String houseName = "my House";
        House myHouse = new House(houseName);
        int expected = 0;

        //Act
        //1.
        GetListOfRoomsCTRL controller = new GetListOfRoomsCTRL(myHouse);
        ArrayList<RoomDTO> result = controller.getListOfRooms();
        int listLength = result.size();

        //Assert
        //2.
        assertEquals(expected,listLength);

    }

}
