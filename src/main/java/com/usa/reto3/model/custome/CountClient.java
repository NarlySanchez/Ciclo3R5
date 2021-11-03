/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.reto3.model.custome;

import com.usa.reto3.model.Client;



/**
 * Clase sirve para agrupar los clientes
 * @author nbsc1
 */
public class CountClient {
    
    private Long total;
    private Client client;
    
    //Constructor
     
    public CountClient(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

    //Setter y Getter
    
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
