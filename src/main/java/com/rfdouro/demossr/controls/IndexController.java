package com.rfdouro.demossr.controls;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * mapeia todas as requisições no caminho padrão '/'
 */
@Controller
@RequestMapping("/")
public class IndexController {
 /**
  * recebe o mapeamento em '/' ou '/index'
  * sempre concatena o requestmapping da classe com o usado no método
  * @param model -> indica a ferramenta para enviar dados para o template
  * @return -> indica o nome do template utilizado para renderização
  */
 @GetMapping(value = { "", "index" })
 public String index(Model model) {
  model.addAttribute("mensagem", "Olá, hoje é " + LocalDate.now());
  return "index";
 }
}
