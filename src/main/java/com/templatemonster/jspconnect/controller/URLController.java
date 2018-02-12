package com.templatemonster.jspconnect.controller;

import com.templatemonster.jspconnect.Algoritm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * user: alekseyb
 * date: 2/9/18
 */
@Controller
public class URLController {

//    @GetMapping
//    public String connect(@RequestParam(value = "nick") String nick,
//                          @RequestParam(value="email") String email,
//                          @RequestParam(value = "orderId") String orderId,
//                          @RequestParam String productType,
//                          @RequestParam String room,
//                          @RequestParam String templateId,
//                          @RequestParam String offerText,
//                          @RequestParam String project,
//                          @RequestParam String question){
//
//
//
//    }
    @RequestMapping("/connect")
    public String connect(@RequestParam MultiValueMap<String, String> allRequestParams, Model model){
        List<String> server = allRequestParams.remove("server");
//        allRequestParams.
        TreeMap<String, String> map = new TreeMap<>(allRequestParams.toSingleValueMap());
        String sum = Algoritm.md5Sum(map, "lak_asdg345");
        allRequestParams.add("key",sum);
        UriComponents build = UriComponentsBuilder.fromHttpUrl(server.get(0)).queryParams(allRequestParams).build();
        System.out.println("build="+build.toUriString());
        System.out.println("build="+build.toString());
        System.out.println("build="+build.toUri().toString());
        return build.toUriString();
    }
}
