package com.hj.huji.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hj.base.util.SqlGetSessionUtil;
import com.hj.base.util.WebUtil;
import com.hj.huji.po.HujiInfo;
import com.hj.huji.service.HujiService;
import com.hj.user.po.UserInfo;

public class HujiDao {
	public void addHuji(HujiInfo huji) {
		//插入
		SqlSession session = SqlGetSessionUtil.getSqlSession();
		try {
			String statement = "com.hj.huji.dao.HujiDao"+".addHuji";
			String hujiId = WebUtil.getUUID();
			huji.setHujiId(hujiId);
			int insert = session.insert(statement,huji);
			session.commit();
			//System.out.println(insert);
		}finally {
			session.close();
		}
	}
	public List<HujiInfo> getAllHujiInfo(){
		//查询所有记录
		/*
		 * 查询操作不需要写session.commit();
		 */
		SqlSession session = SqlGetSessionUtil.getSqlSession();
		String statement = "com.hj.huji.dao.HujiDao"+".getAllHuji";
		List<HujiInfo> list = session.selectList(statement);
		//System.out.println(list);
		session.close();
		return list;
	}
	
	public void updateHujiInfo(){
		//修改户籍信息
		SqlSession session = SqlGetSessionUtil.getSqlSession();
		String statement = "com.hj.huji.dao.HujiDao"+".updateHuji";
		int update = session.update(statement,new HujiInfo("1","43","54","64576","4543","0","768","0"));
		System.out.println(update);
		session.commit();
		session.close();
	}
	@Test
	public void deleteHujiInfo(String id){
		//删除户籍信息
		SqlSession session = SqlGetSessionUtil.getSqlSession();
		String statement = "com.hj.huji.dao.HujiDao"+".deleteHuji";
		int delete = session.delete(statement, id);
		//System.out.println(delete);
		session.commit();
		session.close();
	}
}
