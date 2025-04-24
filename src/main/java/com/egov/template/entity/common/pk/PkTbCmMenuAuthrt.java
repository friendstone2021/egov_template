/**
 * ${projectDescription}
 * <p>
 * ${projectName}
 * ${packageName}
 * PkTbCmMenuAuthrt.java
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
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class PkTbCmMenuAuthrt implements Serializable {

    @Column(name = "MENU_ID")
    @Comment("메뉴아이디")
    private String menuId;

    @Column(name = "AUTHRT_CD")
    @Comment("권한코드")
    private String authrtCd;

}
