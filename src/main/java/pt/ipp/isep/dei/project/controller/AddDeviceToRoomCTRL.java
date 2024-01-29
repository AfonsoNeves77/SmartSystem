package pt.ipp.isep.dei.project.controller;

import pt.ipp.isep.dei.project.DTO.RoomDTO;
import pt.ipp.isep.dei.project.DTO.RoomDTOMapper;
import pt.ipp.isep.dei.project.domain.House;
import pt.ipp.isep.dei.project.domain.Room;

import java.util.ArrayList;

public class AddDeviceToRoomCTRL {

    House myHouse;

    /**
     * Controller Constructor for Use Case: Add a new device to a room
     * @param myHouse
     */
    public AddDeviceToRoomCTRL (House myHouse){
        this.myHouse = myHouse;
    }


    /**
     * Retrieves a list of all rooms in the house.
     * @return an ArrayList of RoomDTO objects representing all rooms in the house
     */
    public ArrayList<RoomDTO> getListOfRooms(){
        CommonListOfRooms common = new CommonListOfRooms(myHouse);
        ArrayList<Room> listOfRooms = common.getListOfRooms();
        RoomDTOMapper mapper = new RoomDTOMapper();
        return mapper.getRoomDTOList(listOfRooms);
    }

    /**
     * Adds a new device to the specified room.
     * @param roomDTO the DTO object representing the room to add the device to
     * @param deviceName the name of the device to add
     * @param deviceModel the model of the device to add
     * @return an integer indicating the success or failure of the operation.
     */
    public int addDeviceToRoom (RoomDTO roomDTO, String deviceName, String deviceModel){
        RoomDTOMapper mapper = new RoomDTOMapper();
        Room selectedRoom = mapper.dtoToDomain(roomDTO, myHouse);
        if(selectedRoom == null){
            return 3;
        }
        String roomName = selectedRoom.getRoomName();
        return selectedRoom.getListOfDevices().addDeviceToList(deviceName, deviceModel, roomName);
    }
}
