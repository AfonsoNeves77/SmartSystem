package pt.ipp.isep.dei.project.testArchive;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.project.controller.AddSensorToDeviceCTRL;
import pt.ipp.isep.dei.project.controller.CommonListOfDevices;
import pt.ipp.isep.dei.project.controller.CommonListOfRooms;
import pt.ipp.isep.dei.project.domain.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


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


    @Test
    void addSensorToDeviceIsolationTest_SuccessAdding() throws InstantiationException {

        //Arrange
        ListOfSensors listOfSensorsDouble = mock(ListOfSensors.class);
        FactorySensor factorySensor = mock(FactorySensor.class);
        String a = "param1";
        String b = "param2";
        String c = "param3";
        when(listOfSensorsDouble.addSensor(a,SensorTypeOptions.HUMIDITY,factorySensor)).thenReturn(true);
        Device device = new Device(a,b,c);

        boolean result = device.addSensor(a,SensorTypeOptions.HUMIDITY,factorySensor);

        assertTrue(result);

    }

    @Test
    void addSensorToDeviceIsolationTest_FailedAdding() throws InstantiationException {

        //Arrange
        ListOfSensors listOfSensorsDouble = mock(ListOfSensors.class);
        FactorySensor factorySensor = mock(FactorySensor.class);
        String a = "param1";
        String b = "param2";
        String c = "param3";
        when(listOfSensorsDouble.addSensor(a,SensorTypeOptions.HUMIDITY,factorySensor)).thenReturn(false);
        Device device = new Device(a,b,c);

        boolean result = device.addSensor(a,SensorTypeOptions.HUMIDITY,factorySensor);

        assertTrue(result);

    }

    @Test
    void addSensorToDeviceIsolationTest_ListOfSensors() {

        //Arrange
        FactorySensor factorySensor = mock(FactorySensor.class);
        Sensor sensor = mock(Sensor.class);
        String a = "param1";
        String b = "param2";
        String c = "param3";

        //Act

        ListOfSensors listOfSensors = new ListOfSensors();
        when(factorySensor.createSensor(a,SensorTypeOptions.HUMIDITY)).thenReturn(sensor);
        boolean result = listOfSensors.addSensor(a,SensorTypeOptions.HUMIDITY,factorySensor);

        //Assert
        assertTrue(result);

    }

    @Test
    void addSensorToDeviceIsolationTest_ListOfSensorsFailed() {

        //Arrange
        FactorySensor factorySensor = mock(FactorySensor.class);
        Sensor sensor = mock(Sensor.class);

        //Act

        ListOfSensors listOfSensors = new ListOfSensors();
        when(factorySensor.createSensor(null,SensorTypeOptions.HUMIDITY)).thenThrow(IllegalArgumentException.class);
        boolean result = listOfSensors.addSensor(null,SensorTypeOptions.HUMIDITY,factorySensor);

        //Assert
        assertFalse(result);

    }





//    private static House  myHouseDouble;
//    private static CommonListOfRooms commonRoomsDouble;
//    private static CommonListOfDevices commonDevicesDouble;
//    private static FactorySensor factorySensorDouble;
//
//
//    @BeforeAll
//
//    static void setUp(){
//
//        myHouseDouble = mock(House.class);
//        commonRoomsDouble = mock(CommonListOfRooms.class);
//        commonDevicesDouble = mock(CommonListOfDevices.class);
//        factorySensorDouble = mock(FactorySensor.class);
//    }
//
//    @Test
//
//    void getRoomsIsolationTest_Controller(){
//
//        AddSensorToDeviceCTRL addSensorToDeviceCTRL = new AddSensorToDeviceCTRL(myHouseDouble,factorySensorDouble);
//
//    }













}
