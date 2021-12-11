package com.example.finalexam323347;
// github link: https://github.com/Babanjot777/FinalExam323347.git
import java.sql.SQLException;
import java.util.List;

public interface DAOInterface {
    public void add(Customer cust) throws ClassNotFoundException, SQLException;
    public void delete(String custno) throws SQLException;
    public Customer edit(Customer cust, String custno) throws SQLException, ClassNotFoundException;
    public List<Customer> display() throws SQLException, ClassNotFoundException;
    public Customer search(String custno) throws SQLException;
}
