package com.upf.projetoIntegrador.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.upf.projetoIntegrador.domain.geral.Cidades;
import com.upf.projetoIntegrador.service.CidadeService;

@Controller
@RequestMapping("/cidade")
public class CidadeController {

	/// Controles de Cidade

		@Autowired
		private CidadeService cidadeService;

		
		@GetMapping("/limpar")
		public String limparUrl(Cidades cidade,ModelMap model) {
			model.addAttribute("cidade",cidade);

			return "/cidade/cadastro";
		}		
		
		@GetMapping("/cadastroTESTE")
		public ModelAndView cadastrar2(Cidades cidade,ModelMap model) {
            
			ModelAndView mv = new ModelAndView("/cidade/cadastro");
			mv.addObject("cidade", cidade);
			//model.addAttribute("success", "Cidade Salva Com Sucesso");
			return mv;
			
			
		}
		
		@GetMapping("/cadastro")
		public String cadastrar(Cidades cidade,ModelMap model,RedirectAttributes attr ) {
            
			if (attr.containsAttribute("fail")) {
				System.out.println("Teste");
			}
			model.addAttribute("cidade",cidade);
			
			return "/cidade/cadastro";	
		}


		@GetMapping("/listar")
		public String listar(ModelMap model) {
			model.addAttribute("cidades", cidadeService.buscarTodos());
			//return "/cidade/lista";
			return "/cidade/lista";
		}

		@PostMapping("/cidade/salvar")
		public String salvarOriginal(Cidades cidade,ModelMap model, RedirectAttributes attr)  {
		
			 try {
				 cidadeService.salvar(cidade);
				 attr.addFlashAttribute("success", "cidade Salva com sucesso.");
					
					return "redirect:/cidade/cadastro";
				} catch (Exception e) {

					attr.addFlashAttribute("fail", e.toString());
					
					  model.addAttribute("cidade", cidade); 
					 // model.addAttribute("faill", "Teste");
					 attr.addAttribute("cidade", model);
					
					//return cadastrar(cidade, model,attr);
					//return limparUrl(cidade, model);
					 // return "redirect:/cidade/cadastro";
					  return "redirect:/cidade/cadastro";
				}
			
			 
		}
		
		@PostMapping("/cidade/salvar22")
		public RedirectView  salvarTeste(Cidades cidade,ModelMap model, RedirectAttributes attr)  {
		
			 try {
				 cidadeService.salvar(cidade);
				 attr.addFlashAttribute("success", "cidade Salva com sucesso.");
					
					//return "redirect:/cidade/cadastro";
					return new RedirectView("/cidade/cadastro");
				} catch (Exception e) {

					attr.addFlashAttribute("fail", e.toString());
					
					  model.addAttribute("cidade", cidade); 
					//  model.addAttribute("faill", "Teste");
					
					//return cadastrar(cidade, model,attr);
					//return "redirect:/cidade/cadastro";
					return new RedirectView("/cidade/cadastro");
					 // return "redirect:/cidade/cadastro";
				}
			
			 
		}
		

		
		@GetMapping("/excluir/{id}")
		public String excluir(@PathVariable("id") Long id, ModelMap model) {
			/*
			 * if(!cidadeService.cidadeTemCargos(id)) { cidadeService.excluir(id); }
			 */
			try {
				cidadeService.excluir(id);
				model.addAttribute("success", "Removido Com Sucesso");
				
			} catch (Exception e) {
				model.addAttribute("fail", e.getMessage());
			}
			
			
			return listar(model);
		}
		
		@GetMapping("/editar/{id}")
		public String preEditar(@PathVariable("id") Long id, ModelMap model) {
			model.addAttribute("cidade", cidadeService.buscarPorId(id));
			return "/cidade/cadastro";
		}
		
		@PostMapping("/editar/cidade/editar")
		public  String editar(Cidades cidade, RedirectAttributes attr) {
			cidadeService.editar(cidade);
			attr.addFlashAttribute("success", "cidade editada com sucesso.");
			
			return "redirect:/cidade/cadastro";
		}
		
		
}
