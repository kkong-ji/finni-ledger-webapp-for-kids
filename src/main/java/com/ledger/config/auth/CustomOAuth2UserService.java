package com.ledger.config.auth;

import com.ledger.config.auth.dto.OAuthAttributes;
<<<<<<< HEAD
import com.ledger.config.auth.dto.SessionMember;
import com.ledger.entity.Member;
import com.ledger.repository.MemberRepository;
import jakarta.servlet.http.HttpSession;
=======
import com.ledger.config.auth.dto.SessionUser;
import com.ledger.entity.Member;
import com.ledger.repository.MemberRepository;
>>>>>>> Feat/oauth2-login
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======
import javax.servlet.http.HttpSession;
>>>>>>> Feat/oauth2-login
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    private final MemberRepository memberRepository;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2UserService<OAuth2UserRequest, OAuth2User>
                delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

        Member member = saveOrUpdate(attributes);

<<<<<<< HEAD
        httpSession.setAttribute("member", new SessionMember(member));

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(member.getRoleKey())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey());
        }

        private Member saveOrUpdate(OAuthAttributes attributes) {
            Member member = memberRepository.findByEmail(attributes.getEmail())
=======
        httpSession.setAttribute("user", new SessionUser(member));

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(member.getRoleValue())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey());
    }

    private Member saveOrUpdate(OAuthAttributes attributes) {
        Member member = memberRepository.findByEmail(attributes.getEmail())
>>>>>>> Feat/oauth2-login
                .map(entity -> entity.update(attributes.getNickname(), attributes.getProfile()))
                .orElse(attributes.toEntity());

        return memberRepository.save(member);
    }
}