/**
 * ${projectDescription}
 * <p>
 * ${projectName}
 * ${packageName}
 * PkTbCmFileDtl.java
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
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PkTbCmFileDtl implements Serializable {

    @Column(name = "FILE_GROUP_ID")
    @Comment("파일그룹아이디")
    private String fileGroupId;

    @Column(name = "FILE_ID")
    @Comment("파일아이디")
    private String fileId;

}
