package com.devsuperior.dslist.projection;

public interface GameMinProjection {
/*interface projections da camada JPA para consultas JPQL(Java Persistence query language)
   usada para recuperar apenas alguns campos e dados especificos da entidade*/

    Long getId();

    String getTitle();

    Integer getGameYear();

    String getImgUrl();

    String getShortDescription();

    Integer getPosition();


}
