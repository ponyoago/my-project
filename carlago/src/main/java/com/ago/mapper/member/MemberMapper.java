/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.ago.mapper.member;

import com.ago.model.member.Member;
import com.ago.util.CustomerMapper;
import org.springframework.stereotype.Service;

/**
 * author ago
 * date 2016/10/21 0021 下午 15:32
 */
@Service
public interface MemberMapper extends CustomerMapper<Member> {
    Member selectByUsername(String username);
}
