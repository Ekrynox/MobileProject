package com.example.mobileproject.model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class DotaHeroMatch {

    @PrimaryKey
    private long match_id;
    private int hero_id;
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

    public long getMatch_id() {
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

    public int getHero_id() {
        return hero_id;
    }

    public void setHero_id(int hero_id) {
        this.hero_id = hero_id;
    }

    public void setMatch_id(long match_id) {
        this.match_id = match_id;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public void setRadiant_win(boolean radiant_win) {
        this.radiant_win = radiant_win;
    }

    public void setLeagueid(int leagueid) {
        this.leagueid = leagueid;
    }

    public void setLeague_name(String league_name) {
        this.league_name = league_name;
    }

    public void setRadiant(boolean radiant) {
        this.radiant = radiant;
    }

    public void setPlayer_slot(int player_slot) {
        this.player_slot = player_slot;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }
}
