package model;

public class Product {
    private int warehouseAmount;
    private String name;

    public Product(int warehouseAmount, String name) {
        if (warehouseAmount<0){
            warehouseAmount=0;
        }
        this.warehouseAmount = warehouseAmount;
        this.name=name;
    }

    public Product(int warehouseAmount) {
        this(warehouseAmount,"название продукта");
    }

    public Product(String name) {
        this(0,name);
    }

    public Product() {
        this(0,"название продукта");
    }

    public int getWarehouseAmount() {
        return warehouseAmount;
    }

    public void setWarehouseAmount(int warehouseAmount) {
        this.warehouseAmount = warehouseAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
