package br.dev.olimpus.semaglib.controller;

import br.dev.olimpus.semaglib.dto.GameDTO;
import br.dev.olimpus.semaglib.dto.MinGameDTO;
import br.dev.olimpus.semaglib.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id) {
        GameDTO game = gameService.findById(id);
        return game;
    }

    public List<MinGameDTO> findAll() {
        return gameService.findAll();
    }
}
