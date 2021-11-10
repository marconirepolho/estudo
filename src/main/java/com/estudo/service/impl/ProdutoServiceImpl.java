package com.estudo.service.impl;

import com.estudo.controller.filtro.ProdutoFilter;
import com.estudo.model.Categoria;
import com.estudo.model.Produto;
import com.estudo.model.dto.ProdutoDto;
import com.estudo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Produto> listaProdutos() {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
        query.from(Produto.class);

        TypedQuery<Produto> typeQuery = em.createQuery(query);
        return typeQuery.getResultList();
    }

    @Override
    public List<Produto> listaPorCategoria(Integer categoriaId) {


        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
        Root<Produto> root = query.from(Produto.class);

        Predicate predicate = builder.equal(root.get("categoria"), categoriaId);
        query.where(predicate);

        TypedQuery<Produto> typeQuery = em.createQuery(query);
        return typeQuery.getResultList();
    }

    @Override
    public List<Produto> listaPorFiltro(ProdutoFilter filtro) {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
        Root<Produto> root = query.from(Produto.class);

        Predicate predicate1 = builder.equal(root.get("categoria"), filtro.getCategoriaId());
        Predicate predicate2 = builder.equal(root.get("codigo"), filtro.getProdutoId());
        query.where(predicate1, predicate2);

        TypedQuery<Produto> typeQuery = em.createQuery(query);
        return typeQuery.getResultList();
    }

    @Override
    public List<Produto> listaPorFiltro2(ProdutoFilter filtro) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
        Root<Produto> root = query.from(Produto.class);

        Predicate predicate1 = builder.equal(root.get("categoria"), filtro.getCategoriaId());
        Predicate predicate2 = builder.equal(root.get("codigo"), filtro.getProdutoId());

        Predicate predicate3 = builder.or(predicate1, predicate2);
        query.where(predicate3);

        TypedQuery<Produto> typeQuery = em.createQuery(query);
        return typeQuery.getResultList();
    }

    @Override
    public List<Produto> listaPorFiltro3(ProdutoFilter filtro) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
        Root<Produto> root = query.from(Produto.class);

        List<Predicate> predicates = new ArrayList<>();

        if(filtro.getProdutoId() != null)
            predicates.add(builder.equal(root.get("codigo"), filtro.getProdutoId()));

        if(filtro.getCategoriaId() != null)
            predicates.add(builder.equal(root.get("categoria"), filtro.getCategoriaId()));

        if(filtro.getValor() != null)
            predicates.add(builder.greaterThanOrEqualTo(root.get("valor"), filtro.getProdutoId()));

        query.where(predicates.stream().toArray(Predicate[]::new));

        TypedQuery<Produto> typeQuery = em.createQuery(query);
        return typeQuery.getResultList();
    }


    @Override
    public List<Produto> listaPorFiltro4(ProdutoFilter filtro) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
        Root<Produto> root = query.from(Produto.class);

        Join<Produto, Categoria> categoriaJoin = root.join("categoria");

        List<Predicate> predicates = new ArrayList<>();

        if(StringUtils.hasText(filtro.getCategoriaNome()))
            predicates.add(builder.like(categoriaJoin.get("nome"), "%" + filtro.getCategoriaNome() + "%"));


        query.where(predicates.stream().toArray(Predicate[]::new));

        TypedQuery<Produto> typeQuery = em.createQuery(query);
        return typeQuery.getResultList();
    }

    @Override
    public List<ProdutoDto> listaPorFiltro5(ProdutoFilter filtro) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<ProdutoDto> query = builder.createQuery(ProdutoDto.class);
        Root<Produto> root = query.from(Produto.class);

        Join<Produto, Categoria> categoriaJoin = root.join("categoria");

        query.select(
                builder.construct(
                        ProdutoDto.class,
                        root.get("codigo"),
                        root.get("nome"),
                        categoriaJoin.get("nome")
                )
        );

        List<Predicate> predicates = new ArrayList<>();

        if(StringUtils.hasText(filtro.getCategoriaNome()))
            predicates.add(builder.like(categoriaJoin.get("nome"), "%" + filtro.getCategoriaNome() + "%"));


        query.where(predicates.stream().toArray(Predicate[]::new));

        TypedQuery<ProdutoDto> typeQuery = em.createQuery(query);
        return typeQuery.getResultList();
    }

}
