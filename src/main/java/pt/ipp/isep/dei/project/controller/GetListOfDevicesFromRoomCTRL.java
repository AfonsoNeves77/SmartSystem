package pt.ipp.isep.dei.project.controller;

import pt.ipp.isep.dei.project.DTO.DeviceDTO;
import pt.ipp.isep.dei.project.DTO.DeviceDTOMapper;
import pt.ipp.isep.dei.project.DTO.RoomDTO;
import pt.ipp.isep.dei.project.DTO.RoomDTOMapper;
import pt.ipp.isep.dei.project.domain.Device;
import pt.ipp.isep.dei.project.domain.House;
import pt.ipp.isep.dei.project.domain.Room;

import java.util.ArrayList;

public class GetListOfDevicesFromRoomCTRL {
    private House house;

    /**
     * Constructs a GetListOfDevicesFromRoomCTRL object with the provided House instance.
     *
     * @param house The House instance to be associated with the controller.
     */
    public GetListOfDevicesFromRoomCTRL(House house) {
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

    /**
     * Retrieves a list of DeviceDTO instances representing the devices in a specific room.
     * This method takes a RoomDTO as a parameter, converts it to a Room domain object, and then
     * retrieves the list of devices in that room. Finally, it uses a DeviceDTOMapper to convert
     * the list of Device objects to DeviceDTO instances.
     *
     * @param roomDTO The RoomDTO instance for which to retrieve the list of devices.
     * @return An ArrayList of DeviceDTO instances representing the devices in the specified room.
     *         If the room is not found, null is returned.
     * @see RoomDTOMapper
     * @see DeviceDTOMapper
     * @see RoomDTO
     * @see DeviceDTO
     * @see Room
     * @see Device
     */

    public ArrayList<DeviceDTO> listOfDevicesInARoom(RoomDTO roomDTO){
        RoomDTOMapper mapper = new RoomDTOMapper();
        Room room = mapper.dtoToDomain(roomDTO, this.house);
        if (room == null){
            return null;
        }
        CommonListOfDevices common = new CommonListOfDevices(house);
        ArrayList<Device> deviceList = common.getListOfDevices(room);
        DeviceDTOMapper deviceMapper = new DeviceDTOMapper();
        return deviceMapper.domainToDTO(deviceList);
    }
}
