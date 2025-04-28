/**
 * ${projectDescription}
 * <p>
 * ${projectName}
 * ${packageName}
 * TbCmUserAuthrt.java
 *
 * @author ${author}
 * @version 1.0
 * @since ${since}
 */
package com.egov.template.entity.common;

import com.egov.template.entity.SystemProperty;
import com.egov.template.entity.common.pk.PkTbCmUserAuthrt;
import lombok.*;

import javax.persistence.*;

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
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "tb_cm_user_authrt")
@ToString
public class TbCmUserAuthrt extends SystemProperty {

    @EmbeddedId
    private PkTbCmUserAuthrt pkTbCmUserAuthrt;


}
