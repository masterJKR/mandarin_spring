package com.talk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talk.Dto.CommentDto;
import com.talk.Entity.CommentEntity;
import com.talk.Repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	// 댓글 저장
	public void commentSave(CommentDto commentDto, String memberId) {
		
		CommentEntity  commentEntity = CommentEntity.from(commentDto);
		commentEntity.setMemberId(memberId);
		
		commentRepository.insert(commentEntity);
		
	}
	//댓글 삭제
	public void commentDelete(int id) {
		
	}
}
