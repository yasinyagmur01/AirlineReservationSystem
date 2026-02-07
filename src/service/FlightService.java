package service;

import model.Flight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class FlightService {

    private List<Flight> flights;

    public FlightService(){
        this.flights = new ArrayList<>();
        seedFlights();

    }


    public void seedFlights(){
        flights.add(new Flight("TK101","Ankara","İstanbul",
                LocalDateTime.of(2026,3,3,18,45),5,6));

        flights.add(new Flight("TK202", "Istanbul", "Izmir",
                LocalDateTime.of(2026, 3, 2, 9, 15), 5, 6));

        flights.add(new Flight("TK303", "Ankara", "Antalya",
                LocalDateTime.of(2026, 3, 3, 18, 45), 5, 6));}



    public void addFlight(Flight flight){
        flights.add(flight);
    }

    public List<Flight> getAllFlights(){
        return Collections.unmodifiableList(flights);
    }

    public Flight findFlightByNumber(String flightNo){
       if(flights==null)return null;


       String key = flightNo.trim();

       for(Flight f:flights){
           if(f.getFlightNo().equalsIgnoreCase(key)){
               return f;
           }
       }
       return null;
    }

    public List<Flight> searchFlights(String origin,String destinations){
            if(origin==null||destinations==null)return Collections.emptyList();

            String o = origin.trim();
            String d = destinations.trim();

            if(o.isEmpty()||d.isEmpty())return Collections.emptyList();

            List<Flight> results = new ArrayList<>();

            for(Flight f: flights){
                if(f.getOrigin().equalsIgnoreCase(o)&&f.getDestination().equalsIgnoreCase(d)){
                    results.add(f);
                }
            }
        return results;
    }


}
