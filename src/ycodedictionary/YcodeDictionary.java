/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ycodedictionary;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author YCODE
 */
public class YcodeDictionary extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        //primaryStage.setTitle("YCODE DICTIONARY");
        BorderPane borderPane = FXMLLoader.load(getClass().getResource("DictionaryForm.fxml"));
        Scene scene = new Scene(borderPane, 900, 630);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
