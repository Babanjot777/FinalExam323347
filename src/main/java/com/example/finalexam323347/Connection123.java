package com.example.finalexam323347;
// github link: https://github.com/Babanjot777/FinalExam323347.git
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection123 {
    public java.sql.Connection connect() throws SQLException,ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        java.sql.Connection con1= DriverManager.getConnection("jdbc:mysql://localhost/savings","root", "");
        return con1;
    }
}
