package com.beyond.basic.b2_board.author.repository;

import com.beyond.basic.b2_board.author.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// SpringDataJpa를 사용하기 위해서는 JpaRepository를 상속
// Entity명과 pk 타입을 지정해줘야함.
// JpaRepository를 상속함으로서 JpaRepository의 주요기능 ( 각종 CRUD 기능이 사전 구현 ) 상속
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    // save, findAll, findById 등은 사전에 구현
    // pk 값은 자동으로 메서드로 생성해줌
    // 그외의 다른 컬럼으로 조회할 때는 findBy + 컬럼명 형식으로 선언만 하면 실행시점에 자동 구현.
    // 단건 조회일 경우 Optional 객체로 감싸주는 것이 좋다 => 서비스에서 에러 처리 가능
    // 다건 조회는 List로 감싸기
    Optional<Author> findByEmail(String email);
}
