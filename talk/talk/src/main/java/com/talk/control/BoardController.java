package com.talk.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.talk.Dto.BoardDetailDto;
import com.talk.Dto.BoardDto;
import com.talk.Dto.BoardListDto;
import com.talk.Dto.CommentDto;
import com.talk.Dto.CommentViewDto;
import com.talk.service.BoardService;
import com.talk.service.CommentService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final CommentService commentService;
	
	@Autowired
	private BoardService boardService;

    BoardController(CommentService commentService) {
        this.commentService = commentService;
    }
	
	// 목록
	@GetMapping("/index")
	public String boardIndex(@RequestParam("page") int pageNum,	Model model) {
		
		//  한페이지에 보여줄 게시글 가져오기
		List<BoardListDto> boardListDtos = boardService.boardList(pageNum);
		
		model.addAttribute("boardListDtos" , boardListDtos);
		
		//  페이징 위해 필요한 전체 게시글 갯수 가져오기
		int totalCount = boardService.boardCount();
		int totalPage = totalCount % 10==0 ? totalCount/10 : totalCount/10+1;
		int start = pageNum>5 ? pageNum-5 : 1;
		int end = start+9 > totalPage ? totalPage : start+9;
		
		model.addAttribute("page",pageNum);
		model.addAttribute("start",start);
		model.addAttribute("end", end);
		
		return "board/boardList";
	}
	//글 페이지
	@GetMapping("/write")
	public String  boardWrite(HttpSession session,	Model model) {
		model.addAttribute("boardDto",new BoardDto());
		return "board/boardWrite";
	}
	
	
	//저장
	@PostMapping("/writeSave")
	public String  boardWrite(BoardDto boardDto,
			@RequestParam("imgFile") MultipartFile multipartFile  ,HttpSession session,
			Model model) {
		String memberId = (String)session.getAttribute("user");
		boardService.boardSave(boardDto ,memberId, multipartFile );
		
		return "redirect:/board/index?page=1";
	}
	
	
	//삭제
	@GetMapping("/delete")
	public String  boardDelete(@RequestParam("id") int id ,	HttpSession session) {
		return null;
	}
	//수정
	@GetMapping("/update")
	public String  boardUpdate(BoardDto boardDto,HttpSession session) {
		return null;
	}
	
	//수정 페이지
	@GetMapping("/updatePage")
	public String  boardUpdate(@RequestParam("id")	int id ,Model model) {
		
		BoardDetailDto boardDto = boardService.boardDetail(id);
		
		model.addAttribute("boardDto", boardDto);
		return "board/boardWrite";
	}
	
	//상세
	@GetMapping("/detail")
	public String  boardDetail(@RequestParam("id")	int id,	HttpSession session , 
	Model model) {
		
		BoardDetailDto boardDetailDto = boardService.boardDetail(id);
		
		model.addAttribute("boardDetailDto", boardDetailDto);
		CommentDto commentDto = new CommentDto();
		commentDto.setBoardId(id);
		model.addAttribute("commentDto", commentDto);
		
		return "board/boardDetail";
	}
	
	
	//댓글 저장
	@GetMapping("/commentSave")
	public String  commentSave(CommentDto commentDto ,HttpSession session) {
		
		// 현재 로그인한 회원 아이디 필요 - 세션에서 가져오기 - 로그인하면 user라는 
		//  이름으로 저장 했다.
		String memberId = (String)session.getAttribute("user");
		
		commentService.commentSave(commentDto , memberId);
		
		return "redirect:/board/detail?id="+ commentDto.getBoardId();
	}
	
	
	//댓글 삭제
	@GetMapping("/commentDelete")
	public String  commentDel(@RequestParam("id") int id , HttpSession session) {
		return null;
	}
}
