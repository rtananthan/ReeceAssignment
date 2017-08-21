package au.com.reece.addressbook.au.com.reece.addressbook.dao;

import au.com.reece.addressbook.model.BaseEntity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * Created by Ananthan on 20/8/17.
 */
public abstract class AbstractDAOBase<T> implements GenericDAO<BaseEntity> {
    private final static Logger LOGGER = Logger.getLogger(AbstractDAOBase.class.getName());

    private Map<Integer,BaseEntity> memoryMap = new HashMap<>();

    /**Returns all entries in the memory for the given entity
     * @return List of Entities
     */
    @Override
    public Stream<BaseEntity> findAll() {
        return memoryMap.values().stream();
    }

    /**
     * Creates a new entry in the map if the entry doesnt exist
     * Otherwise its an update.
     * @param entity Entity Object that needs to be updated or deleted.
     */
    @Override
    public Boolean save(final BaseEntity entity) {
        BaseEntity baseEntity = null;
        try {
            if (entity.getId() == null ) {
                //Generate a unique no based on time
                Random random = new Random(System.nanoTime());

                Integer id = random.nextInt(1000000000);
                entity.setId(id);
            }
            //If the value exists it will be replaced otherwise new entry is created
            baseEntity = memoryMap.put(entity.getId(), entity);
        }catch(Exception ex){
            LOGGER.severe("Error saving contact "+ex.getMessage());
            return false;
        }
        return baseEntity !=null ? true:false;
    }


    /**
     * Removes the given entity from the Memory
     * @param entity Entity that needs to be deleted
     * @return true if the operation was successful , false otherwise
     */
    @Override
    public Boolean delete(final BaseEntity entity) {

        Integer entityId = entity.getId();
        BaseEntity entityObj = null;
        if(entityId != null){
            entityObj = memoryMap.remove(entityId);
        }

        return (entityObj !=null);
    }

    /** Search Entity by id
     * @param id Unique id of the entity
     * @return Entity with the given id.
     */
    @Override
    public Optional<BaseEntity> get(final Serializable id) {
        return Optional.ofNullable(memoryMap.get(id));

    }


}
