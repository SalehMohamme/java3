/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.Appointment;
import Model.Booked_Appointment;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class SearchAppointment implements Initializable {

    @FXML
    private TableView<Booked_Appointment> tableView;
    @FXML
    private TableColumn<Booked_Appointment, Integer> Id;
    @FXML
    private TableColumn<Booked_Appointment, String> first_Name;
    @FXML
    private TableColumn<Booked_Appointment, String> Appointment_data;
    @FXML
    private TableColumn<Booked_Appointment, String> Comments;
    @FXML
    private TableColumn<Appointment, String> status;
    @FXML
    private TextField search_Appoinment;
    DBConnection db = DBConnection.getInstanse();

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        Id.setCellValueFactory(new PropertyValueFactory("id"));
        first_Name.setCellValueFactory(new PropertyValueFactory("user_id"));
        Appointment_data.setCellValueFactory(new PropertyValueFactory("appointment_id"));
        status.setCellValueFactory(new PropertyValueFactory("Status"));
        Comments.setCellValueFactory(new PropertyValueFactory("doctor_commnet"));
        try {
            AllAppoinment();
        } catch (SQLException ex) {
            Logger.getLogger(SearchPatient.class.getName()).log(Level.SEVERE, null, ex);
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

    @FXML
    private void btn_Search_Appoinmnet(ActionEvent event) throws SQLException {
        String Search = search_Appoinment.getText();
        if (Search.equals("")) {
            AllAppoinment();
        } else {
            ResultSet resultSet = DBConnection.statement.executeQuery("SELECT pooked_appointment.id  ,user.first_Name ,appointment.appointment_date , pooked_appointment.status , appointment.status as typeStatue, pooked_appointment.doctor_commnet"
                    + " FROM user, pooked_appointment ,appointment "
                    + "WHERE user.id = pooked_appointment.user_id &&appointment.id = pooked_appointment.appointment_id && user.first_Name = '" + Search + "';");
            tableView.getItems().clear();
            while (resultSet.next()) {
                Booked_Appointment booked_Appointment = new Booked_Appointment();
                booked_Appointment.setId(resultSet.getInt("id"));
                booked_Appointment.setUser_id(resultSet.getString("first_Name"));
                booked_Appointment.setAppointment_id(resultSet.getString("appointment_date"));
                booked_Appointment.setStatus(resultSet.getString("status"));
                booked_Appointment.setDoctor_commnet(resultSet.getString("doctor_commnet"));
                tableView.getItems().addAll(booked_Appointment);
            }
        }
    }

    void AllAppoinment() throws SQLException {
        ResultSet resultSet = DBConnection.statement.executeQuery("SELECT pooked_appointment.id  ,user.first_Name ,appointment.appointment_date , pooked_appointment.status , appointment.status as typeStatue, pooked_appointment.doctor_commnet "
                + " FROM user, pooked_appointment ,appointment "
                + "WHERE user.id = pooked_appointment.user_id &&appointment.id = pooked_appointment.appointment_id ");
        tableView.getItems().clear();
        while (resultSet.next()) {
            Booked_Appointment booked_Appointment = new Booked_Appointment();
            booked_Appointment.setId(resultSet.getInt("id"));
            booked_Appointment.setUser_id(resultSet.getString("first_Name"));
            booked_Appointment.setAppointment_id(resultSet.getString("appointment_date"));
            booked_Appointment.setStatus(resultSet.getString("status"));
            booked_Appointment.setDoctor_commnet(resultSet.getString("doctor_commnet"));
            tableView.getItems().addAll(booked_Appointment);
        }
    }
}
