package model;


public class Record {
    private Product product;
    private Producer producer;
    private Warehouse warehouse;



    private String productName;
    private String producerName;
    private int producerUnp;
    private int warehouseAmount;
    private String warehouseAddress;

    public Record(String productName, String producerName, int producerUnp, int warehouseAmount, String warehouseAddress) {
        this(new Product(warehouseAmount),new Producer(producerName,producerUnp),new Warehouse());
//        this.productName = productName;
//        this.producerName = producerName;
//        this.producerUnp = producerUnp;
//        this.warehouseAmount = warehouseAmount;
//        this.warehouseAddress = warehouseAddress;
    }

    public Record(Product product, Producer producer, Warehouse warehouse) {
        this.product = product;
        this.producer = producer;
        this.warehouse = warehouse;
    }

//    public String getProductName() {
//        return productName;
//    }
//
//    public void setProductName(String productName) {
//        this.productName = productName;
//    }
//
//    public String getProducerName() {
//        return producerName;
//    }
//
//    public void setProducerName(String producerName) {
//        this.producerName = producerName;
//    }
//
//    public int getproducerUnp() {
//        return producerUnp;
//    }
//
//    public void setproducerUnp(int producerUnp) {
//        if (producerUnp<0){
//            producerUnp=0;
//        }
//        this.producerUnp = producerUnp;
//    }
//
//    public int getWarehouseAmount() {
//        return warehouseAmount;
//    }
//
//    public void setWarehouseAmount(int warehouseAmount) {
//        if (warehouseAmount<0){
//            warehouseAmount=0;
//        }
//        this.warehouseAmount = warehouseAmount;
//    }
//
//    public String getWarehouseAddress() {
//        return warehouseAddress;
//    }
//
//    public void setWarehouseAddress(String warehouseAddress) {
//        this.warehouseAddress = warehouseAddress;
//    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
