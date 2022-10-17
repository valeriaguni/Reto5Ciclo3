package com.reto3.com.reto3.CreacionHoteles.modelo.DTOs;

import com.reto3.com.reto3.CreacionHoteles.modelo.Client;

public class CountClient {
    private Long total;
    private Client client;
    public CountClient(Long total, Client client){
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
