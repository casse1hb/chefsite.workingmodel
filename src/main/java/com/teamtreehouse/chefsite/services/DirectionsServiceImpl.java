package com.teamtreehouse.chefsite.services;

import com.teamtreehouse.chefsite.dao.DirectionsDao;
import com.teamtreehouse.chefsite.recipe.Directions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectionsServiceImpl implements DirectionsService {
    @Autowired
    private DirectionsDao directionsDao;

    @Override
    public List<Directions> findAll() {
        return (List<Directions>) directionsDao.findAll();
    }

    @Override
    public Directions findById(Long id) {
        return directionsDao.findOne(id);
    }

    @Override
    public void save(Directions directions) {
        directionsDao.save(directions);
    }

    @Override
    public void delete(Directions directions) {
        directionsDao.delete(directions);
    }
}
