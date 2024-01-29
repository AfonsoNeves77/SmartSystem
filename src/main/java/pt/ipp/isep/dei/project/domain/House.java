package pt.ipp.isep.dei.project.domain;

import pt.ipp.isep.dei.project.archive.SensorTypeList;

public class House {

    /**
     * The Class House manages its name, location, the list of rooms and the list of sensor types;
     */
    private String houseName;
    private GPS gps;
    private Address address;
    private ListOfRooms listOfRooms = new ListOfRooms();
    private SensorTypeList sensorTypeList = new SensorTypeList();

    /**
     * Constructor for House with minimum parameters inserted. We deemed a "name" was the only obligatory parameter;
     * In the abscence of more inserted parameters, those are initialized as empty Strings, to avoid Nulls;
     * @param houseName Name
     * @throws InstantiationException Invalid house name
     */

    public House(String houseName) throws InstantiationException {
        if (houseName == null || houseName.trim().isEmpty())
            throw new InstantiationException ("Please insert a valid house name.");
    }

    /**
     * Requests creation and assigns a new address and gps objects to own attributes.
     * @param doorReference Reference for the House door
     * @param buildingNumber Building number
     * @param streetName Street name
     * @param city City
     * @param country Country
     * @param zipCode Zipcode
     * @param latitude latitude parameter in decimal degrees (DD)
     * @param longitude longitude parameter in decimal degrees (DD)
     * @return Returns 0 on successful creation. Returns 1 if any parameters are invalid.
     */
    public int configureLocation(String doorReference, String buildingNumber, String streetName, String city, String country, String zipCode, double latitude, double longitude) {
        try{
            this.address = createAddress(doorReference,buildingNumber,streetName,city,country,zipCode);
            this.gps = createGPS(latitude, longitude);
        } catch (InstantiationException e) {
            return 1;
        }
        return 0;
    }

    /**
     * Creates a new Address object.
     * @param doorReference Reference for the House door
     * @param buildingNumber Building number
     * @param streetName Street name
     * @param city City
     * @param country Country
     * @param zipCode Zipcode
     * @return Returns new Address object.
     * @throws InstantiationException If parameters invalid, propagates exception from object constructor.
     */
    private  Address createAddress (String doorReference, String buildingNumber, String streetName, String city, String country, String zipCode) throws InstantiationException {
        return new Address(doorReference, buildingNumber, streetName, city, country, zipCode);
    }

    /**
     * Creates a new GPS object.
     * @param latitude latitude parameter in decimal degrees (DD)
     * @param longitude longitude parameter in decimal degrees (DD)
     * @return Returns new GPS object.
     * @throws InstantiationException If parameters invalid, propagates exception from object constructor.
     */
    private GPS createGPS (double latitude, double longitude) throws InstantiationException {
        return new GPS(latitude, longitude);
    }

    public ListOfRooms getListOfRooms() {
        return listOfRooms;
    }

    public SensorTypeList getSensorTypeList() {
        return sensorTypeList;
    }

    public Address getClonedAddress() throws InstantiationException {
        String doorReference = address.getDoorReference();
        String buildingNumber = address.getBuildingNumber();
        String streetName = address.getStreetName();
        String city = address.getCity();
        String country = address.getCountry();
        String zipCode = address.getZipCode();
        return new Address(doorReference,buildingNumber,streetName,city,country,zipCode);
    }

    public GPS getClonedGPS() throws InstantiationException {
        double latitude = gps.getLatitude();
        double longitude = gps.getLongitude();
        return new GPS(latitude,longitude);
    }
}
