package pt.ipp.isep.dei.project.controller;
import pt.ipp.isep.dei.project.domain.Sensor;
import pt.ipp.isep.dei.project.domain.Device;
import pt.ipp.isep.dei.project.domain.Room;

import java.util.ArrayList;
import java.util.HashMap;

public class GroupDevicesByFunctionality {

    private HashMap<String,ArrayList<Device>> devicesMap = new HashMap<>();
    /**
     * Gets all Devices and groups them by functionality
     * @param listRooms List of all Rooms of the house, passed by the controller
     * @return A HashMap with device functionalities as keys, and Device Objects as values
     */
    public HashMap<String,ArrayList<Device>> getDevicesMap(ArrayList<Room> listRooms){
        for (Room room : listRooms){
            ArrayList<Device> deviceList = room.getListOfDevices().getDeviceList();
            for (Device device : deviceList){
                ArrayList<Sensor> sensorList = device.getListOfSensors().getListOfSensors();
                addDeviceToMap(sensorList,device);
                }
            }
        return devicesMap;
    }

    /**
     * Finds the functionality of each Device by evaluating their sensors. Adds functionality to the HashMap.
     * The method does not allow multiplication, i.e., a same device cannot appear twice associated to
     * the same functionality
     * @param sensorList Device sensor list to be analysed
     * @param device Device in analysis
     */
    private void addDeviceToMap(ArrayList<Sensor> sensorList, Device device) {
        for (Sensor sensor : sensorList) {
            String type = sensor.getType().toString();
            ArrayList<Device> deviceList = devicesMap.get(type);
            if (deviceList == null) {
                deviceList = new ArrayList<>();
                deviceList.add(device);
                devicesMap.put(type,deviceList);
            }
            else if(!deviceList.contains(device)){
                deviceList.add(device);
            }
        }
    }
}
