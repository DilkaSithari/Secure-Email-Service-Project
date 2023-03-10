package com.fda.secureemailservice.controller;
import com.fda.secureemailservice.model.Msg;
import com.fda.secureemailservice.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/msg")

public class MsgController {
    @Autowired
    MsgService msgService;

    @GetMapping("/all")
    public ResponseEntity<Object> findAll(Msg msg){
        ResponseEntity<Object> findAll = msgService.findAll(msg);
        return findAll;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") int id){
        ResponseEntity<Object> findById = msgService.findById(id);
        return findById;
    }
    @PutMapping("/update/{id}")
    public  ResponseEntity<Object> updateMsg(@PathVariable("id") int id, @RequestBody Msg msg){
        ResponseEntity<Object> updateMsg = msgService.updateMsg(id,msg);
        return updateMsg;
    }
    @PostMapping("/add")
    public  ResponseEntity<Object> addMsg(@RequestBody Msg msg){
        ResponseEntity<Object> addMsg = msgService.addMsg(msg);
        return addMsg;
    }
    @DeleteMapping("delete/{id}")
    public  ResponseEntity<Object> deleteMsg(@PathVariable int id){
        ResponseEntity<Object> deleteMsg = msgService.deleteMsg(id);
        return deleteMsg;
    }

}
