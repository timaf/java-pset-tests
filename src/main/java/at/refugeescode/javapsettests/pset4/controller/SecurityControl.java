package at.refugeescode.javapsettests.pset4.controller;

import at.refugeescode.javapsettests.pset4.model.Luggage;


import java.util.ArrayList;
import java.util.List;

public class SecurityControl {

    private List<Luggage> rejectedLuggage = new ArrayList<>();

    public boolean isAllowedToTravel(Luggage luggage) {
        // validate that the luggage arrived at least 30 minutes before departure time
        if(luggage.getDropOffTime().plusMinutes(30).isBefore(luggage.getDepartureTime())){
        // counting between the drop off time and the departure time
        return true;
        } else {
            // remember the luggage that has been rejected in order to facilitate it later on
            rejectedLuggage.add(luggage);
            return false;
        }
    }

    public List<Luggage> getRejectedLuggage() {
        return rejectedLuggage;
    }
}
