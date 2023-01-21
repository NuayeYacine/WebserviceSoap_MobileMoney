package com.mobilemoney.soap.service.imp;

import com.mobilemoney.soap.domain.Client;
import com.mobilemoney.soap.repository.ClientRepository;
import com.mobilemoney.soap.service.IClientService;
import com.mobilemoney.soap.wsdl.AddClientRequest;
import com.mobilemoney.soap.wsdl.ClientInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientImpService   {

    @Autowired
    ClientRepository clientRepository;


    public void AddClient(Client client) {
         clientRepository.save(client);

    }


    public Client getClientByPhoneNumber(long number) {
        Client obj = clientRepository.findClientByPhonenumber(number);
        return obj;
    }
}
