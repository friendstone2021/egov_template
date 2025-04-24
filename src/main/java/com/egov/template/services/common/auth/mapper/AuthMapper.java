/**
 * ${projectDescription}
 * <p>
 * ${projectName}
 * ${packageName}
 * AuthMapper.java
 *
 * @author ${author}
 * @version 1.0
 * @since ${since}
 */
package com.egov.template.services.common.auth.mapper;

import com.egov.template.entity.common.TbCmAuthrt;
import com.egov.template.entity.common.TbCmUserAuthrt;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * ${programDescription}
 *
 * @author ${author}
 * @version 1.0
 *
 * <pre>
 * == 개정이력(Modification Information)==
 * 수정일                 수정자          수정내용
 * -------      -------   ----------------------------
 * ${since}   ${author}   최초 작성
 *
 * </pre>
 * @since ${since}
 */
@Mapper
public interface AuthMapper {

    void insertAuth(TbCmAuthrt vo);

    List<TbCmAuthrt> selectAuthList(TbCmAuthrt vo);

    TbCmAuthrt selectAuth(String authrtCd);

    void updateAuth(TbCmAuthrt vo);

    void deleteAuth(String authrtCd);

    void deactiveAuth(Map<String, Object> paramMap);

    int countAuth(String authrtCd);

    int checkAuthrtCdDuplicate(String authrtCd);

    List<String> selectUserAuthList(String userId);

    void insertUserAuth(TbCmUserAuthrt vo);
}
