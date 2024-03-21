package tacos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.CreditCardNumber;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class TacoOrder implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  private Date placedAt = new Date();
  
  @NotBlank(message = "Укажите название доставки")
	private String deliveryName;
  
  @NotBlank(message = "Укажите улицу")
	private String deliveryStreet;
  
  @NotBlank(message = "Укажите город")
	private String deliveryCity;
  
  @Size(max = 2)
  @NotBlank(message = "Укажите регион")
	private String deliveryState;
  
  @NotBlank(message = "Укажите почтовый индекс")
	private String deliveryZip;
  
  @CreditCardNumber(message = "Неверный номер кредитной карты")
	private String ccNumber;
  
  @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
      message = "Значение должно быть в формате ММ/ГГ")
	private String ccExpiration;
  
  @Digits(integer = 3, fraction = 0, message = "Недействительный CVV")
	private String ccCVV;
	
  @OneToMany(cascade = CascadeType.ALL)
	private List<Taco> tacos = new ArrayList<>();
  
  public void addTaco(Taco taco) {
    this.tacos.add(taco);
  }
	
	public Date getPlacedAt() {
    return placedAt;
  }

  public void setPlacedAt(Date placedAt) {
    this.placedAt = placedAt;
  }	
	
	public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
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
	
	public void setCcCVV(String ccCVV) {
		this.ccCVV = ccCVV;
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
		return ccCVV;
	}
	
	public List<Taco> getTacos() {
		return tacos;
	}

	public String getCcCVV() {
    return ccCVV;
  }

  public void setTacos(List<Taco> tacos) {
    this.tacos = tacos;
  }

  @Override
  public String toString() {
    var sb = new StringBuilder();
    
    sb.append(this.getClass().getName() + "(");
    
    sb.append("deliveryName=" + deliveryName + ",");
    sb.append(" deliveryStreet=" + deliveryStreet + ",");
    sb.append(" deliveryCity=" + deliveryCity + ",");
    sb.append(" deliveryState=" + deliveryState + ",");
    sb.append(" deliveryZip=" + deliveryZip + ",");
    sb.append(" ccNumber=" + ccNumber + ",");
    sb.append(" ccExpiration=" + ccExpiration + ",");
    sb.append(" ccCVV=" + ccCVV + ",");
    sb.append(" tacos=" + tacos.toString());
    
    sb.append(")");
    
    return sb.toString();
  }
  
  
}
