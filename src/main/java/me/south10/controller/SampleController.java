package me.south10.controller;

import lombok.extern.slf4j.Slf4j;
import me.south10.domain.SampleVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by south10 on 2016-06-14.
 */
@RestController
@RequestMapping("/sample")
@Slf4j
public class SampleController {
    @RequestMapping("/hello")
    public String sayHello(){
        return "hello world";
    }

    @RequestMapping("/sendVO")
    public SampleVO sendVO(){
        SampleVO vo = new SampleVO();
        vo.setFirstName("길동");
        vo.setLastName("홍");
        vo.setMno(123);
        return vo;
    }

    @RequestMapping("/sendList")
    public List<SampleVO> sendList(){
        List<SampleVO> list = new ArrayList<>();
        for(int i=0; i<10; i++) {
            SampleVO vo = new SampleVO();
            vo.setFirstName("길동");
            vo.setLastName("홍");
            vo.setMno(i);
            list.add(vo);
        }
        return list;
    }

    @RequestMapping("/sendMap")
    public Map<Integer, SampleVO> sendMap(){
        Map<Integer, SampleVO> map = new HashMap<>();
        for(int i=0; i<10; i++) {
            SampleVO vo = new SampleVO();
            vo.setFirstName("길동");
            vo.setLastName("홍");
            vo.setMno(i);
            map.put(i, vo);
        }
        return map;
    }

    @RequestMapping("/sendErrorAuth")
    public ResponseEntity<Void> sendListAuth(){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping("/sendErrorNot")
    public ResponseEntity<List<SampleVO>> sendListNot(){
        List<SampleVO> list = new ArrayList<>();
        for(int i=0; i<10; i++) {
            SampleVO vo = new SampleVO();
            vo.setFirstName("길동");
            vo.setLastName("홍");
            vo.setMno(i);
            list.add(vo);
        }
        return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
    }
}
