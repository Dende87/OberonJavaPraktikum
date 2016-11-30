package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Dende on 30.11.2016.
 */
public class oberonMain extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/guiOberonModel.fxml"));

        Scene scene = new Scene(root,800,600);
        primaryStage.setTitle("First Start");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
