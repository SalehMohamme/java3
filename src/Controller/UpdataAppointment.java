/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.Appointment;
import Model.DBConnection;
import View.ViewManager;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class UpdataAppointment implements Initializable {

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
    public Appointment Appointment;

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

        String StatusGroup = " ";
        if (Free.isSelected()) {
            StatusGroup = Free.getText();
        } else {
            StatusGroup = Booked.getText();
        }
        String sel = "UPDATE `appointment` SET `appointment_date` = '" + Appointment_Data.getText() + "' , `appointment_day` = '" + Appointment_Day.getText()
                + "', `appointment_time` = '" + Appointment_Time.getText() + "' , `status` = '" + StatusGroup + "'  WHERE `appointment`.`id` =" + AdminAppointment.index + ";";
        System.out.println(sel);
        DBConnection.statement.executeUpdate(sel);
        Appointment_Data.setText("");
        Appointment_Day.setText("");
        Appointment_Time.setText("");
        AdminAppointment.index = 0;
        ViewManager.AdminDashboard.sceneAdminAppoinment();
    }

    @FXML
    private void btn_Cansol(ActionEvent event) {

        try {
            ResultSet resultSet = DBConnection.statement.executeQuery("SELECT * FROM `appointment` WHERE `appointment`.`id` = " + AdminAppointment.index + "");
            while (resultSet.next()) {
                Appointment = new Appointment();
                Appointment.setId(resultSet.getInt("id"));
                Appointment.setAppointment_date(resultSet.getString("appointment_date"));
                Appointment.setAppointment_day(resultSet.getString("appointment_day"));
                Appointment.setAppointment_time(resultSet.getString("appointment_time"));
                Appointment.setStatus(resultSet.getString("status"));
            }
            Appointment_Data.setText(Appointment.getAppointment_date());
            Appointment_Time.setText(Appointment.getAppointment_time());
            Appointment_Day.setText(Appointment.getAppointment_day());
        } catch (SQLException ex) {
            Logger.getLogger(UpdataPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
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
