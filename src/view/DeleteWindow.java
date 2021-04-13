package view;

import controller.Deleter;
import controller.Searcher;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javax.management.Notification;

public class DeleteWindow extends Stage {
    final private int width = 1500;
    final private int height = 700;
    PaneWithOptions paneWithOptions = new PaneWithOptions();
    private Table deleteTable = new Table();
    final private MainWindow mainWindow;

    public DeleteWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;

        Button ok = new Button("OK");
        ok.setOnAction(new DeleteConfirmation());

        GridPane root = new GridPane();
        root.setHgap(10);

        root.add(paneWithOptions,0,0,2,9);
        root.add(deleteTable,0,9,6,1);
        root.add(ok,4,4);


        DialogPane dialogPane = new DialogPane();
        dialogPane.setContent(new Label("1111"));
        dialogPane.setVisible(true);

        setScene(new Scene(root, width, height));

        show();
        setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                mainWindow.setDeleteWindow(null);
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


    private class DeleteConfirmation implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            DeleteWindow deleteWindow = DeleteWindow.this;
            String productName = null,
                    producerName = null,
                    producerUNP = null,
                    warehouseAmount = null,
                    warehouseAddress = null;
            if (!(deleteWindow.getProductName().isDisabled())){
                productName = deleteWindow.getProductName().getText();
            }
            if (!(deleteWindow.getProducerName().isDisabled())){
                producerName = deleteWindow.getProducerName().getText();
            }
            if (!(deleteWindow.getProducerUNP().isDisabled()) && deleteWindow.getProducerUNP().tryParse()){
                producerUNP = deleteWindow.getProducerUNP().getText();
            }
            if (!(deleteWindow.getWarehouseAmount().isDisabled()) && deleteWindow.getWarehouseAmount().tryParse()){
                warehouseAmount = deleteWindow.getWarehouseAmount().getText();
            }
            if (!(deleteWindow.getWarehouseAddress().isDisabled())){
                warehouseAddress = deleteWindow.getWarehouseAddress().getText();
            }
            int wasDeleted = Deleter.delete(
                    mainWindow.getTable(),
                    new String[]{
                            productName,
                            producerName,
                            producerUNP,
                            warehouseAmount,
                            warehouseAddress});
            System.out.println(wasDeleted);
            ButtonType loginButtonType = new ButtonType("Понятно", ButtonBar.ButtonData.OK_DONE);
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("title");
            dialog.getDialogPane().getButtonTypes().add(loginButtonType);
            dialog.getDialogPane().setContent(new Label(deletedRecords(wasDeleted)));
            boolean disabled = true;
//            dialog.getDialogPane().lookupButton(loginButtonType).setDisable(disabled);
            dialog.show();
//            new Notification("com.example.alarm.router",DeleteWindow.this,1,"message").;
        }
        private String deletedRecords(int amount){
            if (amount == 0){
                return "Ни одна запись не была удалена";
            }else {
                return "Количество записей, которые были удалены: " + amount;
            }
        }
    }
}
