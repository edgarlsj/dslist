package com.devsuperior.dslist.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity//Anotação Spring para que essa classe seja uma tabela no banco de dados relacional
@Table(name = "tb_game_list") //Anotação para criar nome na tabela no banco.

public class GameList {
    @Id//Anotação que o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //indica como o valor do ID é gerado
    private Long id;
    private String name;


    //construtor null
    public GameList() {
    }

    public GameList(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameList gameList = (GameList) o;
        return Objects.equals(id, gameList.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
