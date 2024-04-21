package jpabook.jpashop.repository;

import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    @PersistenceContext
    private final EntityManager em;

    //회원 저장
    public void save(Member member) {
        em.persist(member);
    }

    //회원 조회 by id
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    //전체 회원 조회
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class) //=> 반환타입: Member.class
                .getResultList();
    }

    //회원 조회 by name
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
