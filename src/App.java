import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class App extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("main/resources/fxml/main.fxml"));
        Parent parent = fxmlLoader.load();

        primaryStage.setTitle("Lottery!");
        
        primaryStage.setScene(new Scene(parent,600, 500));
        primaryStage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}