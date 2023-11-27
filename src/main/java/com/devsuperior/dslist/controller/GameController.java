package com.devsuperior.dslist.controller;


import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Collections;
import java.util.List;

@RestController /*anotação usada para marcar uma classe como controlador, responsavel por lidar com HTTP
e retornar as respostas apropriadas p/ frontend*/
@RequestMapping(value = "/games")//usada para mapear requisiçoes HTTP para os metodos no controller. ao adiocionar a um metodo define qual URL acionará esse metodo


public class GameController {

    @Autowired//anotação para injetar dependencia da classe GameService
    private GameService gameService;

    @GetMapping// Serve para mapear o metodo para solicitaçoes usando htp GET
    //metodo do Endpoint que retorna toda lista de objeto sem DTO
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> result = gameService.findAll();
        Collections.sort(result);
        return result;

    }

    //metodo do Endpoint que retorna p/ front lista por Id

    @GetMapping(value = "/{id}") //@PatchVariable usado para capturar valores da URI e vincular no metodo Long Id
    public GameDTO findById(@PathVariable Long id) {
        GameDTO result = gameService.findById(id);
        return result;
    }


}
