package com.api.example.fixture.asserters;

import com.api.example.database.example.models.AdminFeesModel;
import com.api.example.fixture.invoke.response.basket.AddFlight;
import com.api.example.fixture.invoke.response.basket.Basket;
import com.api.example.fixture.invoke.response.basket.BasketsResponse;
import com.api.example.fixture.invoke.response.flights.Flight;
import com.api.example.fixture.invoke.response.traveller.Traveller;
import com.api.example.fixture.invoke.response.traveller.Travellers;
import org.apache.commons.math3.util.Precision;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.groups.Tuple;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by daniel on 01/12/2016.
 * assertion wrapper for baskets response object, provides reusable assertions to all tests
 */
public class BasketsAssertion implements IAssertion {

    protected static Logger LOG = LogManager.getLogger(BasketsAssertion.class);
    private final BasketsResponse basketsResponse;

    /**
     * @param basketsResponse
     */
    public BasketsAssertion(BasketsResponse basketsResponse) {
        this.basketsResponse = basketsResponse;
    }

    /**
     * @param basketCode the basket code to check
     * @return this
     */
    public BasketsAssertion isEmptied(String basketCode) {
        assertThat(basketsResponse.getBasket().getCode()).matches(basketCode);
        assertThat(basketsResponse.getBasket().getOutbounds()).isNullOrEmpty();
        assertThat(basketsResponse.getBasket().getInbounds()).isNullOrEmpty();
        return this;
    }

    public BasketsAssertion flightBasePriceAndFeesAreTheSameForASinglePassenger(Flight flight)
    {
        assertThat(basketsResponse.getBasket().getOutbounds().get(0).getFlights().get(0).getTravellers().get(0).getFareProduct().getPricing().getBasePrice()).isEqualTo(flight.getFareTypes().get(0).getPassengers().get(0).getBasePrice().toString());
        return this;
    }

    /**
     * @param addFlights the flights to check
     * @return this
     */
    public BasketsAssertion theCurrencyOfTheBasketIsDefinedAsTheFirstFlight(List<AddFlight> addFlights) {
        assertThat(basketsResponse.getBasket().getCurrency().getCode()).isEqualTo(addFlights.get(0).getCurrency());
        return this;
    }

    /**
     * @return this
     */
    public BasketsAssertion aSingleAdultCannotHaveMultipleInfantsOnTheirLap() {
        com.api.example.fixture.invoke.response.basket.Traveller adult = basketsResponse.getBasket().getOutbounds().stream()
                .flatMap(f -> f.getFlights().stream())
                .flatMap(g -> g.getTravellers().stream())
                .filter(h -> h.getPassengerDetails().getPassengerType().equals("adult"))
                .findFirst()
                .orElse(null);
        assertThat(adult.getInfantsOnLap().size()).isLessThan(2);
        return this;
    }

    /**
     * @return this
     */
    public BasketsAssertion theTotalNumberOfOutboundPassengersIs(int numPax)
    {
        assertThat(basketsResponse.getBasket().getOutbounds().stream()
                .flatMap(f -> f.getFlights().stream())
                .flatMap(g -> g.getTravellers().stream())
                .collect(Collectors.toList())).size().isEqualTo(numPax);
        return this;
    }

    /**
     * @return this
     */
    public BasketsAssertion theBasePriceIsReturnedForEachPassenger() {
        List<com.api.example.fixture.invoke.response.basket.Traveller> basketPassengers = basketsResponse.getBasket().getOutbounds().stream()
                .flatMap(f -> f.getFlights().stream())
                .flatMap(p -> p.getTravellers().stream())
                .collect(Collectors.toList());
        for (com.api.example.fixture.invoke.response.basket.Traveller traveller : basketPassengers) {
            assertThat(traveller.getFareProduct().getPricing().getBasePrice()).isNotEmpty();
        }
        return this;
    }

