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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class AdminAppointment implements Initializable {

    @FXML
    private TableView<Appointment> tableView;
    @FXML
    private TableColumn<Appointment, Integer> Id;
    @FXML
    private TableColumn<Appointment, String> Appointment_Data;
    @FXML
    private TableColumn<Appointment, String> Appointment_Day;
    @FXML
    private TableColumn<Appointment, String> Appointment_Time;
    @FXML
    private TableColumn<Appointment, String> status;

    DBConnection db = DBConnection.getInstanse();

    static int index;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        Id.setCellValueFactory(new PropertyValueFactory("id"));
        Appointment_Data.setCellValueFactory(new PropertyValueFactory("appointment_date"));
        Appointment_Day.setCellValueFactory(new PropertyValueFactory("appointment_day"));
        Appointment_Time.setCellValueFactory(new PropertyValueFactory("appointment_time"));
        status.setCellValueFactory(new PropertyValueFactory("status"));
        try {
            allAppoinment();
        } catch (SQLException ex) {
            Logger.getLogger(AdminAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void All_Free_Appointment(ActionEvent event) throws SQLException {
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

    @FXML
    private void Search_Appointment(ActionEvent event) {
        ViewManager.AdminDashboard.sceneSearchAppoinment();
    }

    @FXML
    private void Create_Appointment(ActionEvent event) {
        ViewManager.AdminDashboard.sceneCreatAppoinment();
    }

    @FXML
    private void Deleat_Appointment(ActionEvent event) throws SQLException {
        Appointment Appointment = tableView.getSelectionModel().getSelectedItem();
        String sel = "DELETE FROM appointment WHERE `appointment`.`id` =" + Appointment.getId() + "";
        DBConnection.statement.executeUpdate(sel);
        allAppoinment();
    }

    @FXML
    private void Updata_Appointment(ActionEvent event) {
        Appointment appointment = tableView.getSelectionModel().getSelectedItem();
        index = appointment.getId();
        System.out.println(index);
        ViewManager.AdminDashboard.sceneUpdataAppoinment();
    }

    @FXML
    private void Add_Comment(ActionEvent event) {
        ViewManager.AdminDashboard.sceneCreatComment();
    }

    @FXML
    private void All_Booked_Appointment(ActionEvent event) throws SQLException {
        ResultSet resultSet = DBConnection.statement.executeQuery("SELECT * FROM `appointment` WHERE appointment.status = 'booked' ");
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
    private void Back(ActionEvent event) {
        ViewManager.AdminDashboard.sceneAdminDashboard();
    }

    @FXML
    private void AllFreeAppointment(MouseEvent event) throws SQLException {
        allAppoinment();
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
