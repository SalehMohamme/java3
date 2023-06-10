/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.io.IOException;

/**
 *
 * @author hamza
 */
public class ViewManager {

    public static IndexPage indexPage;
    public static UserDashboard UserDashboard;
    public static AdminDashboard AdminDashboard;

    private ViewManager() {
    }

    public static void openIndexPage() throws IOException {
        if (indexPage == null) {
            indexPage = new IndexPage();
            indexPage.show();
        } else {
            indexPage.show();
        }
    }

    public static void closeIndexPage() {
        if (indexPage != null) {
            indexPage.close();
        }
    }

    public static void openUserDashboard() throws IOException {
        if (UserDashboard == null) {
            UserDashboard = new UserDashboard();
            UserDashboard.show();
        } else {
            UserDashboard.show();
        }
    }

    public static void closeUserDashboard() {
        if (UserDashboard != null) {
            UserDashboard.close();
        }
    }

    public static void openAdminDashboard() throws IOException {
        if (AdminDashboard == null) {
            AdminDashboard = new AdminDashboard();
            AdminDashboard.show();
        } else {
            AdminDashboard.show();
        }
    }

    public static void closeAdminDashboard() {
        if (AdminDashboard != null) {
            AdminDashboard.close();
        }
    }
}
