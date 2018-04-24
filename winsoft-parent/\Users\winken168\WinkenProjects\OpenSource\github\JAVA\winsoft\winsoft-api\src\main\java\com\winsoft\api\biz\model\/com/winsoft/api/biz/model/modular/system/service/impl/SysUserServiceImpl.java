package com.winsoft.api.biz.model.modular.system.service.impl;

import com.winsoft.api.biz.model.SysUser;
import com.winsoft.api.biz.dao.SysUserMapper;
import com.winsoft.api.biz.model.modular.system.service.ISysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author winken@peng
 * @since 2018-01-02
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
	
}
