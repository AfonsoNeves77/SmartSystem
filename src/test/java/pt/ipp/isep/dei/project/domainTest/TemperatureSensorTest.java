package pt.ipp.isep.dei.project.domainTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.project.domain.SensorTypeOptions;
import pt.ipp.isep.dei.project.domain.TemperatureSensor;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemperatureSensorTest {

    /**
     * Test 01 - Tests creating a TemperatureSensor object.
    */
    @Test
    void creatingTemperatureSensor() throws InstantiationException {
        //Arrange
        String sensorName = "Sensor";
        TemperatureSensor humiditySensor = new TemperatureSensor(sensorName);
        //Act
        String result = humiditySensor.getName();
        //Assert
        assertEquals(sensorName,result);

    }

    /**
     * Test 02 - Tests retrieving the last measured temperature reading for a TemperatureSensor.
     */
    @Test
    void temperatureSensor_GetLastReading() throws InstantiationException {
        //Arrange
        String sensorName = "Sensor";
        TemperatureSensor temperatureSensor = new TemperatureSensor(sensorName);
        double outsideReading = 20.4;
        temperatureSensor.continuousMeasure(outsideReading);

        String expected = String.valueOf(outsideReading);

        //Act
        String result = temperatureSensor.getLastReading();

        //Assert
        assertEquals(expected,result);

    }

    /**
     * Test 03 - Tests adding a valid temperature reading to the log of a TemperatureSensor.
     */
    @Test
    void humiditySensor_validReadingRegisteredInLog() throws InstantiationException {
        //Arrange
        String sensorName = "Sensor";
        TemperatureSensor temperatureSensor = new TemperatureSensor(sensorName);
        double outsideReading = 20;
        temperatureSensor.continuousMeasure(outsideReading);
        String expected = "20.0";

        //Act
        String result = temperatureSensor.getLog().get(0);

        //Assert
        assertEquals(expected,result);

    }

    /**
     * Test 04 - Tests getting the name of a TemperatureSensor.
     */
    @Test
    void getNameOfASensor() throws InstantiationException {
        //Arrange
        String sensorName = "Sensor";
        TemperatureSensor temperatureSensor = new TemperatureSensor(sensorName);

        //Act
        String result = temperatureSensor.getName();

        //Assert
        assertEquals(sensorName,result);

    }
    /**
     * Test 05 - Tests getting the sensor type of a TemperatureSensor.
     */
    @Test
    void temperatureSensor_getSensorType() throws InstantiationException {
        //Arrange
        String sensorName = "Sensor";
        TemperatureSensor temperatureSensor = new TemperatureSensor(sensorName);
        SensorTypeOptions expected = SensorTypeOptions.TEMPERATURE;

        //Act
        SensorTypeOptions result = temperatureSensor.getType();

        //Assert
        assertEquals(expected,result);

    }


}
