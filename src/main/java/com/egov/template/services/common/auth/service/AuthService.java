/**
 * ${projectDescription}
 * <p>
 * ${projectName}
 * ${packageName}
 * AuthService.java
 *
 * @author ${author}
 * @version 1.0
 * @since ${since}
 */
package com.egov.template.services.common.auth.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.egov.template.entity.common.TbCmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.egov.template.entity.common.TbCmAuthrt;
import com.egov.template.entity.common.TbCmUserAuthrt;
import com.egov.template.services.common.auth.mapper.AuthMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * ${programDescription}
 * @author ${author}
 * @since ${since}
 * @version 1.0
 *
 * <pre>
 * == 개정이력(Modification Information)==
 * 수정일                 수정자          수정내용
 * -------      -------   ----------------------------
 * ${since}   ${author}   최초 작성
 *
 * </pre>
 */
@Slf4j
@Service
public class AuthService {

	@Autowired
	private AuthMapper authMapper;
	
	public void insertAuth(TbCmAuthrt tbCmAuthrt) {
		TbCmUser user = (TbCmUser)SecurityContextHolder.getContext().getAuthentication().getDetails();
		tbCmAuthrt.setRgtrId(user.getUserId());
		tbCmAuthrt.setRegDt(LocalDateTime.now());
		authMapper.insertAuth(tbCmAuthrt);
	}
	
	public List<TbCmAuthrt> selectAuthList(TbCmAuthrt tbCmAuthrt){
		return authMapper.selectAuthList(tbCmAuthrt);
	}
	
	public TbCmAuthrt selectAuth(String authrtCd) {
		return authMapper.selectAuth(authrtCd);
	}
	
	public void updateAuth(TbCmAuthrt tbCmAuthrt) {
		TbCmUser user = (TbCmUser)SecurityContextHolder.getContext().getAuthentication().getDetails();
		tbCmAuthrt.setMdfrId(user.getUserId());
		tbCmAuthrt.setMdfcnDt(LocalDateTime.now());
		authMapper.updateAuth(tbCmAuthrt);
	}
	
	public void deactivateAuth(String authrtCd) {
		TbCmUser user = (TbCmUser)SecurityContextHolder.getContext().getAuthentication().getDetails();
		Map<String,Object> param = new HashMap<>();
		param.put("mdfrId", user.getUserId());
		param.put("authrtCd", authrtCd);
		authMapper.deactiveAuth(param);
	}
	
	public int countAuth(String authrtCd) {
		return authMapper.countAuth(authrtCd);
	}
	
	public boolean checkAuthrtCdDuplicate(String authrtCd) {
		return authMapper.countAuth(authrtCd) > 0;
	}
	
	public List<String> selectUserAuthList(String userId){
		return authMapper.selectUserAuthList(userId);
	}
	
	public void insertUserAuth(TbCmUserAuthrt tbCmUserAuthrt) {
		TbCmUser user = (TbCmUser)SecurityContextHolder.getContext().getAuthentication().getDetails();
		tbCmUserAuthrt.setRgtrId(user.getUserId());
		tbCmUserAuthrt.setRegDt(LocalDateTime.now());
		tbCmUserAuthrt.setUseYn("Y");
		authMapper.insertUserAuth(tbCmUserAuthrt);
	}
	
}
