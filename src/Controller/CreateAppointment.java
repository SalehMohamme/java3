/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.DBConnection;
import View.ViewManager;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class CreateAppointment implements Initializable {

    @FXML
    private TextField Appointment_Data;
    @FXML
    private RadioButton Booked;
    @FXML
    private ToggleGroup roleGroup;
    @FXML
    private RadioButton Free;
    @FXML
    private TextField Appointment_Time;
    @FXML
    private TextField Appointment_Day;
    DBConnection db = DBConnection.getInstanse();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btn_Save(ActionEvent event) throws SQLException {
        String appointment_date = Appointment_Data.getText();
        String appointment_time = Appointment_Time.getText();
        String appointment_day = Appointment_Day.getText();
        String StatusGroup = " ";
        if (Free.isSelected()) {
            StatusGroup = Free.getText();
        } else {
            StatusGroup = Booked.getText();
        }
        String sql = "INSERT INTO `appointment` "
                + "(`id`, `appointment_date`, `appointment_day`, `appointment_time`, `status`)"
                + "  VALUES (" + null + ",'" + appointment_date + "','" + appointment_day + "', '"
                + appointment_time + "', '" + StatusGroup + "');";
        DBConnection.statement.executeUpdate(sql);
        Appointment_Data.setText("");
        Appointment_Time.setText("");
        Appointment_Day.setText("");
    }

    @FXML
    private void btn_Cansol(ActionEvent event) {
        All_Free_Appointment(event);
    }

    @FXML
    private void All_Free_Appointment(ActionEvent event) {
        ViewManager.AdminDashboard.sceneAdminAppoinment();
    }

    @FXML
    private void Create_Appointment(ActionEvent event) {
        ViewManager.AdminDashboard.sceneCreatAppoinment();
    }

    @FXML
    private void Deleat_Appointment(ActionEvent event) {
    }

    @FXML
    private void Updata_Appointment(ActionEvent event) {
        ViewManager.AdminDashboard.sceneUpdataAppoinment();
    }

    @FXML
    private void Add_Comment(ActionEvent event) {
        ViewManager.AdminDashboard.sceneCreatComment();
    }

    @FXML
    private void Search_Appointment(ActionEvent event) {
        ViewManager.AdminDashboard.sceneSearchAppoinment();
    }

    @FXML
    private void All_Booked_Appointment(ActionEvent event) {
    }

    @FXML
    private void AllFreeAppointment(MouseEvent event) {
    }

}
