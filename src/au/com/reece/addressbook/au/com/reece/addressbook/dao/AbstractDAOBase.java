package au.com.reece.addressbook.au.com.reece.addressbook.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Ananthan on 20/8/17.
 */
public abstract class AbstractDAOBase<T> implements GenericDAO<T> {

    private Map<Integer,T> memoryMap = new HashMap<>();
    
    @Override
    public Stream<T> findAll() {
        return memoryMap.values().stream();
    }

    @Override
    public void save(final T entity) {
       Integer entityId = findEnitityId(entity);

       if(entityId == null){
           Integer nextId = memoryMap.keySet().stream().mapToInt(Integer::intValue).max().getAsInt()+1;
           memoryMap.put(nextId,entity);
       }
       else{
           memoryMap.put(entityId,entity);
       }

    }


    @Override
    public Boolean delete(final T entity) {
        Integer entityId = findEnitityId(entity);
        T entityObj = null;
        if(entityId != null){
            entityObj = memoryMap.remove(entityId);
        }

        return (entityObj !=null);
    }

    @Override
    public Optional<T> get(final Serializable id) {
        return Optional.ofNullable(memoryMap.get(id));

    }

    private Integer findEnitityId(T entity) {
        return memoryMap.entrySet().stream()
                .filter(e -> e.getValue().equals(entity))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }
}
