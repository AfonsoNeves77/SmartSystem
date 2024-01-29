package pt.ipp.isep.dei.project.testArchive;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.project.archive.DefineSensorTypeCTRL;
import pt.ipp.isep.dei.project.domain.House;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefineSensorTypeCTRLTest {

    @Test
    void defineSensorTypeController_SuccessfulOperation() throws InstantiationException {

        //Arrange
        House myHouse = new House("MyHouse");
        String functionality = "Temperature";
        DefineSensorTypeCTRL controller = new DefineSensorTypeCTRL(myHouse);
        int expected = 0;

        //Act
        int result = controller.defineSensorType(functionality);

        //Assert
        assertEquals(expected,result);
    }

    @Test
    void defineSensorTypeController_InvalidSensorType() throws InstantiationException {

        //Arrange
        House myHouse = new House("MyHouse");
        String functionality = "Temperakkture";
        DefineSensorTypeCTRL controller = new DefineSensorTypeCTRL(myHouse);
        int expected = 1;

        //Act
        int result = controller.defineSensorType(functionality);

        //Assert
        assertEquals(expected,result);
    }

    @Test
    void defineSensorTypeController_RepeatedSensorType() throws InstantiationException {

        //Arrange
        House myHouse = new House("MyHouse");
        String functionality = "Temperature";
        DefineSensorTypeCTRL controller = new DefineSensorTypeCTRL(myHouse);
        int expected = 2;

        //Act
        controller.defineSensorType(functionality);
        int result = controller.defineSensorType(functionality);

        //Assert
        assertEquals(expected,result);
    }




}
