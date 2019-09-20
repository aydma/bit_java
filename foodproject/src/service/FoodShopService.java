package service;

import vo.FoodshopVO;

public interface FoodShopService {
	int insertFoodshop(FoodshopVO vo);
	int discountsearch(FoodshopVO vo);
	public int locsearch(FoodshopVO vo);
}
