package ru.pavlenko.project;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.pavlenko.project.GetPersonRequest;
import ru.pavlenko.project.GetPersonResponse;
import ru.pavlenko.project.Person;


@Endpoint
public class PersonEndpoint {


    private static final String NAMESPACE_URI = "http://pavlenko.ru/project/soap";



    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPersonRequest")
    @ResponsePayload
    public GetPersonResponse getCountry(@RequestPayload GetPersonRequest request) {
        Person person = request.getPerson();


        //TODO: Преобразование

        GetPersonResponse response = new GetPersonResponse();
        response.setPerson(person);

        return response;
    }

}
