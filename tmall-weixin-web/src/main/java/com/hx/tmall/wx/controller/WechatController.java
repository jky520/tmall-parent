package com.hx.tmall.wx.controller;

import com.hx.tmall.wx.config.WxConfigProperties;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLEncoder;
/**
 * 页面授权
 * @Create by jky1988@qq.com
 * @Version V1.0
 */
@Controller
@RequestMapping("/wechat")
@Slf4j
public class WechatController {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WxConfigProperties wxConfigProperties;

    @GetMapping("/authorizeBase")
    public String authorizeBase(@RequestParam("returnUrl") String returnUrl){
        String url = wxConfigProperties.getWechatMpAuthorize()+"/wechat/getOpenId";
        System.out.println(WxConsts.OAuth2Scope.SNSAPI_BASE);
        String redirectURL = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_BASE, URLEncoder.encode(returnUrl));
        log.info("【微信网页授权】获取code,redirectURL={}", redirectURL);
        return "redirect:" + redirectURL;
    }

    @GetMapping("/authorizeUserInfo")
    public String authorizeUserInfo(@RequestParam("returnUrl") String returnUrl){
        String url = wxConfigProperties.getWechatMpAuthorize()+"/wechat/getCode";
        String redirectURL = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, URLEncoder.encode(returnUrl));
        log.info("【微信网页授权】获取code,redirectURL={}", redirectURL);
        return "redirect:" + redirectURL;
    }

    @RequestMapping("/getCode")
    public String getCode(@RequestParam("code") String code,
                          @RequestParam("state") String returnUrl) {
        return "redirect:" + returnUrl + "?code=" + code;
    }

    @GetMapping("/getOpenId")
    public String userInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl) throws Exception {
        log.info("【微信网页授权】code={}", code);
        log.info("【微信网页授权】state={}", returnUrl);
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken;
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (Exception e) {
            log.info("【微信网页授权】{}", e);
            throw new Exception(e.getMessage());
        }
        String openId = wxMpOAuth2AccessToken.getOpenId();
        log.info("【微信网页授权】openId={}", openId);
        return "redirect:" + returnUrl + "?openid=" + openId;
    }

    @GetMapping("/getUserInfo")
    @ResponseBody
    public WxMpUser getUserInfo(@RequestParam("openId") String openId) throws Exception {

        WxMpUser wxMpUser = wxMpService.getUserService().userInfo(openId);

        return wxMpUser;
    }
}
