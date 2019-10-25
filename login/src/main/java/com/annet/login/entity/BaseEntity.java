package com.annet.login.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
// 这里注意，启用审计的实体中都必须注册这个 Listener，否则是没有效果的
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private LocalDateTime modifyDate;

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private LocalDateTime createTime;
}