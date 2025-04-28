/**
 * ${projectDescription}
 * <p>
 * ${projectName}
 * ${packageName}
 * CmTbFile.java
 *
 * @author ${author}
 * @version 1.0
 * @since ${since}
 */
package com.egov.template.entity.common;

import com.egov.template.entity.SystemProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity
@Table(name = "tb_cm_file_group")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TbCmFileGroup extends SystemProperty {

    @Id
    @Column(name = "FILE_GROUP_ID")
    @Comment("파일그룹아이디")
    private String fileGroupId;

    @Column(name = "FILE_ACS_AUTHRT_CD")
    @Comment("파일접근권한코드")
    private String fileAcsAuthrtCd;

    @Column(name = "FILE_MDFCN_AUTHRT_CD")
    @Comment("파일수정권한코드")
    private String fileMdfcnAuthrtCd;

    @Column(name = "BFR_FILE_GROUP_ID")
    @Comment("이전파일그룹아이디")
    private String bfrFileGroupId;

}
