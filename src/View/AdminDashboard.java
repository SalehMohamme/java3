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
public class AdminDashboard extends Stage {

    private final Scene sceneLoginAdmin;
    private final Scene sceneAdminPatiets;
    private final Scene sceneAdminDashboard;
    private final Scene sceneAdminAppoinment;
    private final Scene sceneCreatePatientFromAdmin;
    private final Scene sceneCreatAppoinment;
    private final Scene sceneUpdataPatient;
    private final Scene sceneUpdataAppoinment;
    private final Scene sceneSearchPatient;
    private final Scene sceneSearchAppoinment;
    private final Scene sceneCreatComment;

    public AdminDashboard() throws IOException {

        FXMLLoader LoginAdmin = new FXMLLoader(getClass().getResource("Fxml/LoginAdmin.fxml"));
        Parent CreateUser = LoginAdmin.load();
        sceneLoginAdmin = new Scene(CreateUser);

        FXMLLoader AdminDashboard = new FXMLLoader(getClass().getResource("Fxml/AdminDashboard.fxml"));
        Parent sAdminDashboard = AdminDashboard.load();
        sceneAdminDashboard = new Scene(sAdminDashboard);

        FXMLLoader AdminPatiets = new FXMLLoader(getClass().getResource("Fxml/AdminPatients.fxml"));
        Parent createAdminPatiets = AdminPatiets.load();
        sceneAdminPatiets = new Scene(createAdminPatiets);

        FXMLLoader CreatePatient = new FXMLLoader(getClass().getResource("Fxml/CreatePatientFromAdmin.fxml"));
        Parent CreatePatientFromAdmin = CreatePatient.load();
        sceneCreatePatientFromAdmin = new Scene(CreatePatientFromAdmin);

        FXMLLoader UpdataPatient = new FXMLLoader(getClass().getResource("Fxml/UpdataPatient.fxml"));
        Parent UpdataAdminPatient = UpdataPatient.load();
        sceneUpdataPatient = new Scene(UpdataAdminPatient);

        FXMLLoader SearchPatient = new FXMLLoader(getClass().getResource("Fxml/SearchPatient.fxml"));
        Parent SearchAllPatient = SearchPatient.load();
        sceneSearchPatient = new Scene(SearchAllPatient);

        FXMLLoader AdminAppoinment = new FXMLLoader(getClass().getResource("Fxml/AdminAppointment.fxml"));
        Parent sAdminAppoinment = AdminAppoinment.load();
        sceneAdminAppoinment = new Scene(sAdminAppoinment);

        FXMLLoader CreatAppoinment = new FXMLLoader(getClass().getResource("Fxml/CreateAppointment.fxml"));
        Parent sCreatAppoinment = CreatAppoinment.load();
        sceneCreatAppoinment = new Scene(sCreatAppoinment);

        FXMLLoader CreatComment = new FXMLLoader(getClass().getResource("Fxml/CreateComment.fxml"));
        Parent sCreatComment = CreatComment.load();
        sceneCreatComment = new Scene(sCreatComment);

        FXMLLoader UpdataAppoinment = new FXMLLoader(getClass().getResource("Fxml/UpdataAppointment.fxml"));
        Parent sUpdataAppoinment = UpdataAppoinment.load();
        sceneUpdataAppoinment = new Scene(sUpdataAppoinment);

        FXMLLoader SearchAppoinment = new FXMLLoader(getClass().getResource("Fxml/SearchAppoinment.fxml"));
        Parent sSearchAppoinment = SearchAppoinment.load();
        sceneSearchAppoinment = new Scene(sSearchAppoinment);

        this.setScene(sceneLoginAdmin);
        this.setTitle("Admin Dashboard");
    }

    public void sceneLoginAdmin() {
        this.setScene(sceneLoginAdmin);
    }

    public void sceneAdminPatiets() {
        this.setScene(sceneAdminPatiets);
    }

    public void sceneCreatePatientFromAdmin() {
        this.setScene(sceneCreatePatientFromAdmin);
    }

    public void sceneUpdataPatient() {
        this.setScene(sceneUpdataPatient);
    }

    public void sceneSearchPatient() {
        this.setScene(sceneSearchPatient);
    }

    public void sceneAdminAppoinment() {
        this.setScene(sceneAdminAppoinment);
    }

    public void sceneCreatAppoinment() {
        this.setScene(sceneCreatAppoinment);
    }

    public void sceneUpdataAppoinment() {
        this.setScene(sceneUpdataAppoinment);
    }

    public void sceneSearchAppoinment() {
        this.setScene(sceneSearchAppoinment);
    }

    public void sceneCreatComment() {
        this.setScene(sceneCreatComment);
    }

    public void sceneAdminDashboard() {
        this.setScene(sceneAdminDashboard);
    }
}
