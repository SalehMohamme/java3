/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.DBConnection;
import Model.User;
import View.ViewManager;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class LoginUser implements Initializable {

    @FXML
    private TextField LabelUserName;
    @FXML
    private TextField LabelPassword;
    @FXML
    private Label ErrorLogin;
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

    }

    @FXML
    private void textUserName(ActionEvent event) {
    }

    @FXML
    private void textPassword(ActionEvent event) {
    }

    @FXML
    private void btn_Login(ActionEvent event) throws SQLException {
        ResultSet resultSet = DBConnection.statement.executeQuery("SELECT `id` , `first_Name`, `password` FROM `user`");
        List<User> ArrayUser = new ArrayList<>();
        while (resultSet.next()) {
            User userr = new User();
            userr.setId(resultSet.getInt("id"));
            userr.setPassword(resultSet.getString("password"));
            userr.setFirst_Name(resultSet.getString("first_Name"));
            ArrayUser.add(userr);
        }
        for (User user : ArrayUser) {
            if (user.getPassword().equals(LabelPassword.getText()) && user.getFirst_Name().equalsIgnoreCase(LabelUserName.getText())) {
                LabelUserName.setText(null);
                LabelPassword.setText(null);
                index = user.getId();
                ViewManager.UserDashboard.SceneUserPage();
                break;
            } else {
                ErrorLogin.setText("Error in UserName or PassWord");
            }
        }
    }

    @FXML
    private void btn_NewUser(ActionEvent event) {
        ViewManager.UserDashboard.SceneCreateUser();
    }

    @FXML
    private void btn_Cancel(ActionEvent event) throws IOException {
        ViewManager.openIndexPage();
        ViewManager.closeUserDashboard();
    }

}
