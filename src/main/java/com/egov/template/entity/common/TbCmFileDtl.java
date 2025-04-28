/**
 * ${projectDescription}
 * <p>
 * ${projectName}
 * ${packageName}
 * TbCmFileDtl.java
 *
 * @author ${author}
 * @version 1.0
 * @since ${since}
 */
package com.egov.template.entity.common;

import com.egov.template.entity.SystemProperty;
import com.egov.template.entity.common.pk.PkTbCmFileDtl;
import lombok.*;
import org.hibernate.annotations.Comment;

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
@Entity
@Table(name = "tb_cm_file_dtl")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter
@Getter
@ToString
public class TbCmFileDtl extends SystemProperty {

    @EmbeddedId
    private PkTbCmFileDtl pkTbCmFileDtl;

    @Column(name = "FILE_PATH_NM")
    @Comment("파일경로명")
    private String filePathNm;

    @Column(name = "STRG_FILE_NM")
    @Comment("저장파일명")
    private String strgFileNm;

    @Column(name = "ORGNL_FILE_NM")
    @Comment("원본파일명")
    private String orgnlFileNm;

    @Column(name = "FILE_SZ")
    @Comment("파일크기")
    private Long fileSz;

    @Column(name = "FILE_EXTN_NM")
    @Comment("파일확장자명")
    private String fileExtnNm;

}
