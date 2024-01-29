package pt.ipp.isep.dei.project.domain;

import java.util.Arrays;
import java.util.List;

public enum SensorTypeOptions {
    /**
     * The following constants represent each Sensor Type Option.
     * They serve as a way to control and permanently register the system's available Sensor Type.
     */
    HUMIDITY,TEMPERATURE;

    /**
     * Retrieves the SensorTypeOptions as a list.
     * @return The list of available SensorTypeOptions.
     */
    public static List<SensorTypeOptions> asList() {
        return Arrays.asList(values());
    }
}
