package pt.ipp.isep.dei.project.domain;

public class Device {

    private String deviceName;
    private String deviceModel; //We need a way to validate that the model is compatible with the system.
    private String deviceLocation;
    private boolean status;
    private ListOfSensors listOfSensors;

    /**
     * Constructor for device, it initializes status and listOfSensors as null;
     * @param deviceName Device name
     * @param deviceModel Device model
     * @param deviceLocation Room where the device is located
     * @throws InstantiationException Throws exception if parameters invalid.
     */

    public Device(String deviceName, String deviceModel, String deviceLocation) throws InstantiationException{
        if (isDeviceValid(deviceName)) {
            this.deviceName = deviceName;
            this.deviceModel = deviceModel;
            this.deviceLocation = deviceLocation;
            this.listOfSensors = new ListOfSensors();
        } else {
            throw new InstantiationException("Invalid parameter.");
        }
    }

    /**
     * Toggles device status
     * @return Returns the post-operation status (true/false).
     */
    public boolean toggleDeviceStatus(){
        this.status = !this.status;
        return this.status;
    }

    /**
     * Validates name is not null nor empty.
     * @param deviceName Device Name
     * @return Returns true or false.
     */
    private boolean isDeviceValid (String deviceName){
        return !(deviceName == null || deviceName.trim().isEmpty());
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public String getDeviceLocation() {
        return deviceLocation;
    }

    public ListOfSensors getListOfSensors() {
        return listOfSensors;
    }

    public boolean getStatus() {
        return status;
    }
}
