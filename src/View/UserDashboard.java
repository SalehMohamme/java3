/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author hamza
 */
public class UserDashboard extends Stage {

    private final Scene sceneCreateUser;
    private final Scene sceneMainUser;
    private final Scene sceneUserPage;
    private final Scene sceneAllBooked;
    private final Scene sceneBook_Appointment;
    private final Scene sceneDoctorComment;

    public UserDashboard() throws IOException {

        FXMLLoader createUser = new FXMLLoader(getClass().getResource("Fxml/CreateUser.fxml"));
        Parent CreateUser = createUser.load();
        sceneCreateUser = new Scene(CreateUser);
        FXMLLoader createUserLoader = new FXMLLoader(getClass().getResource("Fxml/LoginUser.fxml"));
        Parent createUserRoot = createUserLoader.load();
        sceneMainUser = new Scene(createUserRoot);

        FXMLLoader createUserPage = new FXMLLoader(getClass().getResource("Fxml/PageUser.fxml"));
        Parent createUserPageRoot = createUserPage.load();
        sceneUserPage = new Scene(createUserPageRoot);

        FXMLLoader createAllBooked = new FXMLLoader(getClass().getResource("Fxml/All_booked.fxml"));
        Parent createAllBookeds = createAllBooked.load();
        sceneAllBooked = new Scene(createAllBookeds);

        FXMLLoader createBook_Appointment = new FXMLLoader(getClass().getResource("Fxml/Book_Appointment.fxml"));
        Parent createBook_Appointments = createBook_Appointment.load();
        sceneBook_Appointment = new Scene(createBook_Appointments);

        FXMLLoader createDoctorComment = new FXMLLoader(getClass().getResource("Fxml/DoctorComment.fxml"));
        Parent createDoctorComments = createDoctorComment.load();
        sceneDoctorComment = new Scene(createDoctorComments);

        this.setScene(sceneMainUser);
        this.setTitle("User Dashboard");
    }

    public void SceneMainUser() {
        this.setScene(sceneMainUser);
    }

    public void SceneCreateUser() {
        this.setScene(sceneCreateUser);
    }

    public void SceneUserPage() {
        this.setScene(sceneUserPage);
    }

    public void SceneAllBooked() {
        this.setScene(sceneAllBooked);
    }

    public void SceneBook_Appointment() {
        this.setScene(sceneBook_Appointment);
    }

    public void SceneDoctorComment() {
        this.setScene(sceneDoctorComment);
    }

}
