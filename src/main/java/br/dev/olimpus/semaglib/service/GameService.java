package br.dev.olimpus.semaglib.service;

import br.dev.olimpus.semaglib.domain.Game;
import br.dev.olimpus.semaglib.dto.GameDTO;
import br.dev.olimpus.semaglib.dto.MinGameDTO;
import br.dev.olimpus.semaglib.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game game = gameRepository.findById(id).get();
        return new GameDTO(game);
    }

    @Transactional(readOnly = true)
    public List<MinGameDTO> findAll() {
        List<Game> gameResult = gameRepository.findAll();
        return gameResult.stream()
                .map(game -> new MinGameDTO(game))
                .toList();
    }
}
