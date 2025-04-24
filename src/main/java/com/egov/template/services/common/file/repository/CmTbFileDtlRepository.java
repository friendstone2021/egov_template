/**
 * ${projectDescription}
 * <p>
 * ${projectName}
 * ${packageName}
 * CmTbFileDtlRepository.java
 *
 * @author ${author}
 * @version 1.0
 * @since ${since}
 */
package com.egov.template.services.common.file.repository;

import com.egov.template.entity.common.TbCmFileDtl;
import org.springframework.data.jpa.repository.JpaRepository;

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
public interface CmTbFileDtlRepository extends JpaRepository<TbCmFileDtl, String> {
}
