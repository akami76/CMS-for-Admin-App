package com.app.cms.adminapp.domain.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@Entity
@Table(name = "TB_USER")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "empSeq", nullable = false, updatable = false)
    private int     empSeq;
    private String  empId;
    private String  empNm;
    private String  svcNo;
    private String  macAddr;
    private String  sessionKey;
    private String  empIp;
    private String  passwd;
    private int     failCnt;


    private Timestamp    lifeDateStart;
    private Timestamp    lifeDateEnd;

    @UpdateTimestamp
    private Timestamp lastLoginTime;
    private int     isCountLock;
    private String  lockEtc;

    @CreationTimestamp
    private Timestamp    regDate;
    private int  regEmpSeq;

}


/**
 * CREATE TABLE `akamidb`.`TB_USER` (
 `emp_seq` INT NOT NULL AUTO_INCREMENT COMMENT '고유키',
 `emp_id` VARCHAR(45) NULL COMMENT '사번',
 `emp_nm` VARCHAR(20) NULL COMMENT '이름',
 `svc_no` VARCHAR(45) NULL COMMENT '전화번호',
 `mac_addr` VARCHAR(100) NULL COMMENT '맥주소',
 `session_key` VARCHAR(100) NULL COMMENT '인증 세션키',
 `emp_ip` VARCHAR(45) NULL COMMENT '상용자 허용 IP',
 `passwd` VARCHAR(100) NULL COMMENT '비밀번호',
 `fail_cnt` INT NOT NULL DEFAULT 0 COMMENT '실패횟수',
 `life_date_start` DATETIME NULL COMMENT '계정활성화시작',
 `life_date_end` DATETIME NULL COMMENT '계정활성화종료',
 `last_login_time` DATETIME NOT NULL DEFAULT now() COMMENT '계정활성화종료',
 `is_count_lock` INT NOT NULL DEFAULT 1 COMMENT '계정잠금여부\n0:활성화\n1:잠금',
 `lock_etc` VARCHAR(100) NULL COMMENT '잠금 사유',
 `reg_date` DATETIME NULL DEFAULT now() COMMENT '생성일',
 `reg_emp_seq` VARCHAR(10) NULL COMMENT '생성자',
 PRIMARY KEY (`emp_seq`),
 UNIQUE INDEX `emp_id_UNIQUE` (`emp_id` ASC));
 */