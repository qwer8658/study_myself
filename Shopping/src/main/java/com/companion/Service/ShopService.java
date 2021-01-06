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

	int pagePerCnt = 4; // �������� �� �Խñ� ����

	// ��ǰ ���� �ҷ�����
	public List<HashMap> selectProduct(HashMap<String, Object> vo) {

		//startNum, endNum ���ϱ�
		HashMap<String, Object> rvo=StartEndNum(vo);

		return dao.selectProduct(rvo);
	}

	// �� ��ǰ ������ ��
	public int totalPageCnt(HashMap<String, Object> vo) {

		// �ѰԽñ� �� /�������� �Խñ� ��= �������� ��
		int totalBoardNum=dao.totalPageCnt(vo);
		int totalPage = (int)(totalBoardNum / pagePerCnt)+1;
		if(totalBoardNum % pagePerCnt == 0) {
			totalPage = totalPage-1;
		}
		
		return totalPage;
	}

	
	// ���� �Խñ� ��, ���� �Խñ� �� ���ϱ�
	public HashMap<String, Object> StartEndNum(HashMap<String, Object> vo) {
		// ��������ȣ -> ���� �Խñ� ��ȣ, ���� �Խñ� ��ȣ
		if (vo.get("pNum") == null || vo.get("pNum").equals("")) {
			vo.put("pNum", (Object)1);
		}

		vo.put("startNum", pagePerCnt * (Integer.parseInt(String.valueOf(vo.get("pNum"))) - 1) + 1);
		vo.put("endNum", pagePerCnt * Integer.parseInt(String.valueOf(vo.get("pNum"))));

		return vo;
	}

}
