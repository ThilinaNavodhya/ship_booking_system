
package ship_booking_system;


public interface SystemManager {
    
     void CreateHarbor(String n,String cun,String con); // implementation in Harbor class
          
     void CreateShippingCompany(String id, String name,String Address); // implementation in ShippingCompany class
          
     void CreateShip(String Shipid, String Shipname, String Country, String Originating, String Destination, int theday, int themonth, int theyear); // implementation in Ship class
         
     void CreateSection(String shi, String SlID, int rows, char cols,String SeatClass );// implementation in Section class
         
     boolean FindAvailableShips(String orig, String dest, String fullDate);// implementation in FindAvailableShips
         
     void BookSeat(String air, String fl, Seat_Class s , int row, char col);// implementation in BookSeat
         
     void DisplaySystemDetails(); // implementation in DisplaySystemDetails
    
}


