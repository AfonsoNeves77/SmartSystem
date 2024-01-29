package pt.ipp.isep.dei.project.domain;

import java.util.ArrayList;

public class TemperatureSensor implements Sensor{

    private String sensorName;
    private final SensorTypeOptions TYPE = SensorTypeOptions.TEMPERATURE;
    //default is false
    private double reading;
    private ArrayList<String> log = new ArrayList<>();

    /**
     * Constructor for a new Temperature Sensor object with the specified sensor name.
     * @param sensorName The name of the sensor.
     * @throws InstantiationException If the sensor name is invalid.
     */
    public TemperatureSensor(String sensorName) throws InstantiationException {
        if(sensorName == null || sensorName.trim().isEmpty()){
            throw new InstantiationException("Please insert valid sensor data.");
        }

        this.sensorName = sensorName;
    }

    /**
     * Receives the latest temperature reading from the sensor and updates the internal reading and log.
     * @param reading The latest temperature reading to be updated.
     */
    @Override
    public void continuousMeasure(double reading) {
            this.reading = reading;
            addToLog(reading);
    }

    /**
     * Adds the latest temperature reading to the log.
     * @param reading The latest temperature reading to add to the log.
     */
    private void addToLog(double reading){
        String readingToString = String.valueOf(this.reading);
        log.add(readingToString);
    }

    @Override
    public String getLastReading() {
        return String.valueOf(this.reading);
    }

    @Override
    public String getName() {
        return this.sensorName;
    }

    @Override
    public SensorTypeOptions getType() {
        return this.TYPE;
    }

    public ArrayList<String> getLog() {
        return log;
    }
}
