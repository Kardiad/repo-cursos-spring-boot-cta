package edu.cta.academy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import edu.cta.academy.entity.Curso;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Long>{

}
