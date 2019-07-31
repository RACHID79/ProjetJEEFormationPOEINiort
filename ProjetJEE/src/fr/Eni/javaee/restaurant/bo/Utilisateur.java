package fr.Eni.javaee.restaurant.bo;

import java.util.List;

public class Utilisateur {

	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String mdp;
	private String commentaire;
	private List<String> roles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public Utilisateur(int id, String nom, String prenom, String email, String commentaire) {
		setId(id);
		setNom(prenom);
		setPrenom(prenom);
		setEmail(email);
		setCommentaire(commentaire);
	}

	public Utilisateur(String nom, String prenom, String email, String mdp, String commentaire) {
		setNom(prenom);
		setPrenom(prenom);
		setEmail(email);
		setMdp(mdp);
		setCommentaire(commentaire);
	}

	public Utilisateur() {
		super();
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", commentaire="
				+ commentaire + "]";
	}

}
