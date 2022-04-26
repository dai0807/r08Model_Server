package com.model2.mvc.service.purchase.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.purchase.PurchaseDao;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.user.UserDao;

@Service("purchaseServiceImpl")

public class PurchaseServiceImpl implements PurchaseService {

	
	
	///Field
	@Autowired
	@Qualifier("puchaseDaoImpl")
	private PurchaseDao purchaseDao;
	public void setUserDao(PurchaseDao purchaseDao) {
		this.purchaseDao = purchaseDao;
	}
	
	
	public PurchaseServiceImpl() {
		System.out.println(this.getClass());

	}

	@Override
	public void addPurchase(Purchase purchase) throws Exception {
		// TODO Auto-generated method stub
		purchaseDao.addPurchase(purchase)  ;
	}

	@Override
	public Purchase getPurchase(int tranNo) throws Exception {
		// TODO Auto-generated method stub
		return purchaseDao.getPurchase(tranNo) ;
	}

	@Override // ±¸¸Å¸®½ºÆ® °¡Á®¿Á ¤Ó³» ±¸¸Å ¸®½ºÆ® 
	public Map<String, Object> getPurchaseList(Search search ) throws Exception {
		System.out.println("get Purchas List¿¡ ¿È ");
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(search);
		
		map.put("search",search);
		System.out.println(search);
		//	map.put("userId",userId);
		int totalCount = purchaseDao.getTotalCount(search);
		System.out.println("¼­Ä¡¿È¿È ");

		
		System.out.println(totalCount);
		
		List<Purchase> list= purchaseDao.getPurchaseList(map);	
	
		
		map.put("list", list );		
		map.put("totalCount", new Integer(totalCount));
			
		return map;
 	}

	@Override
	public Map<String, Object> getSaleList(Search search) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("get getSaleList List¿¡ ¿È ");
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(search);
		
		map.put("search",search);
	//	map.put("userId",userId);
		int totalCount = purchaseDao.getTotalCount(search);
		System.out.println("¼­Ä¡¿È¿È ");

		
		System.out.println(totalCount);
		
		List<Purchase> list= purchaseDao.getSaleList(map);	
		
		map.put("list", list );		
		map.put("totalCount", new Integer(totalCount));
			
		return map;
	}

	@Override
	public void updatePurchase(Purchase purchase) throws Exception {
		System.out.println("update _ purchase" +purchase );
		purchaseDao.updatePurchase(purchase);
	}

	@Override
	public void updateTranCode(Purchase purchase) throws Exception {
		System.out.println("updateTranCode :: " +purchase );
		purchaseDao.updatetranCode(purchase) ;
	}
 
	
}
