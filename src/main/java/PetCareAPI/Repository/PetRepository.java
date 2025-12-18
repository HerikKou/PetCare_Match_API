package PetCareAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import PetCareAPI.Model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
    
}
