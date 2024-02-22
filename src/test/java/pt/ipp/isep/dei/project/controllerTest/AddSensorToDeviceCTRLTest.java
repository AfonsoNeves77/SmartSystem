package pt.ipp.isep.dei.project.controllerTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.project.DTO.DeviceDTO;
import pt.ipp.isep.dei.project.DTO.RoomDTO;
import pt.ipp.isep.dei.project.controller.AddSensorToDeviceCTRL;
import pt.ipp.isep.dei.project.domain.House;
import pt.ipp.isep.dei.project.domain.Room;
import pt.ipp.isep.dei.project.domain.SensorTypeOptions;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AddSensorToDeviceCTRLTest {

    /**
     * Test case for verifying the retrieval of RoomDTO instances.
     * 1 - Defining variables necessary to add a room;
     * 2 - Add a room to list with previously defined variables;
     * 3 - Instantiate controller responsible for adding a sensor to a device functionality;
     * 4 - Access room name of the room (previously added) by retrieving the house´s list of rooms;
     *
     * @throws InstantiationException If an error occurs during object instantiation.
     */

    @Test
    void getListOfRoomsDTO() throws InstantiationException {
        //Arrange
        //1.
        House myHouse = new House("MyHouse");
        String name = "Room 0";
        int floor = 0;
        double width = 4;
        double length = 9;
        double height = 2;
        //2.
        myHouse.addRoom(name, floor, width, length, height);

        //Act

        //3.
        AddSensorToDeviceCTRL addSensorCtrl = new AddSensorToDeviceCTRL(myHouse);
        //4.
        String resultName = addSensorCtrl.getRooms().get(0).getRoomName();
        //Assert
        assertEquals(name, resultName);
    }



    /**
     * Test case for verifying the retrieval of DevicesDTO instances.
     * 1 - Defining variables necessary to add a Room and to add a Device;
     * 2 - Add a room to list with previously defined variables;
     * 3 - Add a device to list with previously defined variables;
     * 4 - Instantiate controller responsible for adding a sensor to a device functionality;
     * 5 - Access device name of the specified room list;
     * @throws InstantiationException If an error occurs during object instantiation.
     */

    @Test
    void getListOfDevicesDTOInARoom() throws InstantiationException {
        //Arrange

        //1.
        House myHouse = new House("MyHouse");
        String name = "Room 0";
        int floor = 0;
        double width = 4;
        double length = 9;
        double height = 2;
        String deviceName = "Heater";
        String model = "XO-99";

        //2.
        myHouse.getListOfRooms().addRoomToList(name,floor,width,length,height);
        Room room = myHouse.getListOfRooms().getRoomList().get(0);
        //3.
        room.getListOfDevices().addDeviceToList(deviceName,model,name);

        //Act
        RoomDTO roomDTO = new RoomDTO(name,floor,width,length,height);
        //4.
        AddSensorToDeviceCTRL addSensorCtrl = new AddSensorToDeviceCTRL(myHouse);
        //5.
        String resultName = addSensorCtrl.listOfDevicesInARoom(roomDTO).get(0).getName();
        //Assert
        assertEquals(deviceName,resultName);
    }

    /**
     * Test case for retrieving the list of devices in a room with an invalid roomDto name.
     * By invalid, we mean, no match between roomDto and previously added Room object;
     * @throws InstantiationException If an error occurs during object instantiation.
     */

    @Test
    void getListOfDevicesDTOInARoom_InvalidRoom() throws InstantiationException {
        //Arrange
        House myHouse = new House("MyHouse");
        String name = "Room 0";
        int floor = 0;
        double width = 4;
        double length = 9;
        double height = 2;
        String deviceName = "Heater";
        String model = "XO-99";
        myHouse.getListOfRooms().addRoomToList(name,floor,width,length,height);
        Room room = myHouse.getListOfRooms().getRoomList().get(0);
        room.getListOfDevices().addDeviceToList(deviceName,model,name);

        //Act
        RoomDTO roomDTO = new RoomDTO("WrongName",floor,width,length,height);
        AddSensorToDeviceCTRL addSensorCtrl = new AddSensorToDeviceCTRL(myHouse);
        //Assert
        assertNull(addSensorCtrl.listOfDevicesInARoom(roomDTO));
    }

    /**
     * Test case for retrieving the list of available sensor types.
     * 1 - Instantiate de controller responsible for adding sensor to a device;
     * 2 - Access the list of available types of sensor from controller object;
     * 3 - Access the first type of sensor from the previous accessed list
     * @throws InstantiationException If an error occurs during object instantiation.
     */

    @Test
    void getListOfAvailableSensorTypes() throws InstantiationException {
        //Arrange
        House myHouse = new House("MyHouse");
        //1.
        AddSensorToDeviceCTRL addSensorToDeviceCTRL = new AddSensorToDeviceCTRL(myHouse);
        //Act

        //2.
        ArrayList<SensorTypeOptions> listOfSensorTypes = addSensorToDeviceCTRL.getAvailableSensorTypes();
        //3.
        SensorTypeOptions humidity = listOfSensorTypes.get(0);
        //Assert
        assertEquals(SensorTypeOptions.HUMIDITY,humidity);
    }

    /**
     * Test case for successfully adding a temperature sensor to a device.
     * 1 - Defining variables necessary to add a Room and to add a Device;
     * 2 - Add a room to list with previously defined variables;
     * 3 - Add a device to list with previously defined variables;
     * 4 - Instantiate controller responsible for adding a sensor to a device functionality;
     * 5 - Add sensor to a device and store the result of that operation;
     * @throws InstantiationException If an error occurs during object instantiation.
     */


    @Test
    void addTemperatureSensorToDevice_Success() throws InstantiationException {
        //Arrange

        //1.
        House myHouse = new House("MyHouse");
        String name = "Room 0";
        int floor = 0;
        double width = 4;
        double length = 9;
        double height = 2;
        String deviceName = "Heater";
        String model = "XO-99";
        String location = "Living Room";
        boolean status = true;


        String sensorName = "nameSensor";
        SensorTypeOptions temperature = SensorTypeOptions.TEMPERATURE;

        //2.
        myHouse.getListOfRooms().addRoomToList(name,floor,width,length,height);
        Room room = myHouse.getListOfRooms().getRoomList().get(0);

        //3.
        room.getListOfDevices().addDeviceToList(deviceName,model,name);
        int expected = 0;

        //Act
        RoomDTO roomDTO = new RoomDTO(name,floor,width,length,height);
        DeviceDTO deviceDTO = new DeviceDTO(deviceName,model,location,status);
        //4.
        AddSensorToDeviceCTRL addSensorCtrl = new AddSensorToDeviceCTRL(myHouse);
        //5.
        int result = addSensorCtrl.addSensorToDevice(roomDTO,deviceDTO,sensorName,temperature);
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test case for successfully adding a humidity sensor to a device.
     * @throws InstantiationException If an error occurs during object instantiation.
     */

    @Test
    void addHumiditySensorToDevice_Success() throws InstantiationException {
        //Arrange
        House myHouse = new House("MyHouse");
        String name = "Room 0";
        int floor = 0;
        double width = 4;
        double length = 9;
        double height = 2;
        String deviceName = "Heater";
        String model = "XO-99";
        String location = "Kitchen";
        boolean status = true;


        String sensorName = "nameSensor";
        SensorTypeOptions humidity = SensorTypeOptions.HUMIDITY;
        myHouse.getListOfRooms().addRoomToList(name,floor,width,length,height);
        Room room = myHouse.getListOfRooms().getRoomList().get(0);
        room.getListOfDevices().addDeviceToList(deviceName,model,name);
        int expected = 0;


        //Act
        RoomDTO roomDTO = new RoomDTO(name,floor,width,length,height);
        DeviceDTO deviceDTO = new DeviceDTO(deviceName,model,location,status);
        AddSensorToDeviceCTRL addSensorCtrl = new AddSensorToDeviceCTRL(myHouse);
        int result = addSensorCtrl.addSensorToDevice(roomDTO,deviceDTO,sensorName,humidity);
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test case for attempting to add a sensor to an invalid room.
     *
     * @throws InstantiationException If an error occurs during object instantiation.
     */

    @Test
    void addSensorToDevice_InvalidRoom() throws InstantiationException {
        //Arrange
        House myHouse = new House("MyHouse");
        String name = "Room 0";
        int floor = 0;
        double width = 4;
        double length = 9;
        double height = 2;
        String deviceName = "Heater";
        String model = "XO-99";
        String location = "Kitchen";
        boolean status = true;

        String sensorName = "nameSensor";
        SensorTypeOptions temperature = SensorTypeOptions.TEMPERATURE;
        myHouse.getListOfRooms().addRoomToList(name,floor,width,length,height);
        Room room = myHouse.getListOfRooms().getRoomList().get(0);
        room.getListOfDevices().addDeviceToList(deviceName,model,name);
        int expected = 3;


        //Act
        RoomDTO roomDTO = new RoomDTO("WrongName",floor,width,length,height);
        DeviceDTO deviceDTO = new DeviceDTO(deviceName,model,location,status);
        AddSensorToDeviceCTRL addSensorCtrl = new AddSensorToDeviceCTRL(myHouse);
        int result = addSensorCtrl.addSensorToDevice(roomDTO,deviceDTO,sensorName,temperature);
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test case for attempting to add a sensor to an invalid device.
     *
     * @throws InstantiationException If an error occurs during object instantiation.
     */

    @Test
    void addSensorToDevice_InvalidDevice() throws InstantiationException {
        //Arrange
        House myHouse = new House("MyHouse");
        String name = "Room 0";
        int floor = 0;
        double width = 4;
        double length = 9;
        double height = 2;
        String deviceName = "Heater";
        String model = "XO-99";
        String location = "Kitchen";
        boolean status = true;
        String sensorName = "nameSensor";
        SensorTypeOptions temperature = SensorTypeOptions.TEMPERATURE;
        myHouse.getListOfRooms().addRoomToList(name,floor,width,length,height);
        Room room = myHouse.getListOfRooms().getRoomList().get(0);
        room.getListOfDevices().addDeviceToList(deviceName,model,name);
        int expected = 3;


        //Act
        RoomDTO roomDTO = new RoomDTO(name,floor,width,length,height);
        DeviceDTO deviceDTO = new DeviceDTO("WrongName",model,location,status);
        AddSensorToDeviceCTRL addSensorCtrl = new AddSensorToDeviceCTRL(myHouse);
        int result = addSensorCtrl.addSensorToDevice(roomDTO,deviceDTO,sensorName,temperature);
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test case for attempting to add a sensor with invalid data, to a device.
     *
     * @throws InstantiationException If an error occurs during object instantiation.
     */

    @Test
    void addSensorToDevice_InvalidSensorData() throws InstantiationException {
        //Arrange
        House myHouse = new House("MyHouse");
        String name = "Room 0";
        int floor = 0;
        double width = 4;
        double length = 9;
        double height = 2;
        String deviceName = "Heater";
        String model = "XO-99";
        String location = "Kitchen";
        boolean status = true;
        String sensorName = "";
        SensorTypeOptions temperature = SensorTypeOptions.TEMPERATURE;
        myHouse.getListOfRooms().addRoomToList(name,floor,width,length,height);
        Room room = myHouse.getListOfRooms().getRoomList().get(0);
        room.getListOfDevices().addDeviceToList(deviceName,model,name);
        int expected = 1;


        //Act
        RoomDTO roomDTO = new RoomDTO(name,floor,width,length,height);
        DeviceDTO deviceDTO = new DeviceDTO(deviceName,model,location,status);
        AddSensorToDeviceCTRL addSensorCtrl = new AddSensorToDeviceCTRL(myHouse);
        int result = addSensorCtrl.addSensorToDevice(roomDTO,deviceDTO,sensorName,temperature);
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test case for attempting to add a duplicated sensor, to a device.
     *
     * @throws InstantiationException If an error occurs during object instantiation.
     */

    @Test
    void addSensorToDevice_duplicatedSensor() throws InstantiationException {
        //Arrange
        House myHouse = new House("MyHouse");
        String name = "Room 0";
        int floor = 0;
        double width = 4;
        double length = 9;
        double height = 2;
        String deviceName = "Heater";
        String model = "XO-99";
        String location = "Kitchen";
        boolean status = true;
        String sensorName = "sensorName";
        SensorTypeOptions temperature = SensorTypeOptions.TEMPERATURE;
        myHouse.getListOfRooms().addRoomToList(name,floor,width,length,height);
        Room room = myHouse.getListOfRooms().getRoomList().get(0);
        room.getListOfDevices().addDeviceToList(deviceName,model,name);
        int expected = 2;


        //Act
        RoomDTO roomDTO = new RoomDTO(name,floor,width,length,height);
        DeviceDTO deviceDTO = new DeviceDTO(deviceName,model,location,status);
        AddSensorToDeviceCTRL addSensorCtrl = new AddSensorToDeviceCTRL(myHouse);
        addSensorCtrl.addSensorToDevice(roomDTO,deviceDTO,sensorName,temperature);
        int result = addSensorCtrl.addSensorToDevice(roomDTO,deviceDTO,sensorName,temperature);
        //Assert
        assertEquals(expected,result);
    }
}
