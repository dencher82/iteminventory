package hw.ashkelon2020.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemDto {
	Integer itemNo;
	String name;
	Integer amount;
	Long inventoryCode;
}
