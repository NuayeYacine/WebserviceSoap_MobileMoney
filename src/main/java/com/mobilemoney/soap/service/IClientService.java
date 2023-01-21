package com.mobilemoney.soap.service;


import com.mobilemoney.soap.domain.Client;
import com.mobilemoney.soap.wsdl.ClientInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public interface IClientService {
    public void AddClient(Client client);
    public Client getClientByPhoneNumber(long number);

}
