package com.example.demo.Services;

import com.example.demo.Entites.City;
import com.example.demo.Entites.ServiceE;
import com.example.demo.Repositories.ServiceRepository;
import com.example.demo.Services.Interfaces.ServiceServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceService implements ServiceServiceI {

    @Autowired
    private ServiceRepository serviceRepository;
    @Override
    public ServiceE getServiceById(int id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public ServiceE getServiceByName(String _name) {
        return serviceRepository.findByName(_name);
    }

    @Override
    public List<ServiceE> getAllService() {
        return (List<ServiceE>) serviceRepository.findAll();
    }

    @Override
    public ServiceE createNewService(ServiceE _service) {
        return serviceRepository.save(_service);
    }

    @Override
    public ServiceE updateService(int id, ServiceE _service) {
        if(serviceRepository.existsById(id)){
            ServiceE oldService = serviceRepository.findById(id).orElse(null);
            try{
                oldService.setName(_service.getName());
                serviceRepository.save(oldService);
                return oldService;
            }
            catch (NullPointerException e){
                return null;
            }

        }
        return null;
    }

    @Override
    public boolean deleteService(int id) {
        if(serviceRepository.existsById(id)){
            serviceRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
