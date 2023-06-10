/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author hamza
 */
public class Appointment {

    private int id;
    private String appointment_date;
    private String appointment_day;
    private String appointment_time;
    private String status;

    public Appointment() {
    }

    public Appointment(int id, String appointment_date, String appointment_day, String appointment_time, String status) {
        this.id = id;
        this.appointment_date = appointment_date;
        this.appointment_day = appointment_day;
        this.appointment_time = appointment_time;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(String appointment_date) {
        this.appointment_date = appointment_date;
    }

    public String getAppointment_day() {
        return appointment_day;
    }

    public void setAppointment_day(String appointment_day) {
        this.appointment_day = appointment_day;
    }

    public String getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(String appointment_time) {
        this.appointment_time = appointment_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Appointment{" + "id=" + id + ", appointment_date=" + appointment_date + ", appointment_day=" + appointment_day + ", appointment_time=" + appointment_time + ", status=" + status + '}';
    }

}

//CREATE TABLE appointment(
//  `id` int(11) NOT NULL AUTO_INCREMENT,
//  `appointment_date` int(45) NOT NULL,
//  `appointment_day` varchar(45) NOT NULL,
//   `appointment_time` int(45) NOT NULL, 
//  `status` enum('free','booked') NOT NULL,
//  PRIMARY KEY (`id`)
//);
