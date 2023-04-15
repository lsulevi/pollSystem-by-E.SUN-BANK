package com.ivan.vote.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ivan.vote.dto.PollItemRequest;
import com.ivan.vote.model.PollItem;
import com.ivan.vote.service.PollService;

@Validated
@RestController
public class PollController {

	@Autowired
	private PollService pollService;
	
	//取得所有投票項目
	@GetMapping("/pollItems")
	public ResponseEntity<List<PollItem>> getPollItems(){
		
		List<PollItem> pollItemList = pollService.getPollItems();
		
		return ResponseEntity.status(HttpStatus.OK).body(pollItemList);

	}
	
	
	//取得投票項目
	@GetMapping("/pollItem/{pollItemId}")
	public ResponseEntity<PollItem> getPollItem(@PathVariable Integer pollItemId){

		PollItem pollItem = pollService.getPollItemById(pollItemId);
		
		if(pollItem != null) {
			return ResponseEntity.status(HttpStatus.OK).body(pollItem);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}

	//創建投票項目
	@PostMapping("/pollItem")
	public ResponseEntity<PollItem> createPollItem(@RequestBody @Valid PollItemRequest pollItemRequest){

		Integer pollItemId = pollService.createPollItem(pollItemRequest);
		
		PollItem pollItem = pollService.getPollItemById(pollItemId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(pollItem);
	}
	
	//更改投票項目狀態
	@PutMapping("/pollItem/{pollItemId}")
	public ResponseEntity<PollItem> updatePollItem(@PathVariable Integer pollItemId,
												@RequestBody @Valid PollItemRequest pollItemRequest){
		//檢核修改項目是否存在
		PollItem pollItem = pollService.getPollItemById(pollItemId);
		
		if(pollItem == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		//修改投票項目數據
		pollService.updatePollItem(pollItemId, pollItemRequest);
	
		PollItem updatePollItem = pollService.getPollItemById(pollItemId);

		return ResponseEntity.status(HttpStatus.OK).body(updatePollItem);

	}
	
}
