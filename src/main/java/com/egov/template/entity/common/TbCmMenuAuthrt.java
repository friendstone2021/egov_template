/**
 * ${projectDescription}
 * <p>
 * ${projectName}
 * ${packageName}
 * TbCmMenuAuthrt.java
 *
 * @author ${author}
 * @version 1.0
 * @since ${since}
 */
package com.egov.template.entity.common;

import com.egov.template.entity.SystemProperty;
import com.egov.template.entity.common.pk.PkTbCmMenuAuthrt;
import lombok.*;

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
@Table(name = "TB_CM_MENU_AUTHRT")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter
@Getter
@ToString
public class TbCmMenuAuthrt extends SystemProperty {

    @EmbeddedId
    private PkTbCmMenuAuthrt pkTbCmMenuAuthrt;

}
