package pt.ipp.isep.dei.project.dtoTests;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.project.DTO.DeviceDTO;
import pt.ipp.isep.dei.project.DTO.DeviceDTOMapper;
import pt.ipp.isep.dei.project.DTO.RoomDTO;
import pt.ipp.isep.dei.project.domain.Device;
import pt.ipp.isep.dei.project.domain.House;
import pt.ipp.isep.dei.project.domain.Room;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeviceDTOMapperTest {
    /**
     * Ensures Device object is correctly converted into a deviceDTO. Testing by name.
     * (1.) Creates device object
     * (2.) Creates mapper and converts device into DeviceDTO
     * (3.) Matches DTO name against the Device's name
     * @throws InstantiationException If device name invalid
     */
    @Test
    void domainToDTO() throws InstantiationException {
        //Arrange
        // 1.
        String deviceName = "Device 1";
        String deviceModel = "Refrigerator";
        String location = "Room";
        Device newDevice = new Device(deviceName, deviceModel, location);
        // 2.
        DeviceDTOMapper mapper = new DeviceDTOMapper();
        DeviceDTO dto = mapper.domainToDTO(newDevice);
        //Act
        // 3.
        String result = dto.getName();
        //Assert
        assertEquals(deviceName,result);
    }

    /**
     * Ensures Device object is correctly converted into a deviceDTO. Testing by name.
     * (1.) Creates house and adds 1 room and 1 device
     * (2.) Creates a mapper, extract room from House and a creates a deviceDTO object
     * (3.) calls dtoToDomain on DeviceDTO, and extracts a device from the House.
     * (4.) Confirms the name is similar.
     * @throws InstantiationException If device name invalid
     */
    @Test
    void dtoTODomain() throws InstantiationException {
        //Arrange
        // 1.
        House house = new House ("House1");
        house.getListOfRooms().addRoomToList("Room1",1,1,1,1);
        house.getListOfRooms().getRoomList().get(0).getListOfDevices().addDeviceToList("Device1", "Refrigerator", "Room");
        // 2.
        DeviceDTOMapper mapper = new DeviceDTOMapper();
        Room room = house.getListOfRooms().getRoomList().get(0);
        DeviceDTO deviceDTO = new DeviceDTO ("Device1", "Refrigerator", "Room",true);
        // 3.
        Device deviceFromDTO = mapper.dtoToDomain(room,deviceDTO);
        String expected = "Device1";
        //Act
        // 4.
        String result = deviceFromDTO.getDeviceName();
        //Assert
        assertEquals(expected,result);
    }
}