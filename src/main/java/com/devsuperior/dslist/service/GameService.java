package com.devsuperior.dslist.service;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service //Anotação é usada para marcar a classe como um serviço @Component tem o mesmo papel
public class GameService {

    @Autowired //anotação para injetar dependencia da classe GameRepository
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    // metodo que retorna a lista de games do banco
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        /*Cada objeto Game é convertido em um objeto GameMinDTO usando a lógica fornecida no construtor GameMinDTO(x).
        Isso é feito usando operações de stream, o que pode tornar o código mais legível e expressivo.
         */
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true)//usada p demarcar um limite transacional, garante que o metodo executado dentro de uma unica transação.

    // metodo que retorna a lista de games do banco pelo ID
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }


}
