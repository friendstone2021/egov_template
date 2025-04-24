/**
 * ${projectDescription}
 * <p>
 * ${projectName}
 * ${packageName}
 * CmTbCdGrp.java
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
import java.io.Serializable;

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
@Table(name = "TB_CM_CD_GROUP")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TbCmCdGroup extends SystemProperty implements Serializable {

    @Id
    @Column(name = "GROUP_CD")
    @Comment("그룹코드")
    private String groupCd;

    @Column(name = "GROUP_CD_NM")
    @Comment("그룹코드명")
    private String groupCdNm;

}
