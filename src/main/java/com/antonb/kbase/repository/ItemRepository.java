package com.antonb.kbase.repository;

import com.antonb.kbase.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item,Long> {
    List<Item> findAllByTitleContainsIgnoreCase(String text);

    List<Item> findTop10ByTitleContainsOrderByLastupdateDesc(String text);
}
