package com.acciojob.fristApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class APIclass {

    HashMap<Integer,UserInfo> userInfoDB=new HashMap<>();

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
