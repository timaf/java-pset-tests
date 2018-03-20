package at.refugeescode.javapsettests.pset4.controller.travelstage;

import at.refugeescode.javapsettests.pset4.model.Luggage;

import java.time.Duration;
import java.time.LocalDateTime;

public class Flight implements TravelStage {

    @Override
    public Luggage process(Luggage luggage) {
        // TODO add travel duration to the processing time
        Duration forthDuration = luggage.getWaitingDuration().plus(luggage.getFlightDuration());
        luggage.setWaitingDuration(forthDuration);
        // Update arrival time
        long flightDuration = luggage.getFlightDuration().toHours();
        LocalDateTime arrivalTime = luggage.getDepartureTime().plusHours(flightDuration);
        luggage.setArrivalTime(arrivalTime);
        return luggage;
    }
}