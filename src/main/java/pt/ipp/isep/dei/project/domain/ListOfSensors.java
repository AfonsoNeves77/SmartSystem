package pt.ipp.isep.dei.project.domain;

import java.util.ArrayList;
import java.util.List;

public class ListOfSensors {

    /**
     * Represents a collection of sensors in a device.
     */

    private ArrayList<Sensor> listOfSensors;

    /**
     * Constructs an empty list of sensors.
     */

    public ListOfSensors(){
        listOfSensors = new ArrayList<>();
    }

    /**
     * Creates a new sensor based on the given name and type.
     *
     * @param sensorName The name of the sensor.
     * @param sensorType The type of the sensor.
     * @return           The newly created Sensor object.
     * @throws InstantiationException If an error occurs during sensor instantiation.
     */

    public boolean addSensor(String sensorName, SensorTypeOptions sensorType,FactorySensor factorySensor){
        if(isSensorInList(sensorName)) {
            return false;
        }
        try{
            Sensor newSensor = factorySensor.createSensor(sensorName,sensorType);
            listOfSensors.add(newSensor);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }

    }

    /**
     * Checks if a sensor with the given name already exists in the list.
     *
     * @param sensorName The name of the sensor to check.
     * @return True if the sensor exists, false otherwise.
     */

    private boolean isSensorInList(String sensorName){
        for (Sensor singleSensor : listOfSensors){
            if(singleSensor.getName().equals(sensorName)){
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves the list of sensors.
     *
     * @return The list of sensors.
     */

    public List<Sensor> getListOfSensors() {
        return new ArrayList<>(listOfSensors);
    }
}
