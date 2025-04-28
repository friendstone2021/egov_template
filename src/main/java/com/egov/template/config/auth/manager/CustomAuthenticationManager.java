/**
 * ${projectDescription}
 * <p>
 * ${projectName}
 * ${packageName}
 * CustomAuthenticationManager.java
 *
 * @author ${author}
 * @version 1.0
 * @since ${since}
 */
package com.egov.template.config.auth.manager;

import com.egov.template.entity.common.TbCmUser;
import com.egov.template.entity.common.TbCmUserAuthrt;
import com.egov.template.entity.common.pk.PkTbCmUserAuthrt;
import com.egov.template.services.common.user.repository.CmTbUserAuthRepository;
import com.egov.template.services.common.user.repository.CmTbUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
@Slf4j
public class CustomAuthenticationManager implements AuthenticationManager {

    @Resource(name = "cmTbUserRepository")
    private CmTbUserRepository userRepository;

    @Resource(name = "cmTbUserAuthRepository")
    private CmTbUserAuthRepository userAuthRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        UsernamePasswordAuthenticationToken authToken;

        String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

//        password = EgovFileScrty.encryptPassword(password, username);

        Optional<TbCmUser> optCmTbUser = userRepository.findById(username);
        ExampleMatcher matcher = ExampleMatcher.matching();
        if (optCmTbUser.isPresent()) {
            TbCmUser tbCmUser = optCmTbUser.get();
            if (!password.equals(tbCmUser.getEnpswd())) {
                throw new BadCredentialsException("invalidIdPass");
            } else {
                tbCmUser.setLastCntnDt(new Date());
                userRepository.save(tbCmUser);

                List<String> userAuthList = new ArrayList<>();
                TbCmUserAuthrt tbCmUserAuthrt = new TbCmUserAuthrt();
                PkTbCmUserAuthrt pkTbCmUserAuthrt = new PkTbCmUserAuthrt();
                pkTbCmUserAuthrt.setUserId(username);
                tbCmUserAuthrt.setPkTbCmUserAuthrt(pkTbCmUserAuthrt);

                userAuthRepository.findAll(Example.of(tbCmUserAuthrt, matcher))
                        .forEach(auth -> {
                            userAuthList.add(auth.getPkTbCmUserAuthrt().getAuthrtCd());
                        });;

                if (userAuthList.isEmpty()) {
                    throw new BadCredentialsException("invalidRoute");
                } else {
                    String[] arrUserAuth = userAuthList.toArray(new String[0]);

                    UserDetails userDetails = User.builder().username(username)
                            .password(password)
                            .roles(arrUserAuth)
                            .build();

                    tbCmUser.setEnpswd(null);

                    authToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
                    authToken.setDetails(tbCmUser);
                }

            }
        } else {
            throw new BadCredentialsException("invalidIdPass");
        }

        return authToken;
    }

}
