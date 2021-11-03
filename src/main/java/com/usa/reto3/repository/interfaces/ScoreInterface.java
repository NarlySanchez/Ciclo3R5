/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.reto3.repository.interfaces;

import com.usa.reto3.model.Score;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author nbsc1
 */
public interface ScoreInterface extends CrudRepository<Score, Integer>{
    
}
