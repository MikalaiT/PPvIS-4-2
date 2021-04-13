package model;

public class Warehouse {
    private Address address;

    public Warehouse(Address address) {
        this.address = address;
    }

    public Warehouse() {
        this(new Address());
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
