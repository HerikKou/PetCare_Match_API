package PetCareAPI.Model;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "score_model")
public class ScoreModel {
   @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@ManyToOne
@JoinColumn(name = "first_pet", referencedColumnName = "id")
@NotNull(message = "O firstPet é obrigatório")
private Pet firstPet;

    @ManyToOne
   @JoinColumn(name = "second_pet", referencedColumnName = "id")
@NotNull(message = "O secondPet é obrigatório")
private Pet secondPet;
@Column(name = "match_score")
@NotNull(message = "O score de compatibilidade é obrigatório")
private int  matchScore;
@Column(name = "risk")

private String risk;
@Column(name = "recommendation")
private String recommendation;

@ElementCollection
@CollectionTable( name = "insights", joinColumns = @JoinColumn(name = "score_id", referencedColumnName = "id") )
@Column(name = "message", length = 500)
private List<String> insights;
public ScoreModel(){}
public ScoreModel(Long id,  int  matchScore, String risk, String recommendation, List<String> insights) {
    this.id = id;
    this.matchScore = matchScore;
    this.risk = risk;
    this.recommendation = recommendation;
    this.insights = insights;


}
public Long getId() {
    return id;


}
public void setId(Long id) {
    this.id = id;
}
public Pet getFirstPet() {
    return firstPet;
}
public void setFirstPet(Pet firstPet) {
    this.firstPet = firstPet;
}
public Pet getSecondPet() {
    return secondPet;
}
public void setSecondPet(Pet secondPet) {
    this.secondPet = secondPet;
}
public int  getMatchScore() {
    return matchScore;
}
public void setMatchScore(int  matchScore) {
    this.matchScore = matchScore;
}
public String getRisk() {
    return risk;
}
public void setRisk(String risk) {
    this.risk = risk;
}
public String getRecommendation() {
    return recommendation;
}
public void setRecommendation(String recommendation) {
    this.recommendation = recommendation;
}
public List<String> getInsights() {
    return insights;
}
public void setInsights(List<String> insights) {
    this.insights = insights;
}
    
    }
