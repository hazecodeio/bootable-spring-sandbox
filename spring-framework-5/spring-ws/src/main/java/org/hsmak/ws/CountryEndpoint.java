package org.hsmak.ws;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hsmak.ws.countries_ws.GetCountryRequest;
import org.hsmak.ws.countries_ws.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@Endpoint
public class CountryEndpoint {

    private static final String NAMESPACE_URI = "http://hsmak.org/ws/countries-ws";

    private CountryRepository countryRepository;
    private Logger logger = LogManager.getLogger(getClass());

    @Autowired
    public CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {

        logger.info("GetCountryRequest has been received: {}", request);

        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));

        if(request.getName().equalsIgnoreCase("F"))
            throw new SomeBusinessException("This is an F");

        return response;
    }
}

@SoapFault(faultCode = FaultCode.SERVER)
class SomeBusinessException extends RuntimeException {

    public SomeBusinessException(String message) {
        super(message);
    }
}