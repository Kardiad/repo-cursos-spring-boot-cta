package edu.cta.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cta.academy.entity.Curso;
import edu.cta.academy.service.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	CursoService curso;

	@GetMapping("/list")
	public ResponseEntity<?> listado(){
		return ResponseEntity.ok(this.curso.listaCurso());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable Long id){
		return ResponseEntity.of(this.curso.obtenerCursoPorId(id));
	}
	
	@PostMapping("/insertar")
	public ResponseEntity<?> insertar(@RequestBody Curso c, BindingResult br){
		ResponseEntity<?> r = null;
		if(br.hasErrors()) {
			r = ResponseEntity.badRequest().body(br.getAllErrors());
		}else {
			r =  ResponseEntity.status(HttpStatus.CREATED).body(this.curso.insertarCurso(c));;
		}
		return r;	
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> editar(@RequestBody Curso c, @PathVariable Long id,  BindingResult br){
		ResponseEntity<?> r = null;
		if(br.hasErrors()) {
			r = ResponseEntity.badRequest().body(br.getAllErrors());
		}else {
			r = ResponseEntity.ok(this.curso.editarCurso(c, id).get());
		}
		return r;
		
	}
}