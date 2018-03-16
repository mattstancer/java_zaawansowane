package com.company;

import java.sql.*;
import java.math.*;
public class EmployeesDb {
    private String host="jdbc:mysql://localhost:3306;employees";
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
         conn= DriverManager.getConnection(this.host, this.user, this.dbPass);
    }


}
