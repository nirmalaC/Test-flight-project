# Test-flight-project
 
The Example Automation Framework (HAF) is a Java based automation framework that utilises many different technologies, the main ones being:
cucumberJVM - for providing the 'glue' from feature files to step defintions
Serenity - for reporting and providing coverage and traceability
Jersey Client API - for API connectivity (GET, POST etc)
Lombok - for reducing bolierplate code (Getters, Setters, Builders)
Spring - dependency injection and Inversion of Control
AssertJ - for assertions

1	REQUIRED READING
Specification By Example - Gojko Adzic
Scrum And XP From The Trenches
Imperative vs Declarative
git basics

3	HIGH LEVEL CONCEPTS
The EAF allows testers to execute requests against an API and receive responses.
Requests use HttpMethods such as GET, POST, PUT or DELETE to get a response from a resource or endpoint. The Response is in JSON format and is then cast to an object representing that structure, which we call the domain object.
Responses can then be stored in local variable and asserted against later in the test.
3.1	Cucumber
Cucumber uses the gherkin format for the specification of expected behaviour, in line with the Behaviour Driven Development principle.
Feature files are written that contain the expected behaviour of the system in a specified scenario.
Scenario: Eating one apple reduces the amount of apples I have available by exactly one
Given I have x apples
When I eat one apple
Then I will have x-1 apples left
3.2	How to Create GWT
 
3.2.1	@tagging
By utilising the tagging feature correctly we can ensure that our reports give a consistent message on the state of automation. The tags can be used at either the Feature File level or at the Scenario level and this is the current tag list:-
•	
o	the User Story(s) it relates to @FCPH-1234
o	the Sprint it was created against @sprint:Sprint_17
o	if a defect is discovered against a feature/scenario it should be tagged @defect
o	if feature/scenario is to be executed manually then it should be tagged @manual
o	if the scenario is to be skipped @ignore
Serenity Reports
Serenity BDD is an open source library that create automated reports when the EAF is executed. Serenity BDD helps write cleaner and more maintainable automated acceptance and regression tests faster. Serenity also uses the test results to produce illustrated narrative reports that document and describe what your application does and how it works. Serenity tells you not only what tests have been executed but more importantly what requirements have been tested.

3.2.2	Status
	
o	Passing: The automated tests have passed and validated the assertion
o	Pending: The steps are yet to have automation built (no matching class in the Step Def)
o	Pending Manual: These tests are not currently planned to be automated
o	Ignored: These tests are skipped at execution
o	Failing: The assertion (the 'Then' of the GWT) did not receive expected response/state
o	Errors: One of the steps within the test has failed. Could be due to defect within the code base or an issue with the test itself
o	Compromised: There is insufficient data for these tests to execute or the test has not been fully developed
3.3	Step Definitions
Step definitions (step defs) are the representation of each line in a scenario and match using regular expressions. This means there is a one-to-one mapping of each line in a scenario to a step def. The step def is where we implement the code that automates the test.
Step defs are skinny - that is, they contain minimal code needed to execute a scenario. Step defs call helpers or services and do assertions. Any large logic should be abstracted away from the step def.
3.4	Services
Services provide connectivity to endpoints and implement IExampleService as the base contract. They are responsible for calling the correct resource (as specified in the config file) and mapping the returned response to the correct domain object.
3.5	Helpers
Helpers wrap one or more services and provide extended methods to act upon. For instance a helper class may internally implement multiple other services required to get to the service it is required to perform. This level of abstraction allows us to keep the step defs skinny.


