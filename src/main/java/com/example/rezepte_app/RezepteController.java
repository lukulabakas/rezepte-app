package com.example.rezepte_app;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RezepteController {

	private final RezepteRepository repo;
	
	public RezepteController(RezepteRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping("/")
	public String alleRezepte(Model model) {
		 List<Rezept> rezepte = repo.findAll();
		    rezepte.forEach(r -> System.out.println("ID: " + r.getId() + ", Titel: " + r.getTitel() + ", Beschreibung: " + r.getBeschreibung()));
		model.addAttribute("rezepte", repo.findAll());
		return "liste";
	}
	@PostMapping("/neu")
	public String neuesRezept(@RequestParam String titel, @RequestParam String beschreibung) {
		repo.save(new Rezept(titel, beschreibung));
		return "redirect:/";
	}
	@GetMapping("/loeschen/{id}")
	public String loeschen(@PathVariable Long id) {
		repo.deleteById(id);
		return "redirect:/";
	}
}
