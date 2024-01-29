package pt.ipp.isep.dei.project.controller;

import pt.ipp.isep.dei.project.domain.House;
import pt.ipp.isep.dei.project.domain.Room;

import java.util.ArrayList;

public class CommonListOfRooms {
    private House house;

    public CommonListOfRooms(House house){
        this.house = house;
    }

    /**
     * Retrieves the list of rooms from the associated House.
     *
     * @return An ArrayList of Room objects representing the rooms within the associated House.
     */
    public ArrayList<Room> getListOfRooms(){
        return house.getListOfRooms().getRoomList();
    }



}
