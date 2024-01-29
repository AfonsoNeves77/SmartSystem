package pt.ipp.isep.dei.project.controller;

import pt.ipp.isep.dei.project.DTO.RoomDTO;
import pt.ipp.isep.dei.project.domain.House;

public class AddRoomCTRL {
    private House house;

    /**
     * Controller Constructor for Use Case: Add a new room to the house
     * @param house House to be considered
     */
    public AddRoomCTRL(House house) {
        this.house = house;
    }

    /**
     * Requests to add a new Room to the house
     * @param roomDTO DTO with external information to add a new room
     * @return Code 0: Room successfully added;
     * Code 1: Impossible to instantiate a new Room;
     * Code 2: Room already exists in the house (duplication);
     */
    public int addRoom(RoomDTO roomDTO){
        String roomName = roomDTO.getRoomName();
        int houseFloor = roomDTO.getHouseFloor();
        double width = roomDTO.getRoomWidth();
        double length = roomDTO.getRoomLength();
        double height = roomDTO.getRoomHeight();
        return this.house.getListOfRooms().addRoomToList(roomName,houseFloor,width,length,height);
    }

}
