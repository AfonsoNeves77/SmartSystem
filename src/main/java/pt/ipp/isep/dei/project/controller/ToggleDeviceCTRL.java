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

public class ToggleDeviceCTRL {
    House house;
    private CommonListOfRooms commonRooms;
    private CommonListOfDevices commonDevices;

    /**
     * Constructor for Toggle device controller.
     * @param house House in scope.
     */
    public ToggleDeviceCTRL(House house) {

        this.house = house;
        commonRooms = new CommonListOfRooms(house);
        commonDevices = new CommonListOfDevices(house);
    }

    /**
     * Gets list of Rooms from domain and converts it into a list of RoomsDTO
     * @return Returns a list of RoomsDTO
     */
    public List<RoomDTO> getListOfRooms(){
        return commonRooms.getRooms();
    }
    /**
     * Unpacks RoomDTO and gets its DeviceList in DTO form
     * @param roomDTO RoomDTO with object Room information
     * @return List with DeviceDTOs
     */
    public List<DeviceDTO> getDevicesFromRoom(RoomDTO roomDTO)
    {
        Room selectedRoom = commonRooms.getSelectedRoom(roomDTO);
        return commonDevices.getDevicesFromRoom(selectedRoom);
    }
    /**
     * Receives a Room and a Device in order to change Device status to the opposite boolean value.
     * @param deviceDTO DeviceDTO with object Device information
     * @return Returns Device Status after toggling
     */
    public boolean toggleDevice(DeviceDTO deviceDTO){
        Device selectedDevice = commonDevices.getSelectedDevice(deviceDTO);
        return selectedDevice.toggleDeviceStatus();
    }
}
