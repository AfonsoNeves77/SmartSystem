package pt.ipp.isep.dei.project.testArchive;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.project.domain.House;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SensorTypeListTest {

    @Test
    void defineSensorType_InvalidSensorType() throws InstantiationException {

        //Arrange
        House myHouse = new House("MyHouse");
        String functionality = "Temperalllture";
        int expected = 1;
        //Act

        int result = myHouse.getSensorTypeList().addSensorTypeToList(functionality);
        //Assert
        assertEquals(expected,result);
    }

    @Test
    void defineTemperatureSensorType_SuccessfullyAdded() throws InstantiationException {

        //Arrange
        House myHouse = new House("MyHouse");
        String functionality = "Temperature";
        int expected = 0;

        //Act
        int result = myHouse.getSensorTypeList().addSensorTypeToList(functionality);

        //Assert
        assertEquals(expected,result);
    }

    @Test
    void defineHumiditySensorType_SuccessfullyAdded() throws InstantiationException {

        //Arrange
        House myHouse = new House("MyHouse");
        String functionality = "Humidity";
        int expected = 0;

        //Act
        int result = myHouse.getSensorTypeList().addSensorTypeToList(functionality);

        //Assert
        assertEquals(expected,result);
    }

    @Test
    void defineSensorType_RepeatedSensorType() throws InstantiationException {

        //Arrange
        House myHouse = new House("MyHouse");
        String functionalityOne = "Humidity";
        String functionalityTwo = "Temperature";
        int expected = 2;

        //Act
        myHouse.getSensorTypeList().addSensorTypeToList(functionalityOne);
        myHouse.getSensorTypeList().addSensorTypeToList(functionalityTwo);
        int result = myHouse.getSensorTypeList().addSensorTypeToList(functionalityTwo);

        //Assert
        assertEquals(expected,result);
    }

}
