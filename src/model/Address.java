package model;

public class Address {
    private String country;
    private String city;
    private String street;
    private int houseNumber;

    public Address(String country, String city, String street, int houseNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public Address(String fullAddress){
        this(fullAddress.split(", ",4)[0],
                fullAddress.split(", ",4)[1],
                fullAddress.split(", ",4)[2],
                Integer.parseInt(fullAddress.split(", ",4)[3]));
    }

    public Address() {
        this("Беларусь","Минск","Независимости", 22);
    }

    public String getFullAddress(){
        return country + ", г." + city + ", ул." + street + ", " + houseNumber;
    }

    public static String[] parseAddress(String address){
        if (tryParseAddress(address)) {
            return address.split(", ",4);
        }
        else{
            return new String[]{"не","удалось","парсировать","12"};
        }
    }

    public static boolean tryParseAddress(String address){// FIXME: 06.04.2021 изменить попытку парсировать
        return address.split(",").length==4;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }
}
