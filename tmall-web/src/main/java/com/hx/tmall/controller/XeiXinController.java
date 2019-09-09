package com.hx.tmall.controller;

import com.hx.tmall.util.CheckUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 微信验签控制器
 * @Create by jky1988@qq.com
 * @Version V1.0
 */
@RestController
public class XeiXinController {
    // 验签方法
    @GetMapping("/wx/init")
    public String init(String signature, String timestamp,String nonce, String echostr) {
        boolean checkSignature = CheckUtil.checkSignature(signature, timestamp, nonce);
        if (!checkSignature) {
            return null;
        }
        return echostr;
    }
}
