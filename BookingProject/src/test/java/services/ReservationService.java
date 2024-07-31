package services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Booking;
import models.BookingDates;
import models.BookingResponse;

import static io.restassured.RestAssured.given;

public class ReservationService extends BaseTest{

    public BookingResponse createBooking() {
        BookingDates bookingDates = new BookingDates("2023-04-01", "2023-05-01");
        Booking booking = new Booking("Udemy", "Cucumber", 1000, false, bookingDates, "Kopek yatagi");

        Response response = given(spec)
                .contentType(ContentType.JSON)
                .when()
                .body(booking)
                .post("/booking");

        response
                .then()
                .statusCode(200);

        return response.as(BookingResponse.class);
    }

}
