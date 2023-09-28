package com.acciojob.fristApi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControllerLayer {

    @Autowired
    private ServiceLayer serviceobj;
    @PostMapping("/addAsbody")
    public ResponseEntity<String> addBody(@RequestBody UserInfo obj){
            ResponseEntity<String> message=serviceobj.adduser(obj);
            return message;
    }

    @GetMapping("/FindAllUsers")
    public List<UserInfo> getuser(){
        List<UserInfo> ans=serviceobj.getAllusers();

        return ans;
    }
    @GetMapping("/getage/{Greaterthan}/{Lessthan}")
    public List<UserInfo> getfilter(@PathVariable("Greaterthan")int more, @PathVariable("Lessthan")int less){
        List<UserInfo> list=serviceobj.getallbetween(more,less);

        return list;
    }

    @GetMapping("/Findname")
    public List<String> getallname(){
        List<String> NameList=serviceobj.getname();
        return NameList;
    }
}