    /**
     * @param bundle
     * @return
     */
    public BasketsAssertion theFareBundleIsAddedToEachPassenger(String bundle) {
        List<com.api.example.fixture.invoke.response.basket.Traveller> basketPassengers = basketsResponse.getBasket().getOutbounds().stream()
                .flatMap(f -> f.getFlights().stream())
                .flatMap(p -> p.getTravellers().stream())
                .collect(Collectors.toList());
        for (com.api.example.fixture.invoke.response.basket.Traveller traveller : basketPassengers) {
            assertThat(traveller.getFareProduct().getType()).isNotEmpty();
            assertThat(traveller.getFareProduct().getBundleCode()).isEqualTo(bundle);
        }
        return this;
    }

    /**
     * @return
     */
    public BasketsAssertion thePriceChangedWarningIsReturned() {
        assertThat(basketsResponse.getAdditionalInformations().get(0).getMessage())
                .isEqualTo("Please review the price of the flight you are adding to the basket as it has been updated");
        return this;
    }

    /**
     * @param flight
     * @return
     */
    public BasketsAssertion theBasketContainsTheFlight(Flight flight) {
        List<com.api.example.fixture.invoke.response.basket.Flight> basketFlight = basketsResponse.getBasket().getOutbounds().stream()
                .flatMap(f -> f.getFlights().stream())
                .filter(t -> t.getFlightKey().equals(flight.getFlightKey()))
                .collect(Collectors.toList());

        assertThat(basketFlight.size()).isEqualTo(1);
        return this;
    }

    /**
     * @param type
     * @return
     */
    public BasketsAssertion thereIsNoSeatOfType(String type) {
        List<com.api.example.fixture.invoke.response.basket.Traveller> basketTravellers = basketsResponse.getBasket().getOutbounds().stream()
                .flatMap(f -> f.getFlights().stream())
                .flatMap(g -> g.getTravellers().stream())
                .filter(h -> h.getPassengerDetails().getPassengerType().equals(type))
                .collect(Collectors.toList());
        assertThat(basketTravellers).size().isEqualTo(0).as("Child seat was not removed!");
        return this;
    }

    /**
     * @param updated
     * @param originalBasket
     * @return
     */
    public BasketsAssertion theInfantIsOnTheLapOfTheSecondAdult(Travellers updated, Basket originalBasket) {
        //get original adult who had no infant on their lap
        com.api.example.fixture.invoke.response.basket.Traveller adultNoInfant = originalBasket.getOutbounds().stream()
                .flatMap(f -> f.getFlights().stream())
                .flatMap(g -> g.getTravellers().stream())
                .filter(h -> h.getInfantsOnLap().size() <= 0 && h.getPassengerDetails().getPassengerType().equals("adult"))
                .findFirst()
                .orElse(null);
        com.api.example.fixture.invoke.response.basket.Traveller adultWithInfant = basketsResponse.getBasket().getOutbounds().stream()
                .flatMap(f -> f.getFlights().stream())
                .flatMap(g -> g.getTravellers().stream())
                .filter(h -> h.getCode().equals(adultNoInfant.getCode()))
                .findFirst()
                .orElse(null);
        assertThat(adultWithInfant.getInfantsOnLap()).contains(updated.getTravellers().get(0).getCode()).as("Infant was not moved to be on the lap of the adult!");
        return this;
    }

    /**
     * @return
     */
    public BasketsAssertion infantIsNowOnLapOfFirstAdult() {
        List<com.api.example.fixture.invoke.response.basket.Traveller> basketTravellers = basketsResponse.getBasket().getOutbounds().stream()
                .flatMap(f -> f.getFlights().stream())
                .flatMap(g -> g.getTravellers().stream())
                .collect(Collectors.toList());
        com.api.example.fixture.invoke.response.basket.Traveller adult = basketTravellers.stream()
                .filter(p -> p.getPassengerDetails().getPassengerType().equals("adult"))
                .findFirst()
                .orElse(null);
        com.api.example.fixture.invoke.response.basket.Traveller infant = basketTravellers.stream()
                .filter(p -> p.getPassengerDetails().getPassengerType().equals("infant"))
                .findFirst()
                .orElse(null);
        assertThat(adult.getInfantsOnLap()).contains(infant.getCode());
        return this;
    }

