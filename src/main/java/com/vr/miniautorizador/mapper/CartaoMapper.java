package com.vr.miniautorizador.mapper;

import com.vr.miniautorizador.domain.CartaoEntity;
import com.vr.miniautorizador.domain.dao.CartaoDao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartaoMapper extends EntityMapper<CartaoEntity, CartaoDao> {
}
