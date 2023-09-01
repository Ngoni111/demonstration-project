package com.ngonidzashemusiiwa.demo.project.demonstrationproject.item;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ngonidzashemusiiwa.demo.project.demonstrationproject.repositories.ItemRepository;

import jakarta.validation.Valid;

@RestController
public class ItemJpaResource {
	
	private ItemRepository itemRepository;
	
	public ItemJpaResource(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@GetMapping("/api/items")
	public List<Item> returnAllItems(){
		return itemRepository.findAll();
	}

	@GetMapping("/api/items/{id}")
	public EntityModel<Item> returnSingleItem(@PathVariable int id){
		
		Optional<Item> item = itemRepository.findById(id);
		
		if(item.isEmpty()) {
			throw new ItemNotFoundException("id: " + id);
		}
		
		EntityModel<Item> entityModel = EntityModel.of(item.get());
		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).returnAllItems());
		
		entityModel.add(link.withRel("all-items"));
		
		return entityModel;
	}
	
	@DeleteMapping("/api/items/{id}")
	public void deleteItem(@PathVariable int id) {
		itemRepository.deleteById(id);
	}
	
	@PostMapping("/api/items")
	public ResponseEntity<Item> createItem(@Valid @RequestBody Item item){
		
		Item savedItem = itemRepository.save(item);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedItem.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/api/items/{id}")
	public ResponseEntity<Item> updateItem(@PathVariable int id, @Valid @RequestBody Item item){
		
		Item savedItem = itemRepository.save(item);
		
		System.out.println(savedItem.getCountry());
		System.out.println(savedItem.getMake());
		System.out.println(savedItem.getId());
		System.out.println(savedItem.getConsumption());
		System.out.println(savedItem.getModel());
		
		savedItem.setId(id);
		return ResponseEntity.ok(savedItem);
	}
}