package com.ivan.vote.service;

import java.util.List;

import com.ivan.vote.dto.PollItemRequest;
import com.ivan.vote.model.PollItem;

public interface PollService {
	
	//取得所有有效的投票項目
	List<PollItem> getPollItems();

	//依pollItemId取得對應的投票項目
	PollItem getPollItemById(Integer pollItemId);
	
	//創建投票項目
	Integer createPollItem(PollItemRequest pollItemRequest);

	//修改投票項目狀態或細項
	void updatePollItem(Integer pollItemId, PollItemRequest pollItemRequest);

}
