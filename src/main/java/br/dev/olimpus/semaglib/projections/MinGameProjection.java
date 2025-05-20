package br.dev.olimpus.semaglib.projections;

public interface MinGameProjection {

    Long getId();

    String getTitle();

    Integer getGameYear();

    String getImgUrl();

    String getShortDescription();

    Integer getPosition();
}
