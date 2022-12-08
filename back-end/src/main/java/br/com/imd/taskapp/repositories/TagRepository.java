package br.com.imd.taskapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.imd.taskapp.entities.Tag;

public interface TagRepository extends JpaRepository<Tag, Long>{

}
