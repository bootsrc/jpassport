package com.appjishu.site.biz.service;

import com.appjishu.site.biz.dao.DemoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
	@Autowired
	private DemoDAO demoDAO;

	public int updateName(int id, String name) {
		int result = demoDAO.updateName(id, name);
		return result;
	}
	
	public Long firstId() {
		return demoDAO.firstId();
	}
}
