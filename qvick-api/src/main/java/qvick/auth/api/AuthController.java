package qvick.auth.api;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@Tag(name = "인증", description = "인증 API")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-up")
    @Operation(summary = "유저 회원가입", description = "유저 회원가입")
    public BaseResponse signUp(@Validated @RequestBody SignUpRequest signUpRequest){
        authService.signUp(signUpRequest);
        return BaseResponse.created("회원가입이 완료되었습니다.");
    }

    @PostMapping("/sign-up/admin")
    @Operation(summary = "관리자 회원가입", description = "관리자 회원가입")
    public BaseResponse adminSignUp(@Validated @RequestBody SignUpRequest signUpRequest){
        authService.adminSignUp(signUpRequest);
        return BaseResponse.created("회원가입이 완료되었습니다.");
    }

    @PostMapping("/sign-up/teacher")
    @Operation(summary = "선생님 회원가입", description = "선생님 회원가입")
    public BaseResponse teacherSignUp(@Validated @RequestBody SignUpRequest signUpRequest){
        authService.teacherSignUp(signUpRequest);
        return BaseResponse.created("회원가입이 완료되었습니다.");
    }

    @PostMapping("/sign-in")
    @Operation(summary = "로그인", description = "로그인")
    public BaseResponseData<JsonWebTokenResponse> signIn(@Validated @RequestBody SignInRequest signInRequest){
        return BaseResponseData.ok(
                "로그인 성공",
                authService.signIn(signInRequest));
    }

    @PostMapping("/refresh")
    @Operation(summary = "토큰 재발급", description = "access 토큰을 재발급 합니다")
    public BaseResponseData<RefreshTokenResponse> refresh(RefreshTokenRequest request){
        return BaseResponseData.ok(
                "토큰 재발급 성공",
                authService.refresh(request.refreshToken()));
    }

}
