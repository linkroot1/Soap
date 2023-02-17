package ru.pavlenko.project;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.pavlenko.project.soap.GetPersonRequest;
import ru.pavlenko.project.soap.GetPersonResponse;
import ru.pavlenko.project.soap.Person;

import java.text.SimpleDateFormat;


@Endpoint
public class PersonEndpoint {


    private SoapService service;
    private static final String NAMESPACE_URI = "http://pavlenko.ru/project/soap";


    @Autowired
    public void setService(SoapService service) {
        this.service = service;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPersonRequest")
    @ResponsePayload
    public GetPersonResponse getPerson(@RequestPayload GetPersonRequest request) throws JsonProcessingException {
        Person person = request.getPerson();


        //TODO: Преобразование


        GetPersonResponse response = new GetPersonResponse();
//
//        String dateFormat = "yyyy-MM-dd HH:mm:ss";
//
//        ObjectMapper xmlMapper = new XmlMapper();
//        xmlMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
//        String xmlText = xmlMapper.writeValueAsString(person);



       // response.setPerson(service.convertXml(xmlText));


        response.setPerson(person);

        return response;
    }

}
