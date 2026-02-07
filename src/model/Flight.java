package model;

import java.time.LocalDateTime;

public class Flight {

    private String flightNo;
    private String origin;
    private String destination;
    private LocalDateTime deperatureTime;
    private SeatMap seatMap;

    public Flight(String flightNo,String origin,String destination,LocalDateTime deperatureTime,int rows,int cols){
       this.flightNo=flightNo;
       this.origin=origin;
       this.destination=destination;
       this.deperatureTime=deperatureTime;
       this.seatMap= new SeatMap(rows,cols);
    }

    public String getFlightNo(){
        return flightNo;
    }

    public String getOrigin(){
        return origin;
    }

    public String getDestination(){
        return destination;
    }

    public LocalDateTime getDeperatureTime(){
        return deperatureTime;
    }
    public SeatMap getSeatMap(){
        return seatMap;
    }

    @Override
    public String toString(){
        return flightNo+" | "+origin+" -> "+destination+" | "+deperatureTime;
    }

}
