package com.companion.Controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.companion.Service.ShopService;

@Controller
public class ShopController {
	@Autowired
	private ShopService service;
	
	@RequestMapping(value="loadShopPage.shop", method= RequestMethod.GET)
	public String loadShopPage(HttpServletRequest request ,Model model) {
		
		//request HashMap으로 만들기
		HashMap<String, Object> vo = new HashMap<String, Object>();
		vo.put("pNum",request.getParameter("pNum"));//페이지
		vo.put("orderBy",request.getParameter("orderBy"));//정렬
		vo.put("maxPrice",request.getParameter("maxPrice"));//가격
		vo.put("minPrice",request.getParameter("minPrice"));//가격
		vo.put("category",request.getParameter("category"));//카테고리
		vo.put("soldout",request.getParameter("soldout"));//품절
		
		//총 상품 페이지 수
		model.addAttribute("totalPage",service.totalPageCnt(vo) );
		
		//상품 정보 불러오기
		model.addAttribute("products", service.selectProduct(vo));
		
		
		//조회 조건 그대로 다시 넘기기
		model.addAttribute("prevo",vo);
		
		return "shop";
	}
}
