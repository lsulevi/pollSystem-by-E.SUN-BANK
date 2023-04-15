package com.ivan.vote.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.ivan.vote.dao.PollItemDao;
import com.ivan.vote.dao.UserDao;
import com.ivan.vote.dao.UserPollDao;
import com.ivan.vote.dto.Poll;
import com.ivan.vote.dto.UserPollRequest;
import com.ivan.vote.model.PollDetail;
import com.ivan.vote.model.PollItem;
import com.ivan.vote.model.User;

@Component
public class UserPollServiceImpl implements UserPollService{

	private final static Logger log = LoggerFactory.getLogger(UserPollServiceImpl.class);

	@Autowired
	private UserPollDao userPollDao;

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PollItemDao pollItemDao;
	
	@Transactional
	@Override
	public void createPollDetail(Integer userId, UserPollRequest userPollRequest) {

		User user = userDao.getUserById(userId);
		
		if(user == null) {
			log.warn("該 userId {} 不存在",userId);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		List<PollDetail> pollDetailList = new ArrayList<>();
		
		for(Poll poll : userPollRequest.getPollDetailList()) {
			PollItem pollItem = pollItemDao.getPollItemById(poll.getPoll_item_id());
			
			//檢查 pollItem 是否存在 
			if(pollItem == null) {
				log.warn("投票項目 {} 不存在", poll.getPoll_item_id());
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
			
			//類記投票總數數量
			pollItemDao.updateCount(poll.getPoll_item_id(), pollItem.getPoll_item_count() + 1);
			
			PollDetail pollDetail = new PollDetail();
			pollDetail.setPoll_detail_itemId(poll.getPoll_item_id());
			pollDetail.setPoll_detail_userEmail(user.getUser_email());
			
			Date now = new Date();
			pollDetail.setPoll_detail_gftm(now);
			pollDetailList.add(pollDetail);
			
		}
		
		userPollDao.createPollDetail(pollDetailList);
		
	}
}
