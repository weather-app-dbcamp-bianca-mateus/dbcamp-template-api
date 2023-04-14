package com.template.business.services;

import com.template.data.entity.MeteorologicalEntity;
import com.template.data.repository.MeteorologicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MeteorologicalService {
    @Autowired
    MeteorologicalRepository meteorologicalRepository;

    public List<MeteorologicalEntity> getAll(String city) {

        if (city == null)
            return meteorologicalRepository.findAll();
        else
            return meteorologicalRepository.findAllByCity(city);
    }
    public List<MeteorologicalEntity> findAll(){
        return meteorologicalRepository.findAll();
    }
    public List<MeteorologicalEntity> findByCity(@RequestBody String city){
        return meteorologicalRepository.findAllByCity(city);
    }
    public MeteorologicalEntity create(@RequestBody MeteorologicalEntity meteorological){
        return meteorologicalRepository.save(meteorological);
    }
    public void deleteMeteorological(@PathVariable("id")long id){ meteorologicalRepository.deleteById(id);}
    public void deleteAll() {
        meteorologicalRepository.deleteAll();
    }
}
