
package ship_booking_system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import jdk.jshell.spi.ExecutionControl.NotImplementedException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ShippingCompanyClass implements SystemManager{                                   
       
    String id;
    String name;
    String Address;
   
    
    public void CreateShippingCompany(String id, String name,String Address){
    
        id = id; // assign received parameters
        name = name;
        Address =Address;  
         
        Path shipCompList = Path.of("C:/ShipBooking/ShippingCompany.txt");
        String complist;
                             
        try {
             
            complist = Files.readString(shipCompList);
            String[] compNamesArray = complist.split("---------------------Record End------------------------"); //divide records of the file using this string
            boolean compNotAvail=false;
            
            for(int i=0; i<compNamesArray.length;i++){
                String compData = compNamesArray[i];
		System.out.println(compData); 
                if(compData.contains(name) ){ //check there are any record in the company file which match the name
                    JOptionPane.showMessageDialog(null, "Shipping Company Name Already Available"); 
                    compNotAvail = false;
                    break;
                }
                else{
                    compNotAvail = true;
                }
            }
                
                if(compNotAvail==true){

                    if(name.length() >= 6){
                        JOptionPane.showMessageDialog(null, "Shipping Company Name langth should be less than 6 letters"); 
                    }

                    else{
                     //append parameter values to StringBuffer
                    StringBuffer sh = new StringBuffer();
                    sh.append(id+'_');
                    sh.append(name+'_');
                    sh.append(Address+'_');
                     
                     //define a new buffer writer
                    BufferedWriter bwr = new BufferedWriter(new FileWriter("C:/ShipBooking/ShippingCompany.txt",true)); 
                    String[] shArray = sh.toString().split("_");

                    bwr.write("ShippingCompany ID          " + shArray[0] + System.lineSeparator());
                    bwr.write("ShippingCompany Name        " + shArray[1] + System.lineSeparator());
                    bwr.write("continent Address           " + shArray[2] + System.lineSeparator());
                    bwr.write("---------------------Record End------------------------" + System.lineSeparator());
                    bwr.flush();
                    bwr.close();
                    
                    JOptionPane.showMessageDialog(null, "Shipping Company Name Inserted Successfuly"); 
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Shipping Company Name is available"); 
                }                
            }     
             catch(Exception ex){
                  Logger.getLogger(ShipClass.class.getName()).log(Level.SEVERE, null, ex);  
            }
    }
   
   
    @Override   
    public void CreateShip(String Shipid, String Shipname, String Country, String Originating, String Destination, int theday, int themonth, int theyear){

    }

    
    public void CreateHarbor(String n,String cun,String con){
    
    }

    
    public void CreateSection(String shi, String SlID, int rows, char cols,String SeatClass){
        
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
           ds = new FileReader("C:/ShipBooking/ShippingCompany.txt");
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

   
    

    
    

