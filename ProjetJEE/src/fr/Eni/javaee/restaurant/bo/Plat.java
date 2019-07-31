package fr.Eni.javaee.restaurant.bo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Plat")
public class Plat implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private float prix;
	private String nom;
	private String presentation;
	private String niveau;
	private String cout;
	private int nbConvive;
	private String listIngredient;
	private String imageURL;
	private int nbCommande;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPresentation() {
		return presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getCout() {
		return cout;
	}

	public void setCout(String cout) {
		this.cout = cout;
	}

	public int getNbConvive() {
		return nbConvive;
	}

	public void setNbConvive(int nbConvive) {
		this.nbConvive = nbConvive;
	}

	public String getListIngredient() {
		return listIngredient;
	}

	public void setListIngredient(String listIngredient) {
		this.listIngredient = listIngredient;
	}

	public float getPrix() {
		return prix;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public int getNbCommande() {
		return nbCommande;
	}

	public void setNbCommande(int nbCommande) {
		this.nbCommande = nbCommande;
	}

	public Plat() {
		super();
	}

	public Plat(float prix, String nom, String presentation, String niveau, String cout, int nbConvive, int nbcommande,
			String listIngredient, String imageURL) {
		setPrix(prix);
		setNom(nom);
		setPresentation(presentation);
		setNiveau(niveau);
		setCout(cout);
		setNbConvive(nbConvive);
		setNbCommande(nbcommande);
		setListIngredient(listIngredient);
		setImageURL(imageURL);

	}

	public Plat(int id, float prix, String nom, String presentation, String niveau, String cout, int nbConvive, int nbcommande,
			String listIngredient, String imageURL) {
		setId(id);
		setPrix(prix);
		setNom(nom);
		setPresentation(presentation);
		setNiveau(niveau);
		setCout(cout);
		setNbConvive(nbConvive);
		setNbCommande(nbcommande);
		setListIngredient(listIngredient);
		setImageURL(imageURL);
	}

	@Override
	public String toString() {
		return "Plat [id=" + id + ", prix=" + prix + ", nom=" + nom + ", presentation=" + presentation + ", niveau="
				+ niveau + ", cout=" + cout + ", nbConvive=" + nbConvive + ", listIngredient=" + listIngredient
				+ ", imageURL=" + imageURL + ", nbCommande=" + nbCommande + "]";
	}




}