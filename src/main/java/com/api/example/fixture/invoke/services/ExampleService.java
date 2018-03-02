package com.api.example.fixture.invoke.services;

import com.api.example.fixture.asserters.ErrorsAssertion;
import com.api.example.fixture.invoke.requests.IRequest;
import com.api.example.fixture.invoke.response.common.Errors;
import org.junit.Assert;


import javax.ws.rs.HttpMethod;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.SocketTimeoutException;
import java.util.Map;

/**
 * Created by daniel on 26/11/2016.
 */
public abstract class ExampleService implements IExampleService {

    protected final Client client;
    private final IRequest request;
    protected Response response;
    private Errors errors;
    private boolean successful;
    private WebTarget webTarget;
    private String endPoint;

    public ExampleService(IRequest request, Client client, String endPoint) {
        this.request = request;
        this.client = client;
        this.endPoint = endPoint;
    }

    @Override
    public void invoke() {
        webTarget = client.target(endPoint);
        if (request.getQueryParameters() != null) {
            addQueryParams();
        }
        if (request.getPathParameters() != null) {
            addPathParams();
        }
        try {
            this.response = addHeadersAndExecuteRequest();
        } catch (ProcessingException pe) {
            if (pe.getCause().getClass().equals(SocketTimeoutException.class)) {
                throw new AssertionError("The api service did not respond within the specified timeout.");
            } else {
                throw pe;
            }
        }
        setSuccessState();
        if (successful) {
            mapResponse();
            checkThatResponseBodyIsPopulated();
        } else {
            mapErrors();
        }
    }

    @Override
    public ErrorsAssertion assertThatErrors() {
        assertThatServiceCallWasNotSuccessful();
        return new ErrorsAssertion(errors);
    }

    @Override
    public Errors getErrors() {
        return errors;
    }

    protected void assertThatServiceCallWasSuccessful() {
        Assert.assertNotNull(response);
        Assert.assertTrue("The service was not called successfully.  Response code was: " +
                        response.getStatus(),
                successful);
    }

    protected abstract void checkThatResponseBodyIsPopulated();

    protected void checkThatResponseBodyIsPopulated(Object expectedResponseContent) {
        Assert.assertNotNull("The message body was not populated but the service reported a 200 OK", expectedResponseContent);
    }

    protected abstract void mapResponse();

    private void addPathParams() {
        webTarget = webTarget.path(request.getPathParameters().get());
    }

    private void addQueryParams() {
        for (Map.Entry<String, String> parameter : request.getQueryParameters().getParameters().entrySet()) {
            webTarget = webTarget.queryParam(parameter.getKey(), parameter.getValue());
        }
    }

    private Response addHeadersAndExecuteRequest() throws ProcessingException {
        Invocation.Builder invocationBuilder = webTarget.request().headers(request.getHeaders().get());
        if (request.getHttpMethod().equals(HttpMethod.GET)) {
            return invocationBuilder.get();
        } else if (request.getHttpMethod().equals(HttpMethod.POST)) {
            return invocationBuilder.post(Entity.entity(request.getRequestBody(), MediaType.APPLICATION_JSON_TYPE));
        } else if (request.getHttpMethod().equals(HttpMethod.PUT)) {
            try {
                return invocationBuilder.put(Entity.entity(request.getRequestBody(), MediaType.APPLICATION_JSON_TYPE));
            } catch (Exception e) {
                return invocationBuilder.put(Entity.json(""));
            }
        } else if (request.getHttpMethod().equals(HttpMethod.DELETE)) {
            return invocationBuilder.delete();
        } else {
            return invocationBuilder.get();
        }
    }

    private void setSuccessState() {
        this.successful = response.getStatusInfo().equals(Response.Status.OK);
    }

    private void mapErrors() {
        try {
            errors = response.readEntity(Errors.class);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void assertThatServiceCallWasNotSuccessful() {
        Assert.assertFalse("The service returned a: " +
                response.getStatus() + ":" + response.getStatusInfo().toString(), successful);
    }
}