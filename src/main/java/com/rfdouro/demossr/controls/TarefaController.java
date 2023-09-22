package com.rfdouro.demossr.controls;

import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rfdouro.demossr.models.Tarefa;
import com.rfdouro.demossr.services.TarefaService;

@Controller
@RequestMapping("/tarefa")
public class TarefaController {
 @Autowired
 TarefaService tarefaService;

 //continua

 @GetMapping("/list")
 public String listagem(Model model) {
  model.addAttribute("listaTarefas", this.tarefaService.listaTodas());
  return "tarefa/listagem";
 }

 @GetMapping("/add")
 public String abreCadastro() {
  return "tarefa/cadastro";
 }

 @PostMapping("/add")
 public ModelAndView adiciona(String titulo, String descricao, @DateTimeFormat(pattern = "yyyy-MM-dd") Date data)
   throws ParseException {
  Tarefa tarefa = new Tarefa();
  tarefa.setData(data);
  tarefa.setTitulo(titulo);
  tarefa.setDescricao(descricao);
  this.tarefaService.salva(tarefa);
  return new ModelAndView("redirect:/tarefa/list");
 }

 @GetMapping("/delete/{id}")
 public ModelAndView abreExcluir(@PathVariable(value = "id", required = true) Long id) {
  Tarefa tarefa = this.tarefaService.seleciona(id);
  if (tarefa != null) {
   ModelMap model = new ModelMap();
   model.addAttribute("tarefa", tarefa);
   return new ModelAndView("tarefa/confirmaExclui", model);
  }
  return new ModelAndView("redirect:/tarefa/list");
 }

 @PostMapping("/delete")
 public ModelAndView delete(Long id) throws ParseException {
  this.tarefaService.exclui(id);
  return new ModelAndView("redirect:/tarefa/list");
 }

 @GetMapping("/edit/{id}")
 public ModelAndView abreAltera(@PathVariable(value = "id", required = true) Long id) {
  Tarefa tarefa = this.tarefaService.seleciona(id);
  if (tarefa != null) {
   ModelMap model = new ModelMap();
   model.addAttribute("tarefa", tarefa);
   return new ModelAndView("tarefa/edicao", model);
  }
  return new ModelAndView("redirect:/tarefa/list");
 }

 @PostMapping("/edit")
 public ModelAndView altera(Long id, String titulo, String descricao, @DateTimeFormat(pattern = "yyyy-MM-dd") Date data) {
  Tarefa tarefa = this.tarefaService.seleciona(id);
  tarefa.setData(data);
  tarefa.setDescricao(descricao);
  tarefa.setTitulo(titulo);
  this.tarefaService.salva(tarefa);
  return new ModelAndView("redirect:/tarefa/list");
 }
}
