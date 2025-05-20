package br.dev.olimpus.semaglib.repository;

import br.dev.olimpus.semaglib.domain.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
