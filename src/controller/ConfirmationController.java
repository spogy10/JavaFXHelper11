/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author poliv
 */
public class ConfirmationController implements Initializable {
    
    @FXML private Label label;
    @FXML private Button yes;
    @FXML private Button no;
    private boolean answer;
    
    @FXML
    private void yesConfirm(){
        answer = true;
        Stage window = (Stage) yes.getScene().getWindow();
        window.close();
    }
    
    @FXML
    private void noConfirm(){
        answer = false;
        Stage window = (Stage) no.getScene().getWindow();
        window.close();
        
    }
    
    public boolean getAnswer(){
        return answer;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    public void setMessage(String message){
        label.setText(message);
    }
    
}
