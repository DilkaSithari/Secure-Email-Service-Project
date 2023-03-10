package com.fda.secureemailservice.service.impl;
import com.fda.secureemailservice.model.Msg;
import com.fda.secureemailservice.repository.MsgRepo;
import com.fda.secureemailservice.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MsgServiceImpl implements MsgService {
    @Autowired
    private MsgRepo msgRepo;
    @Override
    public ResponseEntity<Object> findAll(Msg msg) {
        return msgRepo.findAll(msg);
    }

    @Override
    public ResponseEntity<Object> findById(int id) {
        return msgRepo.findById(id);
    }

    @Override
    public ResponseEntity<Object> updateMsg(int id, Msg msg) {
        return msgRepo.updateMsg(id,msg);
    }

    @Override
    public ResponseEntity<Object> addMsg(Msg msg) {
        return msgRepo.addMsg(msg);
    }

    @Override
    public ResponseEntity<Object> deleteMsg(int id) {
        return msgRepo.deleteMsg(id);
    }
}
