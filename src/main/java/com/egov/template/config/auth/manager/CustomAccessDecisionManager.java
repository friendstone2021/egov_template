/**
 * ${projectDescription}
 * <p>
 * ${projectName}
 * ${packageName}
 * CustomAccessDecisionManager.java
 *
 * @author ${author}
 * @version 1.0
 * @since ${since}
 */
package com.egov.template.config.auth.manager;

import com.egov.template.entity.common.TbCmAuthrt;
import com.egov.template.entity.common.TbCmMenu;
import com.egov.template.entity.common.TbCmMenuAuthrt;
import com.egov.template.entity.common.pk.PkTbCmMenuAuthrt;
import com.egov.template.services.common.menu.repository.CmTbMenuAuthRepository;
import com.egov.template.services.common.menu.repository.CmTbMenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * 요청된 URL에 대해 현재 사용자가 필요한 권한을 가지고 있는지 확인하는 역할
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
@Slf4j
@Service
public class CustomAccessDecisionManager implements AccessDecisionManager {

    private final CmTbMenuRepository cmTbMenuRepository;

    private final CmTbMenuAuthRepository cmTbMenuAuthRepository;

    private List<TbCmMenu> authMenuList;

    @Autowired
    public CustomAccessDecisionManager(CmTbMenuRepository cmTbMenuRepository, CmTbMenuAuthRepository cmTbMenuAuthRepository) {
        this.cmTbMenuRepository = cmTbMenuRepository;
        this.cmTbMenuAuthRepository = cmTbMenuAuthRepository;
    }

    @Override
    @Transactional
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {

        if(authMenuList == null) {
            authMenuList = cmTbMenuRepository.findAll();
        }

        // configAttributes: 요청 URL에 필요한 권한들
        // authentication: 현재 사용자의 권한 정보
        if(configAttributes == null || configAttributes.isEmpty()) {
            return;
        }

        // 현재 사용자의 권한 목록 확인
        Collection<? extends GrantedAuthority> userAuthorities = authentication.getAuthorities();

        for(ConfigAttribute attribute : configAttributes) {

            String authConfig = attribute.toString();

            if("permitAll".equals(authConfig)) {
                return;
            }else if("authenticated".equals(authConfig)) {
                FilterInvocation fi = (FilterInvocation) object;
                String requestUrl = fi.getRequestUrl();

                 boolean isPermit = false;
                for(GrantedAuthority authority : userAuthorities) {
                    String userAuth = authority.getAuthority();

                    TbCmAuthrt tbCmAuthrt = new TbCmAuthrt();
                    tbCmAuthrt.setAuthrtCd(userAuth.replace("ROLE_", ""));

                    TbCmMenu tbCmMenu = new TbCmMenu();
                    tbCmMenu.setMenuUrl(requestUrl);

                    ExampleMatcher matcher = ExampleMatcher.matching();
                    Optional<TbCmMenu> optCmTbMenu = cmTbMenuRepository.findOne(Example.of(tbCmMenu, matcher));
                    if(optCmTbMenu.isPresent()){
                        tbCmMenu = optCmTbMenu.get();

                        TbCmMenuAuthrt tbCmMenuAuthrt = new TbCmMenuAuthrt();
                        PkTbCmMenuAuthrt pkTbCmMenuAuthrt = new PkTbCmMenuAuthrt();
                        pkTbCmMenuAuthrt.setMenuId(tbCmMenu.getMenuId());
                        pkTbCmMenuAuthrt.setAuthrtCd(tbCmAuthrt.getAuthrtCd());
                        tbCmMenuAuthrt.setPkTbCmMenuAuthrt(pkTbCmMenuAuthrt);

                        Optional<TbCmMenuAuthrt> optCmTbMenuAuth = cmTbMenuAuthRepository.findOne(Example.of(tbCmMenuAuthrt, matcher));
                        if(optCmTbMenuAuth.isPresent()) {
                            isPermit = true;
                            break;
                        }
                    }
                }

                if(!isPermit) {
                    throw new AccessDeniedException("접근 권한이 없습니다.");
                }
            }
        }
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        // 모든 ConfigAttribute를 지원
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        // 모든 Security 클래스 지원
        return true;
    }

}
