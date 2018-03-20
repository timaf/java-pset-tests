package at.refugeescode.javapsettests.pset4.controller;

import at.refugeescode.javapsettests.pset4.controller.travelstage.*;
import at.refugeescode.javapsettests.pset4.model.Luggage;
import at.refugeescode.javapsettests.pset4.view.SummaryReporter;

import java.util.List;
import java.util.stream.Collectors;

public class Airport {

    private SecurityControl securityControl = new SecurityControl();

    private TravelStage dropOff = new DropOffStand();
    private TravelStage storageArea = new StorageArea();
    private TravelStage transportCart = new TransportCart();
    private TravelStage flight = new Flight();
    private TravelStage luggageClaim = new LuggageClaim();

    private SummaryReporter summaryReporter = new SummaryReporter();

    public List<Luggage> travel(List<Luggage> departureLuggage) {
        // TODO apply airport travel stages per the following order

        // show a welcome message
        summaryReporter.showHeader();

        // allow passengers to travel only if they show up at least 30 minus before departure time
        List <Luggage> allowedLuggage = departureLuggage.stream()
                .filter(luggage -> securityControl.isAllowedToTravel(luggage))

                // drop the luggage at the drop off stand
                .map(luggage -> dropOff.process(luggage))

                // bring the luggage to the storage area
                .map(luggage -> storageArea.process(luggage))

                // carry the luggage to the plane with the transport cart
                .map(luggage -> transportCart.process(luggage))

                // flight to the destination
                .map(luggage -> flight.process(luggage))

                // carry the luggage to the luggage claim with the transport cart
                .map(luggage -> transportCart.process(luggage))

                // pick up the luggage from the luggage claim
                .map(luggage -> luggageClaim.process(luggage))
                .collect(Collectors.toList());

        // display luggage report summary for rejected luggage
        summaryReporter.reportRejected(securityControl.getRejectedLuggage());

        // display luggage report summary for accepted luggage
        summaryReporter.reportAccepted(allowedLuggage);

        return allowedLuggage;
    }


}
