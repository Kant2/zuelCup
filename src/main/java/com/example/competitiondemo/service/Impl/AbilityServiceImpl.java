package com.example.competitiondemo.service.Impl;

import com.example.competitiondemo.pojo.Ability;
import com.example.competitiondemo.repository.AbilityRepository;
import com.example.competitiondemo.service.AbilityService;
import org.springframework.beans.factory.annotation.Autowired;

public class AbilityServiceImpl implements AbilityService {

    @Autowired
    AbilityRepository repository;


    @Override
    public Ability findById(String id) {
        return null;
    }
}
