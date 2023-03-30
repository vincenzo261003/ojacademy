package com.taskCondominio.Gestione.condomini.controllers;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.taskCondominio.Gestione.condomini.models.Avviso;
import com.taskCondominio.Gestione.condomini.services.AvvisoService;
import com.taskCondominio.Gestione.condomini.utils.GestioneAutenticazione;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/condomini/avvisi")
@EnableWebMvc
public class AvvisiControllerWeb {

	@Autowired
	private AvvisoService service;
	
	@Autowired
	private GestioneAutenticazione g;
	
	@GetMapping("/aggiungi/{varCondominio}")
	public String inserisciInquilino(@PathVariable String varCondominio, Model model, HttpServletRequest request) {
		if (! g.checkAutenticazione(request, 1))
			return "errorPermessi";
		
		Avviso u = new Avviso();
		model.addAttribute("avviso", u);
		model.addAttribute("condominio", varCondominio);
		
		return "inserimentoAvviso";
	}
	
	@PostMapping("/aggiungi/{varCondominio}")
	public String insUtente(@ModelAttribute("avviso") Avviso objAvviso, @PathVariable String varCondominio) {
		objAvviso.setDataavviso(new Date(System.currentTimeMillis()));
		service.inserisciAvviso(objAvviso, varCondominio);
		return "redirect:/condomini/stabile/" + varCondominio;
	}
	
	@GetMapping("/{idAvviso}")
	public String showAvviso(@PathVariable String idAvviso, HttpServletRequest request, Model model) {
		Integer id = 0;
		
		try {
			id = Integer.parseInt(idAvviso);
		} catch (Exception e) {
			return "error";
		}
		
		Avviso av = service.cercaAvvisoId(id);
		String varCondominio = av.getCondominio().getCodice();
		
		if (! g.checkAutenticazione2(request, varCondominio))
			return "errorPermessi";
		
		model.addAttribute("avviso", av);
		model.addAttribute("admin", g.checkAutenticazione(request, 1));
		
		return "cardAvviso";
	}
	
	@GetMapping("/modifica/{idAvviso}")
	public String modAvviso(@PathVariable String idAvviso, HttpServletRequest request, Model model) {
		if (! g.checkAutenticazione(request, 1))
			return "errorPermessi";
		
		Integer id = 0;
		
		try {
			id = Integer.parseInt(idAvviso);
		} catch (Exception e) {
			return "error";
		}
		
		Avviso av = service.cercaAvvisoId(id);
		
		model.addAttribute("avviso", av);
		
		return "modificaAvviso";
	}
	
	@PostMapping("/modifica/{idAvviso}")
	public String modAvvisoSave(@PathVariable String idAvviso, HttpServletRequest request, @ModelAttribute("avviso") Avviso a) {
		Integer id = 0;
		try {
			id = Integer.parseInt(idAvviso);
		} catch (Exception e) {
			return "error";
		}
		
		Avviso temp = service.cercaAvvisoId(id);
		
		a.setDataavviso(temp.getDataavviso());
		a.setCondominio(temp.getCondominio());
		service.aggiornaAvviso(id, a);
		return "redirect:/condomini/avvisi/" + idAvviso;
	}
	
	@GetMapping("/elimina/{idAvviso}")
	public String eliminaAvviso(@PathVariable String idAvviso, HttpServletRequest request) {
		if (! g.checkAutenticazione(request, 1))
			return "errorPermessi";
		
		Integer id = 0;
		
		try {
			id = Integer.parseInt(idAvviso);
		} catch (Exception e) {
			return "error";
		}
		
		String varCondominio = service.cercaAvvisoId(id).getCondominio().getCodice();
		
		if (! service.eliminaAvvisoId(id))
			return "error";
		
		return "redirect:/condomini/stabile/" + varCondominio;
	}
	
}
