package fr.Eni.javaee.restaurant.bo;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Commentaire")
public class Commentaire {
	private static final long serialVersionUID = 1L;

	private int id;
	private int note;
	private String commentaire = "";
	private Utilisateur utilisateur;
	private Plat plat;
	private LocalDateTime date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Plat getPlat() {
		return plat;
	}

	public void setPlat(Plat plat) {
		this.plat = plat;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Commentaire(int id, int note, String commentaire, Utilisateur utilisateur, Plat plat, LocalDateTime date) {
		setId(id);
		setNote(note);
		setCommentaire(commentaire);
		setUtilisateur(utilisateur);
		setPlat(plat);
		setDate(date);
	}

	public Commentaire(int note, String commentaire, Utilisateur utilisateur, Plat plat, LocalDateTime date) {
		setNote(note);
		setCommentaire(commentaire);
		setUtilisateur(utilisateur);
		setPlat(plat);
		setDate(date);
	}

	public Commentaire() {
		super();
	}

	public Commentaire(int id, int note, String commentaire, LocalDateTime date) {
		setId(id);
		setNote(note);
		setCommentaire(commentaire);
		setDate(date);
	}

	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", note=" + note + ", commentaire=" + commentaire + ", utilisateur="
				+ utilisateur + ", plat=" + plat + ", date=" + date + "]";
	}

}
