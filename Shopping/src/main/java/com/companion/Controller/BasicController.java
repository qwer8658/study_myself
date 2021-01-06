package com.companion.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BasicController {
	
	@RequestMapping(value="movingPoint.do", method= RequestMethod.GET )
	public String moving(String movingPoint) {
		return movingPoint;
	}

}
