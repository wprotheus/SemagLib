package br.dev.olimpus.semaglib.service;

import br.dev.olimpus.semaglib.domain.Game;
import br.dev.olimpus.semaglib.dto.GameDTO;
import br.dev.olimpus.semaglib.dto.MinGameDTO;
import br.dev.olimpus.semaglib.projections.MinGameProjection;
import br.dev.olimpus.semaglib.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(@PathVariable Long listId) {
        Game result = gameRepository.findById(listId).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<MinGameDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(MinGameDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public List<MinGameDTO> findByGameList(Long listId) {
        List<MinGameProjection> games = gameRepository.searchByList(listId);
        return games.stream().map(MinGameDTO::new).toList();
    }
}
