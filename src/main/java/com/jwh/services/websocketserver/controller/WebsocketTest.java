package com.jwh.services.websocketserver.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/websocket")
public class WebsocketTest {

    //推送数据接口
    @ResponseBody
    @RequestMapping("/socket/push/{cid}")
    public Map<String,Object> pushToWeb(@PathVariable String cid,@RequestParam("message") String message) {
        Map<String,Object> result = new HashMap<>();
        try {
            WebSocketServer.sendInfo(message, cid);
            result.put("code", "200");
            result.put("msg", "success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}