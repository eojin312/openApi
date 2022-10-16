package test.openapi.spring.repository.impl;

import test.openapi.spring.dto.Member;
import test.openapi.spring.repository.MemberRepository;

import java.util.HashMap;
import java.util.Map;

public class MemberRepositoryImpl implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {

    }

    @Override
    public Member findById(Long id) {
        return null;
    }
}
