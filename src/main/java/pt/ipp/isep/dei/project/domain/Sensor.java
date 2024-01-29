package pt.ipp.isep.dei.project.domain;

/**
 * Represents a generic sensor interface.
 */

public interface Sensor {

    /**
     * Records a continuous measurement for the sensor.
     * @param reading The measurement value.
     */
    void continuousMeasure(double reading);

    /**
     * Retrieves the last recorded measurement as a string.
     * @return The last measurement as a string.
     */
    String getLastReading();

    /**
     * Retrieves the name of the sensor.
     * @return The name of the sensor.
     */

    String getName();

    /**
     * Retrieves the type of the sensor.
     * @return The type of the sensor.
     */

    SensorTypeOptions getType();
}
