/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traffic.light.fxml;

import javafx.event.ActionEvent;
//import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

/**
 *
 * @author tjell
 */

public class FXMLTrafficLightController {

    @FXML
    private GridPane root;

    @FXML
    private Circle redLight;

    @FXML
    private Circle redLightOff;

    @FXML
    private Circle yellowLight;

    @FXML
    private Circle yellowLightOff;

    @FXML
    private Circle greenLight;

    @FXML
    private Circle greenLightoff;

    @FXML
    private Button startButton;

    @FXML
    private Button stopButton;

    @FXML
    private GridPane sliders;

    @FXML
    private Slider redSlider;

    @FXML
    private Slider yellowSlider;

    @FXML
    private Slider greenSlider;

    @FXML
    private Label redDelayLabel;

    @FXML
    private Label yellowDelayLabel;

    @FXML
    private Label greenDelayLabel;
    
    @FXML
    private double redTimer;
    
    @FXML
    private double yellowTimer;
    
    @FXML
    private double greenTimer;
    
    @FXML
    void changeGreenDelay(DragEvent event) {
        
        greenTimer = greenSlider.getValue();
    }

    @FXML
    void changeRedDelay(DragEvent event) {
        
    }

    @FXML
    void changeYellowDelay(DragEvent event) {
        
    }

    @FXML
    void start(ActionEvent event) {
        
        startButton.setDisable(true);
        stopButton.disableProperty().bind(startButton.disableProperty().not());
    }

    @FXML
    void stop(ActionEvent event) {
        
        startButton.setDisable(false);
    }
    
    @FXML
    void editTime(MouseEvent event) {
        
        startButton.setDisable(false);
    }

}
