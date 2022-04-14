package com.websockets.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;


    @MessageMapping("/create")
    @SendToUser("/queue/create")
    public Game createNewGame(CreateGameDTO createGameDTO) {
        return gameService.createGame(createGameDTO);
    }


    @MessageMapping("/random")
    @SendToUser("/queue/random")
    public Game connectToRandom(JoinGameDTO joinGameDTO) {
        return gameService.connectToRandomGame(joinGameDTO);
    }

    @MessageMapping("/move/{gameId}")
    public Game makeMove(MoveDTO moveDTO, @DestinationVariable String gameId) {
        return gameService.makeMove(moveDTO);
    }

    @MessageMapping("/broadcast/{gameId}")
    public Game broadcastGame(BroadCastDTO broadCastDTO, @DestinationVariable String gameId) {
        return gameService.broadCastGame(broadCastDTO.getGameId());
    }


}

















