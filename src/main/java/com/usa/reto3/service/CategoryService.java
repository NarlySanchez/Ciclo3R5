/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.reto3.service;

import com.usa.reto3.model.Category;
import com.usa.reto3.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nbsc1
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository metodosCrud;

    public List<Category> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Category> getCategory(int categoryId) {
        return metodosCrud.getCategory(categoryId);
    }

    public Category save(Category categoria) {
        if (categoria.getId() == null) {
            return metodosCrud.save(categoria);
        } else {
            Optional<Category> e = metodosCrud.getCategory(categoria.getId());
            if (e.isEmpty()) {
                return metodosCrud.save(categoria);
            } else {
                return categoria;
            }
        }
    }

    public Category update(Category categoria) {
        if (categoria.getId() != null) {
            Optional<Category> g = metodosCrud.getCategory(categoria.getId());
            if (!g.isEmpty()) {
                if (categoria.getDescription() != null) {
                    g.get().setDescription(categoria.getDescription());
                }
                if (categoria.getName() != null) {
                    g.get().setName(categoria.getName());
                }
                return metodosCrud.save(g.get());
            }
        }
        return categoria;
    }

    public boolean deleteCategory(int categoriaId) {
        Boolean d = getCategory(categoriaId).map(categoria -> {
            metodosCrud.delete(categoria);
            return true;
        }).orElse(d = false);
        return d;
    }
}
