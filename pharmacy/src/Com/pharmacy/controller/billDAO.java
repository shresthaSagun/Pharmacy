package Com.pharmacy.controller;


import Com.pharmacy.common.DBConnection;
import Com.pharmacy.controller.ProductDAO;
import Com.pharmacy.model.bill;
import Com.pharmacy.model.sales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class billDAO {
        public void insertData(ArrayList<bill>list){
        try{
            Connection con=DBConnection.getConnection();
            for(int i=0;i<list.size();i++){
                String sql="insert into bill(billno,item,qtysold,exp_month,exp_year,rate,amount,date) values(?,?,?,?,?,?,?,?)";
                PreparedStatement pst=con.prepareStatement(sql);
                pst.setInt(1, list.get(i).getBillno());
                pst.setString(2, list.get(i).getItem());
                pst.setInt(3, list.get(i).getQtysold());
                pst.setString(4, list.get(i).getExp_month());
                pst.setString(5, list.get(i).getExp_year());
                pst.setDouble(6, list.get(i).getRate());
                
                pst.setDouble(7,list.get(i).getAmount());
                pst.setDate(8, new java.sql.Date(list.get(i).getDate().getTime()));
                pst.executeUpdate();
                //get qty from product table
                //ProductDAO productDAO=new ProductDAO();
                //int qty=productDAO.getQty(list.get(i).getItem(),con);
                
                //update qty in product table
                //int newqty=qty-list.get(i).getQtysold();
               // productDAO.updateQty(newqty,list.get(i).getItem(), con);
                
                
                
            }
            con.close();
        }catch(Exception ex){
            System.out.println(ex);
            
        }
    }
        public ArrayList<bill> fetchData(int bno) {
            if (bno==0){
                System.out.println(bno);
            }  
            
            ArrayList<bill> list =new ArrayList();
        try{
            Connection con=DBConnection.getConnection();
            String sql="select * from bill where billno = ?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,Integer.toString(bno));
            ResultSet rs=pst.executeQuery();
            if(con!=null)
            {
                System.out.println("Connection Sucessful");
            }
            else
                System.out.println("Connection failed");
            
            while (rs.next()) {
                bill ob=new bill();
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


