package Com.pharmacy.common;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class backupdb {

	public static void backup() {
		Process p = null;
        try {

            Runtime runtime = Runtime.getRuntime();
            
            Date d= new Date();
            DateFormat df= new SimpleDateFormat("yyyy-mm-dd");
            String date=df.format(d);
           
            p = runtime.exec("C:\\xampp\\mysql\\bin\\mysqldump -uroot --add-drop-database -B hbk -r " + "F:" + "\\"+date+".sql");
            //change the dbpass and dbname with your dbpass and dbname
            int processComplete = p.waitFor();

            if (processComplete == 0) {
                JOptionPane.showMessageDialog(null, "Backup created successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Could not create the backup   !!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

	}
}
