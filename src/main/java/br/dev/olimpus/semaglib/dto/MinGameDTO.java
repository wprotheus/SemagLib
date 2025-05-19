package br.dev.olimpus.semaglib.dto;


import br.dev.olimpus.semaglib.domain.Game;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MinGameDTO {
    private long id;
    private String title;
    private Integer year;
    private String genre;
    private String imgUrl;
    private String shortDescription;

    public MinGameDTO() {
    }

    public MinGameDTO(Game game) {
        id = game.getId();
        title = game.getTitle();
        year = game.getYear();
        genre = game.getGenre();
        imgUrl = game.getImgUrl();
        shortDescription = game.getShortDescription();
    }
}
