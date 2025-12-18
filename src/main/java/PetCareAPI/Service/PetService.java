package PetCareAPI.Service;

import org.springframework.stereotype.Service;

import PetCareAPI.DTO.PetDTO;
import PetCareAPI.Model.Pet;
import PetCareAPI.Repository.PetRepository;

@Service
public class PetService {
    private final PetRepository petRepository;
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
    public Pet savePet(PetDTO pet){
        Pet newPet = new Pet();
        newPet.setNome(pet.getNome());
        newPet.setRaca(pet.getRaca());
        newPet.setIdade(pet.getIdade());
        newPet.setEnergia(pet.getEnergia());
        newPet.setSociabilidade(pet.getSociabilidade());
        newPet.setPorte(pet.getPorte());
        return petRepository.save(newPet);
        
    }
}
