package hw.ashkelon2020.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hw.ashkelon2020.dto.ItemDto;
import hw.ashkelon2020.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@GetMapping("/items")
	public List<ItemDto> getItems() {
		return itemService.getItems();
	}
	
	@GetMapping("/item/{itemNo}")
	public ItemDto getItemByItemNo(@PathVariable Integer itemNo) {
		return itemService.getItemByItemNo(itemNo);
	}
	
	@DeleteMapping("/item/{itemNo}/quantity/{quantity}")
	public ItemDto withdrawalQuantityToItem(@PathVariable Integer itemNo, @PathVariable Integer quantity) {
		return itemService.withdrawalQuantityToItem(itemNo, quantity);
	}
	
	@PutMapping("/item/{itemNo}/quantity/{quantity}")
	public ItemDto depositQuantityToItem(@PathVariable Integer itemNo, @PathVariable Integer quantity) {
		return itemService.depositQuantityToItem(itemNo, quantity);
	}
	
	@PostMapping("/item")
	public ItemDto addItem(@RequestBody ItemDto itemDto) {
		return itemService.addItem(itemDto);
	}
	
	@DeleteMapping("/item/{itemNo}")
	public ItemDto deleteItem(@PathVariable Integer itemNo) {
		return itemService.deleteItem(itemNo);
	}
	
}
