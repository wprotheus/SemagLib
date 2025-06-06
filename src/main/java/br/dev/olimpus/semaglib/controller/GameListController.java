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
        GameListDTO gameListDTO = gameListService.findById(id);
        return gameListDTO;
    }

    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> listDTOList = gameListService.findAll();
        return listDTOList;
    }

    @GetMapping(value = "/{listId}/games")
    public List<MinGameDTO> findGames(@PathVariable Long listId) {
        List<MinGameDTO> gameDTOList = gameService.findByGameList(listId);
        return gameDTOList;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
