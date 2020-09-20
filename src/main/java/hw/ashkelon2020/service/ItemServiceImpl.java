package hw.ashkelon2020.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hw.ashkelon2020.dao.ItemRepository;
import hw.ashkelon2020.dto.ItemDto;
import hw.ashkelon2020.dto.exceptions.ForbiddenException;
import hw.ashkelon2020.dto.exceptions.ItemAlreadyExist;
import hw.ashkelon2020.dto.exceptions.ItemNotFoundException;
import hw.ashkelon2020.model.Item;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	@Transactional(readOnly = true)
	public List<ItemDto> getItems() {
		return itemRepository.findAll().stream()
				.map(i -> mapper.map(i, ItemDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public ItemDto getItemByItemNo(Integer itemNo) {
		Item item = itemRepository.findById(itemNo).orElseThrow(() -> new ItemNotFoundException(itemNo));
		return mapper.map(item, ItemDto.class);
	}

	@Override
	@Transactional
	public ItemDto withdrawalQuantityToItem(Integer itemNo, Integer quantity) {
		Item item = itemRepository.findById(itemNo).orElseThrow(() -> new ItemNotFoundException(itemNo));
		if (!item.withdrawalQuantity(quantity)) {
			throw new ForbiddenException();
		}
		return mapper.map(item, ItemDto.class);
	}

	@Override
	@Transactional
	public ItemDto depositQuantityToItem(Integer itemNo, Integer quantity) {
		Item item = itemRepository.findById(itemNo).orElseThrow(() -> new ItemNotFoundException(itemNo));
		item.depositQuantity(quantity);
		return mapper.map(item, ItemDto.class);
	}

	@Override
	@Transactional
	public ItemDto addItem(ItemDto itemDto) {
		if (itemRepository.existsById(itemDto.getItemNo())) {
			throw new ItemAlreadyExist(itemDto.getItemNo());
		}
		Item item = mapper.map(itemDto, Item.class);
		itemRepository.save(item);
		return mapper.map(item, ItemDto.class);
	}

	@Override
	@Transactional
	public ItemDto deleteItem(Integer itemNo) {
		Item item = itemRepository.findById(itemNo).orElseThrow(() -> new ItemNotFoundException(itemNo));
		itemRepository.delete(item);
		return mapper.map(item, ItemDto.class);
	}

}
