/**
 * ${projectDescription}
 * <p>
 * ${projectName}
 * ${packageName}
 * UserMapper.java
 *
 * @author ${author}
 * @version 1.0
 * @since ${since}
 */
package com.egov.template.services.common.user.mapper;

import com.egov.template.entity.common.TbCmUser;
import org.apache.ibatis.annotations.Mapper;

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
public interface UserMapper {

    TbCmUser selectUser(TbCmUser vo);

    void insertUser(TbCmUser vo);

    void updateUser(TbCmUser vo);
}
