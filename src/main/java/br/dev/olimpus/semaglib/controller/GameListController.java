package br.dev.olimpus.semaglib.controller;

import br.dev.olimpus.semaglib.domain.GameList;
import br.dev.olimpus.semaglib.dto.GameListDTO;
import br.dev.olimpus.semaglib.service.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    @Autowired
    private GameListService gameListService;

    @GetMapping
    public List<GameListDTO> list() {
        return gameListService.findAll();
    }

}
