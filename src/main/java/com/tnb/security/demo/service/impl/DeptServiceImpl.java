package com.tnb.security.demo.service.impl;

import com.tnb.security.demo.entity.pojo.Dept;
import com.tnb.security.demo.mapper.DeptMapper;
import com.tnb.security.demo.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 部门信息 服务实现类
 * </p>
 *
 * @author swen
 * @since 2020-04-07
 */
@Service
@Transactional
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

}
