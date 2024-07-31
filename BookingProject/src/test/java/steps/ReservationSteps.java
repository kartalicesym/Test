package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.BookingResponse;
import org.junit.jupiter.api.Assertions;
import services.ReservationService;

public class ReservationSteps {

    ReservationService reservationService;
    BookingResponse bookingResponse;

    @Given("Kullanici yeni bir rezervasyon olusturuyor")
    public void create() {
        reservationService = new ReservationService();
        System.out.println("step1");
    }
    @When("Kullanici otel rezervasyonu yaratiyor")
    public void createBooking() {
       bookingResponse = reservationService.createBooking();
        System.out.println("step2");
    }
    @Then("Rezervasyon basarili sekilde olusturuldu")
    public void report() {
        Assertions.assertEquals("Udemy", bookingResponse.getBooking().getFirstname());

        System.out.println("step3");
    }
}
