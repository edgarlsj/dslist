package com.devsuperior.dslist.entities;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

//classe que associa a entidade Game com a GameList"

@Entity //Anotação Spring para que essa classe seja uma tabela no banco de dados relacional
@Table(name = "tb_belonging") //Anotação para criar nome na tabela no banco.
public class Belonging {
    @EmbeddedId //usada para marcar uma classe incorporavel que representa uma chave primaria composta em uma entidade
    private  BelongingPK id = new BelongingPK();
    private Integer position;

    public Belonging() {
    }

    public Belonging(Game game, GameList list, Integer position) {
        id.setGame(game);
        id.setList(list);
        this.position = position;
    }

    public BelongingPK getId() {
        return id;
    }

    public void setId(BelongingPK id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Belonging belonging = (Belonging) o;
        return Objects.equals(id, belonging.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
