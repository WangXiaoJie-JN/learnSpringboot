package com.own.springboot.Controller.home;

import com.own.springboot.common.BaseResponse;
import com.own.springboot.common.StatusCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseResponseController {

    /**
     * 测baseResponse
     * @param param
     * @return
     */
    @RequestMapping(value = "/baseResponse",method= RequestMethod.GET)
    public BaseResponse<String> helloWord(@RequestParam String param){

        StatusCode sc = StatusCode.SUCCESS;
        BaseResponse<String> response = new BaseResponse<String>(sc);
        response.setData(param);
        return response;
    }
}
