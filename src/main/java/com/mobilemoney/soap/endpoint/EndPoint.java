package com.mobilemoney.soap.endpoint;

import com.mobilemoney.soap.domain.Client;
import com.mobilemoney.soap.service.imp.ClientImpService;
import com.mobilemoney.soap.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EndPoint {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ClientImpService clientImpService;

    @PayloadRoot(namespace = "http://ws.groupemg.com",localPart = "addClientRequest")
    public @ResponsePayload ClientResponse addClient(@RequestPayload AddClientRequest request) {
        ClientResponse response = new ClientResponse();
        logger.info(" valeur  "+request);
        ServiceStatus serviceStatus = new ServiceStatus();
        //
        Client client = new Client();
        //permet de copier request dans client
        BeanUtils.copyProperties(request.getClient(),client);
        clientImpService.AddClient(client);
        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Client add successfully");
        response.setStatus(serviceStatus);
        //response.setClient(request);
        return response;
    }
    @PayloadRoot(namespace = "http://ws.groupemg.com",localPart = "getClientRequest")
    public @ResponsePayload SoldeResponse getSolde(@RequestPayload GetSoldeRequest request) {
        SoldeResponse response = new SoldeResponse();
        logger.info(" valeur addition "+request);
        ClientInfo clientInfo = new ClientInfo();

        //if
        BeanUtils.copyProperties(clientImpService.getClientByPhoneNumber(request.getNumeroPhone()), clientInfo);
        response.setSolde(clientInfo.getSolde());
        return response ;
        //else

    }
}
