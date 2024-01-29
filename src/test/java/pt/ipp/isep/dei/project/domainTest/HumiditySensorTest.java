package pt.ipp.isep.dei.project.domainTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.project.domain.HumiditySensor;
import pt.ipp.isep.dei.project.domain.SensorTypeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumiditySensorTest {

    /**
     * Test01 case to ensure that a HumiditySensor can be created successfully.
     *
     * @throws InstantiationException if there is an issue with instantiating the HumiditySensor.
     */
    @Test
    void creatingHumiditySensor() throws InstantiationException {
        //Arrange
        String sensorName = "Sensor";
        HumiditySensor humiditySensor = new HumiditySensor(sensorName);
        //Act
        String result = humiditySensor.getName();
        //Assert
        assertEquals(sensorName,result);

    }

    /**
     * Test02 case to ensure that the getLastReading method returns the last recorded humidity reading.
     *
     * @throws InstantiationException if there is an issue with instantiating the HumiditySensor.
     */
    @Test
    void humiditySensor_GetLastReading() throws InstantiationException {
        //Arrange
        String sensorName = "Sensor";
        HumiditySensor humiditySensor = new HumiditySensor(sensorName);
        double outsideReading = 60.4;
        humiditySensor.continuousMeasure(outsideReading);

        String expected = String.valueOf(outsideReading);

        //Act
        String result = humiditySensor.getLastReading();

        //Assert
        assertEquals(expected,result);

    }

    /**
     * Test03 case to ensure that an invalid reading is registered in the log.
     *
     * @throws InstantiationException if there is an issue with instantiating the HumiditySensor.
     */
    @Test
    void humiditySensor_invalidReadingRegisteredInLog() throws InstantiationException {
        //Arrange
        String sensorName = "Sensor";
        HumiditySensor humiditySensor = new HumiditySensor(sensorName);
        double outsideReading = 0;
        humiditySensor.continuousMeasure(outsideReading);
        String expected = "Error";

        //Act
        String result = humiditySensor.getLog().get(0);

        //Assert
        assertEquals(expected,result);

    }

    /**
     * Test04 case to ensure that a valid reading is registered in the log.
     *
     * @throws InstantiationException if there is an issue with instantiating the HumiditySensor.
     */
    @Test
    void humiditySensor_validReadingRegisteredInLog() throws InstantiationException {
        //Arrange
        String sensorName = "Sensor";
        HumiditySensor humiditySensor = new HumiditySensor(sensorName);
        double outsideReading = 100;
        humiditySensor.continuousMeasure(outsideReading);
        String expected = "100.0";

        //Act
        String result = humiditySensor.getLog().get(0);

        //Assert
        assertEquals(expected,result);

    }

    /**
     * Test05 case to ensure that the getSensorType method returns the correct sensor type.
     *
     * @throws InstantiationException if there is an issue with instantiating the HumiditySensor.
     */
    @Test
    void humiditySensor_getSensorType() throws InstantiationException {
        //Arrange
        String sensorName = "Sensor";
        HumiditySensor humiditySensor = new HumiditySensor(sensorName);
        SensorTypeOptions expected = SensorTypeOptions.HUMIDITY;

        //Act
        SensorTypeOptions result = humiditySensor.getType();

        //Assert
        assertEquals(expected,result);

    }


}
