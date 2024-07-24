package com.example.demo.Services.Interfaces;



import com.example.demo.Entites.ServiceE;

import java.util.List;

public interface ServiceServiceI {
    public ServiceE getServiceById(int id);
    public ServiceE getServiceByName(String _name);
    public List<ServiceE> getAllService();
    public ServiceE createNewService(ServiceE _name);
    public ServiceE updateService(int id , ServiceE _name);
    public boolean deleteService(int id);
}
