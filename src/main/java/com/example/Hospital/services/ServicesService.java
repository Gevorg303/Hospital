package com.example.Hospital.services;

import com.example.Hospital.domain.Service;
import com.example.Hospital.repository.ServiceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServicesService {
    @Autowired
    private ServiceRepository serviceRepository;

    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    @Transactional
    public void addNewService(Service service) {
        serviceRepository.addService(service);
    }

    @Transactional
    public void deleteService(Service service) {
        serviceRepository.deleteService(service);
    }
}