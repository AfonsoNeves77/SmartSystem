package pt.ipp.isep.dei.project.archive;

import pt.ipp.isep.dei.project.domain.House;

/**
 * This controller´s function is to define a sensor type, adding it to the list of sensor types of the house.
 */

public class DefineSensorTypeCTRL {

    private House house;
    public DefineSensorTypeCTRL(House house){
        this.house = house;
    }

    /**
     * This method calls a method in domain that is responsible for the addition of a sensorType to the sensor type list, it confirms 3 scenarios:
     * (i) SensorType does not yet exist in the list and is successfully added, returns 0,
     * (ii) SensorType already exists in the list and can´t be added returns 2;
     * (ii) SensorType is not supported by the system, and it returns 1;
     * @param  sensorType
     * @return int
     */

    public int defineSensorType(String sensorType){
        return house.getSensorTypeList().addSensorTypeToList(sensorType);
    }


}
