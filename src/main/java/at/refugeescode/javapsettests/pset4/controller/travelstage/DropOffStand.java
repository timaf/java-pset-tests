package at.refugeescode.javapsettests.pset4.controller.travelstage;

import at.refugeescode.javapsettests.pset4.model.Luggage;

import java.time.Duration;

public class DropOffStand implements TravelStage {

    @Override
    public Luggage process(Luggage luggage) {
        // TODO add 10 minutes to the processing time
        Duration firstDuration =  Duration.ofMinutes(10);
        Duration dropOffWaiting = luggage.getWaitingDuration().plus(firstDuration);
        luggage.setWaitingDuration(dropOffWaiting);
        return luggage;
    }
}
