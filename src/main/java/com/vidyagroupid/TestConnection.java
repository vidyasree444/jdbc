package com.vidyagroupid;
//import java.beans.Statement;
import java.sql.*;
public class TestConnection 
{
    /*public static void main(String[] args) throws Exception 
    {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://LocalHost:1433;databaseName=MyDatabase;user=SA;password=Imaginnovate@1;encrypt=true;trustServerCertificate=true");
            Statement st=con.createStatement();
            String query="insert into Sample values('vidya',22)";
            int rs=st.executeUpdate(query);
            //System.out.println(con.getClass());
            System.out.println("succesfull!");
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
}*/
public static void main(String[] args) {
    String url = "jdbc:sqlserver://LocalHost:1433;databaseName=MyDatabase;user=SA;password=Imaginnovate@1;encrypt=true;trustServerCertificate=true";
    String query = "INSERT INTO Sample VALUES (?, ?)";

    try (Connection con = DriverManager.getConnection(url);
         PreparedStatement pst = con.prepareStatement(query)) {

        pst.setString(1, "sree");
        pst.setInt(2, 21);

        int rowsInserted = pst.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new row has been inserted successfully!");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}



}