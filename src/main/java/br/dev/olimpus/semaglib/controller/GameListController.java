package br.dev.olimpus.semaglib.controller;

import br.dev.olimpus.semaglib.dto.GameListDTO;
import br.dev.olimpus.semaglib.dto.MinGameDTO;
import br.dev.olimpus.semaglib.dto.ReplacementDTO;
import br.dev.olimpus.semaglib.service.GameListService;
import br.dev.olimpus.semaglib.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameListDTO findById(@PathVariable Long id) {
        GameListDTO result = gameListService.findById(id);
        return result;
    }

    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<MinGameDTO> findGames(@PathVariable Long listId) {
        List<MinGameDTO> result = gameService.findByGameList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
