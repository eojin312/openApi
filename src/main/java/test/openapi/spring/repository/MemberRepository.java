package test.openapi.spring.repository;

import test.openapi.spring.dto.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long id);

}
