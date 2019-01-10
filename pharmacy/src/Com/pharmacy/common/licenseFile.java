/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Com.pharmacy.common;

import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tg
 */
public class licenseFile {
    String uname;
    String pass;
    String key;

    public licenseFile(String uname, String pass, String key) {
        this.uname = uname;
        this.pass = pass;
        this.key = key;
        
        Properties prop= new Properties();
        String code=this.uname+this.pass+this.key;
        try {
            byte[] data1=code.getBytes("UTF-8");
        
            MessageDigest messageDigest= MessageDigest.getInstance("SHA-256");
        
            byte[] digest=messageDigest.digest(data1);
            String s = new String(digest, "US-ASCII");
            prop.setProperty("code", s);
        
            prop.store(new FileOutputStream("f://license.properties"),null);

            JOptionPane.showMessageDialog(null,"license added");
        
        
        
        } catch (Exception ex) {
            ex.printStackTrace();
                        JOptionPane.showMessageDialog(null,"license adding fail");
            Logger.getLogger(licenseFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    public String getUname(){
        return uname;
    }
    public String getPass(){
        return pass;
    }
    public String getKey(){
        return key;
    }

    public void getUname(String uname){
        uname=this.uname;
    }
    public void getPass(String pass){
        pass=this.pass;
    }
    public void getKey(String key){
        key= this.key;
    }
    

    
}
