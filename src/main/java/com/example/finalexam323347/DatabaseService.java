package com.example.finalexam323347;
// github link: https://github.com/Babanjot777/FinalExam323347.git
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService implements DAOInterface {
    Connection con;

    public DatabaseService(Connection con) {
        this.con = con;
    }

    @Override
    public void add(Customer cust) throws ClassNotFoundException, SQLException {
        String quer1 = "INSERT INTO savingstable VALUES (?,?,?,?,?)";
        PreparedStatement query = con.prepareStatement(quer1);

        query.setString(1,cust.getCustno());
        query.setString(2, cust.getCustname());
        query.setDouble(3,cust.getCdep());
        query.setInt(4,cust.getNyears());
        query.setString(5,cust.getSavtype());
        query.executeUpdate();

        System.out.println("one record added");

    }

    @Override
    public Customer edit(Customer cust, String custno) throws SQLException, ClassNotFoundException {
        PreparedStatement query;
        query = con.prepareStatement("UPDATE savingstable SET custno=?,custname=?,cdep=?,nyears=?,savtype=? where custno = ?");
        query.setString(1,cust.getCustno());
        query.setString(2,cust.getCustname());
        query.setDouble(3,cust.getCdep());
        query.setInt(4,cust.getNyears());
        query.setString(5,cust.getSavtype());
        query.setString(6,custno);

        query.executeUpdate();

        System.out.println("One record edited");
        return cust;
    }

    @Override
    public void delete(String custno) throws SQLException {
        String quer1 = "DELETE FROM savingstable where custno = ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, custno);
        query.executeUpdate();

        System.out.println("One record deleted");

    }

    @Override
    public Customer search(String custno) throws SQLException {
        String query1 = "SELECT * FROM savingstable where custno = ?";
        PreparedStatement query = con.prepareStatement(query1);
        query.setString(1, custno);

        ResultSet rs = query.executeQuery();

        if(!rs.first()){
            System.out.println("Record not existing");
            return null;

        }
        Customer obj1 = null;
        obj1 = new Customer(rs.getString("custno"),rs.getString("custname"),rs.getDouble("cdep"),
                rs.getInt("nyears"),rs.getString("savtype"));
        return obj1;
    }

    @Override
    public List<Customer> display() throws SQLException, ClassNotFoundException {
        List<Customer> CustList = new ArrayList<Customer>();

        String quer1 = "SELECT * FROM savingstable";
        PreparedStatement query = con.prepareStatement(quer1);
        ResultSet rs = query.executeQuery();

        Customer obj1;
        while(rs.next()){
            obj1 = new Customer(rs.getString("custno"),rs.getString("custname"),rs.getDouble("cdep"),
                    rs.getInt("nyears"),rs.getString("savtype"));
            CustList.add(obj1);
        }
        return CustList;
    }

}
