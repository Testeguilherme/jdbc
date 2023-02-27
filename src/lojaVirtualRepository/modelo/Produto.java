package lojaVirtualRepository.modelo;

public class Produto {
	
	private Integer id;
	private String name;
	private String description;
	
	
	public Produto(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Produto(Integer id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}


	public String getName() {
		return name;
	}


	public String getDescription() {
		return description;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String toString() {
		return String.format("O produto é: %d, %s, %s.", this.id, this.name, this.description);
	}
	

}
