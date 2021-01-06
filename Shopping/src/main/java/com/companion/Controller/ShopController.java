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
		
		//request HashMap���� �����
		HashMap<String, Object> vo = new HashMap<String, Object>();
		vo.put("pNum",request.getParameter("pNum"));//������
		vo.put("orderBy",request.getParameter("orderBy"));//����
		vo.put("maxPrice",request.getParameter("maxPrice"));//����
		vo.put("minPrice",request.getParameter("minPrice"));//����
		vo.put("category",request.getParameter("category"));//ī�װ�
		vo.put("soldout",request.getParameter("soldout"));//ǰ��
		
		//�� ��ǰ ������ ��
		model.addAttribute("totalPage",service.totalPageCnt(vo) );
		
		//��ǰ ���� �ҷ�����
		model.addAttribute("products", service.selectProduct(vo));
		
		
		//��ȸ ���� �״�� �ٽ� �ѱ��
		model.addAttribute("prevo",vo);
		
		return "shop";
	}
}
