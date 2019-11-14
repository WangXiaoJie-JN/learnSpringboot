package com.own.springboot;

import com.own.springboot.biz.systemUser.domain.SystemUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnStartApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void mathRandom(){
        double num = 12*Math.random();
        int random1 = (int)Math.floor(num);
        int random2 = (int)(num);
        System.out.println("random1="+random1+";random2="+random2);
    }

    //32位
    private String bytes2Hex(byte[] data){
        StringBuffer buffer = new StringBuffer();
        int v = 0xa;
        for (int i = 0; i < data.length; i++) {
            //                           10101010
            //00000000 00000000 00000000 11111111
            //00000000 00000000 00000000 10101010
            int value = data[i] & 255;//0xff
            //value =10 a;
            //10
            //16进制的表现形式 0a
            //Thjava.lang.Integer.toHexString() 方法
            // 返回为无符号整数基数为16的整数参数的字符串表示形式。以下字符作为十六进制数字：0123456789ABCDEF。
            System.out.println("value="+value);
            String temp = "";
            if (value<16){
                temp = "0"+Integer.toHexString(value);
            }else {
                temp = Integer.toHexString(value);
            }
            buffer.append(temp);
        }
        System.out.println("hexString="+buffer.toString());
        System.out.println("hexStringLen="+buffer.toString().length());
        return buffer.toString();
    }

    /**
     * md5加密
     */
    public void md5MessageDigest(String text) {
        try {
            //获取对应算法的加密实体
            MessageDigest md = MessageDigest.getInstance("MD5");
            //设置要加密的文本
            md.update(text.getBytes());
            //生成摘要
            //16位
            byte[] digest = md.digest();
            String result = bytes2Hex(digest);
            System.out.println("result="+result);
            //10010101
            //00000000 11111111
            //00000000 10010101
            //255
            // byte & byte[2] 00000000 11111111
            //00000000 10010101
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    //helloMD5=3ed9e5f6855dbcdbcd95ac6c4fe0c0a5
    @Test
    public void testMD5(){
        md5MessageDigest("helloMD5");
    }

    @Test
    public void testCopy(){

        //结论：copyProperties会null会覆盖
        SystemUser user1 = new SystemUser();
        user1.setUserName("wj");
        SystemUser user2 = new SystemUser();
        user2.setUserPwd("123");
        user2.setCreateDate(new Date());
        System.out.println("user2="+user2.toString());
        //BeanUtils.copyProperties(user1,user2);
        BeanUtils.copyProperties(user1,user2,"userPwd","createDate");
        System.out.println("user2="+user2.toString());
    }
}
