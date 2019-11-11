package com.biosh.owner.web.service;

import com.biosh.owner.db.mapper.BizMessageMapper;
import com.biosh.owner.db.model.BizMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

  @Autowired
  private BizMessageMapper messageMapper;

  public void addMessage(BizMessage message) {

  }

  public void updateMessage(BizMessage message) {

  }
}
