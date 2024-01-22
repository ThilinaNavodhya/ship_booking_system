
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

    
public class ShipClass implements SystemManager{
    
    String Shipid;
    String Shipname;
    String Originating;
    String Destination;
    String Country;
    int theyear;
    int themonth;
    int theday;
    
     

    public void CreateShip(String Shipid, String Shipname, String Country, String Originating, String Destination, int theday, int themonth, int theyear){
        
        Shipid = Shipid;// assign received parameters
        Shipname=Shipname;
        Originating=Originating;
        Destination=Destination;
        Country=Country;
        theyear=theyear;
        themonth=themonth;
        theday=theday;
        
            try {    
                StringBuffer sh = new StringBuffer();
                sh.append(Shipid+"_");
                sh.append(Shipname+"_");
                sh.append(Country+"_");
                sh.append(Originating+"_");
                sh.append(Destination+"_");
                sh.append(String.valueOf(theyear)+"_");
                sh.append(String.valueOf(themonth)+"_");
                sh.append(String.valueOf(theday)+"_");
                //define a new buffer writer
                BufferedWriter bwr = new BufferedWriter(new FileWriter("C:/ShipBooking/ship.txt",true)); 
                String[] shArray = sh.toString().split("_");

                System.out.println(String.valueOf(theyear)+"_");
                System.out.println(String.valueOf(themonth)+"_");
                System.out.println(String.valueOf(theday)+"_");
                 //define a new buffer writer
                 bwr.write("Ship ID - " + shArray[0] + System.lineSeparator());
                 bwr.write("Ship Name - " + shArray[1] + System.lineSeparator());
                 bwr.write("Country - " + shArray[2] + System.lineSeparator());
                 bwr.write("Ship Originating - " + shArray[3] + System.lineSeparator());
                 bwr.write("Ship Destination - " + shArray[4] + System.lineSeparator());
                 bwr.write("year  -  " + shArray[5] + System.lineSeparator());
                 bwr.write("month -  " + shArray[6] + System.lineSeparator());
                 bwr.write("day   -  " + shArray[7] + System.lineSeparator());
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
    public void CreateShippingCompany(String id, String name,String Address){

    } 

    
    public void CreateHarbor(String n,String cun,String con){
    
    }

    
    public void CreateSection(String shi, String SlID, int rows, char cols,String SeatClass){
        
    }


    public void BookSeat(String air, String fl, Seat_Class s , int row, char col){
        
    }
    
    
    public boolean FindAvailableShips(String orig, String dest, String fullDate){
      return false;
    }
  
 
    public void DisplaySystemDetails(){

        FileReader ds;    
       try {
           ds = new FileReader("C:/ShipBooking/ship.txt");
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

    



 

    
    
    

    


    