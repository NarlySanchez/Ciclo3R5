/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.reto3.repository;

import com.usa.reto3.model.Score;
import com.usa.reto3.repository.interfaces.ScoreInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nbsc1
 */
@Repository
public class ScoreRepository {

    @Autowired
    //metodos que van a llamar las acciones del crud repository
    private ScoreInterface scoreCrudRepository;

    // Consulta los elementos de la base y los entrega en una lista
    public List<Score> getAll() {
        return (List<Score>) scoreCrudRepository.findAll();
    }

    //Si el dato esta se entrega y si no existe el dato pues nada
    // y entonces con ese Optional se evitan problemas con los null
    public Optional<Score> getScore(int id) {
        return scoreCrudRepository.findById(id);
    }

    //Para guardar
    public Score save(Score c) {
        return scoreCrudRepository.save(c);
    }

    //Para eliminar
    public void delete(Score score) {
        scoreCrudRepository.delete(score);
    }

}
