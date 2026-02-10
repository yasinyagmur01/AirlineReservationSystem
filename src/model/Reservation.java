package model;

public class Reservation {
    private String pnr;
    private Passenger passenger;
    private Flight flight;
    private String seatLabel;
    private ReservationStatus status;


    public Reservation(String pnr, Passenger passenger, Flight flight, String seatLabel){
            this.pnr=pnr;
            this.passenger = passenger;
            this.flight=flight;
            this.seatLabel=seatLabel;
            //In first reservation it should be Active (before check-in or cancel operations)
            this.status = ReservationStatus.ACTIVE;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public String getPnr() {
        return pnr;
    }

    public Flight getFlight() {
        return flight;
    }

    public String getSeatLabel() {
        return seatLabel;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void cancel(){
        if(status == ReservationStatus.CHECKED_IN){
            throw new IllegalStateException("Checked-In reservation cannot be cancalled.");
        }
        if(status == ReservationStatus.CANCELLED){
            return;
        }
        status = ReservationStatus.CANCELLED;
    }

    public void checkIn(){
       if(status==ReservationStatus.CANCELLED){
           throw new IllegalStateException("Cancelled reservvation cannot be Checked-in");
       }
       if(status==ReservationStatus.CHECKED_IN){
           return;
       }
       status = ReservationStatus.CHECKED_IN;
    }

    @Override
    public String toString(){
        return "PNR: "+ pnr+" | "+passenger.getId()+" | "+flight.getFlightNo()+" | "+passenger.getFullName()+" | Seat: "+seatLabel+" | "+ getStatus();
    }


}
