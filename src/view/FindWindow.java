package view;

import controller.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FindWindow extends Stage {
    final private MainWindow mainWindow;
    final private int width = 1500;
    final private int height = 700;
    private Table findTable = new Table();
    private ScrollPane scrollPane = new ScrollPane();
    PaneWithOptions paneWithOptions = new PaneWithOptions();


    public FindWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;

        Button ok = new Button("OK");
        ok.setOnAction(new FindConfirmation());

        GridPane root = new GridPane();
        root.setHgap(10);

        root.add(paneWithOptions,0,0,2,9);
        root.add(scrollPane = new ScrollPane(findTable),0,9,6,1);
        root.add(ok,4,4);

//        scrollPane.setVisible(false);

        setScene(new Scene(root, width, height));
        show();
        setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                mainWindow.setFindWindow(null);
            }
        });
    }

    public StringTextField getProductName() {
        return paneWithOptions.getProductName();
    }

    public StringTextField getProducerName() {
        return paneWithOptions.getProducerName();
    }

    public IntTextField getProducerUNP() {
        return paneWithOptions.getProducerUNP();
    }

    public IntTextField getWarehouseAmount() {
        return paneWithOptions.getWarehouseAmount();
    }

    public StringTextField getWarehouseAddress() {
        return paneWithOptions.getWarehouseAddress();
    }

    public Table getFindTable() {
        return findTable;
    }

    public void setFindTable(Table findTable) {
        ((GridPane)getScene().getRoot()).getChildren().remove(this.scrollPane);
        this.findTable = findTable;
        this.scrollPane = new ScrollPane(findTable);
        scrollPane.setVmin(200);
        ((GridPane)getScene().getRoot()).add(scrollPane,0,9,6,1);
        scrollPane.setVisible(true);
    }

    private class FindConfirmation implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            FindWindow findWindow = FindWindow.this;
            String productName = null,
                    producerName = null,
                    producerUNP = null,
                    warehouseAmount = null,
                    warehouseAddress = null;
            if (!(findWindow.getProductName().isDisabled())){
                productName = findWindow.getProductName().getText();
            }
            if (!(findWindow.getProducerName().isDisabled())){
                producerName = findWindow.getProducerName().getText();
            }
            if (!(findWindow.getProducerUNP().isDisabled()) && findWindow.getProducerUNP().tryParse()){
                producerUNP = findWindow.getProducerUNP().getText();
            }
            if (!(findWindow.getWarehouseAmount().isDisabled()) && findWindow.getWarehouseAmount().tryParse()){
                warehouseAmount = findWindow.getWarehouseAmount().getText();
            }
            if (!(findWindow.getWarehouseAddress().isDisabled())){
                warehouseAddress = findWindow.getWarehouseAddress().getText();
            }
            findWindow.setFindTable(new Table(Searcher.search(
                    mainWindow.getTable().getRecords(),
                    new String[]{
                            productName,
                            producerName,
                            producerUNP,
                            warehouseAmount,
                            warehouseAddress})));
        }
    }
}
