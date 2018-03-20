package at.refugeescode.javapsettests.pset4.controller;

import at.refugeescode.javapsettests.pset4.model.Luggage;
import at.refugeescode.javapsettests.pset4.util.TimeUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class AirportTest {
    private Luggage luggage;
    private SecurityControl securityControl;

    @BeforeEach
    void setUp() {
        luggage = new Luggage();
        securityControl = new SecurityControl();
    }


    @ParameterizedTest
    @ValueSource(strings = {"2:29", "2:20", "1:10"})
    void travelAllowed(String time) {
        luggage.setDropOffTime(TimeUtils.todayAt(time));
        luggage.setDepartureTime(TimeUtils.todayAt("3:00"));
        assertTrue(securityControl.isAllowedToTravel(luggage));
    }

    @ParameterizedTest
    @ValueSource(strings = {"14:30", "14:40", "16:10"})
    void travelRegected(String time) {
        luggage.setDropOffTime(TimeUtils.todayAt(time));
        luggage.setDepartureTime(TimeUtils.todayAt("15:00"));
        assertEquals(securityControl.isAllowedToTravel(luggage), securityControl.getRejectedLuggage().isEmpty());
    }
}