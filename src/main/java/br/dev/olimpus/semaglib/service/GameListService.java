package br.dev.olimpus.semaglib.service;

import br.dev.olimpus.semaglib.domain.GameList;
import br.dev.olimpus.semaglib.dto.GameListDTO;
import br.dev.olimpus.semaglib.projections.MinGameProjection;
import br.dev.olimpus.semaglib.repository.GameListRepository;
import br.dev.olimpus.semaglib.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> gameLists = gameListRepository.findAll();
        return gameLists.stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {

        List<MinGameProjection> gameProjectionList = gameRepository.searchByList(listId);

        MinGameProjection obj = gameProjectionList.remove(sourceIndex);
        gameProjectionList.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId,
                    gameProjectionList.get(i).getId(), i);
        }
    }

    @Transactional(readOnly = true)
    public GameListDTO findById(Long id) {
        GameList gameList = gameListRepository.findById(id).get();
        return new GameListDTO(gameList);
    }
}
