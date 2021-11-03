package com.usa.reto3.repository;

import com.usa.reto3.repository.interfaces.CategoryInterface;
import com.usa.reto3.model.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nbsc1
 */
@Repository
public class CategoryRepository {

    @Autowired
    private CategoryInterface crud2;

    public List<Category> getAll() {
        return (List<Category>) crud2.findAll();
    }

    public Optional<Category> getCategory(int id) {
        return crud2.findById(id);
    }

    public Category save(Category categoria) {
        return crud2.save(categoria);
    }

    public void delete(Category categoria) {
        crud2.delete(categoria);
    }

}
