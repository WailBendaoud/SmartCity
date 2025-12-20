package com.example.noSqlProject.services.impl;

import com.example.noSqlProject.entities.Avenue;
import com.example.noSqlProject.exceptions.NotFoundException;
import com.example.noSqlProject.repositories.AvenueRepository;
import com.example.noSqlProject.services.api.AvenueService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class AvenueServiceImpl implements AvenueService {

    private final AvenueRepository avenueRepository;
    private final String msgAvenue="Avenue introuvable";


    @Override
    public List<Avenue> getAll() {
        return avenueRepository.findAll();
    }

    @Override
    public Avenue findById(String id) {
        return avenueRepository.findById(id).orElseThrow(()->new NotFoundException(msgAvenue));
    }

    @Override
    public Avenue save(Avenue avenue) {
        List<String> ls=new ArrayList<>();
        avenue.setRadars(ls);
        avenue.setParkings(ls);
        return avenueRepository.save(avenue);
    }

    @Override
    public Avenue update(Avenue element, String id) {
        return null;
    }

    @Override
    public void delete(Avenue element) {
        Avenue a=findById(element.getId());
        avenueRepository.delete(a);
    }

    @Override
    public void deleteById(String id) {
      Avenue avenue=findById(id);
      avenueRepository.deleteById(id);
    }
}
