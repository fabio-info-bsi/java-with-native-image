package br.com.fabex.runtime;

import java.util.List;

public interface BusinessService {
    void save(Object entity);
    boolean delete(Long id);
    Object findById(Long id);
    List<Object> findAll();
}
