/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Com.pharmacy.controller;

import Com.pharmacy.common.DBConnection;
import Com.pharmacy.model.product;
import Com.pharmacy.model.sales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Sushil Shrestha
 */
public class salesDAO {
    
    public void insertData(ArrayList<sales>list){
        try{
            Connection con=DBConnection.getConnection();
            for(int i=0;i<list.size();i++){
                String sql="insert into sales(sn,item,qtysold,exp_month,exp_year,rate,amount,date) values(?,?,?,?,?,?,?,?)";
                PreparedStatement pst=con.prepareStatement(sql);
                pst.setInt(1, list.get(i).getSn());
                pst.setString(2, list.get(i).getItem());
                pst.setInt(3, list.get(i).getQtysold());
                pst.setString(4, list.get(i).getExp_month());
                pst.setString(5, list.get(i).getExp_year());
                pst.setDouble(6, list.get(i).getRate());
                
                pst.setDouble(7,list.get(i).getAmount());
                pst.setDate(8, new java.sql.Date(list.get(i).getDos().getTime()));
                pst.executeUpdate();
                //get qty from product table
                ProductDAO productDAO=new ProductDAO();
                int qty=productDAO.getQty(list.get(i).getItem(),con);
                
                //update qty in product table
                int newqty=qty-list.get(i).getQtysold();
                productDAO.updateQty(newqty,list.get(i).getItem(), con);
                
                
                
            }
            con.close();
        }catch(Exception ex){
            System.out.println(ex);
            
        }
    }
    
    public ArrayList<sales> fetchData() {
         ArrayList<sales> list =new ArrayList();
        try{
            Connection con=DBConnection.getConnection();
            String sql="select * from sales";
            Statement st=con.createStatement();
            if(con!=null)
            {
                System.out.println("Connection Sucessful");
            }
            else
                System.out.println("Connection failed");
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()) {
                sales ob=new sales();
                //ob.setSn(rs.getInt("sn"));
                ob.setBillno(rs.getInt("billno"));
                ob.setItem(rs.getString("item"));
                ob.setQtysold(rs.getInt("qtysold"));
                //ob.setQty(rs.getInt("qty"));
                ob.setExp_month(rs.getString("exp_month"));
                ob.setExp_year(rs.getString("exp_year"));
                ob.setRate(rs.getDouble("rate"));
                ob.setAmount(rs.getDouble("amount"));
                
                list.add(ob);
            }
            con.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;

         }
        
        
        
}
