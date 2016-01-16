package br.com.projeto.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

public interface InterfaceDAO<E> {

    void save(E e);
    void update(E e);
    void remove(E e);
    void merge(E e);
    E getEntity(Serializable id);
    E getEntityByDetachedCriteria(DetachedCriteria dc);
    List<E> getEntitys();
    List<E> getListaByDetachedCriteria(DetachedCriteria dc);
    
}
