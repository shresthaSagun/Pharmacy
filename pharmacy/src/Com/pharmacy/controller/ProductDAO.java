/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Com.pharmacy.controller;

import Com.pharmacy.common.DBConnection;
import Com.pharmacy.model.product;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Sushil Shrestha
 */
public class ProductDAO {

	public void insertData(product ob) {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "insert into drug(name,rate,qty,exp_month,exp_year,sample_month)values(?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ob.getName());
			pst.setDouble(2, ob.getRate());
			pst.setInt(3, ob.getQty());
			pst.setString(4, ob.getExp_month());
			pst.setString(5, ob.getExp_year());
			pst.setInt(6, ob.getSample_month());

			pst.executeUpdate();
			con.close();

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public int getQty(String name, Connection con) {
		int qty = 0;
		try {
			String sql = "select qty from drug where name like '" + name + "%'";
			PreparedStatement pst = con.prepareStatement(sql);
			// pst.setString(1,name);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				qty = rs.getInt("qty");
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return qty;
	}

	public void updateQty(int newqty, String name, Connection con) {
		try {
			String sql = "update drug set qty=? where name like '" + name + "%'";
			PreparedStatement pst = con.prepareCall(sql);
			pst.setInt(1, newqty);
			// pst.setInt(2, name);
			pst.executeUpdate();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void UpdateData(product ob) {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "update drug set name=?,rate=?,qty=?,exp_month=?,exp_year=? where id=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ob.getName());
			pst.setDouble(2, ob.getRate());
			pst.setInt(3, ob.getQty());
			pst.setString(4, ob.getExp_month());
			pst.setString(5, ob.getExp_year());
			pst.setInt(6, ob.getId());
			pst.executeUpdate();
			con.close();

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public ArrayList<product> fetchData() {
		ArrayList<product> list = new ArrayList();
		try {
			Connection con = DBConnection.getConnection();
			String sql = "select * from drug";
			Statement st = con.createStatement();
			if (con != null) {
				System.out.println("Connection Sucessful");
			} else
				System.out.println("Connection failed");
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				product ob = new product();
				ob.setId(rs.getInt("id"));
				ob.setName(rs.getString("name"));
				ob.setRate(rs.getDouble("rate"));
				ob.setQty(rs.getInt("qty"));
				ob.setExp_month(rs.getString("exp_month"));
				ob.setExp_year(rs.getString("exp_year"));

				list.add(ob);
			}
			con.close();

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return list;

	}

	public ArrayList<product> fetchDataWithName(String tname) {
		ArrayList<product> list = new ArrayList();
		try {
			Connection con = DBConnection.getConnection();
			String sql = "select * from drug where name like '" + tname + "%'";
			Statement st = con.createStatement();
			if (con != null) {
				System.out.println("Connection Sucessful");
			} else
				System.out.println("Connection failed");
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				product ob = new product();
				ob.setId(rs.getInt("id"));
				ob.setName(rs.getString("name"));
				ob.setRate(rs.getDouble("rate"));
				ob.setQty(rs.getInt("qty"));
				ob.setExp_month(rs.getString("exp_month"));
				ob.setExp_year(rs.getString("exp_year"));

				list.add(ob);
			}
			con.close();

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return list;

	}

	public ArrayList<product> fetchDataWithNamesale(String tname, int p, int j) {
		ArrayList<product> list = new ArrayList();
		try {
			Connection con = DBConnection.getConnection();
			String sql = "select * from drug where name like '" + tname + "%'";
			Statement st = con.createStatement();
			if (con != null) {
				System.out.println("Connection Sucessful");
			} else
				System.out.println("Connection failed");
			ResultSet rs = st.executeQuery(sql);
			int sn = 0;
			while (rs.next()) {
				sn = sn + 1;
				product ob = new product();
				ob.setId(rs.getInt("id"));
				ob.setName(rs.getString("name"));
				ob.setRate(rs.getDouble("rate"));
				ob.setQty(rs.getInt("qty"));
				ob.setExp_month(rs.getString("exp_month"));
				ob.setExp_year(rs.getString("exp_year"));
				ob.setSoldno(p);
				ob.setSN(j);
				Double q = rs.getDouble("rate");
				ob.setAmount(p * q);

				list.add(ob);
			}
			con.close();

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return list;

	}

	public ArrayList<product> fetchDataWithDate(String eyear, String emonth) {
		ArrayList<product> list = new ArrayList();
		try {
			Connection con = DBConnection.getConnection();
			String sql = "select * from drug where exp_year<'" + eyear + "'";

			String sql1 = "select * from drug where exp_year='" + eyear + "'";
			Statement st = con.createStatement();

			if (con != null) {
				System.out.println("Connection Sucessful");
			} else
				System.out.println("Connection failed");
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				product ob = new product();
				ob.setId(rs.getInt("id"));
				ob.setName(rs.getString("name"));
				ob.setRate(rs.getDouble("rate"));
				ob.setQty(rs.getInt("qty"));
				ob.setExp_month(rs.getString("exp_month"));
				ob.setExp_year(rs.getString("exp_year"));

				list.add(ob);
			}
			ResultSet rs1 = st.executeQuery(sql1);

			while (rs1.next()) {
				product ob1 = new product();
				int a = rs1.getInt("sample_month");

				if (a == Integer.parseInt(emonth) || a < Integer.parseInt(emonth)) {
					ob1.setId(rs1.getInt("id"));
					ob1.setName(rs1.getString("name"));
					ob1.setRate(rs1.getDouble("rate"));
					ob1.setQty(rs1.getInt("qty"));
					ob1.setExp_month(rs1.getString("exp_month"));
					ob1.setExp_year(rs1.getString("exp_year"));

					list.add(ob1);
				}
			}
			con.close();

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return list;

	}
}
