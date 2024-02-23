package pt.ipp.isep.dei.project.controller;

import pt.ipp.isep.dei.project.DTO.RoomDTO;
import pt.ipp.isep.dei.project.DTO.RoomDTOMapper;
import pt.ipp.isep.dei.project.domain.House;
import pt.ipp.isep.dei.project.domain.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonListOfRooms {
    private House house;
    private Map<RoomDTO, Room> _roomsDTOAndRooms = new HashMap<>();

    public CommonListOfRooms(House house){
        this.house = house;
    }

    public List<RoomDTO> getRooms( )
    {

        List<Room> listOfRooms = house.getListOfRooms();
        _roomsDTOAndRooms = RoomDTOMapper.Domain2DTO( listOfRooms );

        return _roomsDTOAndRooms.keySet().stream().toList();
    }

    public Room getSelectedRoom(RoomDTO roomDTO){
        return _roomsDTOAndRooms.get(roomDTO);
    }



}
