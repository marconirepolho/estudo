package com.estudo.service.impl;

import com.estudo.model.Categoria;
import com.estudo.model.Produto;
import com.estudo.model.dto.CategoriaDto;
import com.estudo.model.dto.ProdutoDto;
import com.estudo.service.CategoriaService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Categoria> listaPor(Integer id) {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Categoria> query = builder.createQuery(Categoria.class);
        Root<Categoria> root = query.from(Categoria.class);

        Subquery<Integer> subQuery = query.subquery(Integer.class);
        Root<Produto> subRoot = subQuery.from(Produto.class);

        subQuery.select(subRoot.get("categoria"));
        Predicate predicateSubQuery = builder.equal(subRoot.get("codigo"), id);
        subQuery.where(predicateSubQuery);

        Predicate predicatePrincipal = builder.in(root.get("codigo")).value(subQuery);
        query.where(predicatePrincipal);

        TypedQuery<Categoria> typeQuery = em.createQuery(query);
        return typeQuery.getResultList();
    }

    @Override
    public List<CategoriaDto> listaPor() {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<CategoriaDto> query = builder.createQuery(CategoriaDto.class);
        Root<Categoria> root = query.from(Categoria.class);

        Subquery<Number> subQuery = query.subquery(Number.class);
        Root<Produto> subRoot = subQuery.from(Produto.class);

        query.select(builder.construct(
                CategoriaDto.class,
                root.get("codigo"),
                root.get("nome"),
                subQuery
        ));

        //subtração => builer.diff
        //multiplicação => builder.prod
        //divisão => builder.quot
        Expression<Number> somaDosValores = builder.sum(subRoot.get("valor"));
        subQuery.select(somaDosValores);

        Predicate predicateSubQuery = builder.equal(subRoot.get("categoria"), root.get("codigo"));
        subQuery.where(predicateSubQuery);

        TypedQuery<CategoriaDto> typeQuery = em.createQuery(query);
        return typeQuery.getResultList();
    }
}
