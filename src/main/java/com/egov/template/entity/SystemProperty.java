/**
 * ${projectDescription}
 * <p>
 * ${projectName}
 * ${packageName}
 * SystemProperty.java
 *
 * @author ${author}
 * @version 1.0
 * @since ${since}
 */
package com.egov.template.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

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
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class SystemProperty {

    @Column(name = "USE_YN", nullable = false, length = 1)
    @Comment("사용여부")
    private String useYn;

    @CreatedDate
    @Column(name = "REG_DT")
    @Comment("등록일시")
    private LocalDateTime regDt;

    @Column(name = "RGTR_ID", nullable = false)
    @Comment("등록자아이디")
    private String rgtrId;

    @LastModifiedDate
    @Column(name = "MDFCN_DT")
    @Comment("수정일시")
    private LocalDateTime mdfcnDt;

    @Column(name = "MDFR_ID")
    @Comment("수정자아이디")
    private String mdfrId;
}
