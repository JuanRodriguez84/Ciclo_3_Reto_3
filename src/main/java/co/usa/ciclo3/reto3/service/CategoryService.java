package co.usa.ciclo3.reto3.service;

import co.usa.ciclo3.reto3.model.Category;
import co.usa.ciclo3.reto3.model.Category;
import co.usa.ciclo3.reto3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoriaRepository;

    public List<Category> getAll(){
        return  categoriaRepository.getAll();
    }
    public Optional<Category> getCategoria(int id){
        return categoriaRepository.getCategoria(id);
    }

    public Category save(Category p){
        if(p.getId()==null){
            return categoriaRepository.save(p);
        }else{
            Optional<Category> paux=categoriaRepository.getCategoria(p.getId());
            if(paux.isEmpty()){
                return categoriaRepository.save(p);
            }else{
                return p;
            }
        }
    }
}
