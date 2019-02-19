package ua.pp.darknsoft.services.profile;

import ua.pp.darknsoft.dto.ProfileTO;

public interface ProfileService {
    ProfileTO getProfile(Long userId);

    void updateProfile(Long userId, ProfileTO profileTO);
}