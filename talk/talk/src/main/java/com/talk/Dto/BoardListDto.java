package com.talk.Dto;

import java.time.LocalDate;

import com.talk.Entity.BoardEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardListDto {
	private int id;
	private String title;
	private String memberId;
	private int hit;
	private LocalDate writeDate;
	
	public static BoardListDto from(BoardEntity boardEntity) {
		BoardListDto boardListDto = new BoardListDto();
		
		boardListDto.setHit(boardEntity.getHit());
		boardListDto.setId(boardEntity.getId());
		boardListDto.setTitle(boardEntity.getTitle());
		boardListDto.setMemberId(boardEntity.getMemberId());
		boardListDto.setWriteDate(boardEntity.getWriterDate());
		
		return boardListDto;
	}
}
