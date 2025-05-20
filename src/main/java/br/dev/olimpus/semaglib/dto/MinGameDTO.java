package br.dev.olimpus.semaglib.dto;


import br.dev.olimpus.semaglib.domain.Game;
import br.dev.olimpus.semaglib.projections.MinGameProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MinGameDTO {
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public MinGameDTO(Game game) {
        id = game.getId();
        title = game.getTitle();
        year = game.getYear();
        imgUrl = game.getImgUrl();
        shortDescription = game.getShortDescription();
    }

    public MinGameDTO(MinGameProjection gameProjection) {
        id = gameProjection.getId();
        title = gameProjection.getTitle();
        year = gameProjection.getGameYear();
        imgUrl = gameProjection.getImgUrl();
        shortDescription = gameProjection.getShortDescription();
    }
}
