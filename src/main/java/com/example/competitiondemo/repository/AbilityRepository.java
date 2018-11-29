package com.example.competitiondemo.repository;

import com.example.competitiondemo.pojo.Ability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbilityRepository extends JpaRepository<Ability, String> {
}
