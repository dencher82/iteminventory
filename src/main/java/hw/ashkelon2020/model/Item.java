package hw.ashkelon2020.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"itemNo"})
@Entity
public class Item implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	int itemNo;
	String name;
	int amount;
	long inventoryCode;
	
	public boolean withdrawalQuantity(int quantity) {
		if ((amount - quantity) < 0) {
			return false;
		}
		amount -= quantity;
		return true;		
	}
	
	public void depositQuantity(int quantity) {
		amount += quantity;		
	}
	
}
