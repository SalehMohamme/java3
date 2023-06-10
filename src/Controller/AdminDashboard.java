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
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class AdminDashboard implements Initializable {

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
    private void MyPage(ActionEvent event) {
    }

    @FXML
    private void LogOut(ActionEvent event) throws IOException {
        ViewManager.AdminDashboard.sceneLoginAdmin();
    }

    @FXML
    private void Page_Appoinments(ActionEvent event) {
        ViewManager.AdminDashboard.sceneAdminAppoinment();
    }

    @FXML
    private void Page_Pations(ActionEvent event) {
        ViewManager.AdminDashboard.sceneAdminPatiets();
    }

    @FXML
    private void AllFreeAppointment(MouseEvent event) {
    }

}
