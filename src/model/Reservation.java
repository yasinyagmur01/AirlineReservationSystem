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
        status = ReservationStatus.CANCELLED;
    }

    public void checkIn(){
        status = ReservationStatus.CHECKED_IN;
    }

    @Override
    public String toString(){
        return "PNR: "+ pnr+" | "+passenger.getId()+" | "+flight.getFlightNo()+" | "+passenger.getFullName()+" | Seat: "+seatLabel+" | "+ getStatus();
    }


}
