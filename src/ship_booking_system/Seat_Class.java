
package ship_booking_system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.nio.file.Files;
import java.nio.file.Path;

public class Seat_Class implements SystemManager{
        
        String OrigHarbor;
        String DesHarbor;
        String DateFull;
        String Air_Type;
        String Ship_Floor;
        Seat_Class newSeat;
        int Ros;
        char columns;    
        boolean shipAvailable;
        
@Override
public void BookSeat(String air, String fl, Seat_Class s, int row, char col)
{        
        Air_Type=air; // assign received parameters
        Ship_Floor=fl;
        Ros=row;
        columns=col;
        newSeat = s;
        
        Path shipsList = Path.of("C:/ShipBooking/BookedSeats.txt");
        String slist;
        
        try {
            slist = Files.readString(shipsList);
            String[] seatsArray = slist.split("---------------------Record End------------------------");
            boolean noBookedSeats=false;
            
            for(int i=0; i<seatsArray.length;i++){
                String bookedSeats = seatsArray[i];
		System.out.println(bookedSeats); //check there are any record in the seat file which match the OrigHarbor,DesHarbor,DateFull,ShipFloor,Ros and columns
                if(bookedSeats.contains(OrigHarbor) && bookedSeats.contains(DesHarbor) && bookedSeats.contains(DateFull) && bookedSeats.contains("ShipFloor - "+Ship_Floor) && bookedSeats.contains(String.valueOf("Ros - "+Ros)) && bookedSeats.contains(String.valueOf("columns - "+columns)) ){
                    JOptionPane.showMessageDialog(null, "Seat Already Booked"); 
                    noBookedSeats = false;
                    break;
                }
                else{
                    noBookedSeats = true;
                }
            }
            
            if(noBookedSeats==true){ //if not booked seats enter seat to the file
                
                try {   
                    //append parameter values to StringBuffer
                    StringBuffer sh = new StringBuffer();
                    sh.append(OrigHarbor+"_");
                    sh.append(DesHarbor+"_");
                    sh.append(DateFull+"_");
                    sh.append(Air_Type+"_");
                    sh.append(Ship_Floor+"_");
                    sh.append(Ros+"_");
                    sh.append(columns+"_");
                    sh.append(newSeat+"_");
                    //define a new buffer writer

                    BufferedWriter bwr = new BufferedWriter(new FileWriter("C:/ShipBooking/BookedSeats.txt",true)); 
                    String[] shArray = sh.toString().split("_");//divide string of the StringBuffer using '_' character. Then put values into an array
                    //write data of StringBuffer into the file using BufferedWriter
                     bwr.write("Ship Originating - " + shArray[0] + System.lineSeparator());
                     bwr.write("Ship Destinating - " + shArray[1] + System.lineSeparator());
                     bwr.write("Booked Date - " + shArray[2] + System.lineSeparator());
                     bwr.write("Air_Type - " + shArray[3] + System.lineSeparator());
                     bwr.write("ShipFloor - " + shArray[4] + System.lineSeparator());
                     bwr.write("Ros - " + shArray[5] + System.lineSeparator());
                     bwr.write("columns - " + shArray[6] + System.lineSeparator());
                     bwr.write("newSeat - " + shArray[7] + System.lineSeparator());
                     bwr.write("---------------------Record End------------------------" + System.lineSeparator());
                     bwr.flush();
                     bwr.close();  
                     
                     JOptionPane.showMessageDialog(null, "Successfully Saved");
                }
                catch(Exception ex)
                {
                    Logger.getLogger(seat.class.getName()).log(Level.SEVERE, null, ex);  
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Seat_Class.class.getName()).log(Level.SEVERE, null, ex);
        }                
}

    @Override
    public boolean FindAvailableShips(String orig, String dest, String fullDate){
              
       
       
        Path shipsList = Path.of("C:/ShipBooking/ship.txt");
        String slist;
        try {
            slist = Files.readString(shipsList); //Read ships from th file
            String[] shipsArray = slist.split("---------------------Record End------------------------"); //get available ships into array
            OrigHarbor = orig; //set data to global variables
            DesHarbor = dest;
            DateFull = fullDate;
            for(int i=0; i<shipsArray.length;i++){
                String oneShip = shipsArray[i];
		System.out.println(oneShip); //Then check the orig, destination and date to find the availabe ships
                if(oneShip.contains(orig) && oneShip.contains(dest) && oneShip.contains(fullDate.split("-")[0]) && oneShip.contains(fullDate.split("-")[1]) && oneShip.contains(fullDate.split("-")[2])){
                    shipAvailable=true;  
                    break;
                }
                else{
                    shipAvailable=false;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Seat_Class.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
       return shipAvailable;
}
    

    
@Override
    public void CreateShippingCompany(String id, String name,String Address){

    } 
        
      
    public void CreateShip(String Shipid, String Shipname, String Country, String Originating, String Destination, int theday, int themonth, int theyear){

    }
    
    public void CreateHarbor(String n,String cun,String con){
    
    }

    public void CreateSection(String shi, String SlID, int rows, char cols,String SeatClass){
        
    }
    
    
 
    public void DisplaySystemDetails(){
        
        FileReader ds;    
       try {
           ds = new FileReader("C:/ShipBooking/BookedSeats.txt");
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

