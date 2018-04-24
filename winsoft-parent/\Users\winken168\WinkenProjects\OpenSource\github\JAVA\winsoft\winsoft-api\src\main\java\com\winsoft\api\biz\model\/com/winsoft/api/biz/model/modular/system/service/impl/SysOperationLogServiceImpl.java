package com.winsoft.api.biz.model.modular.system.service.impl;

import com.winsoft.api.biz.model.SysOperationLog;
import com.winsoft.api.biz.dao.SysOperationLogMapper;
import com.winsoft.api.biz.model.modular.system.service.ISysOperationLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志 服务实现类
 * </p>
 *
 * @author winken@peng
 * @since 2018-01-02
 */
@Service
public class SysOperationLogServiceImpl extends ServiceImpl<SysOperationLogMapper, SysOperationLog> implements ISysOperationLogService {
	
}
