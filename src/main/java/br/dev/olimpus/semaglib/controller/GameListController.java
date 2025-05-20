package br.dev.olimpus.semaglib.controller;

import br.dev.olimpus.semaglib.dto.GameListDTO;
import br.dev.olimpus.semaglib.dto.MinGameDTO;
import br.dev.olimpus.semaglib.service.GameListService;
import br.dev.olimpus.semaglib.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{listId}/games")
    public List<MinGameDTO> findById(@PathVariable Long listId) {
        List<MinGameDTO> gameListDTO = gameService.findByList(listId);
        return gameListDTO;
    }

    @GetMapping
    public List<GameListDTO> list() {
        return gameListService.findAll();
    }
}
