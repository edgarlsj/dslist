package com.devsuperior.dslist.controller;


import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController /*anotação usada para marcar uma classe como controlador, responsavel por lidar com HTTP
e retornar as respostas apropriadas p/ frontend*/
@RequestMapping(value = "/games")


public class GameController {

@Autowired
    private GameService gameService;

@GetMapping// serve para mapear o metodo para solicitaçoes usando htp GET
    public List<GameMinDTO> findAll(){
        List<GameMinDTO> result = gameService.findAll();
        return result;

    }

}
