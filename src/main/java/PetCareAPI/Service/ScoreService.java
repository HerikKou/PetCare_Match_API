package PetCareAPI.Service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

import PetCareAPI.DTO.ScoreDTO;
import PetCareAPI.Exceptions.NaoEncontrado;
import PetCareAPI.Model.Pet;
import PetCareAPI.Model.ScoreModel;
import PetCareAPI.Repository.PetRepository;
import PetCareAPI.Repository.ScoreRepository;

@Service
public class ScoreService {
    private final ScoreRepository scoreRepository;
    private final PetRepository petRepository;
    public ScoreService(ScoreRepository scoreRepository, PetRepository petRepository) {
        this.scoreRepository = scoreRepository;
        this.petRepository = petRepository;
    }
    public ScoreModel saveScore(ScoreDTO score){
    Long firstPet =  score.getFirstPet();
    Long secondPet = score.getSecondPet();
    Pet first = petRepository.findById(firstPet).orElseThrow(()->new NaoEncontrado("Pet não encontrado"));
    Pet second = petRepository.findById(secondPet).orElseThrow(()-> new NaoEncontrado("Pet não encontrado"));

    int scoreTotal = calculateScore(first, second);
    if(scoreTotal >= 90){
        String risk = "Baixo";
        String recommendation = "Os pets são altamente compatíveis! Eles provavelmente se darão muito bem juntos. Certifique-se de proporcionar um ambiente seguro e confortável para ambos.";
        List<String> insights = new ArrayList<>();
        insights.add("Os cães têm energia semelhante.");
        insights.add("Ambos são sociáveis.");
        insights.add("O porte dos cães é compatível.");
       ScoreModel newScore =  new ScoreModel();
        newScore.setFirstPet(first);
        newScore.setSecondPet(second);
        newScore.setMatchScore(scoreTotal);
        newScore.setRisk(risk);
        newScore.setRecommendation(recommendation);
        newScore.setInsights(insights);
        return scoreRepository.save(newScore);
    } else if(scoreTotal >= 70){
        String risk = "Médio";
        String recommendation = "Os pets têm uma boa compatibilidade, mas podem haver alguns desafios. Observe suas interações iniciais e esteja preparado para intervir se necessário.";
        List<String> insights = new ArrayList<>();
        insights.add("Energia semelhante");
        insights.add("Alta sociabilidade entre hookup de cães");
        ScoreModel newScore = new ScoreModel();
        newScore.setFirstPet(first);
        newScore.setSecondPet(second);
        newScore.setMatchScore(scoreTotal);
        newScore.setRisk(risk);
        newScore.setRecommendation(recommendation);
        newScore.setInsights(insights);
        return scoreRepository.save(newScore);
    } else {
        String risk = "Alto";
        String recommendation = "Os pets podem não ser muito compatíveis. Considere cuidadosamente antes de juntá-los e esteja preparado para gerenciar possíveis conflitos.";
        List<String> insights = new ArrayList<>();
        insights.add("Os cães têm níveis de energia diferentes, o que pode causar desentendimentos.");
        insights.add("A sociabilidade de um dos cães é baixa, atenção ao contato inicial.");
        insights.add("O porte dos cães é diferente, o que pode gerar desconforto em brincadeiras.");
        ScoreModel newScore = new ScoreModel();
        newScore.setFirstPet(first);
        newScore.setSecondPet(second);
        newScore.setMatchScore(scoreTotal);
        newScore.setRisk(risk);
        newScore.setRecommendation(recommendation);
        newScore.setInsights(insights);
        return scoreRepository.save(newScore);
    }

    }

    public int calculateSociability(Pet firstPet, Pet secondPet) {
        if(firstPet.getSociabilidade() == secondPet.getSociabilidade()) {
            return 30;
        } 
        else if(firstPet.getSociabilidade() != secondPet.getSociabilidade()) {
            return 10;
        } 
    return 0;
    }

    public int calculateEnergy(Pet firstPet, Pet secondPet) {
        if(firstPet.getEnergia() == secondPet.getEnergia()) {
            return 30;
        } 
        else if(firstPet.getEnergia() != secondPet.getEnergia() ) {
            return 10;
        }
        return 0;

}

public int calculatePorte(Pet firstPet, Pet secondPet) {
    if(firstPet.getPorte() == secondPet.getPorte()) {
        return 30;
    } 
    else if(firstPet.getPorte() != secondPet.getPorte()) {
        return 10;
    }
    return 0;





}
public int calculateScore(Pet firstPet, Pet secondPet) {
    int sociabilityScore = calculateSociability(firstPet, secondPet);
    int energyScore = calculateEnergy(firstPet, secondPet);
    int porteScore = calculatePorte(firstPet, secondPet);
    return sociabilityScore + energyScore + porteScore;
}
}

