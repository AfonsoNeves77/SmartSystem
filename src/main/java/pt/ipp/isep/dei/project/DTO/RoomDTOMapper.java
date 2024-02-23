package pt.ipp.isep.dei.project.DTO;

import pt.ipp.isep.dei.project.domain.House;
import pt.ipp.isep.dei.project.domain.Room;
import pt.ipp.isep.dei.project.domain.RoomDimensions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomDTOMapper {

    /**
     * Receives a Room object and converts it to a Room DTO object
     * @param room Room object
     * @return Room DTO object
     */
    public static RoomDTO Domain2DTO(Room room){
        RoomDimensions dimensions = room.getDimensions();
        double[] roomDimensions = room.extractEachDimension(dimensions);
        return new RoomDTO(room.getRoomName(), room.getHouseFloor(),
                roomDimensions[0], roomDimensions[1], roomDimensions[2]);
    }


    static public Map<RoomDTO, Room> Domain2DTO(List<Room> rooms)
    {
        Map<RoomDTO, Room> roomsDTOAndRooms = new HashMap<>();

        rooms.forEach( room -> {
            RoomDTO roomDTO = RoomDTOMapper.Domain2DTO(room);
            roomsDTOAndRooms.put( roomDTO, room );
        });

        return roomsDTOAndRooms;
    }


}
