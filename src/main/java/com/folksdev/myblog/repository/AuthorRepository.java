package com.folksdev.myblog.repository;

import com.folksdev.myblog.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {

    //Author FindByAuthorName(String name);

}
