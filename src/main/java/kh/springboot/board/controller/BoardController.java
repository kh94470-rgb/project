package kh.springboot.board.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kh.springboot.board.model.exception.BoardException;
import kh.springboot.board.model.service.BoardService;
import kh.springboot.board.model.vo.Board;
import kh.springboot.board.model.vo.PageInfo;
import kh.springboot.board.model.vo.Reply;
import kh.springboot.member.model.vo.Member;
import lombok.RequiredArgsConstructor;
import templates.views.common.Pagination;

@Controller
@RequiredArgsConstructor
@RequestMapping({"/board"})
public class BoardController {
    private final BoardService bService;

    @GetMapping("list")
    public ModelAndView selectList(
            @RequestParam(value = "page", defaultValue = "1") int currentPage,
            ModelAndView mv, HttpServletRequest request) {

        int listCount = bService.getListCount(1);
        PageInfo pi = Pagination.getPageInfo(currentPage, listCount, 5);
        ArrayList<Board> list = bService.selectBoardList(pi, 1);
        

        mv.addObject("list", list);
        mv.addObject("pi", pi);
        mv.setViewName("/list");
        mv.addObject("loc", request.getRequestURI());	
        return mv;
    }
    
    @GetMapping("write")
    public String writeBoard() {
    	return "/write";
    }
    
    @PostMapping("insert")
    public String insertBoard(@ModelAttribute Board b, HttpSession session) {
    	String boardWriter = ((Member)session.getAttribute("loginUser")).getId();
    	b.setBoardWriter(boardWriter);
    	b.setBoardType(1);
    	
    	int result = bService.insertBoard(b);
    	if(result > 0) {
    		return "redirect:/board/list";
    	}else {
    		throw new BoardException("게시글 작성을 실패했습니다");
    	}
    }
    
    // board/?/?
    @GetMapping("/{id}/{page}")
    public String selectBoard(@PathVariable("id") int bId, @PathVariable("page") int page,
    							HttpSession session, Model model) {
    	Member loginUser = (Member)session.getAttribute("loginUser");
    	String id = null;
    	if(loginUser != null) {
    		id = loginUser.getId();
    	}
    	
    	Board b = bService.selectBoard(bId, id);
    	ArrayList<Reply> list = bService.selectReplyList(bId);
    	if(b != null) { 
    		model.addAttribute("b", b).addAttribute("page", page).addAttribute("list", list);
    		return "/detail"; // write.html 복사 후 붙여넣기 하여 이름 변경 : detail.html
    	} else {
    		throw new BoardException("게시글 상세보기를 실패하였습니다.");
    	}
    }
    
    @PostMapping("upForm")
    public String updateform(@RequestParam("boardId") int bId, @RequestParam("page") int page, Model model) {
    	Board b = bService.selectBoard(bId, null);
    	model.addAttribute("b", b).addAttribute("page", page);
    	return "views/board/edit";
    }
    
    @PostMapping("update")
    public String updateBoard(@ModelAttribute Board b, @RequestParam("page") int page) {
    	b.setBoardType(1);
    	int result = bService.updateBoard(b);
    	if(result > 0) {
//    		return "redirect:/board/" + b.getBoardId() + "/" + page; 
    		return String.format("redirect:/board/%d/%d", b.getBoardId(), page); // prinf랑 비슷하게 함
    	} else {
    		throw new BoardException("게시글 수정을 실패했습니다.");
    	}
    }
    
    @PostMapping("delete")
    public String deleteBoard(@RequestParam("boardId") int bId, HttpServletRequest request) {
    	int result = bService.deleteBoard(bId);
    	if(result > 0 ) {
    		return "redirect:/" + (request.getHeader("referer").contains("board") ? "board" : "attm") +"/list";
    	} else {
    		throw new BoardException("게시글 삭제를 실패하였습니다.");
    	}
    }
    
   
    
        
    
    
    
    
    
    
    
    
}