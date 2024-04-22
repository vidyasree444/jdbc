package com.vidyagroupid;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Main {
    public static void main(String[] args) throws Exception{
        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection("jdbc:sqlserver://LocalHost:1433;databaseName=MyDatabase;user=SA;password=Imaginnovate@1;encrypt=true;trustServerCertificate=true");
       // System.out.println(con.getClass());
        Statement st=con.createStatement();
        String query="select * from Sample";
        ResultSet rs=st.executeQuery(query);
        while(rs.next()){// rows
            for(int i=1; i<3; i++)// columns
            {
                System.out.print(rs.getString(i)+" ");
            }
            
        }
        //int rs=st.executeUpdate(query);
        
        con.close();
    }
    catch(Exception e){
        e.printStackTrace();
    }
    }
}