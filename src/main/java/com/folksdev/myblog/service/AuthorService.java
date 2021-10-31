package com.folksdev.myblog.service;


import com.folksdev.myblog.entity.Author;
import com.folksdev.myblog.model.Dto.AuthorDto;
import com.folksdev.myblog.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {


    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<AuthorDto> getAllAuthors(){

        List<AuthorDto> authorDtos = authorRepository.findAll().stream().map(author->convertToDto(author)).collect(Collectors.toList());
        return authorDtos;

    }

    public AuthorDto getAuthorById(Long id){
        Author author = authorRepository.findById(id).orElseThrow(()->new RuntimeException("Yazar bulunamadı"));

        return convertToDto(author);
    }


    public Author createAuthor(Author author){
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, Author author){

        // Author author1 = getAuthorById(id);  Best Practice
        Author author1 = authorRepository.findById(id).orElseThrow(()->new RuntimeException("Yazar bulunamadı"));

        author1.setName(author.getName());
        author1.setSurname(author.getSurname());

        return authorRepository.save(author1);

    }

    public void deleteAuthorById(Long id){

        //authorRepository.deleteById(id);
        AuthorDto author = getAuthorById(id);

        authorRepository.delete(convertToEntity(author));

    }


    public AuthorDto convertToDto(Author author){

        AuthorDto authorDto = new AuthorDto();
        authorDto.setName(author.getName());
        authorDto.setSurname(author.getSurname());

        return authorDto;
    }

    public Author convertToEntity(AuthorDto authorDto){

        Author author = new Author();
        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());

        return author;
    }


}
