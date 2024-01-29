package pt.ipp.isep.dei.project.controller;

import pt.ipp.isep.dei.project.DTO.DeviceDTO;
import pt.ipp.isep.dei.project.DTO.DeviceDTOMapper;
import pt.ipp.isep.dei.project.DTO.RoomDTO;
import pt.ipp.isep.dei.project.DTO.RoomDTOMapper;
import pt.ipp.isep.dei.project.domain.Device;
import pt.ipp.isep.dei.project.domain.House;
import pt.ipp.isep.dei.project.domain.Room;

import java.util.ArrayList;

public class ToggleDeviceCTRL {
    House house;

    /**
     * Constructor for Toggle device controller.
     * @param house House in scope.
     */
    public ToggleDeviceCTRL(House house) {
        this.house = house;
    }

    /**
     * Gets list of Rooms from domain and converts it into a list of RoomsDTO
     * @return Returns a list of RoomsDTO
     */
    public ArrayList<RoomDTO> getListOfRooms(){
        CommonListOfRooms common = new CommonListOfRooms(house);
        ArrayList<Room> listOfRooms = common.getListOfRooms();
        RoomDTOMapper mapper = new RoomDTOMapper();
        return mapper.getRoomDTOList(listOfRooms);
    }
    /**
     * Unpacks RoomDTO and gets its DeviceList in DTO form
     * @param roomDTO RoomDTO with object Room information
     * @return List with DeviceDTOs
     */
    public ArrayList<DeviceDTO> getListOfDevices(RoomDTO roomDTO){
        RoomDTOMapper mapper = new RoomDTOMapper();
        Room room = mapper.dtoToDomain(roomDTO, this.house);

        CommonListOfDevices common = new CommonListOfDevices(this.house);
        ArrayList<Device> deviceList = common.getListOfDevices(room);

        DeviceDTOMapper deviceMapper = new DeviceDTOMapper();
        return deviceMapper.domainToDTO(deviceList);
    }
    /**
     * Receives a Room and a Device in order to change Device status to the opposite boolean value.
     * @param roomDTO RoomDTO with object Room information
     * @param deviceDTO DeviceDTO with object Device information
     * @return Returns Device Status after toggling
     */
    public boolean toggleDevice(RoomDTO roomDTO, DeviceDTO deviceDTO){
        RoomDTOMapper roomMapper = new RoomDTOMapper();
        Room room = roomMapper.dtoToDomain(roomDTO,house);
        DeviceDTOMapper deviceMapper = new DeviceDTOMapper();
        Device device = deviceMapper.dtoToDomain(room,deviceDTO);
        return device.toggleDeviceStatus();
    }
}
