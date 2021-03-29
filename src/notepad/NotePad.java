package notepad;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NotePad extends Application
{
    @Override
    public void start(Stage primaryStage)
    {

        NotePadFXMLBase root = new NotePadFXMLBase(primaryStage);
        
        
        Scene scene = new Scene(root, 450, 450);
        
        primaryStage.setTitle("FX Notepad");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
    
}
