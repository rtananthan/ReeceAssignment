package au.com.reece.addressbook.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
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

    }

    @Override
    public void update(final T entity) {

    }

    @Override
    public void delete(final T entity) {

    }

    @Override
    public Optional<T> get(final Serializable id) {
        return Optional.ofNullable(memoryMap.get(id));

    }
}
