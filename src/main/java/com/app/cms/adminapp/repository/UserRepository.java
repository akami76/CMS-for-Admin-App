package com.app.cms.adminapp.repository;

import com.app.cms.adminapp.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    //find..by
    //read..By
    //query..By
    //get..By
    //count..By
    public User findByEmpSeq(int empSeq);

    //public User findOne(int empSeq);

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

    //query를 사용할때 주의해야 한다. native query가 아닌 경우는 모두 Object를 가르키는 것이다. 해당 객체로 쿼리를 구현한다.
    @Query(value="SELECT emp_Nm,emp_Id,emp_Seq FROM tb_user b WHERE b.emp_Id LIKE CONCAT('%', :emp_Id%, '%')  AND b.emp_Seq > 0 ORDER BY b.emp_Seq DESC", nativeQuery = true)
    //@Query(value="SELECT emp_Nm,emp_Id,emp_Seq FROM TB_USER b WHERE EMP_NM LIKE %:empId% AND EMP_SEQ > 0 ORDER BY EMP_SEQ DESC", nativeQuery = true)
    //@Query("select b from User b where b.empId  LIKE %:empId% and b.empSeq > 0 ORDER BY b.empSeq desc ")
    //@Query("select b from #{#entityName} b where b.empId  LIKE %:empId% and b.empSeq > 0 ORDER BY b.empSeq desc ")
    public List<Object> findByEmpId(@Param("emp_Id") String emp_Id);

    @Query("select b from User b where b.empSeq > 0 order by b.empSeq desc" )
    public List<User> findBypage(Pageable pageable);
}