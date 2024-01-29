package pt.ipp.isep.dei.project.DTO;

public class LocationDTO {
    private String doorReference;
    private String buildingNumber;
    private String streetName;
    private String city;
    private String country;
    private String zipCode;
    private double latitude;
    private double longitude;

    /**
     * Constructor for Location DTO. It mixes the parameters for an Address and GPS object.
     * @param doorReference Reference for the House door
     * @param buildingNumber Building number
     * @param streetName Street name
     * @param city City
     * @param country Country
     * @param zipCode Zipcode
     * @param latitude latitude parameter in decimal degrees (DD)
     * @param longitude longitude parameter in decimal degrees (DD)
     */
    public LocationDTO(String doorReference, String buildingNumber, String streetName, String city, String country, String zipCode, double latitude, double longitude) {
        this.doorReference = doorReference;
        this.buildingNumber = buildingNumber;
        this.streetName = streetName;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public String getDoorReference() {
        return doorReference;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
