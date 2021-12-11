package com.example.finalexam323347;
// github link: https://github.com/Babanjot777/FinalExam323347.git
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
class DatabaseServiceTest {

    @InjectMocks
    private DatabaseService panelDao;
    @Mock
    private Connection connection;
    @Mock
    private ResultSet result;
    @Mock
    private PreparedStatement stmt;

    Customer cust;

    @BeforeEach
    public void setup()throws SQLException, ClassNotFoundException {
        MockitoAnnotations.openMocks(this);

        when(connection.prepareStatement(any(String.class))).thenReturn(stmt);

        cust =new Customer("112","Zanip Mendez",5000.0,2,"Savings-Deluxe");
    }


    @Test
    void add()throws SQLException, ClassNotFoundException{
        panelDao.add(cust);
        Mockito.verify(stmt).executeUpdate();
    }

    @Test
    void edit()throws SQLException,ClassNotFoundException{
        panelDao.add(cust);

        cust = new Customer("112", "ZANIP",5000.0,2,"Savings-Deluxe");
        Customer customer = panelDao.edit(cust,"112");

        assertEquals("ZANIP",customer.getCustname());
    }

    @Test
    void delete() throws SQLException,ClassNotFoundException{
        panelDao.add(cust);
        panelDao.delete(cust.getCustno());
        Mockito.verify(stmt, times(2)).executeUpdate();
    }

    @Test
    void search()throws SQLException,ClassNotFoundException{
        Mockito.when(connection
                        .prepareStatement("Select * from savingstable where custno = ?"
                                ,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY))
                .thenReturn(stmt);
        Mockito.when(stmt.executeQuery()).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true);
        Mockito.when(result.getString("custno")).thenReturn("112");
        Mockito.when(result.getString("custname")).thenReturn("Zanip Mendez");
        Mockito.when(result.first()).thenReturn(true);

        Customer r = panelDao.search("112");
        assertEquals("112",r.getCustno());
    }

    @Test
    void display()throws SQLException,ClassNotFoundException{
        when(result.next()).thenReturn(true,false);
        when(result.getString("custno")).thenReturn("112");
        when(result.getString("custname")).thenReturn("Zanip Mendez");
        when(result.getString("cdep")).thenReturn("5000.0");

        Mockito.doReturn(result).when(stmt).executeQuery();

        panelDao.display();
        Mockito.verify(stmt).executeQuery();

    }
}