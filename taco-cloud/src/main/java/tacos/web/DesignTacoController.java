package tacos.web;

import tacos.Ingredient;
import tacos.Ingredient.Type;
import tacos.Taco;
import tacos.TacoOrder;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {
	
	private static final Logger log = Logger.getLogger(DesignTacoController.class.getName());
	
	@ModelAttribute
	public void addIngredientsToModel(Model model) {
		List<Ingredient> ingredients = Arrays.asList(
					new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
					new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
					new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
					new Ingredient("CARN", "Carnitas", Type.PROTEIN),
					new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
					new Ingredient("LETC", "Lettuce", Type.VEGGIES),
					new Ingredient("CHED", "Cheddar", Type.CHEESE),
					new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
					new Ingredient("SLSA", "Salsa", Type.SAUCE),
					new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
				);
		
		Type[] types = Ingredient.Type.values();
		for (Type type : types) {
			model.addAttribute(
					type.toString().toLowerCase(), 
					ingredients.stream()
						.filter(x -> x.getType().equals(type))
						.collect(Collectors.toList()));
		}
	}
	
	@ModelAttribute(name = "tacoOrder")
	public TacoOrder order() {
		return new TacoOrder();
	}
	
	@ModelAttribute(name = "taco")
	public Taco taco() {
		return new Taco();
	}
	
	@GetMapping
	public String showDesignForm() {
		return "design";
	}
	
	// TODO Объект taco получает taco с формы. 
	@PostMapping
	public String processTaco(Taco taco, @ModelAttribute TacoOrder tacoOrder) {
		tacoOrder.addTaco(taco);
		log.info("Processing taco: " + taco);
		return "redirect:/orders/current";
	}
}