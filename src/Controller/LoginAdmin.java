/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import View.ViewManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class LoginAdmin implements Initializable {

    @FXML
    private Label ErrorLogin;
    @FXML
    private TextField textUserName;
    @FXML
    private TextField textPassword;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btn_LoginAdmin(ActionEvent event) {
        if (textUserName.getText().equalsIgnoreCase("1") && textPassword.getText().equals("1")) {
            textPassword.setText("");
            textUserName.setText("");
            ViewManager.AdminDashboard.sceneAdminDashboard();

        } else {
            ErrorLogin.setText("Error in UserName or PassWord ErrorLogin");
        }

    }

    @FXML
    private void btn_Cancel(ActionEvent event) throws IOException {
        ViewManager.openIndexPage();
        ViewManager.closeAdminDashboard();
    }

}
