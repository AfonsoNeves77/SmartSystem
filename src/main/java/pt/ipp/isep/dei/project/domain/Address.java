package pt.ipp.isep.dei.project.domain;

public class Address {
    private String doorReference;
    private String buildingNumber;
    private String streetName;
    private String city;
    private String country;
    private String zipCode;

    /**
     * Constructor for Location object with all the parameters inserted.
     * @param doorReference Reference for the House door
     * @param buildingNumber Building number
     * @param streetName Street name
     * @param city City
     * @param country Country
     * @param zipCode Zipcode
     */

    public Address(String doorReference, String buildingNumber, String streetName, String city, String country, String zipCode) throws InstantiationException {
        if (anyParamsNullOrEmpty(doorReference,buildingNumber,streetName,city,country,zipCode)){
            throw new InstantiationException ("Invalid Parameters");
        }
        this.doorReference = doorReference;
        this.buildingNumber = buildingNumber;
        this.streetName = streetName;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
    }

    /**
     * Receives an address object and takes his attributes. Maintains original reference. Parameter validation is done when the parameter object is created, so none done here.
     * @param address Address object;
     * @return Returns 0 as confirmation.
     */
    public int editAddress (Address address){
        this.doorReference = address.getDoorReference();
        this.buildingNumber = address.getBuildingNumber();
        this.streetName = address.getStreetName();
        this.city = address.getCity();
        this.country = address.getCountry();
        this.zipCode = address.getZipCode();
        return 0;
    }

    /**
     * Validates that parameters are not null or empty
     * @param params Receives doorReference,buildingNumber,streetName,city,country,zipCode
     * @return True or false
     */
    private boolean anyParamsNullOrEmpty (String... params){
        for (String param : params){
            if (param == null || param.trim().isEmpty()){
                return true;
            }
        }
        return false;
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
}
