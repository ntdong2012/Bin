package shop.bin.base;

/**
 * Created by nguyenthanhdong0109@gmail.com on 5/24/2017.
 */

public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void detachView();
}
