/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.ago.service.console;

import com.ago.mapper.console.AdminRoleMapper;
import com.ago.model.console.AdminRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * author ago
 * date 2016/12/6 0006 上午 10:45
 */
@Service
public class AdminRoleService {

    @Autowired
    private AdminRoleMapper adminRoleMapper;

    public void insert(AdminRole adminRole){
        adminRoleMapper.insert(adminRole);
    }

    public void deleteAdminId(String id){
        Example example = new Example(AdminRole.class);
        example.createCriteria().andCondition("admin_id =", id);
        adminRoleMapper.deleteByExample(example);
    }

    public void deleteRoleId(String id){
        Example example = new Example(AdminRole.class);
        example.createCriteria().andCondition("role_id =", id);
        adminRoleMapper.deleteByExample(example);
    }

    public AdminRole selectOne(AdminRole adminRole){
        return adminRoleMapper.selectOne(adminRole);
    }

    public List<AdminRole> getRoleList(AdminRole adminRole){
        return adminRoleMapper.select(adminRole);
    }


}
