package com.estudo.controller;

import com.estudo.repository.CategoriaRepository;
import com.estudo.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<?> listar(@RequestParam Integer id){
        return ResponseEntity.ok().body(categoriaService.listaPor(id));
    }
}
