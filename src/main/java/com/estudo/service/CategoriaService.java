package com.estudo.service;

import com.estudo.model.Categoria;
import com.estudo.model.Produto;
import com.estudo.model.dto.CategoriaDto;

import java.util.List;

public interface CategoriaService {

    public List<Categoria> listaPor(Integer id);
    public List<CategoriaDto> listaPor();
}
