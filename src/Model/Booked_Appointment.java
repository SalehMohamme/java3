/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author hamza
 */
public class Booked_Appointment {

    private int id;
    private String appointment_id;
    private String user_id;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Booked_Appointment{");
        sb.append("id=").append(id);
        sb.append(", appointment_id=").append(appointment_id);
        sb.append(", user_id=").append(user_id);
        sb.append(", status=").append(status);
        sb.append(", doctor_commnet=").append(doctor_commnet);
        sb.append('}');
        return sb.toString();
    }
    private String status;

    private String doctor_commnet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(String appointment_id) {
        this.appointment_id = appointment_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDoctor_commnet() {
        return doctor_commnet;
    }

    public void setDoctor_commnet(String doctor_commnet) {
        this.doctor_commnet = doctor_commnet;
    }

}

//CREATE TABLE pooked_Appointment(
//  `id` int(11) NOT NULL AUTO_INCREMENT,
//  `appointment_id` int(45) NOT NULL,
//  `user_id` int(45) NOT NULL,
//   `doctor_commnet` varchar(45) NOT NULL, 
//  `status` enum('waiting','finished') NOT NULL,
//  PRIMARY KEY (`id`),
//    FOREIGN KEY (user_id) REFERENCES user (id),
//    FOREIGN KEY (appointment_id) REFERENCES appointment(id)
//);  

