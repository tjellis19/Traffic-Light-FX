/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traffic.light.fxml;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
//import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

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
    private Circle greenLightOff;

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
    private int seconds;
    
    @FXML
    private Timeline time;
    
    @FXML
    void changeGreenDelay(DragEvent event) {
        
        greenTimer = greenSlider.getValue();
        System.out.println(greenSlider.getValue());
    }

    @FXML
    void changeRedDelay(DragEvent event) {
        redTimer = redSlider.getValue();
        System.out.println(redTimer);
    }

    @FXML
    void changeYellowDelay(DragEvent event) {
        yellowTimer = yellowSlider.getValue();
        System.out.println(yellowTimer);
    }

    @FXML
    void start(ActionEvent event) {
        redTimer = redSlider.getValue();
        greenTimer = greenSlider.getValue();
        yellowTimer = yellowSlider.getValue();
        System.out.println(redTimer + " " + greenTimer + " " + yellowTimer);
        System.out.println("Playing Animation");
        turnOnRedLight();
        startButton.setDisable(true);
        stopButton.disableProperty().bind(startButton.disableProperty().not());
    }

    @FXML
    void stop(ActionEvent event) {
        time.stop();
        startButton.setDisable(false);
        redLightOff.setVisible(true);
        greenLightOff.setVisible(true);
        yellowLightOff.setVisible(true);
    }
    
    @FXML
    void editTime(MouseEvent event) {
        if(time != null)
        {
            time.stop();
        }
        startButton.setDisable(false);
        redLightOff.setVisible(true);
        greenLightOff.setVisible(true);
        yellowLightOff.setVisible(true);
    }
    
    @FXML
    private void turnOnRedLight()
    {
        System.out.println("Red Light On");
        redLightOff.setVisible(false);
        time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);
        time.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                seconds++;
                if(seconds > redTimer)
                {
                    seconds = 0;
                    redLightOff.setVisible(true);
                    time.stop();
                    turnOnGreenLight();
                }
            }
        }));
        time.play();
    }
    
    @FXML
    private void turnOnGreenLight()
    {
        System.out.println("Green Light On");
        greenLightOff.setVisible(false);
        time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);
        time.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                seconds++;
                if(seconds > greenTimer)
                {
                    seconds = 0;
                    greenLightOff.setVisible(true);
                    time.stop();
                    turnOnYellowLight();
                }
            }
        }));
        time.play();
    }
    
    @FXML
    private void turnOnYellowLight()
    {
        System.out.println("Yellow Light On");
        yellowLightOff.setVisible(false);
        time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);
        time.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                seconds++;
                if(seconds > yellowTimer)
                {
                    seconds = 0;
                    yellowLightOff.setVisible(true);
                    time.stop();
                    turnOnRedLight();
                }
            }
        }));
        time.play();
    }
}
