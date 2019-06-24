package com.own.springboot.biz.systemUser.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;

@Service
@Transactional(rollbackFor = {SQLException.class},propagation = Propagation.REQUIRED,readOnly = false)
public class SystemUserService{

}