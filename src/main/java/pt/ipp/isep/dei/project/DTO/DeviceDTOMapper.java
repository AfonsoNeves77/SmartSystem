package pt.ipp.isep.dei.project.DTO;

import pt.ipp.isep.dei.project.domain.Device;
import pt.ipp.isep.dei.project.domain.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class    DeviceDTOMapper {
    static public DeviceDTO Domain2DTO(Device device){
        return new DeviceDTO(device.getDeviceName(),
                device.getDeviceModel(),
                device.getDeviceLocation(),
                device.getStatus());
    }


    static public Map<DeviceDTO, Device> Domain2DTO(List<Device> deviceList)
    {
        Map<DeviceDTO, Device> deviceDTOAndDevice = new HashMap<>();

        deviceList.forEach( device -> {
            DeviceDTO deviceDTO = DeviceDTOMapper.Domain2DTO(device);
            deviceDTOAndDevice.put( deviceDTO, device );
        });

        return deviceDTOAndDevice;
    }

//    static public List<DeviceDTO> Domain2DTO(List<Device> deviceList)
//    {
//        return deviceList.stream().map(device -> new DeviceDTO(
//                device.getDeviceName(),device.getDeviceModel(),
//                device.getDeviceLocation(),device.getStatus()
//        )).collect(Collectors.toList());
//
//    }
}
