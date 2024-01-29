package pt.ipp.isep.dei.project.controller;

import pt.ipp.isep.dei.project.domain.Device;
import pt.ipp.isep.dei.project.domain.House;
import pt.ipp.isep.dei.project.domain.Room;

import java.util.ArrayList;

public class CommonListOfDevices {

    private House house;

    public CommonListOfDevices(House house){
        this.house = house;
    }

    /**
     * Gets the list of devices from Room class.
     * @param room Room
     * @return Returns a list of devices
     */
    public ArrayList<Device> getListOfDevices(Room room){
        return room.getListOfDevices().getDeviceList();
    }

}
