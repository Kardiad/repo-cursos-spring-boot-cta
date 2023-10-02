package edu.cta.academy.service;

import java.util.Optional;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cta.academy.entity.Curso;
import edu.cta.academy.repository.CursoRepository;


@Service
public class CursoServiceImpl implements CursoService {
	@Autowired 
	CursoRepository repo;

	@Override
	@Transactional
	public Iterable<Curso> listaCurso() {
		return this.repo.findAll();
	}

	@Override
	@Transactional
	public Optional<Curso> obtenerCursoPorId(Long id) {
		return this.repo.findById(id);
	}

	@Override
	@Transactional
	public Optional<Curso> editarCurso(Curso curso, Long id) {
		// TODO Auto-generated method stub
		Optional<Curso> c = Optional.empty();
		Curso cu = null;
		if(id!=null) {
			c = this.repo.findById(id);	
		}
		if(c.isPresent()) {
			cu = c.get();
			BeanUtils.copyProperties(curso, cu, "id");
		}
		return Optional.of(c.get());
	}

	@Override
	@Transactional
	public void borrarCurso(Long id) {
		this.repo.deleteById(id);
	}

	@Override
	@Transactional
	public Curso insertarCurso(Curso curso) {
		return this.repo.save(curso);
	}
	
	
}
