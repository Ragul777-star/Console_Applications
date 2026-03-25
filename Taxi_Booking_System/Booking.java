public class Booking {
    private int booking_id;
    private int drop_time;
    private int charges;
    private Customer customer;
    Booking(int booking_id,int drop_time,int charges,Customer customer){
        this.booking_id = booking_id;
        this.drop_time = drop_time;
        this.charges = charges;
        this.customer = customer;
    }
    //Encapsulation just because we can only read this value not able to change it;
    public int getBooking_id(){
        return booking_id;
    }
    public int getDrop_time(){
        return drop_time;
    }
    public int getCharges(){
        return charges;
    }
    public Customer getCustomer(){
        return customer;
    }
}
