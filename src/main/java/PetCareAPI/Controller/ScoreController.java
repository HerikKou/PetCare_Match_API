package PetCareAPI.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PetCareAPI.DTO.ScoreDTO;
import PetCareAPI.Model.ScoreModel;
import PetCareAPI.Service.ScoreService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/score")
public class ScoreController {
    private final ScoreService scoreService;
    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }
    @PostMapping("/matchScore")
    public ResponseEntity<ScoreModel> createScore(@RequestBody ScoreDTO score ) {
        ScoreModel savedScore = scoreService.saveScore(score);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedScore);
}
}