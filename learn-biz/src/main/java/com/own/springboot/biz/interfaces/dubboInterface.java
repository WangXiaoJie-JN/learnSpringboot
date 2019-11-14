package com.own.springboot.biz.interfaces;

import com.own.springboot.biz.systemUser.domain.SystemUser;
import com.own.springboot.common.BaseResponse;

public interface dubboInterface {

    public BaseResponse getLearnUserMsg(String userName);

    public BaseResponse pushRestUserMsgServer(SystemUser user);
}
