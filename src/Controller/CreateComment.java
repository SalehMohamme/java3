/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class CreateComment implements Initializable {

    @FXML
    private TableView<Booked_Appointment> tableView;
    @FXML
    private TableColumn<Booked_Appointment, String> Id;
    @FXML
    private TableColumn<Booked_Appointment, String> firstName;
    @FXML
    private TableColumn<Booked_Appointment, String> Appointment_data;
    @FXML
    private TableColumn<Booked_Appointment, String> status;
    @FXML
    private TableColumn<Booked_Appointment, String> comment;
    @FXML
    private TextArea text_Comment;
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

        Id.setCellValueFactory(new PropertyValueFactory("id"));
        firstName.setCellValueFactory(new PropertyValueFactory("user_id"));
        Appointment_data.setCellValueFactory(new PropertyValueFactory("appointment_id"));
        status.setCellValueFactory(new PropertyValueFactory("status"));
        comment.setCellValueFactory(new PropertyValueFactory("doctor_commnet"));
        try {
            allAppoinment();
        } catch (SQLException ex) {
            Logger.getLogger(AdminAppointment.class.getName()).log(Level.SEVERE, null, ex);
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

    void allAppoinment() throws SQLException {
        ResultSet resultSet = DBConnection.statement.executeQuery("SELECT  pooked_appointment.id,user.first_Name ,appointment.appointment_date , pooked_appointment.status , pooked_appointment.doctor_commnet "
                + " FROM user, pooked_appointment,appointment"
                + " WHERE user.id = pooked_appointment.user_id && appointment.id = pooked_appointment.appointment_id;");
        tableView.getItems().clear();
        while (resultSet.next()) {
            Booked_Appointment booked_Appointment = new Booked_Appointment();
            booked_Appointment.setId(resultSet.getInt("id"));
            booked_Appointment.setAppointment_id(resultSet.getString("appointment_date"));
            booked_Appointment.setUser_id(resultSet.getString("first_Name"));
            booked_Appointment.setStatus(resultSet.getString("Status"));
            booked_Appointment.setDoctor_commnet(resultSet.getString("doctor_commnet"));
            tableView.getItems().addAll(booked_Appointment);
        }
    }

    @FXML
    private void btn_Comment(ActionEvent event) throws SQLException {
        Booked_Appointment pooked_Appointment = tableView.getSelectionModel().getSelectedItem();
        String sel = "UPDATE `pooked_appointment` SET  `status` = 'finished' , `doctor_commnet` = '" + text_Comment.getText() + "'  WHERE `pooked_appointment`.`id` =" + pooked_Appointment.getId() + ";";
        DBConnection.statement.executeUpdate(sel);
        allAppoinment();
    }
}
