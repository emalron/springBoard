package com.emalron.web.board.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emalron.web.board.model.BoardVO;
import com.emalron.web.service.BoardService;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String index(Model model) throws Exception {
		return "redirect:/board/getBoardList";
	}
	
	@RequestMapping(value="/getBoardList", method=RequestMethod.GET)
	public String getBoardList(Model model) throws Exception {
		model.addAttribute("boardList", boardService.getBoardList());
		return "board/index";
	}
	
	@RequestMapping(value="/boardForm")
	public String boardForm(Model model) {
		model.addAttribute("mode", "new");
		model.addAttribute("boardVO", new BoardVO());		
		return "board/boardForm";
	}
	
	@RequestMapping(value="/saveBoard", method=RequestMethod.POST)
	public String saveBoard(@ModelAttribute("boardVO") BoardVO boardVO) throws Exception {
		boardService.insertBoard(boardVO);
		return "redirect:/board/getBoardList";
	}
	
	@RequestMapping(value="/{number}", method=RequestMethod.GET)
	public String getBoardContent(@PathVariable("number") int bid, Model model) throws Exception {
		BoardVO boardVO = boardService.getBoardContent(bid);
		model.addAttribute("board", boardVO);
		return "board/boardContent";
	}
	
	@RequestMapping(value="/boardForm/{number}", method=RequestMethod.GET)
	public String editBoard(@PathVariable("number") int bid, Model model) throws Exception {
		BoardVO boardVO = boardService.getBoardContent(bid);
		model.addAttribute("board", boardVO);
		model.addAttribute("mode", "edit");
		model.addAttribute("boardVO", new BoardVO());
		return "board/boardForm";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateBoard(@ModelAttribute("BoardVO") BoardVO boardVO) throws Exception {
		boardService.updateBoard(boardVO);
		return "redirect:/board/getBoardList";
	}
}
