package com.example.springbootdb_connect.repository;

import com.example.springbootdb_connect.entity.Members;
import org.springframework.data.repository.CrudRepository;

/*
* CrudRepository, PagingAndSortingRepository, JpaRepository가 존재.
* JpaRepository -> PagingAndSortingRepository -> CrudRepository을 상속받고 있다.
* - CrudRepository : CRUD 관련 기능들을 제공
* - JpaRepository : JPA 관련 특화 기능들 (ex. flushing, 배치성 작업) 등
* 단순한 CRUD만을 한다면 CrudRepository를 그 외 페이징. 솔팅등을 한다면 JpaRepository
 */
public interface TestRepository extends CrudRepository<Members, Integer> {

    Members findByUsername(String username);
}
