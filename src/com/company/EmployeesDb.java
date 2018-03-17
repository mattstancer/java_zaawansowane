package com.company;

import java.sql.*;
import java.math.*;
public class EmployeesDb {
    private String host="jdbc:mysql://localhost:3306/employees";
    private String user = "root";

    public String getHost() {
        return host;
    }

    public String getUser() {
        return user;
    }

    public String getDbPass() {
        return dbPass;
    }
public Connection conn;
    private String dbPass = "";
    public EmployeesDb(String host, String user, String dbPass){

        if(host!="") {
            this.host=host;
        }
        if(user!="") {
            this.user=user;
        }
        if(dbPass!="") {
            this.dbPass=dbPass;
        }

    }
    public void Connect(){
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            this.conn=DriverManager.getConnection(this.host, this.user, this.dbPass);
            this.conn.setAutoCommit(false);
            System.out.println("Connected");
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Błąd połączenia z bazą danych");
        }
    }
    public boolean CheckEmployee(){

            String sql = String.format("select count(*) as ilosc from employees where pesel=?");

        try {
            PreparedStatement employeeToDb = this.conn.prepareStatement(sql);
            employeeToDb.setInt(1, person.getPesel());
            employeeToDb.executeUpdate();
            ResultSet rs = employeeToDb.executeQuery();
            while (rs.next()) {

            }
            this.conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
