package com.modular.erp.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;

@NoRepositoryBean
public interface CrudRepository<T, ID> extends PagingAndSortingRepository<T, ID> {

    // Create
    <S extends T> S save(S entity);

    <S extends T> Iterable<S> saveAll(Iterable<S> entities);

    // If exists
    boolean existsById(ID id);

    @Override
    @NonNull
    Page<T> findAll(@NonNull Pageable pageable);

    Iterable<T> findAllById(Iterable<ID> ids);

    T findById(ID id);

    long count();

    // Delete
    void deleteById(ID id);

    void delete(T entity);

    void deleteAllById(Iterable<? extends ID> ids);

    void deleteAll(Iterable<? extends T> entities);

    void deleteAll();

}
