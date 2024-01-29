package pt.ipp.isep.dei.project.controller;

import pt.ipp.isep.dei.project.DTO.LocationDTO;
import pt.ipp.isep.dei.project.domain.Address;
import pt.ipp.isep.dei.project.domain.GPS;
import pt.ipp.isep.dei.project.domain.House;

public class ConfigureLocationCTRL {
    private final House house;

    /**
     * Constructor for the controller. It takes a house as parameter.
     */
    public ConfigureLocationCTRL(House house) {
        this.house = house;
    }

    /**
     * Unpacks the locationDTO. Tells the class House to configure location.
     * @param locationDTO DTO with Address and GPS attributes.
     * @return Returns 0 if successful. 1 if invalid parameters.
     */
    public int configureLocation(LocationDTO locationDTO) {
        String doorReference = locationDTO.getDoorReference();
        String buildingNumber = locationDTO.getBuildingNumber();
        String streetName = locationDTO.getStreetName();
        String city = locationDTO.getCity();
        String country = locationDTO.getCountry();
        String zipCode = locationDTO.getZipCode();
        double latitude = locationDTO.getLatitude();
        double longitude = locationDTO.getLongitude();
        return house.configureLocation(doorReference,buildingNumber,streetName,city,country,zipCode,latitude,longitude);
    }

}
