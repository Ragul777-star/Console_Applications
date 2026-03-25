import java.util.ArrayList;
import java.util.List;

public class Booking_System {
    private List<Taxi> taxis;
    int bookingid = 1;
    Booking_System(int taxiCount){
        taxis = new ArrayList<>();
        for(int i=1;i<=taxiCount;i++){
            taxis.add(new Taxi(i));
        }
    }

    //Book Taxi
    void bookTaxi(Customer c){
        Taxi selected = findTaxi(c.getPick_up(),c.getPicktime());
        if(selected == null){
            System.out.println("No Taxi is Available");
            return;
        }
        int traveltime = Math.abs(c.getPick_up() - c.getDrop());
        int droptime = c.getPicktime() + traveltime;
        int charges = calculateCharges(c.getPick_up(),c.getDrop());
        Booking booking = new Booking(bookingid,droptime,charges,c);
        bookingid++;

        selected.assignBookings(booking);
        selected.setFree_time(droptime);
        selected.setEarnings(selected.getEarnings() + charges);
        selected.setCurrent_spot(c.getDrop());

        System.out.println("Taxi-"+ selected.getTaxi_id()+"is allocated");
    }

    //Calculate Charges
    private int calculateCharges(char pick_up,char drop){
        int distance = Math.abs(pick_up-drop) * 15;//Convert this into km by multiply with 15;
        int charges = 100;
        distance -= 5;
        charges += distance * 10;
        return charges;
    }

    //Find taxi to book
    Taxi findTaxi(char pickup,int pickTime) {
        List<Taxi> freeTaxis = new ArrayList<>();
        for (Taxi t : taxis) {
            if (t.isFree(pickup, pickTime)) {
                freeTaxis.add(t);
            }
        }
        if (freeTaxis.isEmpty()) return null;

        //Calculate min-dis
        int min_dis = Integer.MAX_VALUE;
        for (Taxi t : freeTaxis) {
            int dis = Math.abs(pickup - t.getC_spot());
            if (dis < min_dis) {
                min_dis = dis;
            }
        }

        //calculate the taxi with that min_dis

        List<Taxi> closest = new ArrayList<>();
        for (Taxi t : freeTaxis) {
            int dis = Math.abs(pickup - t.getC_spot());
            if (dis == min_dis) closest.add(t);
        }

        //Find Taxi with minimum Earnings
        Taxi selected = closest.get(0);
        for (Taxi t : closest) {
            if (t.getEarnings() < selected.getEarnings()) {
                selected = t;
            }
        }
        return selected;
    }

    void displayTaxi(){
        for(Taxi t:taxis){
            System.out.println("Taxi-" + t.getTaxi_id() +" Earnings: " +t.getEarnings());
        }
    }
}
