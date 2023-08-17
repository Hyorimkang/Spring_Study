package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //key값 생성


    @Override
    public Member save(Member member) {
        member.setId(++sequence); //id setting
        store.put(member.getId(), member);  //store에 id 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //Optional을 쓰면 null이어도 감쌀 수 있음
    }

    @Override
    public Optional<Member> findByName(String name) {
        //map을 돌면서 값이 찾아지면 findAny()로 인해 값이 반환됨
        //다 돌렸는데도 없으면 Optional에 null이 포함되어 반환됨
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); //값 찾기
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());  //store 값은 member
    }

    public void clearStore(){
        store.clear();  //store 비우기
    }
}
