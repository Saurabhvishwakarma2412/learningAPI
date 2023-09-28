package com.acciojob.fristApi;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class RepositryLayer {
    Map<Integer,UserInfo> userinfodb=new HashMap<>();

    public ResponseEntity<String> addusertodb(UserInfo userInfo){
     int key=userInfo.getUserID();
     userinfodb.put(key,userInfo);
      String response= "user added to the database";
      return new ResponseEntity<>(response, HttpStatus.OK);
    }
    public List<UserInfo> getAllusers(){
        return userinfodb.values().stream().toList();
    }

}
