package com.ledger.config.auth.dto;

<<<<<<< HEAD
import com.ledger.constant.Profile;
=======
>>>>>>> Feat/oauth2-login
import com.ledger.constant.Role;
import com.ledger.entity.Member;
import lombok.Builder;
import lombok.Getter;
<<<<<<< HEAD

import java.util.Map;

=======
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.User;

import java.util.Map;

@NoArgsConstructor
@Builder
>>>>>>> Feat/oauth2-login
@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String nickname;
    private String email;
    private String profile;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes,
                           String nameAttributeKey, String nickname,
                           String email, String profile) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.nickname = nickname;
        this.email = email;
        this.profile = profile;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        if("naver".equals(registrationId)) {
            return ofNaver("id", attributes);
        }

<<<<<<< HEAD
        if("kakao".equals(registrationId)){
            return ofKakao("id", attributes);
        }

        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .nickname((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .profile((String) attributes.get("profile"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }
=======
        return null;
    }

>>>>>>> Feat/oauth2-login

    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        return OAuthAttributes.builder()
                .nickname((String) response.get("nickname"))
                .email((String) response.get("email"))
                .profile((String) response.get("profile_image"))
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

<<<<<<< HEAD
    public static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>)attributes.get("kakao_account");
        Map<String, Object> profile = (Map<String, Object>) response.get("profile");
        return OAuthAttributes.builder()
                .nickname((String) profile.get("nickname"))
                .email((String) response.get("email"))
                .profile((String) profile.get("profile_image_url"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }
=======
>>>>>>> Feat/oauth2-login
    public Member toEntity() {
        return Member.builder()
                .nickname(nickname)
                .email(email)
                .profile(profile)
                .role(Role.GUEST)
                .build();
    }
<<<<<<< HEAD
}
=======
}

>>>>>>> Feat/oauth2-login
