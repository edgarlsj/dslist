package com.devsuperior.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable //usada para marcar uma classe cujos OBJ serão incorporados como componentes em uma entidade.
public class BelongingPK {
    @ManyToOne//usada para mapear um relacionamento muitos-para-um entre duas entidades no BD
    @JoinColumn(name = "game_id")//especifica a coluna na tabela do lado proprietario da relação ou seja ,a tabela que contem a chave estangeira
    private Game game;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList list;

    public BelongingPK() {
    }

    public BelongingPK(Game game, GameList gameList) {
        this.game = game;
        this.list = gameList;
    }

    public Game getGame(Game game) {
        return this.game;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BelongingPK that = (BelongingPK) o;
        return Objects.equals(game, that.game) && Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, list);
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameList getList() {
        return list;
    }

    public void setList(GameList list) {
        this.list = list;
    }
}
