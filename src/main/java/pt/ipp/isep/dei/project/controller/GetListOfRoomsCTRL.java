package pt.ipp.isep.dei.project.controller;

import pt.ipp.isep.dei.project.DTO.RoomDTO;
import pt.ipp.isep.dei.project.DTO.RoomDTOMapper;
import pt.ipp.isep.dei.project.domain.House;
import pt.ipp.isep.dei.project.domain.Room;

import java.util.ArrayList;

public class GetListOfRoomsCTRL {
    private House house;

    /**
     * Constructs a GetListOfRoomsCTRL object with the provided House instance.
     *
     * @param house The House instance to be associated with the controller.
     */
    public GetListOfRoomsCTRL(House house){
        this.house = house;
    }

    /**
     * Retrieves a list of RoomDTO instances representing the rooms in the current house.
     * This method utilizes a CommonListOfRoomsCTRL object to fetch the list of Room objects from the house.
     * It then employs a RoomDTOMapper to convert the Room objects into corresponding RoomDTO instances.
     *
     * @return An ArrayList of RoomDTO instances representing the rooms in the house.
     * @see CommonListOfRooms
     * @see RoomDTOMapper
     * @see Room
     * @see RoomDTO
     */

    public ArrayList<RoomDTO> getListOfRooms(){
        CommonListOfRooms common = new CommonListOfRooms(house);
        ArrayList<Room> listOfRooms = common.getListOfRooms();
        RoomDTOMapper mapper = new RoomDTOMapper();
        return mapper.getRoomDTOList(listOfRooms);
    }
}
