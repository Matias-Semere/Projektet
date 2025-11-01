package controller;

import java.util.List;
import dao.BaseDAO;
import model.BaseModel;

public abstract class BaseController<T extends BaseModel> {
    protected BaseDAO<T> dao;

    public BaseController(BaseDAO<T> dao) {
        this.dao = dao;
    }

    public List<T> getAll() {
        return dao.getAll();
    }

    public void insert(T entity) {
        dao.insert(entity);
    }

    public void delete(T entity) {
        dao.delete(entity);
    }

    public T getById(int id) {
        return dao.getById(id);
    }

    public void update(T entity) {
        dao.update(entity);
    }

}
