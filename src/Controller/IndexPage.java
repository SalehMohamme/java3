/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import View.ViewManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class IndexPage implements Initializable {

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
    private void btn_Admin(ActionEvent event) {
        try {
            ViewManager.openAdminDashboard();
            ViewManager.closeIndexPage();
        } catch (IOException ex) {
            Logger.getLogger(IndexPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btn_User(ActionEvent event) {
        try {
            ViewManager.openUserDashboard();
            ViewManager.closeIndexPage();
        } catch (IOException ex) {
            Logger.getLogger(IndexPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
