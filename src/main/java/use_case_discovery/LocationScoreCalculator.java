package use_case_discovery;

public class LocationScoreCalculator implements ScoreCalculator{
    // return the score of each user based on distance
    int score;

    public LocationScoreCalculator(Double distance){
        if(distance <= 0.5){
            score = 40;
        }
        else if(distance <= 1){
            score = 35;
        }
        else if(distance <= 1.5){
            score = 30;
        }
        else if(distance <= 2){
            score = 25;
        }
        else if(distance <= 5){
            score = 20;
        }
        else if(distance <= 10){
            score = 15;
        }
        else if(distance <= 20){
            score = 10;
        }
        else if(distance <= 50 ){
            score = 5;
        }
        else{
            score = 0;
        }
    }

    @Override
    public int getScore() {
        return score;
    }
}
