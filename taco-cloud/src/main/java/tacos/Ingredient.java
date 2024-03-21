package tacos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Ingredient{
  @Id
	private final String id;
	private final String name;
	private final Type type;
	
	public enum Type {
    WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
  }
	
	@SuppressWarnings("unused")
  private Ingredient() {
	  id = null;
	  name = null;
	  type = null;
	}
	
	public Ingredient(String id, String name, Type type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}
}