4	PROJECT STRUCTURE
4.1	test
-resources
--environments
Contains *.properties files that represent the resources and enpoints for an environment, eg
Example.base.URL=http://10.10.104.80
Example.languages=${Example.base.URL}/commercial/v1/languages
Example.countries=${Example.base.URL}/commercial/v1/countries
Different properties can be used for different environments by setting the VM Options to -Denvironment=[filename], eg -Denvironment=stable
--feature
---document
This folder contains folders that represent the structure of Theme and a subfolder of Epic as defined in the story in Jira. This Epic folder contains the feature file(s) that are required in that epic, eg
Create Basket (the Theme name)
-Add Flight (the Epic name)
--AddFlight.feature (the feature file containing scenarios)
-java
--integrationtests
Contains any unit test for testing complex code
--feature
---document
Contains the Step Definitions that glue the feature's scenarios to this code implementation.
4.2	main
-java
--com.Example.easyjet
---config
Contains a single class that is used to map the config file in to a class so that the endpoints can be injected and used by the service. Any resources or endpoints included in a properties file must also be mapped in here to be accessible.
---database
This folder contains two sub-folders, one for OtherDB connections and one for Example connections. Connection details are in the properties file for each environment.
FlighFinder.java
This class is responsible for finding valid flights that exist in OtherDB (and are available for the number of pasengers required) as well as existing in Example. This is returned as a Data Access Object (DAO) which is a representation of the database table as an object so that it can be used.
----OtherDB
This folder contains the DB connection object for the OtherDB DB as well as the DAO for the response from the query.
----Example
This folder contains the DB connection object for the Example DB, as has a models folder to represent the DAO returned by various queries
---domain
This folder contains the domain object representation of responses from the API, and is split further down so that each response has its own folder. These classes are created from the swagger definition as defined in the service contract examples. We use http://www.jsonschema2pojo.org/ to create the classes and ensure you name the class with XXXXResponse if it is a response object. All rersponses must implement IResponse!
---exceptions
Contains a single class that is used for throwing custom exceptions in the framework using static strings.
---fixture
----asserters
This folder contains custom logic for asserting object against expected values. Each class implement IAssertion. Assertions are kept in here as a way of keeping our step defs skinny.
Assertions are named to be easily understandable a reusable, such as 'theExpectedNumberOfAirportsIsOne'.
Assertions are fluent so that they can be chained using the dot notation.
-----models
This folder contains any custom models to assert against; this is mostly used when you specify a table within your feature file and meed to map that to a class to be assertable.
----helpers
Contains multiple classes that assist with abstracting functionality away from the end user, either by wrapping multiple services (eg CommitBookingHelper users FlightService, BasketService, travellerService) or generic things we do a lot of, such as converting the case of strings or formatting dates.
----invoke
This is where the main heavy lifting in calling services and gettig responses is done. This folder contains ExampleHeaders.java which is the default class for providing valid headers for a request.
ExampleHeaders returns a builder object that can be fluently changed. You must add the channel (X-POS-Id) to the builder when building.
The main method used is getValid() which returns a builder object with default values (except for the channel). Calling .build() will return the header object needed by the service.
The following folders contain the various parts of the service needed to succesfully call and get a response.
-----pathparams
Contains the model representation of any path parameters to be implemented. For example, in the properties file the base path may be 'commercial/v1/basket' but the path to the resource for GET requires the basket id as part of the path (eg commercial/v1/basket/009292). These classes represent any resource that requires any change to the base path and are used by the service.
-----queryparams
Contains the model representation of the query parameters needed for a GET call. For instance, there are multiple possible query parameters when requesting a flight, including departure airport, date, destination and passengers. Each model for a service has variables that map this out to the query parameters as a string. So, if we set our model with departs=LTN, arrives=FAO, date=12-12-2017 and adults=1, then it would create a query string equal to ?departs=LTN&arrives=FAO&date=12-12-2017&adults=1.
-----requests
Contains the implementation of the underlying IRequest object to say what the service uses in terms of headers. httpMethods, requestBody, pathParameters and queryParams.
-----requestbody
Contains the object that models the request (used by a POST or PUT normally) required by the service. Must implement IRequest. In the same way that domain models our responses from a service, these classes model the JSON request. Again we use http://www.jsonschema2pojo.org/ to create the classes from the JSON and the tope level class should end in xxxxRequest.java.
-----services
These services implement the contract from IExampleService in overriding all the base methods. It uses a private variable that maps the response object to a domain model, implements the asserter, calls the service using the request model and checks that the response is populated.
private XxxxResponse xxxxResponse;

XxxxService(EasyjetTestConfig config, Client client, IRequest request) {
    super(request, client, config.getExampleXxxxXxxxEndpoint());
}

@Override
public XxxxResponse getResponse() {
    assertThatServiceCallWasSuccessful();
    return xxxxResponse;
}

@Override
public XxxxAssertion assertThat() {
    assertThatServiceCallWasSuccessful();
    return new XxxxAssertion(xxxxResponse);
}

@Override
protected void mapResponse() {
    xxxxResponse = response.readEntity(XxxxResponse.class);
}

@Override
protected void checkThatResponseBodyIsPopulated() {
    checkThatResponseBodyIsPopulated(xxxxResponse.getWhatever());
}


