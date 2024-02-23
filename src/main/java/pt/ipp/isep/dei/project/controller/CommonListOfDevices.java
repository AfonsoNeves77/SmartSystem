package pt.ipp.isep.dei.project.controller;

import pt.ipp.isep.dei.project.DTO.DeviceDTO;
import pt.ipp.isep.dei.project.DTO.DeviceDTOMapper;
import pt.ipp.isep.dei.project.domain.Device;
import pt.ipp.isep.dei.project.domain.House;
import pt.ipp.isep.dei.project.domain.Room;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonListOfDevices {

    private House house;

    private Map<DeviceDTO, Device> _deviceDTOAndDevice = new HashMap<>();

    public CommonListOfDevices(House house){
        this.house = house;
    }

    public List<DeviceDTO> getDevicesFromRoom(Room room)
    {
        List<Device> listOfDevices = room.getListOfDevices();
        _deviceDTOAndDevice = DeviceDTOMapper.Domain2DTO(listOfDevices);
        return _deviceDTOAndDevice.keySet().stream().toList();
    }

    public Device getSelectedDevice(DeviceDTO deviceDTO){
        return _deviceDTOAndDevice.get(deviceDTO);
    }

}
