package PetCareAPI.DTO;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ScoreDTO {
    
   @NotNull(message = "O ID do primeiro dog é obrigatório")
    private Long firstPet;
   
    @NotNull(message = "O ID do segundo dog é obrigatório")
    private Long secondPet;
     public ScoreDTO(){}
    public ScoreDTO(Long firstPet, Long secondPet) {
        this.firstPet = firstPet;
        this.secondPet = secondPet;
    }
    public Long getFirstPet() {
        return firstPet;
    }
    public void setFirstPet(Long firstPet) {
        this.firstPet = firstPet;
    }
    public Long getSecondPet() {
        return secondPet;
    }
    public void setSecondPet(Long secondPet) {
        this.secondPet = secondPet;
    }

    
}
