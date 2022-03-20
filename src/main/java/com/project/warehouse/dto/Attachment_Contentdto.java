package com.project.warehouse.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Attachment_Contentdto implements Serializable {
    private final Boolean active;
    private  final Byte byTe;
    private  final  Long attachmentId;
}
