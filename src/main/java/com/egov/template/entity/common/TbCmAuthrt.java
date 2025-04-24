/**
 * ${projectDescription}
 * <p>
 * ${projectName}
 * ${packageName}
 * TbCmAuthrt.java
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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_CM_AUTHRT")
public class TbCmAuthrt extends SystemProperty {

    @Id
    @Column(name = "AUTHRT_CD")
    @Comment("권한코드")
    private String authrtCd;

    @Column(name = "AUTHRT_NM")
    @Comment("권한명")
    private String authrtNm;

}
