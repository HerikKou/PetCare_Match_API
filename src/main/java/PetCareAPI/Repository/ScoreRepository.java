package PetCareAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import PetCareAPI.Model.ScoreModel;

public interface ScoreRepository extends JpaRepository<ScoreModel, Long> {

    
} 