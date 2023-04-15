package com.ivan.vote.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.ivan.vote.dao.PollItemDao;
import com.ivan.vote.dao.UserDao;
import com.ivan.vote.dto.PollItemRequest;
import com.ivan.vote.model.PollItem;
import com.ivan.vote.model.User;

@Component
public class PollServiceImpl implements PollService{

	private final static Logger log = LoggerFactory.getLogger(PollServiceImpl.class);

	@Autowired
	private PollItemDao pollItemDao;
	
	@Autowired
	private UserDao userDao;

	@Override
	public List<PollItem> getPollItems() {
		
		return pollItemDao.getPollItems();
	}
	
	@Override
	public PollItem getPollItemById(Integer pollItemId) {
		
		return pollItemDao.getPollItemById(pollItemId);
	}
	
	@Override
	public Integer createPollItem(PollItemRequest pollItemRequest) {
		
		//設置新建投票項目狀態為正常
		pollItemRequest.setPoll_item_state("N");
		
		//檢核建立該投票項目使用者是否為會員
		User user = userDao.getUserByEmail(pollItemRequest.getPoll_item_email());

		if(user == null) {
			log.warn("該email {} 尚未註冊", pollItemRequest.getPoll_item_email());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		return pollItemDao.createPollItem(pollItemRequest);
	}
	
	@Override
	public void updatePollItem(Integer pollItemId, PollItemRequest pollItemRequest) {
		pollItemDao.updatePollItem(pollItemId, pollItemRequest);
	}
	
}
