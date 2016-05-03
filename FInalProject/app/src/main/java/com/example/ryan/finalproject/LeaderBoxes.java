package com.example.ryan.finalproject;

/**
 * Created by darrentong on 5/2/16.
 */
public class LeaderBoxes {
    //Rank is calculated when leaderboard is generated
    //Stored_rank is stored in the database so there is something to compare
    //to when the leaderboard is generated
    public String name, rank, wins;
    public LeaderBoxes(String rank, String name, String wins){
        this.name = name;
        this.rank = rank;
        this.wins = wins;
    }
    @Override
    public String toString(){
        return rank + " " + name + " " + wins;
    }
}