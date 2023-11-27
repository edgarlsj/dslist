package com.devsuperior.dslist.controller;


import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.dto.ReplacementDTO;
import com.devsuperior.dslist.service.GameListService;
import com.devsuperior.dslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;
    //metodo do endpoint que retona a lista de games
    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }
//metodo do endpoint que retona a lista de games por ID
    @GetMapping(value = "/{listId}/games")
       public List<GameMinDTO> findByList (@PathVariable Long listId){
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }
    //metodo endpoint para alterar a ordem da lista no banco de dados
    @PostMapping (value = "/{listId}/replacement")
    public void move (@PathVariable Long listId, @RequestBody  ReplacementDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
