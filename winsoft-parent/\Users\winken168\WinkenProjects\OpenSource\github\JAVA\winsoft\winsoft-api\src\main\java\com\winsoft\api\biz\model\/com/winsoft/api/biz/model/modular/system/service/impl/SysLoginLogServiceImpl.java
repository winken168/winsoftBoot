package com.winsoft.api.biz.model.modular.system.service.impl;

import com.winsoft.api.biz.model.SysLoginLog;
import com.winsoft.api.biz.dao.SysLoginLogMapper;
import com.winsoft.api.biz.model.modular.system.service.ISysLoginLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登录记录 服务实现类
 * </p>
 *
 * @author winken@peng
 * @since 2018-01-02
 */
@Service
public class SysLoginLogServiceImpl extends ServiceImpl<SysLoginLogMapper, SysLoginLog> implements ISysLoginLogService {
	
}
