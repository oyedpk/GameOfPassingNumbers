package com.game.controller;

import com.game.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Random;

@RestController
public class GameController {

    @Autowired
    GameService gameService;

    Logger logger = LoggerFactory.getLogger(GameController.class);

    @GetMapping("/start")
    public String startGame(@RequestParam Optional<Long> number) {
        return gameService.startGame(Math.abs(number.orElseGet(() -> new Random().nextLong())));
    }


    @ExceptionHandler({ Exception.class })
    public String handleException() {
        return "Invalid input, pass whole numbers";
    }

}
