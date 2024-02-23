package pt.ipp.isep.dei.project.domain;

public class FactoryLocation {

   public  Address createAddress (String doorReference, String buildingNumber, String streetName, String city, String country, String zipCode) throws InstantiationException {
       if (anyParamsNullOrEmpty(doorReference,buildingNumber,streetName,city,country,zipCode)){
           throw new InstantiationException ("Invalid Parameters");
       }
        return new Address(doorReference, buildingNumber, streetName, city, country, zipCode);
   }

    public GPS createGPS (double latitude, double longitude)  {
        if (!areParamsValid(latitude,longitude)) {
            throw new IllegalArgumentException("Invalid Parameters");
        }
        return new GPS(latitude, longitude);
    }

    private boolean areParamsValid(double latitude, double longitude){
        return (latitude >= -90 && latitude <= 90 && longitude >= -180 && longitude <= 180);
    }

    private boolean anyParamsNullOrEmpty (String... params){
        for (String param : params){
            if (param == null || param.trim().isEmpty()){
                return true;
            }
        }
        return false;
    }

}
