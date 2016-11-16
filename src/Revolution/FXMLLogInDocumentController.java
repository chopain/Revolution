/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Revolution;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Shape;
import people.plebian;
import people.propagandist;


import java.net.URL;
import java.util.*;

public class FXMLLogInDocumentController implements Initializable {
    private CommemeismGateway gateway;
    private String selectedClass;
    private TreeMap<String, propagandist> players;
    private List<ImageView> propagandists;
    private List<ImageView> plebs;
    private List<ImageView> bases;
    private List<Shape> borders;
    private List<plebian> plebians;

    @FXML
    private ComboBox<String> classes;
    @FXML
    private TextField handle;
    private WorldPane world;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void quit(ActionEvent event) {
        System.exit(0);
    }

    public void setGateway(CommemeismGateway gateway) {
        this.gateway = gateway;
        classes.setItems(gateway.getClassTypes());
        classes.setValue("Communist");
    }

    public void setWorld(WorldPane world, List<ImageView> p, List<ImageView> plebs, List<plebian> plebians, TreeMap<String, propagandist> players) {
        this.world = world;
        this.propagandists = p;
        this.players = players;
        this.plebians = plebians;
        this.plebs = plebs;
    }

    @FXML
    private void enterGame(ActionEvent event) {
        String selectedClass = classes.getSelectionModel().getSelectedItem();
        //if (handle.getText() != null && selectedClass != null) {
            gateway.sendHandle(handle.getText());
            System.out.println(handle.getText());
            gateway.sendClass(selectedClass);
            System.out.println(selectedClass);
            new Thread(new GameCheck(gateway, world, handle.getText(), players, propagandists, plebs, plebians)).start();
            new Thread(new PlayerCheck(gateway, players, world, propagandists, plebs, plebians)).start();
            new Thread(new PlebianCheck(gateway, plebians, world, propagandists, plebs)).start();
            handle.getScene().getWindow().hide();
        //}
    }

}

