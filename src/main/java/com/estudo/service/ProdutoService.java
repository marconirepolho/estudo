package com.estudo.service;

import com.estudo.controller.filtro.ProdutoFilter;
import com.estudo.model.Produto;
import com.estudo.model.dto.ProdutoDto;

import java.util.List;


public interface ProdutoService {

    public List<Produto> listaProdutos();

    public List<Produto> listaPorCategoria(Integer categoriaId);

    public List<Produto> listaPorFiltro(ProdutoFilter filtro);

    public List<Produto> listaPorFiltro2(ProdutoFilter filtro);

    public List<Produto> listaPorFiltro3(ProdutoFilter filtro);

    public List<Produto> listaPorFiltro4(ProdutoFilter filtro);

    public List<ProdutoDto> listaPorFiltro5(ProdutoFilter filtro);
}
