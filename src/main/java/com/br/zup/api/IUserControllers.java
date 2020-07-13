package com.br.zup.api;

import com.br.zup.api.request.UserRequest;
import com.br.zup.api.response.UserResponse;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

public interface IUserResponse {
    @PostMapping(path = "/login")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    AddDefaultCharsetFilter.ResponseWrapper<UserResponse> create(@RequestBody @Valid UserRequest userRequest);
}
