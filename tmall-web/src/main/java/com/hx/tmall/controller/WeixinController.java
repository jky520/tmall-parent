package com.hx.tmall.controller;

import com.jfinal.weixin.sdk.msg.in.InTextMsg;
import com.jfinal.weixin.sdk.msg.in.event.InFollowEvent;
import com.jfinal.weixin.sdk.msg.in.event.InMenuEvent;
import com.jfinal.weixin.sdk.msg.out.OutTextMsg;
import net.dreamlu.weixin.annotation.WxMsgController;
import net.dreamlu.weixin.properties.DreamWeixinProperties;
import net.dreamlu.weixin.spring.DreamMsgControllerAdapter;
import org.springframework.beans.factory.annotation.Autowired;

@WxMsgController("/weixin/wx")
public class WeixinController extends DreamMsgControllerAdapter {

    @Autowired
    private DreamWeixinProperties weixinProperties;

    @Override
    protected void processInFollowEvent(InFollowEvent inFollowEvent) {
        OutTextMsg outMsg = new OutTextMsg(inFollowEvent);
        outMsg.setContent("关注消息~");
        render(outMsg);
    }

    @Override
    protected void processInTextMsg(InTextMsg inTextMsg) {

    }

    @Override
    protected void processInMenuEvent(InMenuEvent inMenuEvent) {

    }
}
