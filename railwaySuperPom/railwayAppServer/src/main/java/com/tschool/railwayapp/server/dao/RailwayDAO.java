package com.tschool.railwayapp.server.dao;

import com.tschool.railwayapp.commons.exceptions.*;
import com.tschool.railwayapp.commons.entities.*;
import com.tschool.railwayapp.server.utils.JPAUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class RailwayDAO <T extends Serializable> {

    protected static EntityManager eManager;
    
    public void beginTransaction() throws ExceptionInInitializerError, PersistenceException {
        eManager = JPAUtils.getEntityManagerFactory().createEntityManager();
        eManager.getTransaction().begin();
    } 
    
    public void commitTransaction() throws PersistenceException, CommitException {
        try {
            eManager.flush();
            eManager.getTransaction().commit();
        }
        catch(Throwable ex) {
            rollbackTransaction();
        }
    }
    
    public void rollbackTransaction() throws CommitException {
        try {
            eManager.getTransaction().rollback();
        }
        catch(Throwable ex) {
            if(eManager != null) {
                eManager.close();
            }
        }
        finally  {
            throw new CommitException("Could not commit the operation");
        }
    }
    
    /**
     * creates entity
     *
     * @param entity
     * @return
     * @throws CreateException
     */
    public T addEntity(T entity) throws CreateException {
        try {
            eManager.persist(entity);
            return entity;
        } catch (Exception ex) {
            throw new CreateException(ex);
        }
    }
 
    /**
     * updates entity
     *
     * @param entity
     * @return
     * @throws UpdateException
     */
    public T update(T entity) throws UpdateException {
        try {
            entity = eManager.merge(entity);
            return entity;
        } catch (Exception ex) {
            throw new UpdateException(ex);
        }
    }
    
    public void addEntityList(List<T> entityList) {
        for(T entity : entityList) {
            eManager.persist(entity);
        }
    }
    
    public T findByPrimaryKey(Class<T> entityToFind, Object privateKey) throws FindException{
        T entity = null;
        try {
            entity = eManager.find(entityToFind, privateKey);
        } catch (Exception ex) {
            throw new FindException(ex);
        }
        if (entity == null) {
            throw new FindException(entityToFind.getSimpleName() + " with id/name "
                    + privateKey + " not found");
        }
        return entity;
    }
    
    public List<T> getEntityList(Class<T> classToFind) throws FindException {
        String queryString = "SELECT a FROM " + classToFind.getSimpleName() + " a";
        try {
            return eManager.createQuery(queryString).getResultList();
        } catch (Exception ex) {
            throw new FindException(ex);
        }
    }
    
    public List<TimeTable> whichTimetablesFitPathsDate(Date date, List<Path> pathList) throws FindException {
        StringBuilder queryString = new StringBuilder("SELECT t FROM TimeTable t WHERE date = :date AND (");
        
        for (int i = 0; i<pathList.size(); i++) {
            queryString.append("path = :path"+i);
            if (pathList.size() != i+1)
                 queryString.append(" or ");
            else queryString.append(")");
        }
        
        Query query = eManager.createQuery(queryString.toString());
        query.setParameter("date", date);
        
        for (int i = 0; i<pathList.size(); i++) {
            query.setParameter("path"+i, pathList.get(i));
        }
        try {
            return query.getResultList();
        } catch (Exception ex) {
            throw new FindException(ex);
        }
    }
    
    public List<Path> whichPathsFitStations(List<Path> pathsToTest, String stationFrom, String stationTo) throws FindException{
        List<Path> resultList = new ArrayList<Path>();
        Boolean isStartIn;
        
        for(Path path : pathsToTest) {
            isStartIn = false;
            List<Destination> destinationList = path.getDestination();
            for(Destination destination : destinationList) {
                if (stationFrom.equals(destination.getStation().getName())) {
                    isStartIn = true;
                    continue;
                }
                if (isStartIn && stationTo.equals(destination.getStation().getName())) {
                    resultList.add(path);
                    break;
                }
            }
        }
        if (resultList.size() == 0)
            throw new FindException("No routes fit your options");
        return resultList;
    } 
    
}
