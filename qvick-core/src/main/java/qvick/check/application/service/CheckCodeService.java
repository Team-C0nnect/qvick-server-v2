package qvick.check.application.service;

import qvick.check.application.response.CheckCodeResponse;

import java.util.concurrent.CompletableFuture;

public interface CheckCodeService {

    CompletableFuture<CheckCodeResponse> generate();

}
