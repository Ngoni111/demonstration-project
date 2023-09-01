package com.ngonidzashemusiiwa.demo.project.demonstrationproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngonidzashemusiiwa.demo.project.demonstrationproject.item.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
