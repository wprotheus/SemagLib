package br.dev.olimpus.semaglib.repository;

import br.dev.olimpus.semaglib.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
