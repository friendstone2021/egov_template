/**
 * ${projectDescription}
 * <p>
 * ${projectName}
 * ${packageName}
 * CmTbCd.java
 *
 * @author ${author}
 * @version 1.0
 * @since ${since}
 */
package com.egov.template.entity.common;

import com.egov.template.entity.SystemProperty;
import com.egov.template.entity.common.pk.PkTbCmCdDtl;
import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

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
@Table(name = "TB_CM_CD_DTL")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter
@Getter
@ToString
public class TbCmCdDtl extends SystemProperty {

    @EmbeddedId
    private PkTbCmCdDtl pkTbCmCdDtl;

    @Column(name = "CD_NM")
    @Comment("코드명")
    private String cdNm;

    @Column(name = "SORT_SEQ")
    @Comment("정렬순서")
    private Integer sortSeq;

    @Column(name = "ETC_MTTR")
    @Comment("기타사항")
    private String etcMttr;

}
