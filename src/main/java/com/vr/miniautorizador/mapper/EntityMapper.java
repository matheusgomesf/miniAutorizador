package com.vr.miniautorizador.mapper;

public interface EntityMapper<T, K> {

    T dtoToEntity(K dto);

    K entityToDto(T entity);
}
