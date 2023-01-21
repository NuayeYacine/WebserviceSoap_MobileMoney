package com.mobilemoney.soap.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="client")
public class Client  implements Serializable {
        @Id
        @Column(name = "client_id")
        private long client_id;
        //
        @Column(name = "phonenumber")
        private long phonenumber;
        @Column(name = "solde")
        private long solde;

    public Client() {
    }

    public Client(long client_id, long phonenumber, long solde) {
        this.client_id = client_id;
        this.phonenumber = phonenumber;
        this.solde = solde;
    }

    public long getClient_id() {
        return client_id;
    }

    public void setClient_id(long client_id) {
        this.client_id = client_id;
    }

    public long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(long phonenumber) {
        this.phonenumber = phonenumber;
    }

    public long getSolde() {
        return solde;
    }

    public void setSolde(long solde) {
        this.solde = solde;
    }
}