    public BasketsAssertion infantIsNowOnTheirOwnSeat(Travellers updated, Basket originalBasket, Basket updatedBasket){
        com.api.example.fixture.invoke.response.basket.Traveller adultWithInfant = originalBasket.getOutbounds().stream()
                .flatMap(f -> f.getFlights().stream())
                .flatMap(g -> g.getTravellers().stream())
                .filter(h -> h.getInfantsOnLap().size() >= 0 && h.getPassengerDetails().getPassengerType().equals("adult"))
                .findFirst()
                .orElse(null);

        List<com.api.example.fixture.invoke.response.basket.Traveller> basketTravellers = originalBasket.getOutbounds().stream()
                .flatMap(f -> f.getFlights().stream())
                .flatMap(g -> g.getTravellers().stream())
                .collect(Collectors.toList());

        com.api.example.fixture.invoke.response.basket.Traveller infant = basketTravellers.stream()
                .filter(p -> p.getTravellerType().equals("infant"))
                .findFirst()
                .orElse(null);

        com.api.example.fixture.invoke.response.basket.Traveller updatedAdult = updatedBasket.getOutbounds().stream()
                .flatMap(f -> f.getFlights().stream())
                .flatMap(g -> g.getTravellers().stream())
                .filter(h -> h.getCode().equals(adultWithInfant.getCode()))
                .findFirst()
                .orElse(null);

        assertThat(updatedAdult.getInfantsOnLap()).isNullOrEmpty();

        List<com.api.example.fixture.invoke.response.basket.Traveller> updatedBasketTravellers = updatedBasket.getOutbounds().stream()
                .flatMap(f -> f.getFlights().stream())
                .flatMap(g -> g.getTravellers().stream())
                .collect(Collectors.toList());

        com.api.example.fixture.invoke.response.basket.Traveller updatedInfant = basketTravellers.stream()
                .filter(p -> p.getCode().equals(infant.getCode()))
                .findFirst()
                .orElse(null);

        return this;
    }

    /**
     * @param basket
     * @param travellers
     * @return
     */
    public BasketsAssertion theBasketContainsTheUpdatedTravellerDetails(Basket basket, Travellers travellers) {
        for (Traveller traveller : travellers.getTravellers()) {
            List<com.api.example.fixture.invoke.response.basket.Traveller> basketTravellers = basket.getOutbounds().stream()
                    .flatMap(f -> f.getFlights().stream())
                    .flatMap(g -> g.getTravellers().stream())
                    .filter(t -> t.getCode().equals(traveller.getCode()))
                    .collect(Collectors.toList());
            for (com.api.example.fixture.invoke.response.basket.Traveller t : basketTravellers) {
                assertThat(t.getPassengerDetails().getName().getFirstName()).isEqualTo(traveller.getPassengerDetails().getName().getFirstName());
                assertThat(t.getPassengerDetails().getPassengerType().toLowerCase())
                        .as("Passenger type has not been updated as expected.").isEqualTo(traveller.getPassengerDetails().getPassengerType().toLowerCase());
                assertThat(t.getAge()).as("Age is not as expected").isEqualTo(traveller.getAge());
            }
        }
        return this;
    }

    /**
     * @param basket
     * @param travellers
     * @param expectedPaxType
     * @return
     */
    public BasketsAssertion theBasketContainsTheUpdatedTravellerDetails(Basket basket, Travellers travellers, String expectedPaxType) {
        for (Traveller traveller : travellers.getTravellers()) {
            List<com.api.example.fixture.invoke.response.basket.Traveller> basketTravellers = basket.getOutbounds().stream()
                    .flatMap(f -> f.getFlights().stream())
                    .flatMap(g -> g.getTravellers().stream())
                    .filter(t -> t.getCode().equals(traveller.getCode()))
                    .collect(Collectors.toList());
            for (com.api.example.fixture.invoke.response.basket.Traveller t : basketTravellers) {
                assertThat(t.getPassengerDetails().getName().getFirstName()).isEqualTo(traveller.getPassengerDetails().getName().getFirstName());
                assertThat(t.getPassengerDetails().getPassengerType().toLowerCase())
                        .as("Passenger type has not been updated as expected.").isEqualTo(expectedPaxType.toLowerCase());
            }
        }
        return this;
    }

