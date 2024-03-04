package pt.ipp.isep.dei.project.controller;

import pt.ipp.isep.dei.project.DTO.RoomDTO;
import pt.ipp.isep.dei.project.DTO.RoomDTOMapper;
import pt.ipp.isep.dei.project.domain.FactoryListOfSensors;
import pt.ipp.isep.dei.project.domain.House;
import pt.ipp.isep.dei.project.domain.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddDeviceToRoomCTRL {

    House myHouse;
    CommonListOfRooms common;

    /**
     * Controller Constructor for Use Case: Add a new device to a room
     * @param myHouse
     */
    public AddDeviceToRoomCTRL (House myHouse){
        this.myHouse = myHouse;
        common = new CommonListOfRooms(myHouse);
    }


    /**
     * Retrieves a list of all rooms in the house.
     * @return an ArrayList of RoomDTO objects representing all rooms in the house
     */
    public List<RoomDTO> getRooms( )
    {
        return common.getRooms();
    }

    /**
     * Adds a new device to the specified room.
     * @param roomDTO the DTO object representing the room to add the device to
     * @param deviceName the name of the device to add
     * @param deviceModel the model of the device to add
     * @return an integer indicating the success or failure of the operation.
     */
    public int addDeviceToRoom (RoomDTO roomDTO, String deviceName, String deviceModel, FactoryListOfSensors factoryListOfSensors){

        Room selectedRoom = common.getSelectedRoom(roomDTO);
        String roomLocation = selectedRoom.getRoomName();
        return selectedRoom.addDevice(deviceName,deviceModel,roomLocation, );
    }
}
