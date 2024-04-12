/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkroom;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author User
 */
public class Datas {
   /**
     * @return the datacon
     */
    public static Connection getDatas() {
        return datacon;
    }

    /**
     * @param aDatacon the datacon to set
     */
    public static void setDatas(Connection aDatacon) {
        datacon = aDatacon;
    }
    private static Connection datacon;
 public static void Connectiondb(String user, String pass, String dbname, String server) throws Exception{
   Class.forName("com.mysql.jdbc.Driver");
        setDatas(DriverManager.getConnection("jdbc:mysql://"+server+"/"+dbname,user,pass));
 }
    
}
