package PetCareAPI.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PetCareAPI.DTO.PetDTO;
import PetCareAPI.Model.Pet;
import PetCareAPI.Service.PetService;

@RestController
@RequestMapping("/api/pet")
public class PetController {
    private final PetService petService;
    public PetController(PetService petService) {
        this.petService = petService;
    }
    @PostMapping("/create")
    public ResponseEntity<Pet> createPet(@RequestBody PetDTO pet) {
        
        Pet savePet = petService.savePet(pet);
        return ResponseEntity.status(HttpStatus.CREATED).body(savePet);
    }

}
