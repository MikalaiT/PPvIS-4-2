package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class PaneWithOptions extends GridPane {

    final private StringTextField productName;
    final private StringTextField producerName;
    final private IntTextField producerUNP;
    final private IntTextField warehouseAmount;
    final private StringTextField warehouseAddress;

    public PaneWithOptions() {
        RadioButton radioButton1 = new RadioButton("Название товара или Количество на складе");
        radioButton1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                productName.setDisable(false);
                producerName.setDisable(true);
                producerUNP.setDisable(true);
                warehouseAmount.setDisable(false);
                warehouseAddress.setDisable(true);
            }
        });
        RadioButton radioButton2 = new RadioButton("Название производителя или УНП производителя");
        radioButton2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                productName.setDisable(true);
                producerName.setDisable(false);
                producerUNP.setDisable(false);
                warehouseAmount.setDisable(true);
                warehouseAddress.setDisable(true);
            }
        });
        RadioButton radioButton3 = new RadioButton("Адрес склада");
        radioButton3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                productName.setDisable(true);
                producerName.setDisable(true);
                producerUNP.setDisable(true);
                warehouseAmount.setDisable(true);
                warehouseAddress.setDisable(false);
            }
        });

        ToggleGroup toggleGroup = new ToggleGroup();

        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);
        radioButton3.setToggleGroup(toggleGroup);

        productName = new StringTextField("название товара");
        productName.setDisable(true);
        Label productNameLabel = new Label("название товара");

        producerName = new StringTextField("название производителя");
        producerName.setDisable(true);
        Label producerNameLabel = new Label("название производителя");

        producerUNP = new IntTextField("УНП производителя");
        producerUNP.setDisable(true);
        Label producerUNPLabel = new Label("УНП производителя");

        warehouseAmount = new IntTextField("количество на складе");
        warehouseAmount.setDisable(true);
        Label warehouseAmountLabel = new Label("количество на складе");

        warehouseAddress = new StringTextField("адрес склада");
        warehouseAddress.setDisable(true);
        Label warehouseAddressLabel = new Label("адрес склада");

        setHgap(10);

        addRow(0,radioButton1);
        addRow(1,productName,warehouseAmount);
        addRow(2,productNameLabel,warehouseAmountLabel);
        addRow(3,radioButton2);
        addRow(4,producerName,producerUNP);
        addRow(5,producerNameLabel,producerUNPLabel);
        addRow(6,radioButton3);
        addRow(7,warehouseAddress);
        addRow(8,warehouseAddressLabel);
    }

    public StringTextField getProductName() {
        return productName;
    }

    public StringTextField getProducerName() {
        return producerName;
    }

    public IntTextField getProducerUNP() {
        return producerUNP;
    }

    public IntTextField getWarehouseAmount() {
        return warehouseAmount;
    }

    public StringTextField getWarehouseAddress() {
        return warehouseAddress;
    }
}
