package com.websockets.game;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GameStorage {

    private Map<String, Game> games = new HashMap<>();


    public void addGame(Game game) {
        games.put(game.getGameId(), game);
    }


    public Game getGame(String gameId) {
        return games.get(gameId);
    }

    public List<Game> getGames() {
        return new ArrayList<>(games.values());
    }

    public void setGames(Map<String, Game> games) {
        this.games = games;
    }
}
