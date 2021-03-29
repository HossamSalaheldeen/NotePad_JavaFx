package notepad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;

public class NotePadFXMLBase extends BorderPane {

    protected final MenuBar menuBar;
    protected final Menu menu;
    protected final MenuItem newItem;
    protected final MenuItem openItem;
    protected final MenuItem saveItem;
    protected final SeparatorMenuItem separatorMenuItem;
    protected final MenuItem exitItem;
    protected final Menu menu0;
    protected final MenuItem undoItem;
    protected final SeparatorMenuItem separatorMenuItem0;
    protected final MenuItem cutItem;
    protected final MenuItem copyItem;
    protected final MenuItem pasteItem;
    protected final MenuItem deleteItem;
    protected final SeparatorMenuItem separatorMenuItem1;
    protected final MenuItem selectAllItem;
    protected final Menu menu1;
    protected final MenuItem aboutItem;
    protected final TextArea textArea;

    public NotePadFXMLBase(Stage primaryStage) {

        menuBar = new MenuBar();
        menu = new Menu();
        newItem = new MenuItem();
        openItem = new MenuItem();
        saveItem = new MenuItem();
        separatorMenuItem = new SeparatorMenuItem();
        exitItem = new MenuItem();
        menu0 = new Menu();
        undoItem = new MenuItem();
        separatorMenuItem0 = new SeparatorMenuItem();
        cutItem = new MenuItem();
        copyItem = new MenuItem();
        pasteItem = new MenuItem();
        deleteItem = new MenuItem();
        separatorMenuItem1 = new SeparatorMenuItem();
        selectAllItem = new MenuItem();
        menu1 = new Menu();
        aboutItem = new MenuItem();
        textArea = new TextArea();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(menuBar, javafx.geometry.Pos.CENTER);

        menu.setMnemonicParsing(false);
        menu.setText("File");

        newItem.setMnemonicParsing(false);
        newItem.setText("New");
        newItem.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));

        openItem.setMnemonicParsing(false);
        openItem.setText("Open");
        openItem.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));

        saveItem.setMnemonicParsing(false);
        saveItem.setText("Save");
        saveItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));

        separatorMenuItem.setMnemonicParsing(false);

        exitItem.setMnemonicParsing(false);
        exitItem.setText("Exit");
        exitItem.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));

        menu0.setMnemonicParsing(false);
        menu0.setText("Edit");

        undoItem.setMnemonicParsing(false);
        undoItem.setText("Undo");

        separatorMenuItem0.setMnemonicParsing(false);

        cutItem.setMnemonicParsing(false);
        cutItem.setText("Cut");

        copyItem.setMnemonicParsing(false);
        copyItem.setText("Copy");

        pasteItem.setMnemonicParsing(false);
        pasteItem.setText("Paste");

        deleteItem.setMnemonicParsing(false);
        deleteItem.setText("Delete");

        separatorMenuItem1.setMnemonicParsing(false);

        selectAllItem.setMnemonicParsing(false);
        selectAllItem.setText(" Select All");

        menu1.setMnemonicParsing(false);
        menu1.setText("Help");

        aboutItem.setMnemonicParsing(false);
        aboutItem.setText("About Notepad");
        aboutItem.setAccelerator(new KeyCodeCombination(KeyCode.F1, KeyCombination.CONTROL_DOWN));
        setTop(menuBar);

        BorderPane.setAlignment(textArea, javafx.geometry.Pos.CENTER);
        textArea.setPrefHeight(200.0);
        textArea.setPrefWidth(200.0);
        setCenter(textArea);

        menu.getItems().add(newItem);
        menu.getItems().add(openItem);
        menu.getItems().add(saveItem);
        menu.getItems().add(separatorMenuItem);
        menu.getItems().add(exitItem);
        menuBar.getMenus().add(menu);
        menu0.getItems().add(undoItem);
        menu0.getItems().add(separatorMenuItem0);
        menu0.getItems().add(cutItem);
        menu0.getItems().add(copyItem);
        menu0.getItems().add(pasteItem);
        menu0.getItems().add(deleteItem);
        menu0.getItems().add(separatorMenuItem1);
        menu0.getItems().add(selectAllItem);
        menuBar.getMenus().add(menu0);
        menu1.getItems().add(aboutItem);
        menuBar.getMenus().add(menu1);
        
        newItem.setOnAction((ActionEvent e) ->
        {
            textArea.clear();
        });
        
        openItem.setOnAction((ActionEvent e) ->
        {
            FileChooser fc = new FileChooser();
            File f = fc.showOpenDialog(primaryStage);
            if(f != null) 
            {
                
                try
                {
                    FileInputStream fis = new FileInputStream(f);
                    int size = fis.available();
                    byte[] b = new byte[size];
                    fis.read(b);
                    textArea.setText(new String(b));
                    fis.close();
                }
                catch(IOException ex)
                {
                    ex.printStackTrace();
                }
            }
        });
        
        saveItem.setOnAction((ActionEvent e) ->
        {
            FileChooser fc = new FileChooser();
            File f = fc.showSaveDialog(primaryStage);
            if(f != null) 
            {
                try
                {
                    FileWriter fw = new FileWriter(f);
                    fw.write(textArea.getText());
                    fw.close();
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();  
                }
            }
        });
        
        exitItem.setOnAction((ActionEvent e) ->
        {
            //Platform.exit();
            System.exit(0);
        });
        
        undoItem.setOnAction((ActionEvent e) ->
        {
            textArea.undo();
        });
        
        cutItem.setOnAction((ActionEvent e) ->
        {
            textArea.cut();
        });
        
        copyItem.setOnAction((ActionEvent e) ->
        {
            textArea.copy();
        });
        
        pasteItem.setOnAction((ActionEvent e) ->
        {
            textArea.paste();
        });
        
        deleteItem.setOnAction((ActionEvent e) ->
        {
            textArea.deleteText(textArea.getSelection());
        });
        
        selectAllItem.setOnAction((ActionEvent e) ->
        {
            textArea.selectAll();
        });
        
        aboutItem.setOnAction((ActionEvent e) ->
        {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("About Notepad");
            alert.setHeaderText("Welcome to Fx Notepad help");
            alert.setContentText("Product version:\nLisences:\nUpdates:\n\u00a9 FX Notepad 2020");
            alert.showAndWait();
        });

    }
}
