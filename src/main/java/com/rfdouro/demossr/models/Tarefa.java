package com.rfdouro.demossr.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tbdemotarefa", indexes = {
  @Index(columnList = "titulo,dt_tarefa", unique = true)
})
public class Tarefa {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "id")
 private Long id;
 @Column(name = "titulo", length = 150)
 private String titulo;
 @Column(name = "descricao")
 private String descricao;
 @Column(name = "dt_tarefa")
 @Temporal(TemporalType.DATE)
 private Date data;

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getTitulo() {
  return titulo;
 }

 public void setTitulo(String titulo) {
  this.titulo = titulo;
 }

 public String getDescricao() {
  return descricao;
 }

 public void setDescricao(String descricao) {
  this.descricao = descricao;
 }

 public Date getData() {
  return data;
 }

 public void setData(Date data) {
  this.data = data;
 }

}
