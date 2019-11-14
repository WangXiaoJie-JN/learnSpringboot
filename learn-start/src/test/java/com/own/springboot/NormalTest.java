package com.own.springboot;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.own.springboot.biz.systemUser.domain.SystemUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;

@RunWith(SpringRunner.class)
@Slf4j
public class NormalTest {


    /**
     * hutool-all 复制对象
     */
    @Test
    public  void beanCopyTest(){

        SystemUser user1 = new SystemUser();
        user1.setUserName("user1");
        user1.setUserPwd("password");
        user1.setCreateDate(Calendar.getInstance().getTime());

        SystemUser user2 = new SystemUser();
        user2.setUserName("user2");
        user2.setRemarks("hutool copy");

        BeanUtil.copyProperties(user1,user2,CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true).setIgnoreProperties(new String[]{"userName"}));

        System.out.println(user1.toString());
        //        SystemUser(id=0, userName=user1, userPwd=password, userPlainPwd=null, userPhone=null, userWxOpenid=null, userEmail=null, userSex=null, pinyin=null, delFlag=null, createBy=null, createDate=Fri Nov 08 11:37:42 CST 2019, updateBy=null, updateDate=null, remarks=null, bak1=0, bak2=null, price=0.0)
        System.out.println(user2.toString());
        //        SystemUser(id=0, userName=user1, userPwd=password, userPlainPwd=null, userPhone=null, userWxOpenid=null, userEmail=null, userSex=null, pinyin=null, delFlag=null, createBy=null, createDate=Fri Nov 08 11:37:42 CST 2019, updateBy=null, updateDate=null, remarks=hutool copy, bak1=0, bak2=null, price=0.0)

    }
}
