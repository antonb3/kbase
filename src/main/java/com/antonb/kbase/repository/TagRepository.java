package com.antonb.kbase.repository;

import com.antonb.kbase.entity.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends CrudRepository<Tag,Long> {
    List<Tag> findAllByTag(String tag);
}
