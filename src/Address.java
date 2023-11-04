public class Address {

    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    public Address(String street,String city,String state,String zipCode,String country){
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void updateAddress(String street, String city, String state, String zipCode, String country) {
        if (street != null || city != null || state != null || zipCode != null || country != null) {
            //method used to update address objects
            if (street != null) {
                this.setStreet(street);
            }
            if (city != null) {
                this.setCity(city);
            }
            if (state != null) {
                this.setState(state);
            }
            if (zipCode != null) {
                this.setZipCode(zipCode);
            }
            if (country != null) {
                this.setCountry(country);
            }
        }
    }
}
