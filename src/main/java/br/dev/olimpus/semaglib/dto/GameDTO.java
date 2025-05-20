package br.dev.olimpus.semaglib.dto;

import br.dev.olimpus.semaglib.domain.Game;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class GameDTO {
    private Long id;
    private String title;
    private Integer year;
    private String genre;
    private String platform;
    private Double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    public GameDTO() {
    }

    public GameDTO(Game game) {
        BeanUtils.copyProperties(game, this);
    }
}
