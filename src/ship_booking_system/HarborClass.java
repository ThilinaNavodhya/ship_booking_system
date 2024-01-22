
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


public class HarborClass implements SystemManager{
    
   String harborName;
   String country;
   String continent;
   
   public void CreateHarbor(String n,String cun,String con){
                
        harborName = n;
        country=cun;
        continent=con;
        
        Path HarborCompList = Path.of("C:/ShipBooking/Harbor.txt");
        String complist;
                             
        try {
             
            complist = Files.readString(HarborCompList);
            String[] compNamesArray = complist.split("---------------------Record End------------------------"); //divide records of the file using this string
            boolean compNotAvail=false;
            
            for(int i=0; i<compNamesArray.length;i++){
                String compData = compNamesArray[i];
		System.out.println(compData); 
                
                if(compData.contains(harborName) ){ //check there are any record in the company file which match the name
                    JOptionPane.showMessageDialog(null, "Harbor Name Already Available"); 
                    compNotAvail = false;
                    break;
                }
                else{
                    compNotAvail = true;
                }
            }
                
                if(compNotAvail==true){

                    if(harborName.length()>=4){
                        JOptionPane.showMessageDialog(null, "Harbor Name langth should be less than 3 letters"); 
                    }

                    else{


                StringBuffer sh = new StringBuffer();
                sh.append(n+'_');
                sh.append(cun+'_');
                sh.append(con+'_');
                 //define a new buffer writer
                BufferedWriter bwr = new BufferedWriter(new FileWriter("C:/ShipBooking/Harbor.txt",true)); 
                String[] shArray = sh.toString().split("_");//divide string of the StringBuffer using '_' character. Then put values into an array
                //write data of StringBuffer into the file using BufferedWriter
                 bwr.write("Harbor name           " + shArray[0] + System.lineSeparator());
                 bwr.write("country               " + shArray[1] + System.lineSeparator());
                 bwr.write("continent Numbor      " + shArray[2] + System.lineSeparator());
                 bwr.flush();
                 bwr.close();
              
            JOptionPane.showMessageDialog(null, "Harbor Name Inserted Successfuly"); 
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Harbor Name is available"); 
                }                
            }     
             catch(Exception ex){
                  Logger.getLogger(ShipClass.class.getName()).log(Level.SEVERE, null, ex);  
            }
    }
                      

     @Override
    public void CreateShippingCompany(String id, String name,String Address){

    } 
   
    
    public void CreateShip(String Shipid, String Shipname, String Country, String Originating, String Destination, int theday, int themonth, int theyear){

    }
    
    
    public void Createarbor(String n,String cun,String con){
    
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
           ds = new FileReader("C:/ShipBooking/Harbor.txt");
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


    
  

    

