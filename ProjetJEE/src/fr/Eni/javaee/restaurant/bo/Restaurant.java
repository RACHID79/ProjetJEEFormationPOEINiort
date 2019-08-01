package fr.Eni.javaee.restaurant.bo;

public class Restaurant {

	private int id;
	private String nom;
	private String mapURL;
	private String imageURL;

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

	public String getMapURL() {
		return mapURL;
	}

	public void setMapURL(String mapURL) {
		this.mapURL = mapURL;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public Restaurant(int id, String nom, String mapURL, String imageURL) {
		setId(id);
		setNom(nom);
		setMapURL(mapURL);
		setImageURL(imageURL);
	}

	public Restaurant(String nom, String mapURL, String imageURL) {
		setNom(nom);
		setMapURL(mapURL);
		setImageURL(imageURL);
	}

	public Restaurant() {
		super();
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", nom=" + nom + ", mapURL=" + mapURL + ", imageURL=" + imageURL + "]";
	}

}
