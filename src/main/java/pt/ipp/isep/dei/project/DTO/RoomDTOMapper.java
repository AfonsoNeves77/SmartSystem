package pt.ipp.isep.dei.project.DTO;

import pt.ipp.isep.dei.project.domain.House;
import pt.ipp.isep.dei.project.domain.Room;
import pt.ipp.isep.dei.project.domain.RoomDimensions;

import java.util.ArrayList;

public class RoomDTOMapper {

    /**
     * Receives a Room object and converts it to a Room DTO object
     * @param room Room object
     * @return Room DTO object
     */
    public RoomDTO domainToDTO(Room room){
        RoomDimensions dimensions = room.getDimensions();
        double[] roomDimensions = room.extractEachDimension(dimensions);
        return new RoomDTO(room.getRoomName(), room.getHouseFloor(),
                roomDimensions[0], roomDimensions[1], roomDimensions[2]);
    }

    /**
     * Converts list of rooms into a list of room dtos.
     * @param list List of rooms
     * @return List of Room DTOS
     */
    public ArrayList<RoomDTO> getRoomDTOList(ArrayList<Room> list){
        ArrayList<RoomDTO> roomDTOList = new ArrayList<>();
        for (Room singleRoom : list){
            RoomDTO singleDTO = domainToDTO(singleRoom);
            roomDTOList.add(singleDTO);
        }
        return roomDTOList;
    }

    /**
     * Converts a RoomDTO object to its corresponding domain representation.
     * @param roomDTO The RoomDTO object to convert.
     * @param myhouse The house object to which the converted room belongs.
     * @return The corresponding domain representation of the room. Returns null if
     * room does not exist in the House.
     */
    public Room dtoToDomain (RoomDTO roomDTO, House myhouse){
        ArrayList<Room> list = myhouse.getListOfRooms().getRoomList();
        for(Room singleRoom: list){
            if(singleRoom.getRoomName().equals(roomDTO.getRoomName())){
                return singleRoom;
            }
        }
        return null;
    }
}
