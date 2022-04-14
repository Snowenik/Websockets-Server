package com.websockets.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.UUID;

@Service
public class GameService {

    @Autowired
    private GameStorage gameStorage;


    public Game createGame(CreateGameDTO createGameDTO) {
        Game game = new Game();
        game.setFirstPlayerName(createGameDTO.getUsername());
        game.setGameId(UUID.randomUUID().toString());
        game.setGameStatus(GameStatus.NEW);
        String[] squares = new String[] {"", "", "", "", "", "", "", "", ""};
        game.setSquares(squares);
        String currentPlayerID = UUID.randomUUID().toString();
        game.setFirstPlayerID(currentPlayerID);
        game.setCurrentPlayerID(currentPlayerID);
        game.setxNext(true);
        game.setType("X");
        gameStorage.addGame(game);
        return game;
    }

    public Game connectToGame(String secondPlayer, String gameId) {
        Game game = gameStorage.getGame(gameId);
        game.setSecondPlayerID(secondPlayer);
        game.setGameStatus(GameStatus.IN_PROGRESS);
        return game;
    }

    public Game connectToRandomGame(JoinGameDTO joinGameDTO) {
        Game game = gameStorage.getGames().stream().filter(g -> g.getGameStatus().equals(GameStatus.NEW))
                .findFirst().orElseThrow(() -> new RuntimeException("There isn't any available game"));
        game.setSecondPlayerName(joinGameDTO.getUsername());
        game.setSecondPlayerID(UUID.randomUUID().toString());
        game.setGameStatus(GameStatus.IN_PROGRESS);
        return game;
    }

    public Game broadCastGame(String gameId) {
        return gameStorage.getGames().stream().filter(g -> g.getGameId().equals(gameId)).findFirst().get();
    }


    public Game makeMove(MoveDTO moveDTO) {
        Game game = gameStorage.getGame(moveDTO.getGameId());
        if (checkSquareAlreadyTaken(game.getSquares(), moveDTO.getSquareIndex())) {
            return game;
        }
        String[] board = game.getSquares();
        board[moveDTO.getSquareIndex()] = game.isxNext() ? "X" : "O";
        game.setxNext(!game.isxNext());
        game.setCurrentPlayerID(moveDTO.getCurrentPlayerID().equals(game.getFirstPlayerID()) ? game.getSecondPlayerID() : game.getFirstPlayerID());
        game.setSquares(board);
        String moveType = moveDTO.getCurrentPlayerID().equals(game.getFirstPlayerID()) ? "X" : "O";
        if (checkWinner(game.getSquares(), moveType)) {
            game.setGameStatus(GameStatus.END);
            game.setWinner(true);
            return game;
        }
        if (checkDraw(game.getSquares())) {
            game.setGameStatus(GameStatus.END);
            game.setDraw(true);
            return game;
        }
        game.setType(game.isxNext() ? "X" : "O");
        return game;
    }

    public boolean checkSquareAlreadyTaken(String[] board, int index) {
        return !board[index].equals("");
    }

    public boolean checkDraw(String[] board) {
        return Arrays.stream(board).allMatch(s -> s.equals("X") || s.equals("O"));
    }

    public boolean checkWinner(String[] board, String type) {
        int[][] winningCombinations = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8},
                {0, 4, 8},
                {2, 4, 6}
        };
        int c = 0;
        for (int[] w : winningCombinations) {
            c = 0;
            for (int k : w) {
                if (board[k].equals(type)) {
                    c++;
                }
                if (c == 3) {
                    return true;
                }
            }
        }
        return false;

    }

}














