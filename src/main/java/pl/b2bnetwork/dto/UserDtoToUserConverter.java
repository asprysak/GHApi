package pl.b2bnetwork.dto;

import pl.b2bnetwork.domain.User;

import java.sql.Date;
import java.util.Calendar;

public class UserDtoToUserConverter {

    public User convert(UserDto dto) {

        Calendar calendar = dto.getCalendarForCreatingAnAccount();
        java.sql.Date dateSql = new Date(calendar.getTimeInMillis());

        User user = User.builder()
                .id(dto.getId())
                .login(dto.getLogin())
                .noOfPublicRepos(dto.getNoOfPublicRepos())
                .followers(dto.getFollowers())
                .avatarUrl(dto.getAvatarUrl())
                .dateOfCreatingAnAccount(dateSql)
                .reposUrl(dto.getReposUrl())
                .build();

        return user;
    }
}
