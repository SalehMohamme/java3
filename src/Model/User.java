/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author hamza
 */
public class User {

    private int id;
    private String first_Name;
    private String last_Name;

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", first_Name=" + first_Name + ", last_Name=" + last_Name + ", password=" + password + ", email=" + email + ", phone=" + phone + ", gender=" + gender + ", role=" + role + ", age=" + age + '}';
    }
    private String password;
    private String email;
    private String phone;
    private String gender;
    private String role;
    private int age;
    public User() {

    }

    public User(int id, String first_Name, String last_Name, String password, String email, String phone, String gender, String role, int age) {
        this.id = id;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.role = role;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
