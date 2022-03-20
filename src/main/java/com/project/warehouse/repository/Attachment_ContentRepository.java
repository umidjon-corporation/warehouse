package com.project.warehouse.repository;

import com.project.warehouse.entity.Attachment_Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Attachment_ContentRepository extends JpaRepository<Attachment_Content,Long> {
    List<Attachment_Content> findAllByActiveTrue();

}
