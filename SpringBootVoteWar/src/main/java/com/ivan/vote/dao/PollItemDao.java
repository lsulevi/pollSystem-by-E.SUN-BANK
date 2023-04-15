package com.ivan.vote.dao;

import java.util.List;

import com.ivan.vote.dto.PollItemRequest;
import com.ivan.vote.model.PollItem;

public interface PollItemDao {

	//取得所有投票項目，並限定狀態為N的
	List<PollItem> getPollItems();

	//取得單一投票項目
	PollItem getPollItemById(Integer pollItemId);

	//創建新的投票項目
	Integer createPollItem(PollItemRequest pollItemRequest);

	//更新投票項目
	void updatePollItem(Integer pollItemId, PollItemRequest pollItemRequest);

	//更新投票總數量
	void updateCount(Integer pollItemId,Integer pollItemCount);
}
