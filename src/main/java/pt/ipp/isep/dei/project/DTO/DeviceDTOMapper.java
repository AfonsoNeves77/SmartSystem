package pt.ipp.isep.dei.project.DTO;

import pt.ipp.isep.dei.project.domain.Device;
import pt.ipp.isep.dei.project.domain.Room;

import java.util.ArrayList;

public class    DeviceDTOMapper {
    public DeviceDTO domainToDTO(Device device){
        return new DeviceDTO(device.getDeviceName(),
                device.getDeviceModel(),
                device.getDeviceLocation(),
                device.getStatus());
    }

    /**
     * Converts a list of Device objects to a list of DeviceDTO objects.
     *
     * @param list The list of Device objects to be converted.
     * @return An ArrayList of DeviceDTO objects representing the given list of Device objects.
     */
    public ArrayList<DeviceDTO> domainToDTO(ArrayList<Device> list){
        ArrayList<DeviceDTO> deviceList = new ArrayList<>();
        for (Device singleDevice : list) {
            DeviceDTO singleDeviceDTO = domainToDTO(singleDevice);
            deviceList.add(singleDeviceDTO);
        }
        return deviceList;//deviceDTOList
    }

    /**
     * Converts a DeviceDTO object to a corresponding Device object within a specified Room.
     *
     * @param room The Room containing the list of devices to search.
     * @param deviceDTO The DeviceDTO object to be converted to a Device object.
     * @return The Device object corresponding to the provided DeviceDTO within the given Room.
     *         Returns null if no matching device is found.
     */
    public Device dtoToDomain (Room room, DeviceDTO deviceDTO){
        ArrayList<Device> list = room.getListOfDevices().getDeviceList();
        for(Device singleDevice: list){
            if(singleDevice.getDeviceName().equals(deviceDTO.getName())){
                return singleDevice;
            }
        }
        return null;
    }
}