    /**
     * @param basket
     * @return
     */
    public BasketsAssertion theBasketIsNotUpdated(BasketsResponse basket) {
        return this;
    }

    /**
     * @param strNoOfExpectedFlights
     * @return
     */
    public BasketsAssertion NumberOfFlightsInBasket(String strNoOfExpectedFlights) {
        assertThat(basketsResponse.getBasket().getOutbounds().size() +
                basketsResponse.getBasket().getInbounds().size()).isEqualTo(Integer.parseInt(strNoOfExpectedFlights));
        return this;
    }

    /**
     * @param channel
     * @param feesFromDB
     * @return
     */
    public BasketsAssertion theCreditCardFeeForEachPassengerIsCorrect(String channel, List<AdminFeesModel> feesFromDB) {
        String creditCardFeeCode = "CRCardFee";
        double creditCardFee = 0;
        double bookingTotalDebitCard = 0;
        for (AdminFeesModel feesModel : feesFromDB) {
            if (feesModel.getFeeCode().contains("CardFee")) {
                creditCardFee = feesModel.getFeeValue();
            }
        }
        List<com.api.example.fixture.invoke.response.basket.Traveller> basketPassengers = basketsResponse.getBasket().getOutbounds().stream()
                .flatMap(f -> f.getFlights().stream())
                .flatMap(p -> p.getTravellers().stream())
                .collect(Collectors.toList());
        for (com.api.example.fixture.invoke.response.basket.Traveller traveller : basketPassengers) {
            if (!channel.contentEquals("Digital")) {
                //assert that Credit card fee is not applied at the customer level for non Digital Channels
                //assertThat(traveller.getFareProduct().getPricing().getFees()).isEmpty();
                assertThat(traveller.getFareProduct().getPricing().getTotalAmountWithCreditCard())
                        .isEqualTo(traveller.getFareProduct().getPricing().getTotalAmountWithDebitCard());
            } else {
                double totalAmountWithDebitCard = traveller.getTravellerTotalWithDebitCard();
                double expectedCreditCardAmount = new BigDecimal((totalAmountWithDebitCard + (totalAmountWithDebitCard * creditCardFee) / 100)).setScale(2, RoundingMode.HALF_UP).doubleValue();
                double expectedCCFeeAmount = new BigDecimal(expectedCreditCardAmount - totalAmountWithDebitCard).setScale(2, RoundingMode.HALF_UP).doubleValue();
                // Check that Credit Card fee is applied at the traveller level for booking made by Digital channel
                assertThat(traveller.getFareProduct().getPricing().getFees()).isNotEmpty();
                assertThat(traveller.getFareProduct().getPricing().getFees()).extracting("code", "amount","percentage").containsSequence(Tuple.tuple(creditCardFeeCode, expectedCCFeeAmount, creditCardFee));
                assertThat(traveller.getTravellerTotalWithCreditCard()).isEqualTo(expectedCreditCardAmount);
            }
        }
        return this;
    }

    /**
     * @param feesFromDB
     * @return
     */
    public BasketsAssertion theTotalFareWithCreditCardIsAtBookingLevel(List<AdminFeesModel> feesFromDB) {
        double adminFee = 0;
        double creditCardFee = 0;
        double bookingTotalDebitCard = 0;
        for (AdminFeesModel feesModel : feesFromDB) {
            if (feesModel.getFeeCode().contains("AdminFee") && feesModel.getFeeCurrency().contains(basketsResponse.getBasket().getCurrency().getCode())) {
                adminFee = feesModel.getFeeValue();
            } else if (feesModel.getFeeCode().contains("CardFee")) {
                creditCardFee = feesModel.getFeeValue();
            }
        }
        //#(BASE PRICE + ADMIN FEE) * CREDIT CARD PERCENTAGE
        //calculate total
        List<com.api.example.fixture.invoke.response.basket.Outbound> basketFlights = basketsResponse.getBasket().getOutbounds().stream()
                .collect(Collectors.toList());

        for (com.api.example.fixture.invoke.response.basket.Outbound outboundFlight : basketFlights) {
            //add up all flight fees
            bookingTotalDebitCard = bookingTotalDebitCard + outboundFlight.getJourneyTotalWithDebitCard();
        }

        double expectedBookingCreditCardAmount = Precision.round((bookingTotalDebitCard + ((bookingTotalDebitCard + adminFee) * creditCardFee) / 100), 2, BigDecimal.ROUND_HALF_UP);
        assertThat(expectedBookingCreditCardAmount).isEqualTo(basketsResponse.getBasket().getSubtotalAmountWithCreditCard());
        return this;
    }

