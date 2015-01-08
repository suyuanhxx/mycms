package com.mycms.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;

import com.google.common.collect.Maps;


@Controller
public class BaseController {
	Map<String,Object> session = Maps.newHashMap();
}
