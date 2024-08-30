package com.rfdouro.demossr.controls;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

public class MeuErrorController implements ErrorController {
 @RequestMapping("/error")
 public String handleError(Model model, HttpServletRequest request) {
  Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
  Exception e = (Exception) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
  model.addAttribute("status", status);
  if (status != null) {
   Integer statusCode = Integer.valueOf(status.toString());
   model.addAttribute("statusCode", statusCode);
   switch (statusCode.intValue()) {
    case 404:
     model.addAttribute("message", "Recurso não encontrado");
     break;
    default:
     model.addAttribute("message", e.getMessage());
   }
  }
  // envia para a página de erro
  return "error";
 }
}
