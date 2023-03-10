package com.fda.secureemailservice.repository;
import com.fda.secureemailservice.model.Msg;
import org.springframework.http.ResponseEntity;

public interface MsgRepo {
    ResponseEntity<Object> findAll(Msg msg);

    ResponseEntity<Object> findById(int id);
    ResponseEntity<Object> updateMsg(int id, Msg msg);

    ResponseEntity<Object> addMsg(Msg msg);
    ResponseEntity<Object> deleteMsg(int id);
}
