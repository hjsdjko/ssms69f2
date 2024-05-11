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

import com.entity.DiscussxuexitiandiEntity;
import com.entity.view.DiscussxuexitiandiView;

import com.service.DiscussxuexitiandiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 学习天地评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2021-05-18 19:15:08
 */
@RestController
@RequestMapping("/discussxuexitiandi")
public class DiscussxuexitiandiController {
    @Autowired
    private DiscussxuexitiandiService discussxuexitiandiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussxuexitiandiEntity discussxuexitiandi, 
		HttpServletRequest request){

        EntityWrapper<DiscussxuexitiandiEntity> ew = new EntityWrapper<DiscussxuexitiandiEntity>();
		PageUtils page = discussxuexitiandiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxuexitiandi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussxuexitiandiEntity discussxuexitiandi, 
		HttpServletRequest request){
        EntityWrapper<DiscussxuexitiandiEntity> ew = new EntityWrapper<DiscussxuexitiandiEntity>();
		PageUtils page = discussxuexitiandiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxuexitiandi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussxuexitiandiEntity discussxuexitiandi){
       	EntityWrapper<DiscussxuexitiandiEntity> ew = new EntityWrapper<DiscussxuexitiandiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussxuexitiandi, "discussxuexitiandi")); 
        return R.ok().put("data", discussxuexitiandiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussxuexitiandiEntity discussxuexitiandi){
        EntityWrapper< DiscussxuexitiandiEntity> ew = new EntityWrapper< DiscussxuexitiandiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussxuexitiandi, "discussxuexitiandi")); 
		DiscussxuexitiandiView discussxuexitiandiView =  discussxuexitiandiService.selectView(ew);
		return R.ok("查询学习天地评论表成功").put("data", discussxuexitiandiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussxuexitiandiEntity discussxuexitiandi = discussxuexitiandiService.selectById(id);
        return R.ok().put("data", discussxuexitiandi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussxuexitiandiEntity discussxuexitiandi = discussxuexitiandiService.selectById(id);
        return R.ok().put("data", discussxuexitiandi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussxuexitiandiEntity discussxuexitiandi, HttpServletRequest request){
    	discussxuexitiandi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussxuexitiandi);

        discussxuexitiandiService.insert(discussxuexitiandi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussxuexitiandiEntity discussxuexitiandi, HttpServletRequest request){
    	discussxuexitiandi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussxuexitiandi);

        discussxuexitiandiService.insert(discussxuexitiandi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiscussxuexitiandiEntity discussxuexitiandi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussxuexitiandi);
        discussxuexitiandiService.updateById(discussxuexitiandi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussxuexitiandiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<DiscussxuexitiandiEntity> wrapper = new EntityWrapper<DiscussxuexitiandiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discussxuexitiandiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
