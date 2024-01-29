package pt.ipp.isep.dei.project.controllerTest;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.project.DTO.DeviceDTO;
import pt.ipp.isep.dei.project.DTO.RoomDTO;
import pt.ipp.isep.dei.project.controller.AddDeviceToRoomCTRL;
import pt.ipp.isep.dei.project.controller.AddRoomCTRL;
import pt.ipp.isep.dei.project.controller.AddSensorToDeviceCTRL;
import pt.ipp.isep.dei.project.controller.GetDevicesByFunctionalityCTRL;
import pt.ipp.isep.dei.project.domain.House;
import pt.ipp.isep.dei.project.domain.SensorTypeOptions;
import static org.junit.jupiter.api.Assertions.*;

class GetDevicesByFunctionalityCTRLTest {
    /**
     * Test01 - Returns a HashMap with device functionalities as keys, and DeviceDTOs as values.
     * 1. Add rooms to the house
     * 2. Add devices to the rooms
     * 3. Add sensors to the devices
     * 4. Expected result when searching for a chosen device name in the HashMap
     * 5. Gets the device's name
     * @throws InstantiationException On house and device creation, if parameters invalid
     */
    @Test
    void listDevicesByFunctionality_checksSpecificDevice() throws InstantiationException {
        //Arrange
        House myHouse = new House("House Test");
        // 1.
        AddRoomCTRL roomCTRL = new AddRoomCTRL(myHouse);;
        RoomDTO room1 = new RoomDTO("Kitchen",1,4,5,2);
        RoomDTO room2 = new RoomDTO("Guest bedroom",2,8,10,2);
        roomCTRL.addRoom(room1); roomCTRL.addRoom(room2);

        // 2.
        AddDeviceToRoomCTRL deviceCTRL = new AddDeviceToRoomCTRL(myHouse);
        deviceCTRL.addDeviceToRoom(room1,"Hairdryer H1","BabyBlissPro");
        deviceCTRL.addDeviceToRoom(room2,"Dehumidifier D1","Bosch");

        // 3.
        AddSensorToDeviceCTRL sensorCTRL = new AddSensorToDeviceCTRL(myHouse);
        DeviceDTO device1 = new DeviceDTO("Hairdryer H1","BabyBlissPro","Bathroom 1",true);
        DeviceDTO device2 = new DeviceDTO("Dehumidifier D1","Bosch","Guest bedroom",false);
        sensorCTRL.addSensorToDevice(room1,device1,"Temp1",SensorTypeOptions.TEMPERATURE);
        sensorCTRL.addSensorToDevice(room1,device1,"Temp2",SensorTypeOptions.TEMPERATURE);
        sensorCTRL.addSensorToDevice(room1,device1,"Hum1", SensorTypeOptions.HUMIDITY);

        sensorCTRL.addSensorToDevice(room2,device2,"Temp1",SensorTypeOptions.TEMPERATURE);
        sensorCTRL.addSensorToDevice(room2,device2,"Temp1",SensorTypeOptions.TEMPERATURE);
        sensorCTRL.addSensorToDevice(room2,device2,"Hum1", SensorTypeOptions.HUMIDITY);

        // 4.
        String expected = "Dehumidifier D1";

        //Act
        // 5.
        GetDevicesByFunctionalityCTRL deviceCtrl = new GetDevicesByFunctionalityCTRL(myHouse);
        String result = deviceCtrl.getDevicesByFunctionality().get("HUMIDITY").get(1).getName();
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test02 - Returns a HashMap with device functionalities as keys, and DeviceDTOs as values.
     * 1. Add rooms to the house
     * 2. Add devices to the rooms
     * 3. Add sensors to the devices
     * 4. Expected result of the size of a chosen list of Devices, associated to a functionality
     * (multiple temperature sensors were added to the same device)
     * 5. Gets the size of the chosen device list
     * @throws InstantiationException On house and device creation, if parameters invalid
     */
    @Test
    void listDevicesByFunctionality_checksSize() throws InstantiationException {
        //Arrange
        House myHouse = new House("House Test");
        // 1.
        AddRoomCTRL roomCTRL = new AddRoomCTRL(myHouse);;
        RoomDTO room1 = new RoomDTO("Kitchen",1,4,5,2);
        RoomDTO room2 = new RoomDTO("Guest bedroom",2,8,10,2);
        roomCTRL.addRoom(room1); roomCTRL.addRoom(room2);

        // 2.
        AddDeviceToRoomCTRL deviceCTRL = new AddDeviceToRoomCTRL(myHouse);
        deviceCTRL.addDeviceToRoom(room1,"Hairdryer H1","BabyBlissPro");
        deviceCTRL.addDeviceToRoom(room2,"Dehumidifier D1","Bosch");

        // 3.
        AddSensorToDeviceCTRL sensorCTRL = new AddSensorToDeviceCTRL(myHouse);
        DeviceDTO device1 = new DeviceDTO("Hairdryer H1","BabyBlissPro","Bathroom 1",true);
        DeviceDTO device2 = new DeviceDTO("Dehumidifier D1","Bosch","Guest bedroom",false);
        sensorCTRL.addSensorToDevice(room1,device1,"Temp1", SensorTypeOptions.TEMPERATURE);
        sensorCTRL.addSensorToDevice(room1,device1,"Temp2",SensorTypeOptions.TEMPERATURE);
        sensorCTRL.addSensorToDevice(room1,device1,"Hum1", SensorTypeOptions.HUMIDITY);

        sensorCTRL.addSensorToDevice(room2,device2,"Temp1",SensorTypeOptions.TEMPERATURE);
        sensorCTRL.addSensorToDevice(room2,device2,"Temp1",SensorTypeOptions.TEMPERATURE);
        sensorCTRL.addSensorToDevice(room2,device2,"Hum1", SensorTypeOptions.HUMIDITY);

        // 4.
        int expected = 2;

        //Act
        // 5.
        GetDevicesByFunctionalityCTRL deviceCtrl = new GetDevicesByFunctionalityCTRL(myHouse);
        int result = deviceCtrl.getDevicesByFunctionality().get("TEMPERATURE").size();

        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test03 - Returns a HashMap with device functionalities as keys, and DeviceDTOs as values.
     * 1. Add rooms to the house
     * 2. Add devices to the rooms
     * 3. Add sensors to the devices
     * 4. Expected result of the room name (device location) of a chosen device
     * 5. Gets the location from the device
     * @throws InstantiationException On house and device creation, if parameters invalid
     */
    @Test
    void listDevicesByFunctionality_GetsLocation() throws InstantiationException {
        //Arrange
        House myHouse = new House("House Test");
        // 1.
        AddRoomCTRL roomCTRL = new AddRoomCTRL(myHouse);;
        RoomDTO room1 = new RoomDTO("Kitchen",1,4,5,2);
        RoomDTO room2 = new RoomDTO("Guest bedroom",2,8,10,2);
        roomCTRL.addRoom(room1); roomCTRL.addRoom(room2);

        // 2.
        AddDeviceToRoomCTRL deviceCTRL = new AddDeviceToRoomCTRL(myHouse);
        deviceCTRL.addDeviceToRoom(room1,"Hairdryer H1","BabyBlissPro");
        deviceCTRL.addDeviceToRoom(room2,"Dehumidifier D1","Bosch");

        // 3.
        AddSensorToDeviceCTRL sensorCTRL = new AddSensorToDeviceCTRL(myHouse);
        DeviceDTO device1 = new DeviceDTO("Hairdryer H1","BabyBlissPro","Bathroom 1",true);
        DeviceDTO device2 = new DeviceDTO("Dehumidifier D1","Bosch","Guest bedroom",false);
        sensorCTRL.addSensorToDevice(room1,device1,"Temp1",SensorTypeOptions.TEMPERATURE);
        sensorCTRL.addSensorToDevice(room1,device1,"Temp2",SensorTypeOptions.TEMPERATURE);
        sensorCTRL.addSensorToDevice(room1,device1,"Hum1", SensorTypeOptions.HUMIDITY);

        sensorCTRL.addSensorToDevice(room2,device2,"Temp1",SensorTypeOptions.TEMPERATURE);
        sensorCTRL.addSensorToDevice(room2,device2,"Temp1",SensorTypeOptions.TEMPERATURE);
        sensorCTRL.addSensorToDevice(room2,device2,"Hum1", SensorTypeOptions.HUMIDITY);

        // 4.
        String expected = "Guest bedroom";

        //Act
        // 5.
        GetDevicesByFunctionalityCTRL deviceCtrl = new GetDevicesByFunctionalityCTRL(myHouse);
        String result = deviceCtrl.getDevicesByFunctionality().get("TEMPERATURE").get(1).getLocation();
        //Assert
        assertEquals(expected,result);
    }
}