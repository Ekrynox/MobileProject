package com.example.mobileproject;

public class DotaHeroMatch {
    private int match_id;
    private int duration;
    private int start_time;
    private boolean radiant_win;
    private int leagueid;
    private String league_name;
    private boolean radiant;
    private int player_slot;
    private int account_id;
    private int kills;
    private int deaths;
    private int assists;

    public int getMatch_id() {
        return match_id;
    }

    public int getDuration() {
        return duration;
    }

    public int getStart_time() {
        return start_time;
    }

    public boolean isRadiant_win() {
        return radiant_win;
    }

    public int getLeagueid() {
        return leagueid;
    }

    public String getLeague_name() {
        return league_name;
    }

    public boolean isRadiant() {
        return radiant;
    }

    public int getPlayer_slot() {
        return player_slot;
    }

    public int getAccount_id() {
        return account_id;
    }

    public int getKills() {
        return kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getAssists() {
        return assists;
    }
}
