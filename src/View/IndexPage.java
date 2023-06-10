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
public class IndexPage extends Stage {

    private final Scene SceneIndexPage;

    IndexPage() throws IOException {
        FXMLLoader sceneIndexPage = new FXMLLoader(getClass().getResource("Fxml/index.fxml"));
//        FXMLLoader sceneIndexPage = new FXMLLoader(getClass().getResource("Fxml/AdminDashboard.fxml"));
        Parent usersManagmentRoot = sceneIndexPage.load();
        SceneIndexPage = new Scene(usersManagmentRoot);
        this.setScene(SceneIndexPage);
        this.setTitle("Admin Dashboard");
    }

    public void changeSceneIndexPage() {
        this.setScene(SceneIndexPage);
    }

}
