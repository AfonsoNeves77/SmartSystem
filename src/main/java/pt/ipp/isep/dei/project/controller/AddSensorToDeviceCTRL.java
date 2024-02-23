package pt.ipp.isep.dei.project.controller;
import pt.ipp.isep.dei.project.DTO.DeviceDTO;
import pt.ipp.isep.dei.project.DTO.DeviceDTOMapper;
import pt.ipp.isep.dei.project.DTO.RoomDTO;
import pt.ipp.isep.dei.project.DTO.RoomDTOMapper;
import pt.ipp.isep.dei.project.domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddSensorToDeviceCTRL {

    private House house;

    CommonListOfRooms commonRooms;
    CommonListOfDevices commonDevices;
    FactorySensor factorySensor;


    public AddSensorToDeviceCTRL(House house,FactorySensor factorySensor){

        this.house = house;
        commonRooms = new CommonListOfRooms(house);
        commonDevices = new CommonListOfDevices(house);
        this.factorySensor = factorySensor;
    }

    public List<RoomDTO> getRooms( )
    {
        return commonRooms.getRooms();
    }

    public List<DeviceDTO> getDevicesFromRoom(RoomDTO roomDTO) {

        Room selectedRoom = commonRooms.getSelectedRoom(roomDTO);
        return commonDevices.getDevicesFromRoom(selectedRoom);
    }


    public List<SensorTypeOptions> getAvailableSensorTypes() {
        return SensorTypeOptions.asList();
    }

    public boolean addSensorToDevice(DeviceDTO deviceDto, String nameSensor, SensorTypeOptions sensorType){
        Device selectedDevice = commonDevices.getSelectedDevice(deviceDto);
        return selectedDevice.addSensor(nameSensor,sensorType,factorySensor);
    }


}
