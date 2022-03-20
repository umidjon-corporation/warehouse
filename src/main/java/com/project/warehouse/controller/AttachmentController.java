package com.project.warehouse.controller;

import com.project.warehouse.dto.ApiResponse;
import com.project.warehouse.dto.AttachmentDto;
import com.project.warehouse.dto.MeasurementDto;
import com.project.warehouse.entity.Attachment;
import com.project.warehouse.entity.Measurement;
import com.project.warehouse.repository.AttachmentRepository;
import com.project.warehouse.repository.MeasurementRepository;
import com.project.warehouse.service.AttachmentService;
import com.project.warehouse.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/attachment")
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;
    @Autowired
    AttachmentRepository attachmentRepository;
    @GetMapping
    public String getAttachmentPage(Model model) {
        List<Attachment> all = attachmentRepository.findAllByActiveTrue();
        model.addAttribute("list", all);
        return "attachment/attachment";
    }


    @GetMapping("/add")
    public String getSaveAttachment() {

        return "attachment/attachment-add";
    }

    @PostMapping("/add")
    public String saveAttachment(Model model, @ModelAttribute Attachment attachment) {
        attachmentService.add(attachment);
        return "redirect:/attachment";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        Optional<Attachment> byId = attachmentRepository.findById(id);
        if (byId.isEmpty()) return "404";
        Attachment attachment = byId.get();
        attachment.setActive(false);
        attachmentRepository.save(attachment);
        return "redirect:/attachment";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable Long id, Model model) {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (!optionalAttachment.isPresent()) return "Xatolik!";
        model.addAttribute("edited", optionalAttachment.get());
        return "attachment/attachment-edit";
    }

    @PostMapping("/edit/{id}")
    public String editAttachment(@PathVariable Long id, @ModelAttribute AttachmentDto attachmentDto) {
        ApiResponse response = attachmentService.edit(id, attachmentDto);
        System.out.println(response);
        return "redirect:/attachment";
    }
}
