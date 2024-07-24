package com.example.demo.APIs;

import com.example.demo.Entites.ServiceE;
import com.example.demo.Services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceAPIs {
    @Autowired
    private ServiceService serviceService;

    @PostMapping("/")
    public ResponseEntity<ServiceE> createNewService(@RequestBody ServiceE service){
        return ResponseEntity.ok(serviceService.createNewService(service));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ServiceE>> getAllServices(){
        return ResponseEntity.ok(serviceService.getAllService());
    }

    @GetMapping("/{name}")
    public ResponseEntity<ServiceE> getServiceByName(@PathVariable String name){
        return ResponseEntity.ok(serviceService.getServiceByName(name));
    }
}
