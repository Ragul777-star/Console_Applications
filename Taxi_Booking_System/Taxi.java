import java.util.*;
public class Taxi {
    private int taxi_id;
    private char current_spot;
    private int free_time;
    private int earnings;
    private List<Booking> bookings;

    Taxi(int id){
        this.taxi_id = id;
        this.current_spot = 'A';
        this.free_time = 0;
        this.earnings = 0;
        bookings = new ArrayList<>();
    }

    public boolean isFree(char pick_up,int pickTime){
        int traveltime = Math.abs(pick_up - current_spot);
        if(free_time + traveltime <= pickTime){
            return true;
        }
        return false;
    }

    public void assignBookings(Booking b){
        bookings.add(b);
    }

    public int getTaxi_id(){ return  taxi_id;}
    public char getC_spot(){ return  current_spot;}
    public int getEarnings(){ return  earnings;}
    public int getFree_time(){ return  free_time;}
    public List<Booking> getBookings(){
        return bookings;
    }
    public void setFree_time(int free_time){
        this.free_time = free_time;
    }

    public void setEarnings(int earnings){
        this.earnings = earnings;
    }

    public void setCurrent_spot(char current_spot){
        this.current_spot = current_spot;
    }
}

