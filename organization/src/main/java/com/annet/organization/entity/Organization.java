package com.annet.organization.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Copyright © 2016 深圳安泰创新科技股份有限公司 版权所有 All Right Reserved
 *
 * @author: Saber
 * 包名：com.annet.user.entity
 * 时间：2019/10/23 12:09
 * 说明：
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "tbl_organization")
public class Organization extends BaseEntity implements Serializable {
    // 机构编码
    @Column(nullable = false, unique = true)
    private String orgCode;

    // 机构名称
    private String orgName;

    private String logoUrl;

    // CDS_IP
    private String cdsIP;

    // CDS_PORT
    private String cdsPort;
}
