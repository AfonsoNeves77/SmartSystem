package pt.ipp.isep.dei.project.controllerTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.project.controller.CommonListOfRooms;
import pt.ipp.isep.dei.project.domain.House;
import pt.ipp.isep.dei.project.domain.Room;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommonListOfRoomsCTRLTest {
    @Test
    void getListOfRooms() throws InstantiationException {
        //Arrange
        String houseName = "Random House";
        House myHouse = new House(houseName);
        String roomName = "Office";
        String otherRoomName = "Kitchen";
        int houseFloor = 1;
        double roomWidth = 3.5;
        double roomLength = 3;
        double roomHeight = 2;
        myHouse.getListOfRooms().addRoomToList(roomName,houseFloor,roomWidth,roomLength,houseFloor);
        myHouse.getListOfRooms().addRoomToList(roomName,houseFloor,roomWidth,roomLength,houseFloor);

        //Act
        CommonListOfRooms common = new CommonListOfRooms(myHouse);
        ArrayList<Room> listOfRooms = common.getListOfRooms();
        String result = listOfRooms.get(0).getRoomName();

        //Assert
        assertEquals(roomName,result);

    }

    @Test
    void getListOfRooms_HouseWithNoRooms() throws InstantiationException {
        //Arrange
        String houseName = "Random House";
        House myHouse = new House(houseName);
        int expected = 0;

        //Act
        CommonListOfRooms common = new CommonListOfRooms(myHouse);
        ArrayList<Room> listOfRooms = common.getListOfRooms();
        int result = listOfRooms.size();

        //Assert
        assertEquals(expected,result);

    }

}