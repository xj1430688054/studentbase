package com.xj.base.controller.admin.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xj.base.common.JsonResult;
import com.xj.base.controller.BaseController;
import com.xj.base.entity.Classes;
import com.xj.base.entity.Student;
import com.xj.base.entity.Dormitory;
import com.xj.base.service.IClassesService;
import com.xj.base.service.IStudentService;
import com.xj.base.service.specification.SimpleSpecificationBuilder;
import com.xj.base.service.specification.SpecificationOperator.Operator;

@Controller
@RequestMapping("/admin/classes")
public class ClassesController extends BaseController{
	@Autowired
	private IStudentService employeeService;
	@Autowired
	private IClassesService classesService;

	@RequestMapping(value = { "/", "/index" })
	public String index() {
		return "admin/classes/index";
	}

	@RequestMapping(value = { "/list" })
	@ResponseBody
	public Page<Classes> list() {
		SimpleSpecificationBuilder<Classes> builder = new SimpleSpecificationBuilder<Classes>();
		SimpleSpecificationBuilder<Student> builder1 = null;
		String searchText = request.getParameter("searchText");
		if(StringUtils.isNotBlank(searchText)){
			builder.addOr("name", Operator.likeAll.name(), searchText);
		}
		Page<Classes> page = classesService.findAll(builder.generateSpecification(), getPageRequest());
		for (Classes classes : page) {
//			classes.setTeacher(teacher);
		}
		
		
		return page;
	}
	

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap map) {
		Map<String, String> map2 = new HashMap<String, String>();
		List<Classes> list = classesService.findAll();
		return "admin/classes/form";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Integer id,ModelMap map) {
		Classes classes = classesService.find(id);
		map.put("classes", classes);
		return "admin/classes/form";
	}

	@RequestMapping(value= {"/edit"} ,method = RequestMethod.POST)
	@ResponseBody
	public JsonResult edit(Classes classes,ModelMap map){
		try {
			classesService.saveOrUpdate(classes);
			
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult delete(@PathVariable Integer id,ModelMap map) {
		try {
			classesService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}

	
	
	


}


