package com.fda.secureemailservice.service;
import com.fda.secureemailservice.model.Msg;
import org.springframework.http.ResponseEntity;



public interface MsgService {

    ResponseEntity<Object> findAll(Msg msg);

    ResponseEntity<Object> findById(int id);
    ResponseEntity<Object> updateMsg(int id, Msg msg);

    ResponseEntity<Object> addMsg(Msg msg);
    ResponseEntity<Object> deleteMsg(int id);
}
