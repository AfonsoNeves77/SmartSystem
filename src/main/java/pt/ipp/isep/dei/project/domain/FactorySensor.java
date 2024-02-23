package pt.ipp.isep.dei.project.domain;

public interface FactorySensor {

    Sensor createSensor(String sensorName,SensorTypeOptions sensorType);
}
