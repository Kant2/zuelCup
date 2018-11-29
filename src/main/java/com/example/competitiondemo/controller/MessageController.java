package com.example.competitiondemo.controller;

import com.example.competitiondemo.pojo.Message;
import com.example.competitiondemo.util.result.Result;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageController {

    /**
     * 获取通知
     *
     * @param id 通知id
     * @return 结果对象
     */
    @GetMapping("/message/{id}")
    public Result getMessage(@PathVariable("id") String id) {
        return null;
    }

    /**
     * 获取通知
     *
     * @param senderId 发送者Id
     * @param receiverId 接收者Id
     * @return 结果对象
     */
    @GetMapping("/messages")
    public Result getMessages(
            @PathParam(value = "senderId") String senderId,
            @PathParam(value = "receiverId") String receiverId) {
        return null;
    }

    /**
     * 保存通知
     *
     * @param message 通知内容
     * @return 结果对象
     */
    @PostMapping("/message")
    public Result saveMessage(@RequestBody Message message) {
        return null;
    }


    /**
     * 删除通知
     *
     * @param id 通知Id
     * @return 结果对象
     */
    @DeleteMapping("/message/{id}")
    public String deleteMessage(@PathVariable("id") String id) {
        return null;
    }

//    /**
//     * 删除通知
//     *
//     * @param messageIdList 通知Id数组
//     * @return 结果信息
//     */
//    @DeleteMapping("/messages")
//    public String deleteMessagess() {
//        return null;
//    }

    /**
     * 删除通知
     *
     * @param senderId 通知Id数组
     * @return 结果信息
     */
    @DeleteMapping("/messages")
    public String deleteMessages(
            @PathParam("senderId") String senderId,
            @PathParam("receiverId") String receiverId,
            @RequestBody List<String> messageIdList) {
        return null;
    }

}
