/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.Appointment;
import Model.DBConnection;
import Model.User;
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
public class PageUser implements Initializable {

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
    @FXML

    private Label username;

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
            ResultSet resultSet = DBConnection.statement.executeQuery("SELECT * FROM `user` WHERE `user`.`id` = " + LoginUser.index + "");
            System.out.println(LoginUser.index);
            while (resultSet.next()) {
                User User = new User();
                User.setId(resultSet.getInt("id"));
                User.setFirst_Name(resultSet.getString("first_Name"));
                username.setText(User.getFirst_Name());
                System.out.println(User.toString());
            }
            allAppoinment();
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
    private void All_Booked_Finished_Appointments(ActionEvent event) {
        ViewManager.UserDashboard.SceneAllBooked();
    }

    @FXML
    private void All_Booked_waiting_Appointments(ActionEvent event) {
        ViewManager.UserDashboard.SceneAllBooked();
    }

    @FXML
    private void Back(ActionEvent event) {
        ViewManager.UserDashboard.SceneMainUser();
    }

    @FXML
    private void doctor_Comment(ActionEvent event) {
        ViewManager.UserDashboard.SceneDoctorComment();
    }

    void allAppoinment() throws SQLException {
        ResultSet resultSet = DBConnection.statement.executeQuery("SELECT * FROM `appointment` WHERE appointment.status = 'free' ");
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

}
