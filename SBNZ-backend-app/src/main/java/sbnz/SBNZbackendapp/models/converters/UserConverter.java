package sbnz.SBNZbackendapp.models.converters;

import sbnz.SBNZbackendapp.models.DTO.UserDTO;
import sbnz.SBNZbackendapp.models.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    private ModelMapper modelMapper = new ModelMapper();

    public UserDTO toDTO(User user, String token){
        UserDTO userDto = modelMapper.map(user, UserDTO.class);
        userDto.setToken(token);
        return  userDto;
    }

}
