package view;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MainApplication extends Application {
    public static void doThing(String[] args) {
        System.out.println(2112);
        launch();
        System.out.println(1221);
    }


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(new MainWindow()));
        primaryStage.setMaximized(true);
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                MainWindow mainWindow = (MainWindow) primaryStage.getScene().getRoot();
                if (mainWindow.getAddWindow()!=null){
                    mainWindow.getAddWindow().close();
                }
                if (mainWindow.getFindWindow()!=null){
                    mainWindow.getFindWindow().close();
                }
                if (mainWindow.getDeleteWindow()!=null){
                    mainWindow.getDeleteWindow().close();
                }
            }
        });
    }
}
