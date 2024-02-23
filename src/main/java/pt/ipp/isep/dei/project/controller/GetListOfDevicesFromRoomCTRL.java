package pt.ipp.isep.dei.project.controller;

import pt.ipp.isep.dei.project.DTO.DeviceDTO;
import pt.ipp.isep.dei.project.DTO.DeviceDTOMapper;
import pt.ipp.isep.dei.project.DTO.RoomDTO;
import pt.ipp.isep.dei.project.DTO.RoomDTOMapper;
import pt.ipp.isep.dei.project.domain.Device;
import pt.ipp.isep.dei.project.domain.House;
import pt.ipp.isep.dei.project.domain.Room;

import java.util.ArrayList;
import java.util.List;

public class GetListOfDevicesFromRoomCTRL {
    private House house;

    private CommonListOfRooms commonRooms;
    private CommonListOfDevices commonDevices;
    /**
     * Constructs a GetListOfDevicesFromRoomCTRL object with the provided House instance.
     *
     * @param house The House instance to be associated with the controller.
     */
    public GetListOfDevicesFromRoomCTRL(House house) {

        this.house = house;
        commonRooms = new CommonListOfRooms(house);
        commonDevices = new CommonListOfDevices(house);
    }

    public List<RoomDTO> getListOfRooms(){
        return commonRooms.getRooms();
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

    public List<DeviceDTO> getDevicesFromRoom(RoomDTO roomDTO)
    {
        Room selectedRoom = commonRooms.getSelectedRoom(roomDTO);
        return commonDevices.getDevicesFromRoom(selectedRoom);
    }
}
