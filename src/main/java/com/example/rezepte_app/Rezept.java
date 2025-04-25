package com.example.rezepte_app;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Rezept {
	@Id
	@GeneratedValue
	private Long id;
	private String titel;
	private String beschreibung;
	
	public Rezept() {}
	
	public Rezept(String titel, String beschreibung) {
		this.titel = titel;
		this.beschreibung = beschreibung;
	}
	//Getter & Setter
	public String getTitel() {
		return this.titel;
	}
	public Long getId() {
		return this.id;
	}
	public String getBeschreibung() {
		return this.beschreibung;
	}
}
