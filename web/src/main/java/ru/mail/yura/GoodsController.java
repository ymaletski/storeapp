package ru.mail.yura;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.mail.yura.dao.impl.GoodsDaoImpl;
import ru.mail.yura.model.Goods;

@RequestMapping("/goods")
public class GoodsController {
	
	private GoodsDaoImpl goodsDaoImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String listOfGoods(Model uiModel) {
		List<Goods> goods = goodsDaoImpl.findAll();
		uiModel.addAttribute("manyGoods", goods);
		return "goods/list";
	}
	
	@Autowired
	public void setGoodsDaoImpl (GoodsDaoImpl goodsDaoImpl) {
		this.goodsDaoImpl = goodsDaoImpl;
	}
	
}
