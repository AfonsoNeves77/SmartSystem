package pt.ipp.isep.dei.project.domainTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.project.domain.ListOfSensors;
import pt.ipp.isep.dei.project.domain.Sensor;
import pt.ipp.isep.dei.project.domain.SensorTypeOptions;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListOfSensorsTest {

    /**
     * Test case for successfully adding a temperature sensor to the list of sensors.
     */
    @Test
    void addTemperatureSensorToDevice_Success(){
        //Arrange
        String sensorName = "Sensor 1";
        SensorTypeOptions sensorType = SensorTypeOptions.TEMPERATURE;
        int expected = 0;
        //Act
        ListOfSensors listOfSensorsObj = new ListOfSensors();
        int result = listOfSensorsObj.addSensor(sensorName,sensorType);
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test case for successfully adding a humidity sensor to the list of sensors.
     */

    @Test
    void addHumiditySensorToDevice_Success(){
        //Arrange
        String sensorName = "Sensor 1";
        SensorTypeOptions sensorType = SensorTypeOptions.HUMIDITY;
        int expected = 0;
        //Act
        ListOfSensors listOfSensorsObj = new ListOfSensors();
        int result = listOfSensorsObj.addSensor(sensorName,sensorType);
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test case for attempting to add a sensor with invalid data to the list of sensors.
     */

    @Test
    void addSensorToDevice_InvalidData(){
        //Arrange
        String sensorName = "";
        SensorTypeOptions sensorType = SensorTypeOptions.HUMIDITY;
        int expected = 1;
        //Act
        ListOfSensors listOfSensorsObj = new ListOfSensors();
        int result = listOfSensorsObj.addSensor(sensorName,sensorType);
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test case for attempting to add a duplicated sensor to the list of sensors.
     */

    @Test
    void addSensorToDevice_DuplicatedSensor(){
        //Arrange
        String sensorName = "Sensor 1";
        SensorTypeOptions sensorType = SensorTypeOptions.TEMPERATURE;
        SensorTypeOptions sensorTypeTwo = SensorTypeOptions.HUMIDITY;
        int expected = 2;
        //Act
        ListOfSensors listOfSensorsObj = new ListOfSensors();
        listOfSensorsObj.addSensor(sensorName,sensorType);
        int result = listOfSensorsObj.addSensor(sensorName,sensorTypeTwo);
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test case for retrieving the list of sensors.
     */

    @Test
    void getListOfSensors(){
        //Arrange
        String sensorName = "Sensor 1";
        String sensorNameTwo = "Sensor 2";
        SensorTypeOptions sensorType = SensorTypeOptions.TEMPERATURE;
        SensorTypeOptions sensorTypeTwo = SensorTypeOptions.HUMIDITY;
        ListOfSensors listOfSensorsObj = new ListOfSensors();
        listOfSensorsObj.addSensor(sensorName,sensorType);
        listOfSensorsObj.addSensor(sensorNameTwo,sensorTypeTwo);
        //Act
        ArrayList<Sensor> listOfSensors = listOfSensorsObj.getListOfSensors();
        String result = listOfSensors.get(1).getName();
        //Assert
        assertEquals(sensorNameTwo,result);
    }

}
