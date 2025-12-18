package PetCareAPI.Model;

import java.util.List;

import org.springframework.data.domain.Score;

import com.fasterxml.jackson.annotation.JsonIgnore;

import PetCareAPI.Enum.Energia;
import PetCareAPI.Enum.Porte;
import PetCareAPI.Enum.Sociabilidade;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Entity
public class Pet{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome do pet é obrigatório")
    private String nome;
    @NotBlank(message = "A raça do pet é obrigatória")
    private String raca;
    @NotNull(message = "A idade do pet é obrigatória")
    private int idade;
    @Enumerated(EnumType.STRING)
    private Energia energia;
    @Enumerated(EnumType.STRING)
    private Sociabilidade sociabilidade;
    @Enumerated(EnumType.STRING)
    private Porte porte;
    @OneToMany(mappedBy = "firstPet")
    @JsonIgnore
    private List<ScoreModel> score;
    @OneToMany(mappedBy = "secondPet")
    @JsonIgnore
    private List<ScoreModel> score2;
    public Pet(){}
    public Pet(Long id, String nome, String raca, int idade, Energia energia, Sociabilidade sociabilidade, Porte porte) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.energia = energia;
        this.sociabilidade = sociabilidade;
        this.porte = porte;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public List<ScoreModel> getScore() {
        return score;
    }
    public void setScore(List<ScoreModel> score) {
        this.score = score;
    }
    public List<ScoreModel> getScore2() {
        return score2;
    }
    public void setScore2(List<ScoreModel> score2) {
        this.score2 = score2;
    }
    
   
    


}