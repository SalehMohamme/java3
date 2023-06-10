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
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class UpdataPatient implements Initializable {

    @FXML
    private TextField Text_First_Name;
    @FXML
    private TextField Text_Email;
    @FXML
    private ToggleGroup genderGroup;
    @FXML
    private ToggleGroup roleGroup;
    @FXML
    private TextField Text_Last_Name;
    @FXML
    private TextField Text_Phone;
    @FXML
    private TextField Text_Password;
    User User = null;

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
        ViewManager.AdminDashboard.sceneUpdataPatient();
    }

    @FXML
    private void Search_In_Appoinments(ActionEvent event) {
        ViewManager.AdminDashboard.sceneSearchPatient();
    }

    @FXML
    private void Delete_Appoinments(ActionEvent event) {
    }

    @FXML
    private void btn_Show(ActionEvent event) {
        try {
            ResultSet resultSet = DBConnection.statement.executeQuery("SELECT * FROM `user` WHERE `user`.`id` = " + index + "");
            while (resultSet.next()) {
                User = new User();
                User.setId(resultSet.getInt("id"));
                User.setFirst_Name(resultSet.getString("first_Name"));
                User.setLast_Name(resultSet.getString("last_Name"));
                User.setPhone(resultSet.getString("phone"));
                User.setEmail(resultSet.getString("email"));
                User.setPassword(resultSet.getString("password"));
                User.setAge(resultSet.getInt("age"));
                User.setGender(resultSet.getString("gender"));
            }
            Text_First_Name.setText(User.getFirst_Name());
            Text_Last_Name.setText(User.getLast_Name());
            Text_Email.setText(User.getEmail());
            Text_Phone.setText(User.getPhone());
            Text_Password.setText(User.getPassword());
        } catch (SQLException ex) {
            Logger.getLogger(UpdataPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btn_Save(ActionEvent event) throws SQLException {
        String sel = "UPDATE `user` SET `first_Name` = '" + Text_First_Name.getText() + "' , `last_Name` = '" + Text_Last_Name.getText()
                + "', `password` = '" + Text_Password.getText() + "' , `email` = '" + Text_Email.getText() + "' , `phone` = '" + Text_Phone.getText() + "'  WHERE `user`.`id` =" + index + ";";
        DBConnection.statement.executeUpdate(sel);
        Text_First_Name.setText("");
        Text_Last_Name.setText("");
        Text_Email.setText("");
        Text_Password.setText("");
        Text_Phone.setText("");
        index = 0;
        ViewManager.AdminDashboard.sceneAdminPatiets();
    }

}
