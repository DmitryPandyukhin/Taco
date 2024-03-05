package tacos;

import java.util.ArrayList;
import java.util.List;

public class TacoOrder {
	private String deliveryName;
	private String deliveryStreet;
	private String deliveryCity;
	private String deliveryState;
	private String deliveryZip;
	private String ccNumber;
	private String ccExpiration;
	private String ccOW;
	
	private List<Taco> tacos = new ArrayList<>();
	
	public TacoOrder() {}
	
	public TacoOrder(String deliveryName, String deliveryStreet, String deliveryCity, String deliveryState,
			String deliveryZip, String ccNumber, String ccExpiration, String ccOW) {
		super();
		this.deliveryName = deliveryName;
		this.deliveryStreet = deliveryStreet;
		this.deliveryCity = deliveryCity;
		this.deliveryState = deliveryState;
		this.deliveryZip = deliveryZip;
		this.ccNumber = ccNumber;
		this.ccExpiration = ccExpiration;
		this.ccOW = ccOW;
	}
	
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public void setDeliveryStreet(String deliveryStreet) {
		this.deliveryStreet = deliveryStreet;
	}

	public void setDeliveryCity(String deliveryCity) {
		this.deliveryCity = deliveryCity;
	}

	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}

	public void setDeliveryZip(String deliveryZip) {
		this.deliveryZip = deliveryZip;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public void setCcExpiration(String ccExpiration) {
		this.ccExpiration = ccExpiration;
	}

	public void setCcOW(String ccOW) {
		this.ccOW = ccOW;
	}

	public String getDeliveryName() {
		return deliveryName;
	}

	public String getDeliveryStreet() {
		return deliveryStreet;
	}

	public String getDeliveryCity() {
		return deliveryCity;
	}

	public String getDeliveryState() {
		return deliveryState;
	}

	public String getDeliveryZip() {
		return deliveryZip;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public String getCcExpiration() {
		return ccExpiration;
	}

	public String getCcOW() {
		return ccOW;
	}
	
	public List<Taco> getTacos() {
		return tacos;
	}

	public void addTaco(Taco taco) {
		this.tacos.add(taco);
	}
}
