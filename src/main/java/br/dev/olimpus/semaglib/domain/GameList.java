package br.dev.olimpus.semaglib.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
@Table(name = "tb_game_list")
public class GameList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GameList gameList = (GameList) o;
        return id == gameList.id && Objects.equals(title, gameList.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
