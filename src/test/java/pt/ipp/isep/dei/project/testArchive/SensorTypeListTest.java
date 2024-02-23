package pt.ipp.isep.dei.project.testArchive;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.project.domain.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class SensorTypeListTest {

//    @Test
//    void defineSensorType_InvalidSensorType() throws InstantiationException {
//
//        //Arrange
//        House myHouse = new House("MyHouse");
//        String functionality = "Temperalllture";
//        int expected = 1;
//        //Act
//
//        int result = myHouse.getSensorTypeList().addSensorTypeToList(functionality);
//        //Assert
//        assertEquals(expected,result);
//    }
//
//    @Test
//    void defineTemperatureSensorType_SuccessfullyAdded() throws InstantiationException {
//
//        //Arrange
//        House myHouse = new House("MyHouse");
//        String functionality = "Temperature";
//        int expected = 0;
//
//        //Act
//        int result = myHouse.getSensorTypeList().addSensorTypeToList(functionality);
//
//        //Assert
//        assertEquals(expected,result);
//    }
//
//    @Test
//    void defineHumiditySensorType_SuccessfullyAdded() throws InstantiationException {
//
//        //Arrange
//        House myHouse = new House("MyHouse");
//        String functionality = "Humidity";
//        int expected = 0;
//
//        //Act
//        int result = myHouse.getSensorTypeList().addSensorTypeToList(functionality);
//
//        //Assert
//        assertEquals(expected,result);
//    }
//
//    @Test
//    void defineSensorType_RepeatedSensorType() throws InstantiationException {
//
//        //Arrange
//        House myHouse = new House("MyHouse");
//        String functionalityOne = "Humidity";
//        String functionalityTwo = "Temperature";
//        int expected = 2;
//
//        //Act
//        myHouse.getSensorTypeList().addSensorTypeToList(functionalityOne);
//        myHouse.getSensorTypeList().addSensorTypeToList(functionalityTwo);
//        int result = myHouse.getSensorTypeList().addSensorTypeToList(functionalityTwo);
//
//        //Assert
//        assertEquals(expected,result);
//    }
//
//    @Test
//    void defineLocationHouse() throws InstantiationException {
//
//        //Arrange
//        House myHouse = new House("MyHouse");
//        String functionalityOne = "Humidity";
//        String functionalityTwo = "Temperature";
//        int expected = 2;
//
//        //Act
//        myHouse.getSensorTypeList().addSensorTypeToList(functionalityOne);
//        myHouse.getSensorTypeList().addSensorTypeToList(functionalityTwo);
//        int result = myHouse.getSensorTypeList().addSensorTypeToList(functionalityTwo);
//
//        //Assert
//        assertEquals(expected,result);
//    }
//
//
//    //ExperimentalTestsHouse
//
//    @Test
//    void getHouseListOfRooms() throws InstantiationException {
//
//        //Arrange
//        House myHouse = new House("MyHouse");
//        //??
//        Room room = new Room("roomName",3);
//        ArrayList<Room> roomList = new ArrayList<>();
//        roomList.add(room);
//
//
//        ListOfRooms listOfRoomsDouble = mock(ListOfRooms.class);
//
//        //Act
//        when(listOfRoomsDouble.getRoomList()).thenReturn(roomList);
//
//
//        int size = myHouse.getListOfRooms().size();
//
//        assertEquals(size,1);
//
//    }

    /*@Test
    void configureLocation() throws InstantiationException {

        //Arrange
        FactoryLocation factoryLocationDouble = mock(FactoryLocation.class);
        House myHouse = new House("MyHouse",factoryLocationDouble);
        String a = "A";
        String b = "B";
        String c = "C";
        String d = "D";
        Adress adressDouble =

        when(factoryLocationDouble.createAddress(a,b,c,d,a,b)).thenReturn()
    }*/


//    @Test
//    void configureSensor() throws InstantiationException {
//
//        //Arrange
//        FactoryListOfSensors factoryListOfSensors = mock(FactoryListOfSensors.class);
//        ListOfSensors listOfSensorsDouble = mock(ListOfSensors.class);
//
//        FactorySensor factorySensor = mock(FactorySensor.class);
//        String a = "A";
//        String b = "B";
//        String c = "C";
//        String d = "D";
//        //when(listOfSensorsDouble.addSensor(a,SensorTypeOptions.HUMIDITY,factorySensor)).thenReturn(true);
//        Device device = new Device(a,b,c,factoryListOfSensors);
//
//        boolean result = device.addSensor(a,SensorTypeOptions.HUMIDITY,factorySensor);
//
//        assertTrue(result);
//
//    }

    @Test
    void configureSensorTwo() throws InstantiationException {

        //Arrange
        FactoryListOfSensors factoryListOfSensors = mock(FactoryListOfSensors.class);
        ListOfSensors listOfSensorsDouble = mock(ListOfSensors.class);

        FactorySensor factorySensor = mock(FactorySensor.class);
        String a = "A";
        String b = "B";
        String c = "C";

        //Act
        //when(factoryListOfSensors.createListOfSensorsObject()).thenReturn(listOfSensorsDouble);
        when(listOfSensorsDouble.addSensor(a,SensorTypeOptions.HUMIDITY,factorySensor)).thenReturn(true);
        Device device = new Device(a,b,c,factoryListOfSensors);

        boolean result = device.addSensor(a,SensorTypeOptions.HUMIDITY,factorySensor);


        //Assert
        assertTrue(result);

    }


//    @Test
//    void addSensorIsolationTest() throws InstantiationException {
//        //Arrange
//        String sensorName = "Sensor 1";
//        SensorTypeOptions sensorType = SensorTypeOptions.TEMPERATURE;
//        Device device = new Device("Name","Model","RoomK",factorySensorDouble);
//        ListOfSensors listOfSensorsDouble = device.getListOfSensors();
//        listOfSensorsDouble = mock(ListOfSensors.class);
//        //Act
//        when(listOfSensorsDouble.addSensor(sensorName,sensorType,factorySensorDouble)).thenReturn(true);
//        boolean result = device.addSensor(sensorName,sensorTypeTwo,factorySensorDouble);
//        //Assert
//        assertTrue(result);
//    }



    @Test
    void addSensorIsolationTest() throws InstantiationException {
        //Arrange
        String sensorName = "Sensor 1";
        SensorTypeOptions sensorType = SensorTypeOptions.TEMPERATURE;
        FactorySensor factorySensorDouble = mock(FactorySensor.class);
        Device device = new Device("Name","Model","RoomK");

        ListOfSensors listOfSensorsDouble = mock(ListOfSensors.class);
        //Act
        when(listOfSensorsDouble.addSensor(sensorName,sensorType,factorySensorDouble)).thenReturn(true);
        boolean result = device.addSensor(sensorName,sensorType,factorySensorDouble);
        //Assert
        assertTrue(result);
    }










}
