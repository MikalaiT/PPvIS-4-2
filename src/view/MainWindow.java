package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class MainWindow extends BorderPane {

    public MainWindow() {
        MenuBar menuBar = new MenuBar();

        Menu file = new Menu("Файл");
        Menu edit = new Menu("Правка");

        MenuItem openFile = new MenuItem("Открыть");
        MenuItem saveFile = new MenuItem("Сохранить");

        MenuItem addRecord = new MenuItem("Добавить");
        MenuItem findRecords = new MenuItem("Найти");
        MenuItem deleteRecords = new MenuItem("Удалить");

        file.getItems().addAll(openFile,saveFile);
        edit.getItems().addAll(addRecord,findRecords,deleteRecords);
        menuBar.getMenus().addAll(file, edit);

        addRecord.setOnAction(new AddWindowCreator());
        findRecords.setOnAction(new FindWindowCreator());
        deleteRecords.setOnAction(new DeleteWindowCreator());

        setTop(menuBar);
        setCenter(new Table(Table.init));
        Label label1 = new Label("label1");
        setAlignment(label1, Pos.CENTER);
        setBottom(label1);
    }

    public Table getTable(){
        return (Table)getChildren().get(1);
    }

    private AddWindow addWindow;
    private FindWindow findWindow;
    private DeleteWindow deleteWindow;

    public AddWindow getAddWindow() {
        return addWindow;
    }

    public void setAddWindow(AddWindow addWindow) {
        this.addWindow = addWindow;
    }

    public FindWindow getFindWindow() {
        return findWindow;
    }

    public void setFindWindow(FindWindow findWindow) {
        this.findWindow = findWindow;
    }

    public DeleteWindow getDeleteWindow() {
        return deleteWindow;
    }

    public void setDeleteWindow(DeleteWindow deleteWindow) {
        this.deleteWindow = deleteWindow;
    }

    private class AddWindowCreator implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            AddWindow addWindow = getAddWindow();
            if (addWindow==null) {
                addWindow = new AddWindow(MainWindow.this);
                setAddWindow(addWindow);
                addWindow.show();
            }else {
                addWindow.toFront();
            }
        }
    }

    private class DeleteWindowCreator implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            DeleteWindow deleteWindow = getDeleteWindow();
            if (deleteWindow==null) {
                deleteWindow = new DeleteWindow(MainWindow.this);
                setDeleteWindow(deleteWindow);
                deleteWindow.show();
            }else {
                deleteWindow.toFront();
            }
        }
    }

    private class FindWindowCreator implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            FindWindow findWindow = getFindWindow();
            if (findWindow==null) {
                findWindow = new FindWindow(MainWindow.this);
                setFindWindow(findWindow);
                findWindow.show();
            }else {
                findWindow.toFront();
            }
        }
    }
}
