package shop.bin.model.http;

import javax.inject.Inject;

import io.reactivex.Flowable;
import shop.bin.model.http.api.YupaxApis;
import shop.bin.model.http.request.ChangePasswordRequest;
import shop.bin.model.http.request.LoginRequest;
import shop.bin.model.http.request.ResendPasswordRequest;
import shop.bin.model.http.response.ChangePasswordResponse;
import shop.bin.model.http.response.LoginResponse;
import shop.bin.model.http.response.Token;

/**
 * Created by nguyenthanhdong0109@gmail.com on 5/20/17.
 */

public class RetrofitHelper implements HttpHelper {

    private YupaxApis yupaxApis;

    @Inject
    public RetrofitHelper(YupaxApis yupaxApis) {
        this.yupaxApis = yupaxApis;
    }

    @Override
    public Flowable<LoginResponse> signIn(LoginRequest loginRequest) {
        return yupaxApis.signIn(loginRequest);
    }

    @Override
    public Flowable<Token> resendPassword(ResendPasswordRequest resendPasswordRequest) {
        return null;
    }

    @Override
    public Flowable<ChangePasswordResponse> changePassword(ChangePasswordRequest changePasswordRequest) {
        return yupaxApis.changePassword(changePasswordRequest);
    }
}
