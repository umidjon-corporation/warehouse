package com.project.warehouse.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "attachment")
public class Attachment {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id")
    @ToString.Exclude
    private Attachment_Content Id;

    @Column(name = "active")
    private Boolean active=true;
    @Column(name = "size",nullable = false)
    private Long size;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "content_type", nullable = false)
    private String content_type;

}
