package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.*;

public class AddWindow extends Stage {
    final private MainWindow mainWindow;
    final private StringTextField productName;
    final private StringTextField producerName;
    final private IntTextField producerUNP;
    final private IntTextField warehouseAmount;
    final private StringTextField warehouseAddress;

    public AddWindow(MainWindow mainWindow) {
        this.mainWindow=mainWindow;

        productName = new StringTextField("название товара");
        Label productNameLabel = new Label("название товара");

        producerName = new StringTextField("название производителя");
        Label producerNameLabel = new Label("название производителя");

        producerUNP = new IntTextField("УНП производителя");
        Label producerUNPLabel = new Label("УНП производителя");

        warehouseAmount = new IntTextField("количество на складе");
        Label warehouseAmountLabel = new Label("количество на складе");

        warehouseAddress = new StringTextField("адрес склада");
        Label warehouseAddressLabel = new Label("адрес склада");

        Button ok = new Button("OK");
        ok.setOnAction(new AddConfirmation());

        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(1);
        root.addRow(0,productName,producerName,producerUNP,warehouseAmount,warehouseAddress);
        root.addRow(1,productNameLabel,producerNameLabel,producerUNPLabel,warehouseAmountLabel,warehouseAddressLabel,ok);

        setScene(new Scene(root));
        show();
        setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                clearAddWindow();
            }
        });


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

    private void clearAddWindow(){
        mainWindow.setAddWindow(null);
    }

    private class AddConfirmation implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            AddWindow addWindow = AddWindow.this;// FIXME: 06.04.2021 попробовать улучшить
            if (addWindow.getProducerUNP().tryParse() & addWindow.getWarehouseAmount().tryParse()/* & Address.tryParseAddress(addWindow.getWarehouseAddress().getText())*/) {
                String[] address = Address.parseAddress(addWindow.getWarehouseAddress().getText());
                mainWindow.getTable().addRecord(new Record(
                        new Product(Integer.parseInt(addWindow.getWarehouseAmount().getText()), addWindow.getProductName().getText()),
                        new Producer(addWindow.getProducerName().getText(),Integer.parseInt(addWindow.getProducerUNP().getText())),
                        new Warehouse(new Address(address[0],address[1],address[2],Integer.parseInt(address[3])))));
                addWindow.close();
                clearAddWindow();
            }
        }
    }
}
