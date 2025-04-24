/**
 * ${projectDescription}
 * <p>
 * ${projectName}
 * ${packageName}
 * FileMapper.java
 *
 * @author ${author}
 * @version 1.0
 * @since ${since}
 */
package com.egov.template.services.common.file.mapper;

import com.egov.template.entity.common.TbCmFileDtl;
import com.egov.template.entity.common.TbCmFileGroup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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
public interface FileMapper {

    TbCmFileGroup selectFileGrp(TbCmFileGroup vo);

    TbCmFileDtl selectFileDtl(TbCmFileDtl vo);

    List<TbCmFileDtl> selectFileDtlList(TbCmFileDtl vo);

    void insertFileGrp(TbCmFileGroup vo);

    void updateFileGrp(TbCmFileGroup vo);

    void insertFileDtl(TbCmFileDtl vo);

    void updateFileDtl(TbCmFileDtl vo);

}
