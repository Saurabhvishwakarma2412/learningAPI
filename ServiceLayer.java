package com.acciojob.fristApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceLayer {

    @Autowired
    private RepositryLayer repoobj;
    public ResponseEntity<String> adduser(UserInfo userInfo){
       ResponseEntity<String> message=repoobj.addusertodb(userInfo);
       return message;
    }

    public List<UserInfo> getAllusers(){
        List<UserInfo> ans=repoobj.getAllusers();
        return ans;
    }
    public List<UserInfo> getallbetween(int lowlimit,int uplimit){
        List<UserInfo> tempList=repoobj.getAllusers();
        List<UserInfo> ansList=new ArrayList<>();
        for(UserInfo obj: tempList){
            if(obj.getAge()>lowlimit && obj.getAge()<uplimit){
                ansList.add(obj);
            }
        }
        return ansList;
    }
    public  List<String> getname(){
        List<UserInfo> tempList=repoobj.getAllusers();
        List<String> ansList=new ArrayList<>();
        for(UserInfo obj: tempList){
            ansList.add(obj.getName());
        }
        return ansList;
    }
}
