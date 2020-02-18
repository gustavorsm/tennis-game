package com;

public class tennisGame
{
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public tennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){

        String score = "";
        score = tie(score);
        score = Deuces(score);
        if ((P1point>P2point && P1point < 4) || (P1point > 0 && P1point==0))
            calculate(P1point,P2point);
        if ((P2point>P1point && P2point < 4) || (P1point > 0 && P1point==0))
            calculate(P2point,P1point);

        score = advantage(score);

        score = win(score);
        return score;
    }

    private String advantage(String score) {
        if(P1point >= 3 || P2point >= 3){
            if (P1point > P2point)
                score = "Advantage player1";
            else
                score = "Advantage player2";
        }
        return score;
    }

    private String win(String score) {
        if((P1point >= 4 && P2point>=0) || (P2point >= 4 && P1point>=0)){
            if((P1point-P2point)>=2){
                score = "Win for player1";
            }
            if((P2point-P1point)>=2){
                score = "Win for player2";
            }
        }
        return score;
    }

    private String calculate(int p1Point, int p2Point){
        String score;
        score = getLiteral(p1Point) + "-" + getLiteral(p2Point);
        return score;
    }

    private String getLiteral(int p1point2) {
        String result = "";
        if (p1point2==0)
            result = "Love";
        if (p1point2==1)
            result = "Fifteen";
        if (p1point2==2)
            result = "Thirty";
        if (p1point2==3)
            result = "Forty";
        return result;
    }

    private String tie(String score) {
        if (P1point == P2point && P1point < 4)
        {
            if (P1point==0)
                score = "Love";
            if (P1point==1)
                score = "Fifteen";
            if (P1point==2)
                score = "Thirty";
            score += "-All";
        }
        return score;
    }

    private String Deuces(String score) {
        if (P1point==P2point && P1point>=3)
            score = "Deuce";
        return score;
    }

    public void SetP1Score(int number){

        for (int i = 0; i < number; i++)
        {
            P1Score();
        }

    }

    public void SetP2Score(int number){

        for (int i = 0; i < number; i++)
        {
            P2Score();
        }

    }

    public void P1Score(){
        P1point++;
    }

    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}