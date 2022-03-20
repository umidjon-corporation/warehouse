package com.project.warehouse.service;

import com.project.warehouse.dto.ApiResponse;
import com.project.warehouse.dto.AttachmentDto;
import com.project.warehouse.dto.MeasurementDto;
import com.project.warehouse.entity.Attachment;
import com.project.warehouse.entity.Measurement;
import com.project.warehouse.repository.AttachmentRepository;
import com.project.warehouse.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AttachmentService {
    @Autowired
    AttachmentRepository attachmentRepository;

    public ApiResponse add(Attachment attachment) {
        Attachment save = attachmentRepository.save(attachment);
        return new ApiResponse("Saved", true, save);
    }
    public ApiResponse edit(Long id, AttachmentDto attachmentDto) {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        Attachment attachment = optionalAttachment.get();
        attachment.setName(attachmentDto.getName());
        attachment.setContent_type(attachmentDto.getContent_type());
        attachment.setSize(attachmentDto.getSize());
        attachmentRepository.save(attachment);
        return new ApiResponse("Updated!", true);
    }
}
