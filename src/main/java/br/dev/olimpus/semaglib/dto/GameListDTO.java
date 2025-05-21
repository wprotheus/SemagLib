package br.dev.olimpus.semaglib.dto;

import br.dev.olimpus.semaglib.domain.GameList;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GameListDTO {
    private Long id;
    private String title;

    public GameListDTO(GameList gameList) {
        id = gameList.getId();
        title = gameList.getTitle();

    }
}
