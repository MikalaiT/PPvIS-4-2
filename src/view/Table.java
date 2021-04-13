package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.*;


public class Table extends GridPane {
    public Table() {
        setWidth(1500);
        getColumnConstraints().addAll(
                new ColumnConstraints(300),
                new ColumnConstraints(300),
                new ColumnConstraints(300),
                new ColumnConstraints(300),
                new ColumnConstraints(300));

        setBorder(new Border(new BorderStroke(
                Color.BLACK,
                BorderStrokeStyle.SOLID,
                null,
                new BorderWidths(borderWidth))));

        setBackground(new Background(new BackgroundFill(
                new Color(0.5,0.95,0.95,1),
                new CornerRadii(0),
                new Insets(0))));

        setGridLinesVisible(true);
        setAlignment(Pos.TOP_CENTER);
        addRow(0,
                new Label("Название товара"),
                new Label("Название производителя"),
                new Label("УНП производителя"),
                new Label("Количество на складе"),
                new Label("Адрес склада"));
    }

    public Table(Records recs) {
        this();
        addRecords(recs);
    }

    public void addRecords(Records recs){
        for (int i = 0; i < recs.getData().length; i++) {
            records.addRecord(recs.getData()[i]);
            addRow(recs.getData()[i]);
        }
    }

    public void addRecord(Record rec) {
        records.addRecord(rec);
        addRow(rec);
    }

    private void addRow(Record record){
        String warehouseIsEmpty;
        if (record.getProduct().getWarehouseAmount()==0){
            warehouseIsEmpty="нет на складе";
        }
        else{
            warehouseIsEmpty=String.valueOf(record.getProduct().getWarehouseAmount());
        }
        addRow(currentRows++, new Label(record.getProduct().getName()),
                new Label(record.getProducer().getName()),
                new Label(String.valueOf(record.getProducer().getUnp())),
                new Label(warehouseIsEmpty),
                new Label(record.getWarehouse().getAddress().getFullAddress()));
    }

    private void repaint(){
        if (getChildren().size()>6){
            getChildren().remove(6,getChildren().size());
        }
        currentRows=1;
        for (int i = 0; i < records.getData().length; i++) {
            addRow(records.getData()[i]);
        }
    }

    private int currentRows=1;
    private int currentPage=1;
    private int currentRecordsOnPage=10;

    private final int borderWidth = 3;

    public static final Records init =  new Records(new Record[]{
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(20,"name11"),new Producer("name21",2221),new Warehouse()),
            new Record(new Product(21,"name12"),new Producer("name22",2222),new Warehouse()),
            new Record(new Product(22,"name13"),new Producer("name23",2223),new Warehouse()),
            new Record(new Product(23,"name14"),new Producer("name24",2224),new Warehouse())});

    private Records records = new Records();

    public Records getRecords() {
        return records;
    }

    public void setRecords(Records records) {
        this.records = records;
        repaint();
    }
}
