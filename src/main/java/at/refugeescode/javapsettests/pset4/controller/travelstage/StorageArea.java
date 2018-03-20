package at.refugeescode.javapsettests.pset4.controller.travelstage;

import at.refugeescode.javapsettests.pset4.model.Luggage;

import java.time.Duration;
import java.time.LocalDateTime;

public class StorageArea implements TravelStage {

    @Override
    public Luggage process(Luggage luggage) {
        // TODO add as much duration to the processing time as the departure time minus 30 minutes
        Duration interval = Duration.between(luggage.getDropOffTime(), luggage.getDepartureTime());
        // if 30 minutes is not possible, the luggage won't be stored at all, which means that
        // no waiting time will be added at all
        if (interval.toMinutes() > 30) {
            Duration secondDuration = luggage.getWaitingDuration().plus(interval.minusMinutes(40));
            luggage.setWaitingDuration(secondDuration);
            return luggage;
        }

        return luggage;
    }
}
