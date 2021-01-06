package com.companion.Dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("shopdao")
public class ShopDao {

	@Autowired
	private SqlSessionTemplate mybatis;

	//��ǰ ���� �ҷ�����
	public List<HashMap> selectProduct(HashMap<String, Object> vo) {
		
		return mybatis.selectList("com.mapper.shoppingmapper.selectProduct", vo);
	}
	
	//�� ��ǰ ������ ��
	public int totalPageCnt(HashMap<String, Object> vo) {
		return mybatis.selectOne("com.mapper.shoppingmapper.totalPageCnt",vo);
	}
}
