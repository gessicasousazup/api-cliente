package com.br.zup.api.controllers;

import com.br.zup.api.IUserControllers;
import com.br.zup.api.request.UserRequest;
import com.br.zup.api.response.UserResponse;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/crud")
public class UserContlorss implements IUserControllers {

    private final IUserService userService;
    private final PlayerMapper mapper;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public AddDefaultCharsetFilter.ResponseWrapper<UserResponse> create(@Valid UserRequest userRequest) {
        return null;
    }
    @Override
    @ApiOperation(value = "Creates a new user")
    @ApiResponses({
            @ApiResponse(code = 400, message = "Alguns campos são inválidos", response = ErrorResponseWithFields.class)
    })
    public ResponseWrapper<UserResponse> create(@RequestBody @Valid UserRequest userRequest) {
        log.info("Player registering: " + userRequest.toString());

        return new ResponseWrapper<>(mapper.toResponse(userService.create(mapper.toDto(userRequest))));
    }

}
