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
	public void �Խñ���_insert�Ѵ�() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setCate_cd("����");
		boardVO.setTitle("�׽�Ʈ �Դϴ�");
		boardVO.setContent("���� �Դϴ�.");
		boardVO.setReg_id("�׽���");
		int result = boardDAO.insertBoard(boardVO);
		logger.info("\n Insert result \n");
		if(result == 1) {
			logger.info("�Խù� ��� ����\n");
		} else {
			logger.info("�Խù� ��� ����\n");
		}
	}
	
	@Test @Ignore
	public void �Խñ���_10��_insert�Ѵ�() throws Exception {
		logger.info("\n Insert result \n");
		for(int i=20; i<30; i++) {
			BoardVO boardVO = new BoardVO();
			boardVO.setCate_cd("����");
			boardVO.setTitle("�׽�Ʈ �Դϴ� " + i);
			boardVO.setContent("���� �Դϴ�. " + i);
			boardVO.setReg_id("�׽���");
			int result = boardDAO.insertBoard(boardVO);
			if(result == 1) {
				logger.info("�Խù� ��� ����");
			} else {
				logger.info("�Խù� ��� ����");
			}
		}
	}
	
	@Test @Ignore
	public void boardDAO��ü��_�����ȴ�() {
		logger.info("\n boardDAO: " + boardDAO);
	}
	
	
	
	@Test @Ignore
	public void getBoardList��_���ϵȴ�() throws Exception {
		List<BoardVO> list = boardDAO.getBoardList();
		logger.info("\n Board List \n");
		if(list.size() > 0) {
			for(BoardVO b : list) {
				logger.info(b.getTitle());
			}
		} else {
			logger.info("�����Ͱ� �����ϴ�.");
		}
	}
	
	@Test @Ignore
	public void getBoard��_���ϵȴ�() throws Exception {
		BoardVO boardVO = boardDAO.getBoardContent(10);
		if(boardVO != null) {
			logger.info("title: " + boardVO.getTitle());
			logger.info("content: " + boardVO.getContent());
			logger.info("author: " + boardVO.getReg_id());
		} else {
			logger.info("�����Ͱ� �����ϴ�.");
		}
	}
	
	@Test @Ignore
	public void board��_update�Ѵ�() throws Exception {
		BoardVO boardVO = boardDAO.getBoardContent(1);
		boardVO.setTitle("this is updated title.");
		int result = boardDAO.updateBoard(boardVO);
		if(result == 1) {
			boardVO = boardDAO.getBoardContent(1);
			logger.info("title: " + boardVO.getTitle());
			logger.info("content: " + boardVO.getContent());
			logger.info("author: " + boardVO.getReg_id());
		} else {
			logger.info("�����Ͱ� �����ϴ�.");
		}
	}
	
	@Test @Ignore
	public void board��_delete�Ѵ�() throws Exception {
		int index = 4;
		int result = boardDAO.deleteBoard(index);
		if(result == 1) {
			BoardVO boardVO = boardDAO.getBoardContent(index);
			if(boardVO == null) {
				logger.info("board #"+index+"�� �����ƽ��ϴ�.");
			} else {
				logger.info("title: " + boardVO.getTitle());
				logger.info("content: " + boardVO.getContent());
				logger.info("author: " + boardVO.getReg_id());
			}
		} else {
			logger.info("�����Ͱ� �����ϴ�.");
		}
	}
	
	@Test
	public void board��_viewCnt��_10��_update�Ѵ�() throws Exception {
		int index = 5;
		for(int i=0; i<10; i++) {
			int result = boardDAO.updateViewCnt(index);
			if(result == 1) {
				BoardVO boardVO = boardDAO.getBoardContent(index);
				if(boardVO == null) {
					logger.info("board #"+index+"�� �����ϴ�.");
				} else {
					logger.info("title: " + boardVO.getTitle());
					logger.info("content: " + boardVO.getContent());
					logger.info("author: " + boardVO.getReg_id());
					logger.info("view count: " + boardVO.getView_cnt());
				}
			} else {
				logger.info("�����Ͱ� �����ϴ�.");
			}
		}
	}
}
