package pt.ipp.isep.dei.project.archive;

import pt.ipp.isep.dei.project.domain.SensorTypeOptions;

import java.util.ArrayList;

public class SensorTypeList {

    /**
     * This class registers all the sensor types available in the house and that are
     * supported by the system
     * It contains all methods necessary to add the different types of Sensor.
     */
    private ArrayList<String> sensorTypeList;

    public SensorTypeList(){
        sensorTypeList = new ArrayList<>();
    }


    /**
     * This method adds a sensorType to the sensor type list, it confirms 3 scenarios:
     * (i) SensorType does not yet exist in the list and is successfully added, returns 0,
     * (ii) SensorType already exists in the list and can´t be added returns 2;
     * (ii) SensorType is not supported by the system and it returns 1;
     * @param  sensorType
     * @return int
     */

    public int addSensorTypeToList(String sensorType) {
        if(!isSensorTypeAvailable(sensorType)){
            return 1;
        }
        if (!isSensorTypeAlreadyInTheList(sensorType)){
            this.sensorTypeList.add(sensorType);
            return 0;  //Operation successful
        } return 2; //Sensor Type is repeated in the list
    }

    private boolean isSensorTypeAlreadyInTheList(String inputSensorType){
        for(String singleSensorType : this.sensorTypeList){
            if(singleSensorType.equals(inputSensorType)){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a specific Sensor Type is present in the pool of Sensor Type Options
     * @param sensorType Sensor Type
     * @return Correspondent Sensor Type Option.
     */
    private boolean isSensorTypeAvailable(String sensorType) {
        for (SensorTypeOptions option : SensorTypeOptions.values()) {
            if (option.name().equals(sensorType.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

}
