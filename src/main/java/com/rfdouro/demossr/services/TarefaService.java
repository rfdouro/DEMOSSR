package com.rfdouro.demossr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rfdouro.demossr.models.Tarefa;
import com.rfdouro.demossr.models.TarefaRepository;

@Service
public class TarefaService {
 @Autowired
 TarefaRepository repository;

 public Tarefa salva(Tarefa tarefa) {
  return this.repository.save(tarefa);
 }

 public Tarefa seleciona(Long id) {
  Tarefa tarefa = this.repository.findById(id).get();
  if (tarefa != null) {
   return tarefa;
  }
  return null;
 }

 public Tarefa exclui(Long id) {
  Tarefa tarefa = this.seleciona(id);
  if (tarefa != null) {
   this.repository.delete(tarefa);
  }
  return tarefa;
 }

 public List<Tarefa> listaTodas() {
  return this.repository.findAll(Sort.by(Sort.Direction.ASC, "data", "titulo"));
 }
}
