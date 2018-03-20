package at.refugeescode.javapsettests.pset4.controller.travelstage;

import at.refugeescode.javapsettests.pset4.model.Luggage;

import java.time.Duration;

public class TransportCart implements TravelStage {

    @Override
    public Luggage process(Luggage luggage) {
        // TODO add 25 minutes to the processing time
        Duration thirdDuration = Duration.ofMinutes(25);
        Duration transportCartWaiting = luggage.getWaitingDuration().plus(thirdDuration);
        luggage.setWaitingDuration(transportCartWaiting);
        return luggage;
    }
}
