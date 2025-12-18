package PetCareAPI.DTO;

import PetCareAPI.Enum.Energia;
import PetCareAPI.Enum.Porte;
import PetCareAPI.Enum.Sociabilidade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PetDTO {
    @NotBlank(message = "O nome do pet é obrigatório")
    private String nome;
    @NotBlank(message = "A raça do pet é obrigatória")
    private String raca;
    @NotNull(message = "A idade do pet é obrigatória")
    private int idade;
  
    private Energia energia;
    
    private Sociabilidade sociabilidade;
    
    private Porte porte;
    public PetDTO(){}
   public PetDTO(String nome, String raca, int idade, Energia energia, Sociabilidade sociabilidade, Porte porte) {
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.energia = energia;
        this.sociabilidade = sociabilidade;
        this.porte = porte;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public Energia getEnergia() {
        return energia;
    }
    public void setEnergia(Energia energia) {
        this.energia = energia;
    }
    public Sociabilidade getSociabilidade() {
        return sociabilidade;
    }
    public void setSociabilidade(Sociabilidade sociabilidade) {
        this.sociabilidade = sociabilidade;
    }
    public Porte getPorte() {
        return porte;
    }
    public void setPorte(Porte porte) {
        this.porte = porte;
    }
    
}