    /**
     * @param feesFromDB
     * @return
     */
    public BasketsAssertion theAdministrationTaxIsAtBookingLevel(List<AdminFeesModel> feesFromDB) {
        Double adminFee = null;
        String adminFeeCode = "AdminFee";
        for (AdminFeesModel feesModel : feesFromDB) {
            if (feesModel.getFeeCode().contains(adminFeeCode) && feesModel.getFeeCurrency()
                    .contains(basketsResponse.getBasket().getCurrency().getCode().toString())) {
                adminFee = feesModel.getFeeValue();
                break;
            }
        }
        List<com.api.example.fixture.invoke.response.basket.Traveller> basketPassengers = basketsResponse.getBasket().getOutbounds().stream()
                .flatMap(f -> f.getFlights().stream())
                .flatMap(p -> p.getTravellers().stream())
                .collect(Collectors.toList());
        //Check that no Admin fees are applied at the traveler level
        for (com.api.example.fixture.invoke.response.basket.Traveller traveller : basketPassengers) {
            assertThat(traveller.getFareProduct().getPricing().getTaxes().isEmpty());
        }
        //Admin Fee is applied at the booking level
        assertThat(basketsResponse.getBasket().getFees().getItems()).extracting("code", "amount").contains(Tuple.tuple(adminFeeCode, adminFee));
        return this;
    }

    /**
     * @param feesFromDB
     * @return
     */
    public BasketsAssertion theTotalFareWithCreditCardIsCorrect(List<AdminFeesModel> feesFromDB) {
        double creditCardFee = 0;
        double totalDebitCard = 0;
        double totalCreditCard = 0;
        double expectedTotalCreditCardAmount = 0;

        for (AdminFeesModel feesModel : feesFromDB) {
            if (feesModel.getFeeCode().contains("CardFee")) {
                creditCardFee = feesModel.getFeeValue();
            }
        }

        totalCreditCard = basketsResponse.getBasket().getTotalAmountWithCreditCard();
        totalDebitCard = basketsResponse.getBasket().getTotalAmountWithDebitCard();

        expectedTotalCreditCardAmount = new BigDecimal((totalDebitCard + (totalDebitCard * creditCardFee) / 100)).setScale(2, RoundingMode.HALF_UP).doubleValue();
        assertThat(expectedTotalCreditCardAmount).isEqualTo(totalCreditCard);
        return this;
    }

