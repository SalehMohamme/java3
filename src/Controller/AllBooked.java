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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class AllBooked implements Initializable {

    @FXML
    private Label username;
    @FXML
    private TableView<Appointment> tableView;
    @FXML
    private TableColumn<Appointment, String> Appointment_Data;
    @FXML
    private TableColumn<Appointment, String> Appointment_Day;
    @FXML
    private TableColumn<Appointment, String> Appointment_Time;
    @FXML
    private TableColumn<Appointment, String> status;
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
        
        Appointment_Data.setCellValueFactory(new PropertyValueFactory("appointment_date"));
        Appointment_Day.setCellValueFactory(new PropertyValueFactory("appointment_day"));
        Appointment_Time.setCellValueFactory(new PropertyValueFactory("appointment_time"));
        status.setCellValueFactory(new PropertyValueFactory("status"));
        try {

            AllPooked_appointment_Waiting();
        } catch (SQLException ex) {
            Logger.getLogger(AdminAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void All_Free_Appointments(ActionEvent event) {
        ViewManager.UserDashboard.SceneUserPage();
    }

    @FXML
    private void Book_An_Free_Appointment(ActionEvent event) {
        ViewManager.UserDashboard.SceneBook_Appointment();
    }

    @FXML
    private void All_Booked_Finished_Appointments(ActionEvent event) throws SQLException {
        AllPooked_appointment_Finished();
    }

    @FXML
    private void All_Booked_waiting_Appointments(ActionEvent event) throws SQLException {
        AllPooked_appointment_Waiting();
    }

    @FXML
    private void Back(ActionEvent event) {
        ViewManager.UserDashboard.SceneMainUser();
    }

    void AllPooked_appointment() throws SQLException {
        ResultSet resultSet = DBConnection.statement.executeQuery("SELECT appointment.id , appointment.appointment_date ,appointment.appointment_day,appointment.appointment_time ,pooked_appointment.status  FROM `appointment`,`pooked_appointment` WHERE appointment.id = pooked_appointment.id");
        tableView.getItems().clear();
        while (resultSet.next()) {
            Appointment Appointment = new Appointment();
            Appointment.setId(resultSet.getInt("id"));
            Appointment.setAppointment_date(resultSet.getString("appointment_date"));
            Appointment.setAppointment_day(resultSet.getString("appointment_day"));
            Appointment.setAppointment_time(resultSet.getString("appointment_time"));
            Appointment.setStatus(resultSet.getString("status"));
            tableView.getItems().addAll(Appointment);
        }
    }

    void AllPooked_appointment_Waiting() throws SQLException {
        ResultSet resultSet = DBConnection.statement.executeQuery("SELECT appointment.id , appointment.appointment_date ,appointment.appointment_day,appointment.appointment_time ,pooked_appointment.status  FROM `appointment`,`pooked_appointment` WHERE appointment.id = pooked_appointment.id && pooked_appointment.status = 'waiting' ");
        tableView.getItems().clear();
        while (resultSet.next()) {
            Appointment Appointment = new Appointment();
            Appointment.setId(resultSet.getInt("id"));
            Appointment.setAppointment_date(resultSet.getString("appointment_date"));
            Appointment.setAppointment_day(resultSet.getString("appointment_day"));
            Appointment.setAppointment_time(resultSet.getString("appointment_time"));
            Appointment.setStatus(resultSet.getString("status"));
            tableView.getItems().addAll(Appointment);
        }
    }

    void AllPooked_appointment_Finished() throws SQLException {
        ResultSet resultSet = DBConnection.statement .executeQuery("SELECT appointment.id , appointment.appointment_date ,appointment.appointment_day,appointment.appointment_time ,pooked_appointment.status  FROM `appointment`,`pooked_appointment` WHERE appointment.id = pooked_appointment.id && pooked_appointment.status = 'finished' ");
        tableView.getItems().clear();
        while (resultSet.next()) {
            Appointment Appointment = new Appointment();
            Appointment.setId(resultSet.getInt("id"));
            Appointment.setAppointment_date(resultSet.getString("appointment_date"));
            Appointment.setAppointment_day(resultSet.getString("appointment_day"));
            Appointment.setAppointment_time(resultSet.getString("appointment_time"));
            Appointment.setStatus(resultSet.getString("status"));
            tableView.getItems().addAll(Appointment);
        }
    }

    @FXML
    private void doctor_Comment(ActionEvent event) {
        ViewManager.UserDashboard.SceneDoctorComment();
    }
}
