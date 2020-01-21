package com.emalron.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emalron.web.board.dao.BoardDAO;
import com.emalron.web.board.model.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
	"classpath:spring/root-context.xml",
	"classpath:spring/dataSource-context.xml"
	})
public class BoardDAOTest {
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Inject
	private BoardDAO boardDAO;
	
	@Test @Ignore
	public void 게시글을_insert한다() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setCate_cd("유머");
		boardVO.setTitle("테스트 입니다");
		boardVO.setContent("내용 입니다.");
		boardVO.setReg_id("테스터");
		int result = boardDAO.insertBoard(boardVO);
		logger.info("\n Insert result \n");
		if(result == 1) {
			logger.info("게시물 등록 성공\n");
		} else {
			logger.info("게시물 등록 실패\n");
		}
	}
	
	@Test @Ignore
	public void 게시글을_10개_insert한다() throws Exception {
		logger.info("\n Insert result \n");
		for(int i=20; i<30; i++) {
			BoardVO boardVO = new BoardVO();
			boardVO.setCate_cd("유머");
			boardVO.setTitle("테스트 입니다 " + i);
			boardVO.setContent("내용 입니다. " + i);
			boardVO.setReg_id("테스터");
			int result = boardDAO.insertBoard(boardVO);
			if(result == 1) {
				logger.info("게시물 등록 성공");
			} else {
				logger.info("게시물 등록 실패");
			}
		}
	}
	
	@Test @Ignore
	public void boardDAO객체가_생성된다() {
		logger.info("\n boardDAO: " + boardDAO);
	}
	
	
	
	@Test @Ignore
	public void getBoardList가_리턴된다() throws Exception {
		List<BoardVO> list = boardDAO.getBoardList();
		logger.info("\n Board List \n");
		if(list.size() > 0) {
			for(BoardVO b : list) {
				logger.info(b.getTitle());
			}
		} else {
			logger.info("데이터가 없습니다.");
		}
	}
	
	@Test @Ignore
	public void getBoard가_리턴된다() throws Exception {
		BoardVO boardVO = boardDAO.getBoardContent(10);
		if(boardVO != null) {
			logger.info("title: " + boardVO.getTitle());
			logger.info("content: " + boardVO.getContent());
			logger.info("author: " + boardVO.getReg_id());
		} else {
			logger.info("데이터가 없습니다.");
		}
	}
	
	@Test @Ignore
	public void board를_update한다() throws Exception {
		BoardVO boardVO = boardDAO.getBoardContent(1);
		boardVO.setTitle("this is updated title.");
		int result = boardDAO.updateBoard(boardVO);
		if(result == 1) {
			boardVO = boardDAO.getBoardContent(1);
			logger.info("title: " + boardVO.getTitle());
			logger.info("content: " + boardVO.getContent());
			logger.info("author: " + boardVO.getReg_id());
		} else {
			logger.info("데이터가 없습니다.");
		}
	}
	
	@Test @Ignore
	public void board를_delete한다() throws Exception {
		int index = 4;
		int result = boardDAO.deleteBoard(index);
		if(result == 1) {
			BoardVO boardVO = boardDAO.getBoardContent(index);
			if(boardVO == null) {
				logger.info("board #"+index+"가 삭제됐습니다.");
			} else {
				logger.info("title: " + boardVO.getTitle());
				logger.info("content: " + boardVO.getContent());
				logger.info("author: " + boardVO.getReg_id());
			}
		} else {
			logger.info("데이터가 없습니다.");
		}
	}
	
	@Test
	public void board의_viewCnt를_10번_update한다() throws Exception {
		int index = 5;
		for(int i=0; i<10; i++) {
			int result = boardDAO.updateViewCnt(index);
			if(result == 1) {
				BoardVO boardVO = boardDAO.getBoardContent(index);
				if(boardVO == null) {
					logger.info("board #"+index+"가 없습니다.");
				} else {
					logger.info("title: " + boardVO.getTitle());
					logger.info("content: " + boardVO.getContent());
					logger.info("author: " + boardVO.getReg_id());
					logger.info("view count: " + boardVO.getView_cnt());
				}
			} else {
				logger.info("데이터가 없습니다.");
			}
		}
	}
}
