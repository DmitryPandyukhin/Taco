package tacos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Taco {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  @NotNull
  @Size(min = 5, message = "Поле должно содержать не менее 5 символов.")
	private String name;
  
  private Date createdAt = new Date();
  
  @NotNull
  @Size(min=1, message = "Вы должны выбрать хотя бы 1 ингредиент")
  @ManyToMany
	private List<Ingredient> ingredients = new ArrayList<>();
  
  public void addIngredient(Ingredient ingredient) {
    this.ingredients.add(ingredient);
  }
	
  @Override
	public String toString() {
	  var sb = new StringBuilder();
	  sb.append(this.getClass().getName() + "(");
	  
	  sb.append("name=" + name + ",");
	  sb.append(" ingredients=" + ingredients.toString());
	  
	  sb.append(")");
	  
	  return sb.toString();
	}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  public void setIngredients(List<Ingredient> ingredients) {
    this.ingredients = ingredients;
  }
}
