package edu.cta.academy.service;

import java.util.Optional;

import edu.cta.academy.entity.Curso;


public interface CursoService {
	public Iterable<Curso> listaCurso();
	public Optional<Curso> obtenerCursoPorId(Long id);
	public Optional<Curso> editarCurso(Curso curso, Long id);
	public Curso insertarCurso(Curso curso);
	public void borrarCurso(Long id);
}
