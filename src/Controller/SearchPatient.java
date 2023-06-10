/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import static Controller.AdminPatients.index;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class SearchPatient implements Initializable {

    @FXML
    private TableView<User> tableView;
    @FXML
    private TableColumn<User, Integer> Id;
    @FXML
    private TableColumn<User, String> FristName;
    @FXML
    private TableColumn<User, String> LastName;
    @FXML
    private TableColumn<User, Integer> Phone;
    @FXML
    private TableColumn<User, String> Email;
    @FXML
    private TableColumn<User, Integer> Age;
    @FXML
    private TableColumn<User, String> Gender;
    @FXML
    private TextField textF_Search_Patient;
    DBConnection db = DBConnection.getInstanse();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Id.setCellValueFactory(new PropertyValueFactory("id"));
        FristName.setCellValueFactory(new PropertyValueFactory("first_Name"));
        LastName.setCellValueFactory(new PropertyValueFactory("last_Name"));
        Phone.setCellValueFactory(new PropertyValueFactory("phone"));
        Email.setCellValueFactory(new PropertyValueFactory("email"));
        Age.setCellValueFactory(new PropertyValueFactory("age"));
        Gender.setCellValueFactory(new PropertyValueFactory("gender"));
        try {
            AllUser();
        } catch (SQLException ex) {
            Logger.getLogger(SearchPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void All_Patient(ActionEvent event) {
        ViewManager.AdminDashboard.sceneAdminPatiets();
    }

    private void Search_Patient(ActionEvent event) {
        ViewManager.AdminDashboard.sceneSearchPatient();
    }

    @FXML
    private void Create_Patient(ActionEvent event) {
        ViewManager.AdminDashboard.sceneCreatePatientFromAdmin();
    }

    @FXML
    private void Updata_Patient(ActionEvent event) {
        User User = tableView.getSelectionModel().getSelectedItem();
        index = User.getId();
        ViewManager.AdminDashboard.sceneUpdataPatient();
    }

    @FXML
    private void btn_Search_Patient(ActionEvent event) throws SQLException {
        String search = textF_Search_Patient.getText();
        if (search.equals("")) {
            AllUser();
        } else {
            ResultSet resultSet = DBConnection.statement.executeQuery("SELECT * FROM `user` WHERE `user`.`first_Name` = '" + search + "'");
            tableView.getItems().clear();
            while (resultSet.next()) {
                User User = new User();
                User.setId(resultSet.getInt("id"));
                User.setFirst_Name(resultSet.getString("first_Name"));
                User.setLast_Name(resultSet.getString("last_Name"));
                User.setPhone(resultSet.getString("phone"));
                User.setEmail(resultSet.getString("email"));
                User.setAge(resultSet.getInt("age"));
                User.setGender(resultSet.getString("gender"));
                tableView.getItems().addAll(User);
            }
        }
    }

    public void AllUser() throws SQLException {
        ResultSet resultSet = DBConnection.statement.executeQuery("SELECT * FROM `user`");
        tableView.getItems().clear();
        while (resultSet.next()) {
            User User = new User();
            User.setId(resultSet.getInt("id"));
            User.setFirst_Name(resultSet.getString("first_Name"));
            User.setLast_Name(resultSet.getString("last_Name"));
            User.setPhone(resultSet.getString("phone"));
            User.setEmail(resultSet.getString("email"));
            User.setAge(resultSet.getInt("age"));
            User.setGender(resultSet.getString("gender"));
            tableView.getItems().addAll(User);
        }
    }

    @FXML
    private void Search_In_Appoinments(ActionEvent event) {
    }

    @FXML
    private void Delete_Appoinments(ActionEvent event) {
    }
}
