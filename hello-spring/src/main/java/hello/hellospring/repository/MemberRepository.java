package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); //회원 아이디 찾기
    Optional<Member> findByName(String name);  //회원 이름 찾기
    List<Member> findAll(); //회원의 모든 정보 찾기


}
