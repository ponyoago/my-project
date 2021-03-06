/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.ago.mapper.console;

import com.ago.model.console.Menu;
import com.ago.util.CustomerMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface MenuMapper extends CustomerMapper<Menu> {
    Set<String> findMenuCodeByUserId(String userId);
    Set<String> getALLMenuCode();
    List<Menu> selectMenuByAdminId(String userId);
    List<Menu> selectAllMenu();
    List<Menu> selectMenuByRoleId(String roleId);
}