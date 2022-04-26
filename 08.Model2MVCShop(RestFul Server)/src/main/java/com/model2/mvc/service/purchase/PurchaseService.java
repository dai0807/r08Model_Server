package com.model2.mvc.service.purchase;

import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Purchase;

public interface PurchaseService {
	
	//제품 추가
	public void addPurchase(Purchase purchase)  throws Exception;
	
	// 제품 찾기
	public  Purchase getPurchase (int tranNo) throws Exception;
	
	//구매 리스트 가져오기 
	public Map<String, Object>  getPurchaseList(Search search  )  throws Exception;
	
	//판매리스트 가져오기
	public  Map<String, Object>  getSaleList(Search  search )  throws Exception; 
	
	//판매 내역 업데이트
	public void updatePurchase(Purchase purchase)  throws Exception; 
	
	//트랜코드 변경 
	public void updateTranCode(Purchase purchase) throws Exception; 
	
}