    /**
     * @param feesFromDB
     * @return
     */
    public BasketsAssertion theAdministrationFeeDividedAcrossPassengersandOfTheFirstFlightOnly(List<AdminFeesModel> feesFromDB) {
        double adminFee = 0;
        double addedAdminFee = 0;
        int flightOrder = 0;
        double firstFlightAdminFee = 0;
        double subsequentFlightsAdminFee = 1; //this should be reset to 0 in the logic
        for (AdminFeesModel feesModel : feesFromDB) {
            if (feesModel.getFeeCode().contains("AdminFee") && feesModel.getFeeCurrency().contains(basketsResponse.getBasket().getCurrency().getCode().toString())) {
                adminFee = feesModel.getFeeValue();
                break;
            }
        }

        List<com.api.example.fixture.invoke.response.basket.Flight> basketFlights =  basketsResponse.getBasket().getOutbounds().stream()
                .flatMap(f -> f.getFlights().stream()).collect(Collectors.toList());


        //Validate That Admin fees is split only per passenger of the First Flight Only

        for (com.api.example.fixture.invoke.response.basket.Flight flight : basketFlights){

            List<com.api.example.fixture.invoke.response.basket.Traveller> flightPassengers = flight.getTravellers().stream().collect(Collectors.toList());

            for (com.api.example.fixture.invoke.response.basket.Traveller traveller : flightPassengers) {

                for (com.api.example.fixture.invoke.response.basket.Fee fee : traveller.getFareProduct().getPricing().getFees()) {
                    if (fee.getName().contains("Administration Fee")) {
                        addedAdminFee = addedAdminFee + fee.getAmount();
                    }
                }
            }

            if (flightOrder == 0) {
                firstFlightAdminFee = addedAdminFee;
                addedAdminFee = 0;
                flightOrder++;
            } else {
                subsequentFlightsAdminFee = addedAdminFee;
            }
        }

        //Admin Fee split across Flights and Passengers is the same as total

        double subsequentFlightsAdminFeeRounded = Precision.round(subsequentFlightsAdminFee, 1, BigDecimal.ROUND_HALF_UP);
        double firstFlightAdminFeeRounded = Precision.round(firstFlightAdminFee, 1, BigDecimal.ROUND_HALF_UP);
        assertThat(adminFee).isEqualTo(firstFlightAdminFeeRounded);
        assertThat(firstFlightAdminFeeRounded).isNotZero();
        assertThat(subsequentFlightsAdminFeeRounded).isZero();

        return this;
    }

