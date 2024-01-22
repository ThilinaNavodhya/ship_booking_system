
package ship_booking_system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import jdk.jshell.spi.ExecutionControl.NotImplementedException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Ship_Section_Class implements SystemManager {
    String Shipid;
    String Shipcommid;
    int Ros;
    char columns;
    String seattype;
               
    @Override
    public void CreateSection(String shi, String SlID, int rows, char cols,String SeatClass){
        Shipid = shi; // assign received parameters
        Shipcommid=SlID;
        Ros=rows;
        columns=cols;
        seattype=SeatClass;
     
            try {    
                //append parameter values to StringBuffer
                StringBuffer sh = new StringBuffer();
                sh.append(Shipid+"_");
                sh.append(Shipcommid+"_");
                sh.append(Ros+"_");
                sh.append(columns+"_");
                sh.append(seattype+"_");
                
                //define a new buffer writer
                BufferedWriter bwr = new BufferedWriter(new FileWriter("C:/ShipBooking/Ship_Section.txt",true)); 
                String[] shArray = sh.toString().split("_"); //divide string of the StringBuffer using '_' character. Then put values into an array
                 
                //write data of StringBuffer into the file using BufferedWriter
                 bwr.write("Ship ID - " + shArray[0] + System.lineSeparator());
                 bwr.write("Shipping Company ID   - " + shArray[1] + System.lineSeparator());
                 bwr.write("Ros - " + shArray[2] + System.lineSeparator());
                 bwr.write("columns - " + shArray[3] + System.lineSeparator());
                 bwr.write("seat type - " + shArray[4] + System.lineSeparator());
                 bwr.write("---------------------Record End------------------------" + System.lineSeparator());
                 bwr.flush();
                 bwr.close();
                 
                 JOptionPane.showMessageDialog(null, "Successfully Saved");
              
            }     
             catch(Exception ex){
                  Logger.getLogger(ShipClass.class.getName()).log(Level.SEVERE, null, ex);  
            }
   }
    
    @Override   
    public void CreateShip(String Shipid, String Shipname, String Country, String Originating, String Destination, int theday, int themonth, int theyear){

    }
        
    @Override
    public void CreateShippingCompany(String id, String name,String Address){

    } 

    
    public void CreateHarbor(String n,String cun,String con){
    
    }


    //bool FindAvailableShips(String orig, String dest);

    public void BookSeat(String air, String fl, Seat_Class s , int row, char col){
       
    }
    

    public boolean FindAvailableShips(String orig, String dest, String fullDate){
     return false;
    }
  
 
    public void DisplaySystemDetails(){
    FileReader ds;    
       try {
           ds = new FileReader("C:/ShipBooking/Ship_Section.txt");
           BufferedReader readF = new BufferedReader(ds);    
            
            String line;
            StringBuilder fileString = new StringBuilder();
            while ((line = readF.readLine()) != null) {
                System.out.println(line + System.lineSeparator());
                fileString.append(line + System.lineSeparator());
            }  
          JOptionPane.showMessageDialog(null, fileString.toString());
          readF.close();    
          ds.close(); 
       } catch (FileNotFoundException ex) {
           Logger.getLogger(HarborClass.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(HarborClass.class.getName()).log(Level.SEVERE, null, ex);
       }
            
    }
  
}

    


