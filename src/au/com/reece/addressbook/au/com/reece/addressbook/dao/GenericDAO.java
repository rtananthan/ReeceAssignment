package au.com.reece.addressbook.au.com.reece.addressbook.dao;

import java.io.Serializable;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Ananthan on 20/8/17.
 */
public interface GenericDAO<T> {

    public Stream<T> findAll();

    public Boolean save(final T entity);

    public Boolean delete(final T entity);

    public Optional<T> get(final Serializable id);
}
