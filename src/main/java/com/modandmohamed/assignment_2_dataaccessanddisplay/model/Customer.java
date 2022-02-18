package com.modandmohamed.assignment_2_dataaccessanddisplay.model;

import java.sql.*;

import static com.modandmohamed.assignment_2_dataaccessanddisplay.database.ConnectionHelper.URL;

public class Customer {

        private Connection connect() {
            Connection conn = null;

            try {
                conn = DriverManager.getConnection(URL);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return conn;
        }

        public void ReadAllCustomers(){
            String sql = "SELECT * FROM Customer";

            try {
                Connection conn = this.connect();
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql);

                // loop through the result set
                while (rs.next()) {
                    System.out.println(rs.getInt("CustomerId") +  "\t" +
                            rs.getString("FirstName") + "\t" +
                            rs.getString("LastName")  + "\t" +
                            rs.getString("Country")  + "\t" +
                            rs.getString("PostalCode")  + "\t" +
                            rs.getString("Phone")  + "\t" +
                            rs.getString("Email")

                    );
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    public void specificCustomerThroughID(Integer InputID){ // easier when inserting ID
        String sql = "SELECT * FROM Customer WHERE CustomerId =" + InputID.toString();

        try{
            Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("CustomerId") +  "\t" +
                        rs.getString("FirstName") + "\t" +
                        rs.getString("LastName")  + "\t" +
                        rs.getString("Country")  + "\t" +
                        rs.getString("PostalCode")  + "\t" +
                        rs.getString("Phone")  + "\t" +
                        rs.getString("Email")

                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


        public static void main(String[] args) {
            Customer app = new Customer();
            app.specificCustomerThroughID(12);
        }

    //private properties

    //constructor


    //getter and setters
}
