package com.acciojob.fristApi;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class APIclass {

    HashMap<Integer,UserInfo> userInfoDB=new HashMap<>();
    @PostMapping("/addAsbody")
    public String addBody(@RequestBody UserInfo obj){
        int key=obj.getUserID();
        userInfoDB.put(key,obj);
        return "user added as JSON body";
    }
    @GetMapping("/getuserinfopath/{UserID}")
    public UserInfo getuserpath(@PathVariable("UserID")Integer userID){
        UserInfo obj=userInfoDB.get(userID);
        return obj;
    }
    @GetMapping("/getage/{Greaterthan}/{Lessthan}")
    public List<UserInfo> getfilter(@PathVariable("Greaterthan")int more,@PathVariable("Lessthan")int less){
        List<UserInfo> list=new ArrayList<>();
        for(UserInfo obj:userInfoDB.values()){
            if(obj.getAge()>more && obj.getAge()<less){
                list.add(obj);
            }
        }
        return list;
    }
    @PostMapping("/addUser")
    public String addusertoDB(@RequestParam("userID")Integer userID,
                              @RequestParam("name")String name,
                              @RequestParam("age")Integer age,
                              @RequestParam("emailID")String emailID
                              ){
        UserInfo obj=new UserInfo(name,age,emailID,userID);
        userInfoDB.put(userID,obj);
        return "user is added in db";
    }
    @GetMapping("/FindAllUsers")
    public List<UserInfo> getuser(){
        List<UserInfo> ans=new ArrayList<>();
        for(UserInfo obj:userInfoDB.values()){
            ans.add(obj);
        }
        return ans;
    }
    @GetMapping("/Findname")
    public List<String> getallname(){
        List<String> NameList=new ArrayList<>();
        for(UserInfo obj:userInfoDB.values()){
            NameList.add(obj.getName());
        }
        return NameList;
    }


   @GetMapping("/getuserinfo")
    public UserInfo getUserInfo(@RequestParam("userID")Integer userID){
        return userInfoDB.get(userID);
    }
    @GetMapping("/SayHello")
    public String sayHello(){
        return "Hello Spring";
    }
    @GetMapping("/Springis")
    public String sayeasy(){
        return "Spring is easy";
    }
}
