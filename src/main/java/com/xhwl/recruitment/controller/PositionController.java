package com.xhwl.recruitment.controller;

import com.xhwl.recruitment.exception.MException;
import com.xhwl.recruitment.service.DeliverService;
import com.xhwl.recruitment.service.PositionService;
import com.xhwl.recruitment.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: guiyu
 * @Description:
 * @Date: Create in 下午1:05 2018/4/23
 **/
@RestController
public class PositionController {
    @Autowired
    UserService userService;

    @Autowired
    PositionService positionService;

    @Autowired
    DeliverService deliverService;

    @GetMapping("/positions/{typeId}")
    public List<HashMap> getUnderwayPositionsByType(@RequestHeader HttpHeaders headers, @PathVariable("typeId") Integer typeId) {
        List<HashMap> res = positionService.getUnderwayPositions(typeId);
        return res;
    }

    @GetMapping("/position/{positionId}")
    public HashMap getPositionById(@RequestHeader HttpHeaders headers, @PathVariable("positionId") Long positionId) {
        HashMap res = positionService.getPosition(positionId);
        return res;
    }

    /**
     * 用户投递岗位
     * @param headers
     * @param positionId
     * @return
     */
    @PutMapping("/deliver/{positionId}")
    public Long deliver(@RequestHeader HttpHeaders headers, @PathVariable("positionId") Long positionId) {

        Long userId = userService.getUserIdByToken(headers.getFirst("authorization"));
        if(!deliverService.checkResumeType(userId,positionId)) throw new MException("简历类型不符");

        //判断重复投递
        if (deliverService.isFirst(userId, positionId)) {
            Long id = deliverService.deliver(positionId, userId);
            return id;
        }
        else{
            throw new MException("重复投递");
        }
    }
}
