package com.model2.mvc.service.purchase.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.purchase.PurchaseDao;


@Repository("puchaseDaoImpl")
public class PuchaseDaoImpl implements PurchaseDao {
	
	
	///Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	///Constructor
	public PuchaseDaoImpl() {
		System.out.println(this.getClass());
	}
	 
	public void addPurchase(Purchase purchase) throws Exception {
		sqlSession.insert("PurchaseMapper.addPurchase", purchase);

	}

 
	public Purchase getPurchase(int tranNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("PurchaseMapper.getPurchase" ,tranNo );
	}

	 // 판매 리스트  
	public List<Purchase> getSaleList(Map<String,Object> map )  throws Exception {
		// TODO Auto-generated method stub
		return  sqlSession.selectList("PurchaseMapper.getSaleList",map );
	}

	 
	//구매리스트 
	public List<Purchase> getPurchaseList(Map<String,Object> map ) throws Exception{

		return sqlSession.selectList("PurchaseMapper.getPurchaseList",map );

	}

 	public void updatePurchase(Purchase purchase) throws Exception {
		// TODO Auto-generated method stub
 		sqlSession.update("PurchaseMapper.updatePurchase",purchase) ;
	}

 	public void updatetranCode(Purchase purchase) throws Exception {
		// TODO Auto-generated method stub
 		System.out.println("DAO 옴 ");
 
 		sqlSession.update("PurchaseMapper.update_tran_code", purchase)  ;
 		System.out.println("dao 끝");
	}

 	public int getTotalCount(Search search) throws Exception {
		// TODO Auto-generated method stub
 		System.out.println("get total Count ");
 		String userId = search.getSearchKeyword() ;
 		System.out.println(userId);
		return sqlSession.selectOne("PurchaseMapper.getTotalCount" ,userId );
	}

 

}
