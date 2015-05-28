package org.xiwc.tool.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xiwc.tool.model.RespBody;

import com.emc.tool.i18n.chain.I18nFactory;

@Controller
@RequestMapping("json2bean")
public class Json2BeanController {

	static Logger logger = LoggerFactory.getLogger(Json2BeanController.class);

	@Autowired
	Environment env;

	@RequestMapping(value = "convert", method = RequestMethod.POST)
	@ResponseBody
	RespBody convert(@RequestParam(value = "input", required = true) String input,
			@RequestParam(value = "ns", required = true, defaultValue = "ui") String ns) {

		return RespBody.succeed(I18nFactory.getInstance().produce(input, ns));
	}
}
