/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.ago.service.console;

import com.ago.mapper.console.RoleMenuMapper;
import com.ago.model.console.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * author ago
 * date 2016/12/6 0006 上午 10:45
 */
@Service
public class RoleMenuService {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    public void insert(RoleMenu roleMenu){
        roleMenuMapper.insert(roleMenu);
    }

    public void deleteMenuId(String id){
        Example example = new Example(RoleMenu.class);
        example.createCriteria().andCondition("menu_id =", id);
        roleMenuMapper.deleteByExample(example);
    }

    public void deleteRoleId(String id){
        Example example = new Example(RoleMenu.class);
        example.createCriteria().andCondition("role_id =", id);
        roleMenuMapper.deleteByExample(example);
    }

    public RoleMenu selectOne(RoleMenu roleMenu){
        return roleMenuMapper.selectOne(roleMenu);
    }

    public List<RoleMenu> getRoleList(RoleMenu roleMenu){
        return roleMenuMapper.select(roleMenu);
    }


}
