package ua.pp.darknsoft.services.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.pp.darknsoft.dto.ProfileTO;
import ua.pp.darknsoft.models.Profile;
import ua.pp.darknsoft.repositories.ProfileRepository;
import ua.pp.darknsoft.repositories.UserRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public ProfileTO getProfile(Long userId) {
        ProfileTO profileTO = new ProfileTO();
        profileRepository
                .findByUser_id(userId)
                .ifPresentOrElse(
                        (profile)-> {
                            profileTO.setFirstName(profile.getFirstName())
                                     .setLastName(profile.getLastName())
                                     .setEmail(profile.getEmail());
                        },
                        () -> {
                            profileTO.setFirstName("")
                                     .setLastName("")
                                     .setEmail("");
                        });
        return profileTO;
    }

    //there is a risk to mix fields as all of them are of String type, interface chaining can be implemented
    @Override
    public void updateProfile(Long userId, ProfileTO profileTO) {
        profileRepository
                .findByUser_id(userId)
                .ifPresentOrElse(
                        (profile)-> {
                            profileRepository
                                    .save(profile.setFirstName(profileTO.getFirstName())
                                                 .setLastName(profileTO.getLastName())
                                                 .setEmail(profileTO.getEmail()));
                        },
                        () -> {
                            profileRepository
                                    .save(new Profile()
                                            .setFirstName(profileTO.getFirstName())
                                            .setLastName(profileTO.getLastName())
                                            .setEmail(profileTO.getEmail())
                                            .setUser(userRepository.findById(userId).get()));
                        });
    }
}
