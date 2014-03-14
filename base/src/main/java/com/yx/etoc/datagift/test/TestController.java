package com.yx.etoc.datagift.test;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/etoc")
public class TestController {
	protected static Logger log = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		return null;
	}
	@RequestMapping("/connect")
	@ResponseBody
	public List<Tvo> test(){
		List<Tvo> rs = new ArrayList<Tvo>();
		Tvo t = new Tvo();
		t.setImei("123");
		t.setNickname("jj");
		rs.add(t);
		return rs;
	}
}
