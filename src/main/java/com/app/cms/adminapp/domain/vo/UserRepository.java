package com.app.cms.adminapp.domain.vo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    //find..by
    //read..By
    //query..By
    //get..By
    //count..By

    public List<User> findUserByEmpId(String empId);

    public List<User> findByEmpIdLike(String empId);

    public User findUserByEmpNm(String empNm);

    //@Query("Select emp_seq, emp_id, emp_ip, emp_nm  from tb_user where emp_nm like %:emp_nm%")
    public List<User>  findByEmpNmContaining(String empNm);

    //paging EmpSeq desc ordered
    public List<User> findByEmpSeqGreaterThanOrderByEmpSeqDesc(int empSeq, Pageable paging);


    //paging EmpSeq not ordered
    //public List<User> findByEmpSeqGreaterThan2(int empSeq, Pageable paging);

    //return Page
    public Page<User> findByEmpSeqGreaterThan(int empSeq, Pageable paging);

    //query use
   // @Query("SELECT b FROM TB_USER b WHERE EMP_NM LIKE %?1% AND EMP_SEQ > 0 ORDER BY EMP_SEQ DESC")
    //public List<Object[]> findByEmpNm(String empNm);

    //@Query("SELECT EMP_NM FROM TB_USER EMP_NM LIKE %:empNm% AND EMP_SEQ > 0 ORDER BY EMP_SEQ DESC")
   // public List<User> findByEmpName(@Param("empNm") String empNm);

    //query use
    @Query(value="SELECT emp_Nm,emp_Id,emp_Seq FROM TB_USER b WHERE EMP_NM LIKE %?1% AND EMP_SEQ > 0 ORDER BY EMP_SEQ DESC", nativeQuery = true)
    public List<Object[]> findByEmpNmNativeQuery(String empNm);
}