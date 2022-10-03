package com.antonb.kbase.controller;

import com.antonb.kbase.ItemDto;
import com.antonb.kbase.entity.Item;
import com.antonb.kbase.entity.ItemTag;
import com.antonb.kbase.entity.Tag;
import com.antonb.kbase.repository.ItemRepository;
import com.antonb.kbase.repository.ItemTagRepository;
import com.antonb.kbase.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private ItemTagRepository itemTagRepository;

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
        dbItem.setLastupdate(Timestamp.from(ZonedDateTime.now().toInstant()));
        itemRepository.save(dbItem);
        return dbItem;
    }

    @GetMapping("last")
    public List<Item> getLast10Items() {
        List<Item> items = itemRepository.findTop10ByTitleContainsOrderByLastupdateDesc("");
        return items;
    }

    @PostMapping("new")
    public Item add(@RequestBody ItemDto itemDto) {
        Item item = new Item();
        item.setTitle(itemDto.getTitle());
        item.setText(itemDto.getText());
        item.setLastupdate(Timestamp.from(ZonedDateTime.now().toInstant()));
        itemRepository.save(item);

        for(String tagString : itemDto.getTags()) {
            String tagUpper = tagString.toUpperCase();
            Tag tag = null;
            List<Tag> tags = tagRepository.findAllByTag(tagUpper);
            if (tags.size()==0) {
                tag = new Tag();
                tag.setTag(tagUpper);
                tagRepository.save(tag);
            } else {
                tag = tags.get(0);
            }
            ItemTag itemTag = new ItemTag();
            itemTag.setItem(item);
            itemTag.setTag(tag);
            itemTagRepository.save(itemTag);
        }

        return item;
    }
}
