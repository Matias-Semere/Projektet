package controller;

import java.util.List;
import dao.BaseDAO;

public abstract class BaseController<T> {
    protected BaseDAO<T> dao;
    
    public BaseController(BaseDAO<T> dao) {
        this.dao = dao;
    }
    
    public List<T> getAll() { 
        // return dao.getAll(); 
    }
    
    public void insert(T entity) { 
        dao.insert(entity); 
    }
    
    public void delete(T entity) { 
        // dao.delete(entity); 
    }

    

}