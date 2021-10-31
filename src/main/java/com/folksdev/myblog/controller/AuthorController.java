package com.folksdev.myblog.controller;


import com.folksdev.myblog.entity.Author;
import com.folksdev.myblog.model.Dto.AuthorDto;
import com.folksdev.myblog.model.request.CreatAuthorRequest;
import com.folksdev.myblog.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<AuthorDto> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("{id}")
    public AuthorDto getAuthorById(@PathVariable Long id){
        return authorService.getAuthorById(id);
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author){
        return authorService.createAuthor(author);
    }

    @PutMapping("{id}")
    public Author updateAuthor(@PathVariable Long id , @RequestBody Author author){
        return authorService.updateAuthor(id,author);
    }

    @DeleteMapping("{id}")
    public void deleteAuthor(@PathVariable Long id){
        authorService.deleteAuthorById(id);
    }



}
