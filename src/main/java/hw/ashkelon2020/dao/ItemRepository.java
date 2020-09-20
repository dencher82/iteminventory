package hw.ashkelon2020.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import hw.ashkelon2020.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{
	
}
