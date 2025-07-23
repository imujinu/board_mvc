package com.beyond.basic.b2_board.post.repository;

import com.beyond.basic.b2_board.author.domain.Author;
import com.beyond.basic.b2_board.post.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    // select * from post where author_id = ? and title =?
//    List<Post> findByAuthorIdAndTitle(Long id, String title);

    // select * from post where author_id = ? and title = ? order by createdTime desc;
    //    List<Post> findByAuthorIdAndTitleOrderByCreatedTimeDesc(Long id, String title);

    //변수명은 Author지만 AuthorId로도 조회 가능
    List<Post> findByAuthorId(Long id);


    List<Post> findByAuthor(Author author);

//        select * from post p inner join author a on a.id=p.author_id;
    // jpql을 사용한 일반 join
    // jpa는 기본적으로 lazy로딩 지향하므로, inner join filtering 하되 post 객체만 조회  -> 여전히 N+1문제 발생
    @Query("select p from Post p inner join p.author")
    List<Post> findAllJoin();

    // jpql을 사용한 fetch inner join
    // join 시 post 뿐만 아니라 author 객체까지 한번에 조립하여 조회 -> N+1 문제 해결
    @Query("select p from Post p inner join fetch p.author")
    List<Post> findAllFetchJoin();

    //paging처리 + delyn 적용
    //    domain.pageable import
    //page 객체 안에 list<Post> 포함, 전체페이지 수 등의 정보 포함.
    // Pageble 객체 안에는 페이지 size, 페이지번호, 정결기준 등이 포함되어 있다.
    Page<Post> findAllByDelYnAndAppointment(Pageable pageable, String DelYn, String appointment);


    List<Post> findByAppointment(String appointment);
}
