package com.antonb.kbase.controller;

import com.antonb.kbase.entity.Item;
import com.antonb.kbase.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("find")
    public List<Item> findItems(@RequestParam(name = "text", required = false) String text) {
        List<Item> items = itemRepository.findAllByTitleContainsIgnoreCase(text);
        return items;
    }

    @GetMapping("{id}")
    public Item getById(@PathVariable("id") Item item) {
        return item;
    }

    @PutMapping("{id}")
    public Item update(@PathVariable("id") Item dbItem, @RequestBody Item item) {
        dbItem.setTitle(item.getTitle());
        dbItem.setText(item.getText());
        itemRepository.save(dbItem);
        return dbItem;
    }

    @GetMapping("last")
    public List<Item> getLast10Items() {
        List<Item> items = itemRepository.findTop10OrderByIdDesc();
        return items;
    }

    @PostMapping("{id}")
    public Item add(@RequestBody Item item) {
        itemRepository.save(item);
        return item;
    }
}
