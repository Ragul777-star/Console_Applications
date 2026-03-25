public class Customer {
    private int customer_id;
    private char pick_up;
    private char drop;
    private int picktime;

    Customer(int customer_id,char pick_up,char drop,int picktime){
        this.customer_id = customer_id;
        this.pick_up = pick_up;
        this.drop = drop;
        this.picktime = picktime;
    }

    public int getCustomer_id(){
        return customer_id;
    }

    public char getPick_up(){
        return pick_up;
    }

    public char getDrop(){
        return drop;
    }

    public int getPicktime(){
        return picktime;
    }
}
