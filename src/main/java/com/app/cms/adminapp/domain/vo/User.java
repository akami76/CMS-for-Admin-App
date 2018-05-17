package com.app.cms.adminapp.domain.vo;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
@Entity
//@Data
@Table(name = "TB_USER")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int     empSeq;
    private String  empId;
    private String  empNm;
    private String  svcNo;
    private String  macAddr;
    private String  sessionKey;
    private String  empIp;
    private String  passwd;
    private int     failCnt;
    private Date    lifeDateStart;
    private Date    lifeDateEnd;

    @CreatedDate
    private Date    lastLoginTime;
    private int     isCountLock;
    private String  lockEtc;

    @CreatedDate
    private Date    regDate;
    private String  regEmpSeq;

    public int getEmpSeq() {
        return empSeq;
    }

    public void setEmpSeq(int empSeq) {
        this.empSeq = empSeq;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpNm() {
        return empNm;
    }

    public void setEmpNm(String empNm) {
        this.empNm = empNm;
    }

    public String getSvcNo() {
        return svcNo;
    }

    public void setSvcNo(String svcNo) {
        this.svcNo = svcNo;
    }

    public String getMacAddr() {
        return macAddr;
    }

    public void setMacAddr(String macAddr) {
        this.macAddr = macAddr;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getEmpIp() {
        return empIp;
    }

    public void setEmpIp(String empIp) {
        this.empIp = empIp;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getFailCnt() {
        return failCnt;
    }

    public void setFailCnt(int failCnt) {
        this.failCnt = failCnt;
    }

    public Date getLifeDateStart() {
        return lifeDateStart;
    }

    public void setLifeDateStart(Date lifeDateStart) {
        this.lifeDateStart = lifeDateStart;
    }

    public Date getLifeDateEnd() {
        return lifeDateEnd;
    }

    public void setLifeDateEnd(Date lifeDateEnd) {
        this.lifeDateEnd = lifeDateEnd;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public int getIsCountLock() {
        return isCountLock;
    }

    public void setIsCountLock(int isCountLock) {
        this.isCountLock = isCountLock;
    }

    public String getLockEtc() {
        return lockEtc;
    }

    public void setLockEtc(String lockEtc) {
        this.lockEtc = lockEtc;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getRegEmpSeq() {
        return regEmpSeq;
    }

    public void setRegEmpSeq(String regEmpSeq) {
        this.regEmpSeq = regEmpSeq;
    }
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