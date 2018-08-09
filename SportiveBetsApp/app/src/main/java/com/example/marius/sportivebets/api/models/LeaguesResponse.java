package com.example.marius.sportivebets.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LeaguesResponse {

    @SerializedName("leagues")
    private List<League> leagues;

    public List<League> getLeagues() {
        return leagues;
    }
}
