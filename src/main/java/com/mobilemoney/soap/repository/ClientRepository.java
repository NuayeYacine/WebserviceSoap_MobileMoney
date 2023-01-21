package com.mobilemoney.soap.repository;

import com.mobilemoney.soap.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>  {
    Client findClientByPhonenumber(long number);
}
