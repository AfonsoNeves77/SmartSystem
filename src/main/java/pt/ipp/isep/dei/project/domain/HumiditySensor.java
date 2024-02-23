package pt.ipp.isep.dei.project.domain;

import java.util.ArrayList;

public class HumiditySensor implements Sensor {
    private String sensorName;
    private final SensorTypeOptions TYPE = SensorTypeOptions.HUMIDITY;
    //default is false
    private double reading;
    private ArrayList<String> log = new ArrayList<>();

    /**
     * Constructor for Sensor with all parameters.
     * @param sensorName Sensor name
     */
    public HumiditySensor(String sensorName) {
        this.sensorName = sensorName;
    }

    /**
     * Checks if the provided humidity reading is valid (between 0 and 100).
     *
     * @param reading The humidity reading to be validated.
     * @return True if the reading is valid, false otherwise.
     */
    private boolean isReadingValid(double reading){
        return reading > 0 && reading <= 100;
    }

    /**
     * Records a continuous measurement of humidity. If the reading is valid, it updates the sensor's
     * current reading and adds the reading to the measurement log.
     *
     * @param reading The humidity reading to be recorded.
     */
    @Override
    public void continuousMeasure(double reading) {
        if(isReadingValid(reading)){
            this.reading = reading;
            addToLog(reading);
        }else{
            String invalidReading = "Error";
            log.add(invalidReading);
        }
    }

    /**
     * Adds a humidity reading to the measurement log.
     *
     * @param reading The humidity reading to be added to the log.
     */
    private void addToLog(double reading){
        String readingToString = String.valueOf(this.reading);
        log.add(readingToString);
    }

    /**
     * Retrieves the last recorded humidity reading.
     *
     * @return The last recorded humidity reading as a string.
     */
    @Override
    public String getLastReading() {
        return String.valueOf(this.reading);
    }

    /**
     * Retrieves the name of the humidity sensor.
     *
     * @return The name of the humidity sensor.
     */
    @Override
    public String getName() {
        return this.sensorName;
    }

    /**
     * Retrieves the type of the sensor.
     *
     * @return The type of the sensor, which is SensorTypeOptions.HUMIDITY.
     */
    @Override
    public SensorTypeOptions getType() {
        return this.TYPE;
    }

    /**
     * Retrieves the measurement log of the humidity sensor.
     *
     * @return An ArrayList of strings representing the measurement log.
     */
    public ArrayList<String> getLog() {
        return log;
    }
}