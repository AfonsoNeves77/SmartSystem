package pt.ipp.isep.dei.project.controller;
import pt.ipp.isep.dei.project.DTO.DeviceDTO;
import pt.ipp.isep.dei.project.DTO.DeviceDTOMapper;
import pt.ipp.isep.dei.project.DTO.RoomDTO;
import pt.ipp.isep.dei.project.DTO.RoomDTOMapper;
import pt.ipp.isep.dei.project.domain.*;

import java.util.ArrayList;

public class AddSensorToDeviceCTRL {

    private House house;

    /**
     * Constructs a GetListOfRoomsCTRL object with the provided House instance.
     *
     * @param house The House instance to be associated with the controller.
     */

    public AddSensorToDeviceCTRL(House house){
        this.house = house;
    }

    /**
     * Retrieves a collection of RoomDTO instances, where each RoomDTO serves as a secure container for conveying
     * information from the corresponding Room object.
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
     * Retrieves a collection of DeviceDTO instances, where each DeviceDTO  serves as a secure container for conveying
     * information from the corresponding DeviceDTO object.

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
        Room selectedRoom = getRoomFromDto(roomDTO);
        if (selectedRoom == null){
            return null;
        }
        CommonListOfDevices common = new CommonListOfDevices(house);
        ArrayList<Device> list = common.getListOfDevices(selectedRoom);
        DeviceDTOMapper dtoMapper = new DeviceDTOMapper();
        return dtoMapper.domainToDTO(list);
    }

    /**
     * This method return a list of all the sensor types available in the system.
     * @return ArrayList<SensorTypeOptions> an immutable arrayList that contain all the sensor types available in the system
     * @see SensorTypeOptions
     */

    public ArrayList<SensorTypeOptions> getAvailableSensorTypes() {
        return new ArrayList<>(SensorTypeOptions.asList());
    }

    /**
     * The overall goal of this method is adding a sensor to the specified device within the given room.
     *
     * @param roomDTO The data transfer object representing the room.
     * @param deviceDto The data transfer object representing the device.
     * @param nameSensor The name of the sensor to be added.
     * @param sensorType The type of the sensor to be added.
     * @return (0) - sensor was added with success,
     *         (1) - sensor not added, invalid parameters,
     *         (2) - sensor not added, passed sensor name is duplicated,
     *         (3) - No match between received RoomDTO object and homologue Room object in domain/No match between received
     *          DeviceDTO object and homologue Device object in domain.
     * @see RoomDTO
     * @see DeviceDTO
     * @see Room
     * @see Device
     * @see ListOfSensors
     */

    public int addSensorToDevice(RoomDTO roomDTO,DeviceDTO deviceDto, String nameSensor, SensorTypeOptions sensorType){
        Room selectedRoom = getRoomFromDto(roomDTO);
        if (selectedRoom == null){
            return 3;
        }
        Device selectedDevice = getDeviceFromDto(selectedRoom,deviceDto);
        if (selectedDevice == null){
            return 3;
        }
        return selectedDevice.getListOfSensors().addSensor(nameSensor,sensorType);
    }

    /**
     * Converts a RoomDTO to a Room object using the provided mapper.
     *
     * @param roomDTO The data transfer object representing the room.
     * @return The corresponding Room object.
     */

    private Room getRoomFromDto(RoomDTO roomDTO){
        RoomDTOMapper mapper = new RoomDTOMapper();
        return mapper.dtoToDomain(roomDTO, this.house);
    }

    /**
     * Converts a DeviceDTO to a Device object within the given room using the provided mapper.
     *
     * @param room       The Room object to which the device belongs.
     * @param deviceDTO  The data transfer object representing the device.
     * @return           The corresponding Device object.
     */

    private Device getDeviceFromDto(Room room,DeviceDTO deviceDTO){
        DeviceDTOMapper deviceMapper = new DeviceDTOMapper();
        return deviceMapper.dtoToDomain(room,deviceDTO);
    }

}
