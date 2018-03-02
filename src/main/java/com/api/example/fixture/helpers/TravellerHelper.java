package com.api.example.fixture.helpers;

import com.api.example.database.example.ExamplePassengerTypeDao;
import com.api.example.database.example.models.PassengerTypeDbModel;
import com.api.example.fixture.invoke.response.basket.BasketsResponse;
import com.api.example.fixture.invoke.response.traveller.*;
import lombok.Setter;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by dwebb on 11/25/2016.
 */
@Component
public class TravellerHelper {

    @Setter
    private int AdultMin;
    @Setter
    private int AdultMax;
    @Setter
    private int ChildMax;
    @Setter
    private int ChildMin;
    @Setter
    private int InfantMax;

    private static DataFactory df = new DataFactory();

    private ExamplePassengerTypeDao examplePassengerTypeDao;

    @Autowired
    public TravellerHelper(ExamplePassengerTypeDao examplePassengerTypeDao) {
        this.examplePassengerTypeDao = examplePassengerTypeDao;
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    //TODO: This was changing the passenger type to be correct as well as the age, this is not the
    //method for doing that, this is only for changing age
    public Travellers CreateRequestToChangePassengerAge(String original, String changeTo, String channel, BasketsResponse basket) throws Exception {
        List<Traveller> travellers = new ArrayList<>();
        Traveller traveller = aTraveller();
        traveller.getPassengerDetails().setPassengerType(original.toLowerCase());
        traveller.setAge(GetAge(changeTo));
        traveller.getPassengerDetails().getName().setTitle(GetTitle(changeTo));
        traveller.setCode(GetPassengerCode(basket, original));
        travellers.add(traveller);
        return Travellers.builder().travellers(travellers).build();

    }

    public Travellers CreateRequestWithFieldsSetAs(List<FieldAndValue> fields, BasketsResponse basket) throws Exception {
        List<Traveller> travellers = new ArrayList<>();
        Traveller traveller = aTraveller();

        boolean setAge = true;

        for (FieldAndValue fv : fields) {
            switch (fv.getField()) {
                case "firstname":
                    traveller.getPassengerDetails().getName().setFirstName(fv.getValue());
                    break;
                case "lastname":
                    traveller.getPassengerDetails().getName().setLastName(fv.getValue());
                    break;
                case "title":
                    traveller.getPassengerDetails().getName().setTitle(fv.getValue());
                    break;
                case "passengertype":
                    traveller.getPassengerDetails().setPassengerType(fv.getValue());
                    break;
                case "age":
                    if (fv.getValue() != null) {
                        traveller.setAge(Integer.parseInt(fv.getValue()));
                    }
                    else
                    {
                        traveller.setAge(null);
                    }
                    setAge = false;
                    break;
                case "phoneNumber":
                    traveller.getPassengerDetails().setPhoneNumber(fv.getValue());
                    break;
                default:
                    throw new IllegalArgumentException("the parameter you provided is not valid.  you provided: " + fv.getField());
            }
        }
        if (setAge && traveller.getPassengerDetails().getPassengerType() != null) {
            traveller.setAge(GetAge(traveller.getPassengerDetails().getPassengerType()));
        }
        traveller.setCode(GetPassengerCode(basket, "adult"));
        travellers.add(traveller);
        return Travellers.builder().travellers(travellers).build();
    }

    public Travellers CreateRequestWithFieldSetAs(FieldAndValue field, BasketsResponse basket) throws Exception {
        List<Traveller> travellers = new ArrayList<>();
        Traveller traveller = aTraveller();

        boolean setAge = true;

            switch (field.getField()) {
                case "firstname":
                    traveller.getPassengerDetails().getName().setFirstName(field.getValue());
                    break;
                case "lastname":
                    traveller.getPassengerDetails().getName().setLastName(field.getValue());
                    break;
                case "title":
                    traveller.getPassengerDetails().getName().setTitle(field.getValue());
                    break;
                case "passengertype":
                    traveller.getPassengerDetails().setPassengerType(field.getValue());
                    break;
                case "age":
                    if (field.getValue() != null) {
                        traveller.setAge(Integer.parseInt(field.getValue()));
                    }
                    else
                    {
                        traveller.setAge(null);
                    }
                    setAge = false;
                    break;
                case "phoneNumber":
                    traveller.getPassengerDetails().setPhoneNumber(field.getValue());
                    break;
                case "email":
                    traveller.getPassengerDetails().setEmail(field.getValue());
                    break;
                default:
                    throw new IllegalArgumentException("the parameter you provided is not valid.  you provided: " + field.getField());
            }

        if (setAge && traveller.getPassengerDetails().getPassengerType() != null) {
            traveller.setAge(GetAge(traveller.getPassengerDetails().getPassengerType()));
        }

        traveller.setCode(GetPassengerCode(basket, "adult"));
        travellers.add(traveller);
        return Travellers.builder().travellers(travellers).build();
    }

    public Travellers CreateValidRequestToAddAllTravellersForBasket(BasketsResponse basket) {
        List<Traveller> travellers = new ArrayList<>();

        List<com.api.example.fixture.invoke.response.basket.Traveller> basketTravellers = GetAllOutboundTravellers(basket);
        basketTravellers.addAll(GetAllInboundTravellers(basket));

        basketTravellers.stream().filter(distinctByKey(p -> p.getCode()));

        for (com.api.example.fixture.invoke.response.basket.Traveller basketTraveller : basketTravellers) {
            Traveller traveller = aTraveller();
            traveller.getPassengerDetails().setPassengerType(basketTraveller.getPassengerDetails().getPassengerType());
            traveller.setAge(GetAge(basketTraveller.getPassengerDetails().getPassengerType()));
            traveller.setCode(basketTraveller.getCode());
            travellers.add(traveller);
        }

        return Travellers.builder().travellers(travellers).build();

    }

    public List<com.api.example.fixture.invoke.response.basket.Traveller> GetAllOutboundTravellers(BasketsResponse basket) {
        return basket.getBasket().getOutbounds().stream()
                .flatMap(f -> f.getFlights().stream())
                .flatMap(g -> g.getTravellers().stream())
                .collect(Collectors.toList());

    }

    public List<com.api.example.fixture.invoke.response.basket.Traveller> GetAllInboundTravellers(BasketsResponse basket) {
        return basket.getBasket().getInbounds().stream()
                .flatMap(f -> f.getFlights().stream())
                .flatMap(g -> g.getTravellers().stream())
                .collect(Collectors.toList());

    }

    public int GetValidAgeForPassengerType(String type)
    {
        return GetAge(type);
    }

    private String GetPassengerCode(BasketsResponse basket, String original) throws Exception {
        List<com.api.example.fixture.invoke.response.basket.Traveller> travellers = basket.getBasket().getOutbounds().get(0).getFlights().get(0).getTravellers(); //.stream().filter(t -> t.getPassengerDetails().getPassengerType() == original).map(Traveller::getAdditionalProperties).collect(Collectors.toList());

        for (com.api.example.fixture.invoke.response.basket.Traveller traveller : travellers) {
            if (traveller.getPassengerDetails().getPassengerType().toLowerCase().equals(original.toLowerCase())) {
                return traveller.getCode();
            }
        }

        throw new Exception("No passenger type of " + original + " was found in the basket!");

    }

    private int GetAge(String paxType) {

        if (AdultMin == 0 && InfantMax == 0 && ChildMin == 0)
        {
            List<PassengerTypeDbModel> examplePassengers = examplePassengerTypeDao.getPassengersOfType("adult");
            this.setAdultMax(99);
            this.setAdultMin(examplePassengers.get(0).getMinAge());
            examplePassengers = examplePassengerTypeDao.getPassengersOfType("child");
            this.setChildMax(examplePassengers.get(0).getMaxAge());
            this.setChildMin(examplePassengers.get(0).getMinAge());
            examplePassengers = examplePassengerTypeDao.getPassengersOfType("infant");
            this.setInfantMax(examplePassengers.get(0).getMaxAge());
        }


        switch (paxType) {
            case "adult":
            case "Adult":
            case "Adults":
                return AdultMin + 10;
            case "infant":
            case "Infant":
            case "Infants":
                return InfantMax - 1;
            case "child":
            case "Child":
            case "Children":
                return ChildMax - 1;
        }

        return 0;

    }

    private String GetTitle(String paxType)
    {
        switch (paxType) {
            case "adult":
            case "Adult":
            case "Adults":
                return "MR";
            case "infant":
            case "Infant":
            case "Infants":
                return "INFANT";
            case "child":
            case "Child":
            case "Children":
                return "MISS";
        }

        return "MR";
    }

    private Traveller aTraveller() {

        return Traveller.builder()
                .code("123456")
                .travellerType("ADULT_CHILD_INFANT_SEAT")
                //.relatedAdult("string")
                .passengerDetails(
                        PassengerDetails.builder()
                                .email(df.getEmailAddress())
                                .name(
                                        Name.builder()
                                                .firstName(df.getFirstName() + df.getRandomChars(5))
                                                .lastName(df.getLastName() + df.getRandomChars(5))
                                                .fullName(df.getName() + df.getRandomChars(5))
                                                .title("MR")
                                                .build()
                                )
                                .email(df.getFirstName() + df.getRandomChars(5) + "." + df.getLastName() + "@" + df.getRandomChars(5) + ".com")
                                .phoneNumber(df.getNumberText(12))
                                //.ejPlusCardNumber("")
                                //.nifNumber("")
                                .passengerType("adult")
                                .build()
                )
                .age(1)
                .lead(true)
                .passengerAPIS(
                        PassengerAPIS.builder()
                                .name(
                                        Name.builder()
                                                .firstName(df.getFirstName())
                                                .lastName(df.getLastName())
                                                .fullName(df.getName())
                                                .title("MR")
                                                .build()
                                )
                                .countryOfIssue("GBR")
                                .nationality("GBR")
                                .gender("MALE")
                                .documentType("PASSPORT")
                                .documentNumber("YT1234567A")
                                .documentExpiryDate("2099-01-01")
                                .dateOfBirth("1980-01-01")
                                .build()
                )
                .build();
    }

}

