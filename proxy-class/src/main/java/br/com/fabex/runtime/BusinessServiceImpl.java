package br.com.fabex.runtime;

import java.util.List;

public class BusinessServiceImpl implements BusinessService {
    @Override
    public void save(Object entity) {
        System.out.println("Save " + entity);
    }

    @Override
    public boolean delete(Long id) {
        System.out.println("delete " + id);
        return false;
    }

    @Override
    public Object findById(Long id) {
        System.out.println("findById " + id);
        for (int i = 0; i < 1_000_000_000; i++) ;
        return new User(id, null);
    }

    @Override
    public List<Object> findAll() {
        return List.of(1, 2, 3, 4, 5);
    }
}
