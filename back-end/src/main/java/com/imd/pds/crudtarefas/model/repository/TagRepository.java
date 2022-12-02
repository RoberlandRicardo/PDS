package com.imd.pds.crudtarefas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imd.pds.crudtarefas.model.entity.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

}