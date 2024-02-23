package pt.ipp.isep.dei.project.domain;

public class GPS {
    private double latitude;
    private double longitude;

    /**
     * Constructor for GPS with full parameters. The constructor verifies their validity.
     * @param latitude latitude parameter in decimal degrees (DD)
     * @param longitude longitude parameter in decimal degrees (DD)
     */
    public GPS(double latitude, double longitude)  {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    /**
     * Receives a GPS object and takes his attributes. Maintains original reference. Parameter validation is done when the parameter object is created, so none done here.
     * @param gps GPS object;
     * @return Returns 0 as confirmation.
     */
    public int editGPS(GPS gps){
        this.latitude = gps.getLatitude();
        this.longitude = gps.getLongitude();
        return 0;
    }
    /**
     * Verifies latitude and longitude fall within accepted range (for latitude: >= -90 and <= 90; for longitude >= -180 and <= 180)
     * @param latitude latitude parameter in decimal degrees (DD)
     * @param longitude longitude parameter in decimal degrees (DD)
     * @return True or False
     */
    private boolean areParamsValid(double latitude, double longitude){
        return (latitude >= -90 && latitude <= 90 && longitude >= -180 && longitude <= 180);
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
