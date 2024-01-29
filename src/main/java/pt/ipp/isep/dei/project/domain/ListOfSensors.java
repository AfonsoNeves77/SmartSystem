package pt.ipp.isep.dei.project.domain;

import java.util.ArrayList;

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

    private Sensor createSensor(String sensorName,SensorTypeOptions sensorType) throws InstantiationException {
       if(sensorType.equals(SensorTypeOptions.HUMIDITY)){
           return new HumiditySensor(sensorName);
       }else {
           return new TemperatureSensor(sensorName);
       }
    }

    /**
     * Adds a new sensor to the list.
     *
     * @param sensorName The name of the sensor to be added.
     * @param sensorType The type of the sensor to be added.
     * @return 0 on successful addition, 1 if instantiation error, 2 if the sensor already exists.
     */

    public int addSensor(String sensorName, SensorTypeOptions sensorType){
        if(isSensorInList(sensorName)) {
            return 2;
        }
        try{
            Sensor newSensor = createSensor(sensorName,sensorType);
            listOfSensors.add(newSensor);
            return 0;
        } catch (InstantiationException e) {
            return 1;
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

    public ArrayList<Sensor> getListOfSensors() {
        return listOfSensors;
    }
}
