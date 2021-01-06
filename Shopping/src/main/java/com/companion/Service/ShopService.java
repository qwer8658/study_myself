package com.companion.Service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companion.Dao.ShopDao;

@Service("shopservice")
public class ShopService {

	@Autowired
	private ShopDao dao;

	int pagePerCnt = 4; // 한페이지 당 게시글 갯수

	// 상품 정보 불러오기
	public List<HashMap> selectProduct(HashMap<String, Object> vo) {

		//startNum, endNum 구하기
		HashMap<String, Object> rvo=StartEndNum(vo);

		return dao.selectProduct(rvo);
	}

	// 총 상품 페이지 수
	public int totalPageCnt(HashMap<String, Object> vo) {

		// 총게시글 수 /페이지당 게시글 수= 총페이지 수
		int totalBoardNum=dao.totalPageCnt(vo);
		int totalPage = (int)(totalBoardNum / pagePerCnt)+1;
		if(totalBoardNum % pagePerCnt == 0) {
			totalPage = totalPage-1;
		}
		
		return totalPage;
	}

	
	// 시작 게시글 수, 종료 게시글 수 구하기
	public HashMap<String, Object> StartEndNum(HashMap<String, Object> vo) {
		// 페이지번호 -> 시작 게시글 번호, 종료 게시글 번호
		if (vo.get("pNum") == null || vo.get("pNum").equals("")) {
			vo.put("pNum", (Object)1);
		}

		vo.put("startNum", pagePerCnt * (Integer.parseInt(String.valueOf(vo.get("pNum"))) - 1) + 1);
		vo.put("endNum", pagePerCnt * Integer.parseInt(String.valueOf(vo.get("pNum"))));

		return vo;
	}

}
