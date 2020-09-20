package hw.ashkelon2020.service;

import java.util.List;

import hw.ashkelon2020.dto.ItemDto;

public interface ItemService {

	List<ItemDto> getItems();

	ItemDto getItemByItemNo(Integer itemNo);
	
	ItemDto withdrawalQuantityToItem(Integer itemNo, Integer quantity);
	
	ItemDto depositQuantityToItem(Integer itemNo, Integer quantity);
	
	ItemDto addItem(ItemDto itemDto);
	
	ItemDto deleteItem(Integer itemNo);
	
}