    public BasketsAssertion theAdminFeeShouldBeApportionedPerPassengerAndRoundedToTheNearestPenceForTheFirstTwoSectors(List<AdminFeesModel> feesFromDB) {

        double adminFee = 0;
        double addedTotalAdminFee = 0;
        double addedOutboundAdminFee = 0;
        double addedInboundAdminFee = 0;
        double firstOutboundFlightAdminFee = 0;
        double subsequentOutboundFlightsAdminFee = 0;
        double firstInboundFlightAdminFee = 0;
        double subsequentInboundFlightsAdminFee = 0;
        int outboundFlightOrder = 0;
        int inboundFlightOrder = 0;

        for (AdminFeesModel feesModel : feesFromDB) {
            if (feesModel.getFeeCode().contains("AdminFee") && feesModel.getFeeCurrency().contains(basketsResponse.getBasket().getCurrency().getCode().toString())) {
                adminFee = feesModel.getFeeValue();
                break;
            }
        }

        List<com.api.example.fixture.invoke.response.basket.Flight> basketOutboundFlights =  basketsResponse.getBasket().getOutbounds().stream()
                .flatMap(f -> f.getFlights().stream()).collect(Collectors.toList());

        List<com.api.example.fixture.invoke.response.basket.Flight> basketInboundFlights =  basketsResponse.getBasket().getInbounds().stream()
                .flatMap(f -> f.getFlights().stream()).collect(Collectors.toList());

        //Validate That Admin fees is split only per passenger of the First Flight Only

        for (com.api.example.fixture.invoke.response.basket.Flight flight : basketOutboundFlights){

            List<com.api.example.fixture.invoke.response.basket.Traveller> flightPassengers = flight.getTravellers().stream().collect(Collectors.toList());

            for (com.api.example.fixture.invoke.response.basket.Traveller traveller : flightPassengers) {

                for (com.api.example.fixture.invoke.response.basket.Fee fee : traveller.getFareProduct().getPricing().getFees()) {
                    if (fee.getName().contains("Administration Fee")) {
                        addedOutboundAdminFee = addedOutboundAdminFee + fee.getAmount();
                    }
                }
            }

            if (outboundFlightOrder == 0) {
                firstOutboundFlightAdminFee = addedOutboundAdminFee;
                addedOutboundAdminFee = 0;
                outboundFlightOrder++;
            } else {
                subsequentOutboundFlightsAdminFee = addedOutboundAdminFee;
            }
        }

        for (com.api.example.fixture.invoke.response.basket.Flight flight : basketInboundFlights){

            List<com.api.example.fixture.invoke.response.basket.Traveller> flightPassengers = flight.getTravellers().stream().collect(Collectors.toList());

            for (com.api.example.fixture.invoke.response.basket.Traveller traveller : flightPassengers) {

                for (com.api.example.fixture.invoke.response.basket.Fee fee : traveller.getFareProduct().getPricing().getFees()) {
                    if (fee.getName().contains("Administration Fee")) {
                        addedInboundAdminFee = addedInboundAdminFee + fee.getAmount();
                    }
                }
            }

            if (inboundFlightOrder == 0) {
                firstInboundFlightAdminFee = addedInboundAdminFee;
                addedInboundAdminFee = 0;
                inboundFlightOrder++;
            } else {
                subsequentInboundFlightsAdminFee = addedInboundAdminFee;
            }
        }

        //Admin Fee split across  Passengers of First Outbound and Inbound Flights is the same as total

        double firstOutboundFlightAdminFeeRounded = Precision.round(firstOutboundFlightAdminFee, 1, BigDecimal.ROUND_HALF_UP);
        double subsequentOutboundFlightsAdminFeeRounded = Precision.round(subsequentOutboundFlightsAdminFee, 1, BigDecimal.ROUND_HALF_UP);
        double firstInboundFlightAdminFeeRounded= Precision.round(firstInboundFlightAdminFee, 1, BigDecimal.ROUND_HALF_UP);
        double subsequentInboundFlightsAdminFeeRounded= Precision.round(subsequentInboundFlightsAdminFee, 1, BigDecimal.ROUND_HALF_UP);

        addedTotalAdminFee = firstOutboundFlightAdminFeeRounded+firstInboundFlightAdminFeeRounded;

        assertThat(adminFee).isEqualTo(addedTotalAdminFee);
        assertThat(adminFee).overridingErrorMessage("First Outbound flight added apportioned Admin Fee <%s> should be only half of Total Admin Fee <%s>",firstOutboundFlightAdminFeeRounded, adminFee).isNotEqualTo(firstOutboundFlightAdminFeeRounded);
        assertThat(firstInboundFlightAdminFeeRounded).overridingErrorMessage("Expecting half of Admin Fee <%s> apportioned between all Travelers on Inbound Flight but it was: <%s>", adminFee, firstInboundFlightAdminFeeRounded).isNotZero();
        assertThat(firstOutboundFlightAdminFeeRounded).overridingErrorMessage("Expecting half of Admin Fee <%s> apportioned between all Travelers on Outbound Flight but it was: <%s> ",adminFee,firstOutboundFlightAdminFeeRounded).isNotZero();
        assertThat(subsequentOutboundFlightsAdminFeeRounded).isZero();
        assertThat(subsequentInboundFlightsAdminFeeRounded).isZero();

        return this;

    }

    public void theAdministrationFeeDividedAcrossPassengersandFlights(List<AdminFeesModel> feesFromDB) {
        double adminFee = 0;
        double addedAdminFee = 0;
        for (AdminFeesModel feesModel : feesFromDB) {
            if (feesModel.getFeeCode().contains("AdminFee") && feesModel.getFeeCurrency().contains(basketsResponse.getBasket().getCurrency().getCode().toString())) {
                adminFee = feesModel.getFeeValue();
                break;
            }
        }
        List<com.api.example.fixture.invoke.response.basket.Traveller> basketPassengers = basketsResponse.getBasket().getOutbounds().stream()
                .flatMap(f -> f.getFlights().stream())
                .flatMap(p -> p.getTravellers().stream())
                .collect(Collectors.toList());
        //Validate That Admin fees is split only per passenger of the First Flight Only

        for (com.api.example.fixture.invoke.response.basket.Traveller traveller : basketPassengers) {

            for (com.api.example.fixture.invoke.response.basket.Fee fee : traveller.getFareProduct().getPricing().getFees()) {
                if (fee.getName().contains("Administration Fee")) {
                    addedAdminFee = addedAdminFee + fee.getAmount();
                }
            }
        }
    }
}
