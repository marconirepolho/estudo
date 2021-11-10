package com.estudo.controller;

import com.estudo.controller.filtro.ProdutoFilter;
import com.estudo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<?> listarProdutos(){
        return ResponseEntity.ok().body(service.listaProdutos());
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<?> listarProdutos(@PathVariable Integer id){
        return ResponseEntity.ok().body(service.listaPorCategoria(id));
    }

    @GetMapping("/filtro")
    public ResponseEntity<?> listarPorFiltro(ProdutoFilter filtro){
        return ResponseEntity.ok().body(service.listaPorFiltro3(filtro));
    }
}
