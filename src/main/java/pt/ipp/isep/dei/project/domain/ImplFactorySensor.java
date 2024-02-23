package pt.ipp.isep.dei.project.domain;

public class ImplFactorySensor implements FactorySensor{
    @Override
    public Sensor createSensor(String sensorName, SensorTypeOptions sensorType) {
        if(sensorName == null || sensorName.trim().isEmpty()){
            throw new IllegalArgumentException("Please insert valid sensor data.");
        }
        if(sensorType.equals(SensorTypeOptions.HUMIDITY)){
            return new HumiditySensor(sensorName);
        }else {
            return new TemperatureSensor(sensorName);
        }
    }
}
