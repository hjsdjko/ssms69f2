package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.XuexiqiandaoEntity;
import com.entity.view.XuexiqiandaoView;

import com.service.XuexiqiandaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 学习签到
 * 后端接口
 * @author 
 * @email 
 * @date 2021-05-18 19:15:08
 */
@RestController
@RequestMapping("/xuexiqiandao")
public class XuexiqiandaoController {
    @Autowired
    private XuexiqiandaoService xuexiqiandaoService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XuexiqiandaoEntity xuexiqiandao, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			xuexiqiandao.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XuexiqiandaoEntity> ew = new EntityWrapper<XuexiqiandaoEntity>();
		PageUtils page = xuexiqiandaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuexiqiandao), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XuexiqiandaoEntity xuexiqiandao, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			xuexiqiandao.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XuexiqiandaoEntity> ew = new EntityWrapper<XuexiqiandaoEntity>();
		PageUtils page = xuexiqiandaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuexiqiandao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XuexiqiandaoEntity xuexiqiandao){
       	EntityWrapper<XuexiqiandaoEntity> ew = new EntityWrapper<XuexiqiandaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xuexiqiandao, "xuexiqiandao")); 
        return R.ok().put("data", xuexiqiandaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XuexiqiandaoEntity xuexiqiandao){
        EntityWrapper< XuexiqiandaoEntity> ew = new EntityWrapper< XuexiqiandaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xuexiqiandao, "xuexiqiandao")); 
		XuexiqiandaoView xuexiqiandaoView =  xuexiqiandaoService.selectView(ew);
		return R.ok("查询学习签到成功").put("data", xuexiqiandaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XuexiqiandaoEntity xuexiqiandao = xuexiqiandaoService.selectById(id);
        return R.ok().put("data", xuexiqiandao);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XuexiqiandaoEntity xuexiqiandao = xuexiqiandaoService.selectById(id);
        return R.ok().put("data", xuexiqiandao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XuexiqiandaoEntity xuexiqiandao, HttpServletRequest request){
    	xuexiqiandao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuexiqiandao);

        xuexiqiandaoService.insert(xuexiqiandao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XuexiqiandaoEntity xuexiqiandao, HttpServletRequest request){
    	xuexiqiandao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuexiqiandao);
    	xuexiqiandao.setUserid((Long)request.getSession().getAttribute("userId"));

        xuexiqiandaoService.insert(xuexiqiandao);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody XuexiqiandaoEntity xuexiqiandao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xuexiqiandao);
        xuexiqiandaoService.updateById(xuexiqiandao);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xuexiqiandaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<XuexiqiandaoEntity> wrapper = new EntityWrapper<XuexiqiandaoEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("zhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = xuexiqiandaoService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
