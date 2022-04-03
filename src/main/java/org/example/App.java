package org.example;

import java.sql.*;
import static java.lang.System.exit;

// SEE HERE: https://stackoverflow.com/questions/2839321/connect-java-to-a-mysql-database
// PLS add soem data to the DB...
// usually we add jdbc to CLASSPATH as here:
//https://docs.oracle.com/cd/E17952_01/connector-j-5.1-en/connector-j-installing-classpath.html
//but I predfer to add to project structure ->  Libaries -> and choosing so.

class MysqlCon{
    public static void main(String args[]){
        Connection con = null;
        try{
            //DEPRECATED Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/fakeDB",
                    "root",
                    "gnoccofritto01");
        }catch(Exception e){
            System.out.println(e);
            exit(-1);
        }

        try{
            Statement stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}