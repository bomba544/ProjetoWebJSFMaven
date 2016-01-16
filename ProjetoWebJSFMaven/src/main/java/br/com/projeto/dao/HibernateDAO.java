package br.com.projeto.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

public class HibernateDAO<E> implements InterfaceDAO<E>, Serializable{
    
    private static final long serialVersionUID = 1L;
    private Class<E> clazz;
    private Session session;

    public HibernateDAO() {
    }

    public HibernateDAO(Class<E> clazz, Session session) {
        this.clazz   = clazz;
        this.session = session;
    }

    @Override
    public void save(E e) {
        session.save(e);
    }

    @Override
    public void update(E e) {
        session.update(e);
    }

    @Override
    public void remove(E e) {
        session.delete(e);
    }

    @Override
    public void merge(E e) {
        session.merge(e);
    }

    @Override
    public E getEntity(Serializable id) {
        return (E) session.get(clazz, id);
    }

    @Override
    public E getEntityByDetachedCriteria(DetachedCriteria dc) {
        return (E) dc.getExecutableCriteria(session).uniqueResult();
    }
    
    @Override
    public List<E> getListaByDetachedCriteria(DetachedCriteria dc) {
        return dc.getExecutableCriteria(session).list();
    }

    @Override
    public List<E> getEntitys() {
        return (List<E>) session.createCriteria(clazz);
    }
}
