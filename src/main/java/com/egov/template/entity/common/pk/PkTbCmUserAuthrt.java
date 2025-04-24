/**
 * ${projectDescription}
 * <p>
 * ${projectName}
 * ${packageName}
 * PkTbCmUserAuthrt.java
 *
 * @author ${author}
 * @version 1.0
 * @since ${since}
 */
package com.egov.template.entity.common.pk;

import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.io.Serializable;

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
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class PkTbCmUserAuthrt implements Serializable {

    @Column(name = "USER_ID")
    @Comment("사용자아이디")
    private String userId;

    @Column(name = "AUTHRT_CD")
    @Comment("권한코드")
    private String authrtCd;

}
